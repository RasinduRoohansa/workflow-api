package com.spsolutions.grand.service.booking;

import com.spsolutions.grand.constant.ServiceConstants;
import com.spsolutions.grand.dao.BookingTablePlanDao;
import com.spsolutions.grand.domain.EdgeDocument;
import com.spsolutions.grand.domain.booking.Booking;
import com.spsolutions.grand.domain.booking.BookingCheckListTemplate;
import com.spsolutions.grand.domain.booking.BookingCheckListTemplateItem;
import com.spsolutions.grand.domain.booking.BookingTablePlan;
import com.spsolutions.grand.domain.master.CheckListTemplateItem;
import com.spsolutions.grand.mappers.DocumentMapper;
import com.spsolutions.grand.mappers.booking.BookingMapper;
import com.spsolutions.grand.mappers.event.EventMapper;
import com.spsolutions.grand.service.FileService;
import com.spsolutions.grand.service.event.EnquiryService;
import com.spsolutions.grand.service.master.CheckListService;
import com.spsolutions.grand.service.serviceutil.ExcelService;
import com.spsolutions.grand.service.serviceutil.GeneratorService;
import com.spsolutions.grand.util.ArchiveUtils;
import org.apache.ibatis.annotations.Param;
import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;

@Service
public class BookingService {
    final static Logger logger = Logger.getLogger(ArchiveUtils.class);

    @Autowired
    private BookingMapper bookingMapper;

    @Autowired
    private GeneratorService generatorService;

    @Autowired
    private EventMapper eventMapper;

    @Autowired
    private ExcelService excelService;

    @Autowired
    private DocumentMapper documentMapper;

    @Autowired
    private CheckListService checkListService;

    @Value("${archive.path}")
    private String archivePath;

    public Map<String, String> createBookingByWalkThrough(Booking booking) {
        Map<String, String> response = new HashMap<>();

        String bookingNumber = generatorService.generateId(ServiceConstants.BOOKING_TYPE.getType());
        response.put("bookingNumber", bookingNumber);

        booking.setBookingNumber(bookingNumber);
        this.bookingMapper.createBookingByWalkThrough(booking);

        this.eventMapper.changeEnquiryToProcessed(booking.getFkWalkThrough());

        return response;
    }

    public List<Booking> findAllBookings() {
        return this.bookingMapper.findAllBookings();
    }

    public Booking findNextBooking() {
        return this.bookingMapper.findNextBooking();
    }

    public Booking findBookingById(Long id) {
        return this.bookingMapper.findBookingById(id);
    }

    public Map<String, Object> uploadTablePlan(MultipartFile file, Long fkBooking, String username) {
        boolean validate = true;
        Map<String, Object> response = new HashMap<>();

        if (file != null) {

            try {
                InputStream inputStream = file.getInputStream();

                Workbook workbook = new XSSFWorkbook(inputStream);
                int numberOfSheets = workbook.getNumberOfSheets();

                if (numberOfSheets > 0) {
                    Sheet sheetAt = workbook.getSheetAt(0);
                    Iterator<Row> rows = sheetAt.iterator();
                    int emptyCount = 0;

                    Row firstRow = rows.next();
                    Map<String, Integer> columnName = this.excelService.getColoumNameMap(firstRow);

                    EdgeDocument edgeDocument;
                    if (columnName.get("TABLE NUMBER") == null ||
                            columnName.get("SALUTATION") == null ||
                            columnName.get("FULL NAME") == null ||
                            columnName.get("CONTACT") == null) {
                        validate = false;

                        response.put("code", 500);
                        response.put("msg", "Excel file data format is not correct !");
                        return response;
                    } else {
                        edgeDocument = new ArchiveUtils().writeStreamToFile(file.getInputStream(), file.getOriginalFilename(), archivePath);
                        edgeDocument.setCreatedBy(username);
                        this.documentMapper.saveDocument(edgeDocument);
                    }

                    if (validate) {
                        while (rows.hasNext()) {
                            Row row = rows.next();

                            Iterator<Cell> cells = row.cellIterator();
                            boolean isRowEmpty = false;
                            while (cells.hasNext()) {
                                double value = cells.next().getNumericCellValue();
                                String val = String.valueOf(value);
                                if (val.trim().equals("0.0")) {
                                    isRowEmpty = true;
                                } else {
                                    isRowEmpty = false;
                                    break;
                                }
                            }

                            if (isRowEmpty) {
                                emptyCount++;
                                if (emptyCount > 10) {
                                    break;
                                }
                            } else {
                                emptyCount = 0;
                                BookingTablePlan tablePlan = new BookingTablePlan();
                                tablePlan.setFkBooking(fkBooking);
                                if (edgeDocument != null) {
                                    tablePlan.setFkDocument(edgeDocument.getId());
                                }

                                DataFormatter formatter = new DataFormatter();

                                Cell tableNumber = row.getCell(columnName.get("TABLE NUMBER"));
                                tablePlan.setTableNumber(formatter.formatCellValue(tableNumber));

                                Cell salutation = row.getCell(columnName.get("SALUTATION"));
                                tablePlan.setSalutation(this.excelService.getValue(salutation));

                                Cell fullName = row.getCell(columnName.get("FULL NAME"));
                                tablePlan.setFullName(this.excelService.getValue(fullName));

                                Cell contact = row.getCell(columnName.get("CONTACT"));
                                tablePlan.setContact(formatter.formatCellValue(contact));

                                this.bookingMapper.saveTablePlan(tablePlan);
                            }
                        }
                    }
                }
            } catch (IOException e) {
                logger.error(e.getMessage(), e);
            }
        }
        return response;
    }

