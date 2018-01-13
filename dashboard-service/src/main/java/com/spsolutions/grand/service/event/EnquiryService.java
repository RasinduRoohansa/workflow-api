package com.spsolutions.grand.service.event;

import com.spsolutions.grand.constant.LoggerConstants;
import com.spsolutions.grand.constant.ServiceConstants;
import com.spsolutions.grand.dao.*;
import com.spsolutions.grand.domain.EdgeDocument;
import com.spsolutions.grand.domain.calendar.EdgeCalendar;
import com.spsolutions.grand.domain.common.Customer;
import com.spsolutions.grand.domain.enquiry.Enquiry;
import com.spsolutions.grand.domain.location.EdgeLocation;
import com.spsolutions.grand.domain.master.Driver;
import com.spsolutions.grand.mappers.DocumentMapper;
import com.spsolutions.grand.mappers.customer.CustomerMapper;
import com.spsolutions.grand.mappers.event.EventMapper;
import com.spsolutions.grand.mappers.master.DriverMapper;
import com.spsolutions.grand.mappers.master.VenueMapper;
import com.spsolutions.grand.service.FileService;
import com.spsolutions.grand.service.activitylog.ActivityLogService;
import com.spsolutions.grand.service.calendar.CalendarService;
import com.spsolutions.grand.service.location.LocationService;
import com.spsolutions.grand.service.serviceutil.GeneratorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class EnquiryService {
    private final static Logger LOGGER = LoggerFactory.getLogger(EnquiryService.class);

    @Autowired
    private CustomerMapper customerMapper;

    @Autowired
    private EventMapper eventMapper;

    @Autowired
    private FileService fileService;

    @Autowired
    private VenueMapper venueMapper;

    @Autowired
    private DocumentMapper documentMapper;

    @Autowired
    private LocationService locationService;

    @Autowired
    private CalendarService calendarService;

    @Autowired
    private DriverMapper driverMapper;

    @Autowired
    private GeneratorService generatorService;

    @Autowired
    private ActivityLogService logService;

    private DateFormat timeFormat = new SimpleDateFormat("hh:mm a");
    private DateFormat ddMMyyyy = new SimpleDateFormat("dd-MM-yyyy");

    public void createEnquiry(Enquiry enquiry) {
        this.customerMapper.saveCustomer(enquiry.getCustomer());

        if (enquiry.getCustomer().getId() != null) {
            if (enquiry.getStartDate() != null) {
                Calendar sC = Calendar.getInstance();
                sC.setTime(enquiry.getStartDate());
                sC.add(Calendar.MINUTE, enquiry.getStartTime());
                enquiry.setStartDate(sC.getTime());
            }

            if (enquiry.getEndDate() != null) {
                Calendar eC = Calendar.getInstance();
                eC.setTime(enquiry.getEndDate());
                eC.add(Calendar.MINUTE, enquiry.getEndTime());
                enquiry.setEndDate(eC.getTime());
            }

            enquiry.setFkCustomer(enquiry.getCustomer().getId());
            this.eventMapper.saveEnquiry(enquiry);

            Customer customer = enquiry.getCustomer();
            if (customer != null) {

                this.logService.createActLog(LoggerConstants.CREATE,
                        customer.getFirstName()
                                .concat(" ")
                                .concat(customer.getLastName())
                                .concat(", ")
                                .concat(LoggerConstants.LOG_1.getType()), "", enquiry.getId());
            }
        }

    }

    public List<Enquiry> getNotAllocatedEnquiry() {
        List<Enquiry> enquiries = eventMapper.getNotAllocatedEnquiry();
        enquiries.stream().forEach(enquiry -> enquiry.setCustomer(customerMapper.findCustomerById(enquiry.getFkCustomer())));
        return enquiries;
    }

    public List<VenueSpacesDao> findAvailableSpaces(SearchEnquiryDao enquiryDao) {
        List<VenueSpacesDao> spacesDaos = eventMapper.findAvailableSpaces(enquiryDao);
        return spacesDaos;
    }

    public VenueSpacesDao findSpaceDetail(Long fkSpace) {
        VenueSpacesDao spaceDetail = this.venueMapper.findSpaceDetail(fkSpace);

        if (spaceDetail != null) {
            spaceDetail.setVenue(this.venueMapper.findVenue(spaceDetail.getFkVenue()));
            if (spaceDetail.getFkDocument() != null) {
                spaceDetail.setImage(this.fileService.findImage(spaceDetail.getFkDocument()));
            }
            spaceDetail.setFacilities(venueMapper.findFacility(fkSpace));
        }

        return spaceDetail;
    }

    public void allocateEnquiry(EnquiryAllocationDao allocationDao) {
        this.eventMapper.saveEnquiryAllocation(allocationDao);
        if (allocationDao.getId() != null) {
            this.eventMapper.allocateEnquiry(allocationDao);

            this.logService.createActLog(LoggerConstants.CREATE,
                    LoggerConstants.LOG_2.getType(), allocationDao.getCreatedBy(), allocationDao.getFkEnquiry());
        }
    }

    public List<Enquiry> getAllocatedEnquiry() {
        List<Enquiry> enquiries = eventMapper.getAllocatedEnquiry();
        enquiries.stream().forEach(enquiry -> enquiry.setCustomer(customerMapper.findCustomerById(enquiry.getFkCustomer())));
        return enquiries;
    }

    public List<Enquiry> getAllocatedEnquiryByUsers(String username) {
        List<Enquiry> enquiries = eventMapper.getAllocatedEnquiryByUsers(username);
        enquiries.stream().forEach(enquiry -> enquiry.setCustomer(customerMapper.findCustomerById(enquiry.getFkCustomer())));
        return enquiries;
    }

    public List<VenueSpacesDao> findAvailableSpacesForWeb(SearchEnquiryDao enquiryDao) {
        List<VenueSpacesDao> spacesDaos = eventMapper.findAvailableSpaces(enquiryDao);
        if (spacesDaos != null) {
            spacesDaos.stream()
                    .filter(space -> space.getAltPath() != null)
                    .forEach(spaces -> {
                        UploadImage image = new UploadImage();
                        image.setImage(this.fileService.findThumbnail(spaces.getAltPath(), spaces.getExt()));
                        image.setFkId(spaces.getFkDocument());
                        spaces.setImage(image);
                    });
        }
        return spacesDaos;
    }

    public List<Enquiry> getEnquiry(String status) {
        List<Enquiry> enquiries = eventMapper.getEnquiry(status);

        if (enquiries != null)
            enquiries.stream().forEach(enquiry -> enquiry.setCustomer(customerMapper.findCustomerById(enquiry.getFkCustomer())));
        return enquiries;
    }

    public Enquiry getEnquiryById(Long id) {
        Enquiry enquiry = eventMapper.getEnquiryById(id);
        if (enquiry != null) {
            enquiry.setCustomer(customerMapper.findCustomerById(enquiry.getFkCustomer()));
        }
        return enquiry;
    }

    public void reserveTimeWalkThrough(WalkThroughTime throughTime) {
        if (throughTime.getCalendar() != null && throughTime.getLocation() != null) {
            EdgeCalendar calendar = throughTime.getCalendar();
            calendar.setCreatedBy(throughTime.getCreatedBy());

            this.calendarService.saveCalendar(calendar);

            this.logService.createActLog(LoggerConstants.EDIT,
                    LoggerConstants.LOG_4.getType(), throughTime.getCreatedBy(), throughTime.getFkEnquiry());

            EdgeLocation location = throughTime.getLocation();
            location.setCreatedBy(throughTime.getCreatedBy());
            this.locationService.saveLocation(location);

            throughTime.setFkCalendar(calendar.getId());
            throughTime.setFkLocation(location.getId());

            if (throughTime.getPickupTime() != null) {
                try {
                    throughTime.setTime(timeFormat.parse(throughTime.getPickupTime()));
                } catch (ParseException e) {
                    LOGGER.error(e.getMessage(), e);
                }
            }
            eventMapper.deactivateWalkThroughSetup(throughTime.getFkEnquiry());
            eventMapper.saveWalkThroughSetup(throughTime);
            eventMapper.updateEnquiryStatus(throughTime.getFkEnquiry(), 1);

            this.logService.createActLog(LoggerConstants.CREATE,
                    LoggerConstants.LOG_3.getType(), throughTime.getCreatedBy(), throughTime.getFkEnquiry());
        }
    }

    public List<Enquiry> findLatestWalkthrough(int count) {
        return eventMapper.findLatestWalkthrough(count);
    }

    public List<EdgeLocation> findWalkThroughMapLocation(int count) {
        return eventMapper.findWalkThroughMapLocation(count);
    }

    public List<UploadImage> findSpaceImage(Long fkSpace) {
        List<EdgeDocument> images = documentMapper.findVenueSpaceImages(fkSpace);
        List<UploadImage> uploadImages = new ArrayList<>();

        for (EdgeDocument img : images) {
            if (img.getAltPath() != null) {
                UploadImage image = new UploadImage();
                image.setImage(fileService.findThumbnail(img.getAltPath(), img.getExt()));
                image.setFkId(img.getId());
                uploadImages.add(image);
            }
        }

        return uploadImages;
    }

    public Driver getDriverWithImage(Driver driver) {
        if (driver == null) {
            driver = new Driver();
            driver.setFullName("No Driver Allocation");
        } else if (driver != null && driver.getThumbnail() != null) {
            driver.setThumbnail(this.fileService.findThumbnail(driver.getThumbnail(), driver.getExt()));
        }
        return driver;
    }

    public void allocateDriver(EnquiryAllocationDao allocationDao) {
        /**
         * Generate Transport Voucher
         */
        TransportVoucherDao transportVoucherDao = new TransportVoucherDao();
        transportVoucherDao.setFkSysIdGenerator(1L);
        transportVoucherDao.setVoucherType("TRANSPORT");
        transportVoucherDao.setVoucherNumber(this.generatorService.generateId(ServiceConstants.VOUCHER_TYPE.getType()));
        transportVoucherDao.setActive(true);
        eventMapper.saveTransportVoucher(transportVoucherDao);
        /**
         * Generate Driver Allocation
         */
        allocationDao.setFkVoucher(transportVoucherDao.getId());
        this.eventMapper.saveDriverAllocation(allocationDao);
        if (allocationDao.getId() != null) {
            this.eventMapper.updateWalkThroughSetupForDriver(allocationDao.getFkEnquiry(), allocationDao.getId());
            this.eventMapper.updateDriverAllocation(allocationDao);
        }
    }

    public List<EnquiryDriverAllocationDao> getEnquiryByIdForDriverAllocation() {
        List<EnquiryDriverAllocationDao> enquiryList = eventMapper.getEnquiryByIdForDriverAllocation();
        enquiryList.stream().forEach(
                enquiry -> enquiry.setDriver(getDriverWithImage(driverMapper.findDriverById(enquiry.getFkDriver())))
        );
        enquiryList.stream().forEach(
                enquiry -> enquiry.setCustomer(customerMapper.findCustomerById(enquiry.getFkCustomer()))
        );
        return enquiryList;
    }

    public void unAllocateTransport(Enquiry enquiry) {
        enquiry.setCreatedDate(new Date());
        eventMapper.unAllocateTransport(enquiry);
        this.eventMapper.updateWalkThroughSetupForDriver(enquiry.getId(), null);
    }

    public WalkThroughTime findReserveTimeWalkThrough(Long id) {
        return eventMapper.findReserveTimeWalkThrough(id);
    }

    public Enquiry getEnquiryByWalkThroughId(Long id) {
        Enquiry enquiry = eventMapper.getEnquiryByWalkThroughId(id);
        if (enquiry != null) {
            enquiry.setCustomer(customerMapper.findCustomerById(enquiry.getFkCustomer()));
        }
        return enquiry;
    }
}