    public List<EdgeDocument> findTablePlanHeader(Long fkBooking) {
        return this.documentMapper.findTablePlanHeader(fkBooking);
    }

    public List<BookingTablePlanDao> findTablePlan(Long fkDocument) {
        Map<String, List<BookingTablePlan>> map = new HashMap<>();

        List<BookingTablePlan> tablePlans = this.bookingMapper.findTablePlan(fkDocument);

        tablePlans.stream().forEach(table -> {
            List<BookingTablePlan> plans = map.get(table.getTableNumber());
            if (plans == null) {
                plans = new ArrayList<>();
            }

            plans.add(table);
            map.put(table.getTableNumber(), plans);
        });

        List<BookingTablePlanDao> tablePlanDaos = new ArrayList<>();
        for (String key : map.keySet()) {
            BookingTablePlanDao tablePlanDao = new BookingTablePlanDao();
            tablePlanDao.setTablePlans(map.get(key));
            tablePlanDao.setTableNumber(key);
            tablePlanDaos.add(tablePlanDao);
        }
        return tablePlanDaos;
    }

    public void createBookingCheckListTemplate(BookingCheckListTemplate checkListTemplate) {
        this.bookingMapper.deactivateBookingCheckList(checkListTemplate.getFkBooking());
        this.bookingMapper.createBookingCheckListTemplate(checkListTemplate);

        List<CheckListTemplateItem> checkListTemplateItems = this.checkListService.findCheckListItemByTemplateId(checkListTemplate.getFkMasterCheckList());

        checkListTemplateItems.stream().forEach(item -> {
            BookingCheckListTemplateItem templateItem = new BookingCheckListTemplateItem();
            templateItem.setFkBookingCheckList(checkListTemplate.getId());
            templateItem.setFkMasterCheckListItem(item.getId());
            templateItem.setItemName(item.getItemName());
            templateItem.setSheduled(item.getSheduled());
            templateItem.setSheduleMinute(item.getSheduleMinute());
            templateItem.setSheduleTime(item.getSheduleTime());
            templateItem.setSheduleType(item.getSheduleType());
            templateItem.setCreatedBy(checkListTemplate.getCreatedBy());

            this.bookingMapper.createBookingCheckListTemplateItem(templateItem);
        });
    }

    public BookingCheckListTemplate findBookingCheckListTemplate(Long fkBooking) {
        return this.bookingMapper.findBookingCheckListTemplate(fkBooking);
    }

    public List<BookingCheckListTemplateItem> findBookingCheckListTemplateItem(Long fkBooking) {
        return this.bookingMapper.findBookingCheckListTemplateItem(fkBooking);
    }

    public void checkBookingCheckListItemDone(Long fkId) {
        this.bookingMapper.checkBookingCheckListItemDone(fkId);
    }

    public void saveBookingCheckListItem(BookingCheckListTemplateItem templateItem) {
        this.bookingMapper.createBookingCheckListTemplateItem(templateItem);
    }
}