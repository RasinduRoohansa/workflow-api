package com.spsolutions.grand.resources.booking;

import com.spsolutions.grand.dao.BookingTablePlanDao;
import com.spsolutions.grand.domain.EdgeDocument;
import com.spsolutions.grand.domain.booking.Booking;
import com.spsolutions.grand.domain.booking.BookingCheckListTemplate;
import com.spsolutions.grand.domain.booking.BookingCheckListTemplateItem;
import com.spsolutions.grand.service.booking.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

/**
 * @author Stelan Briyan
 */
@RestController
@RequestMapping(value = "/booking/")
public class BookingAPI {

    @Autowired
    private BookingService bookingService;

    @PostMapping("createBookingByWalkThrough")
    public Map<String, String> createBookingByWalkThrough(@RequestBody Booking booking) {
        return this.bookingService.createBookingByWalkThrough(booking);
    }

    @GetMapping("findAllBookings")
    public List<Booking> findAllBookings() {
        return this.bookingService.findAllBookings();
    }

    @GetMapping("findNextBooking")
    public Booking findNextBooking() {
        return this.bookingService.findNextBooking();
    }

    @GetMapping("findBookingById/{id}")
    public Booking findBookingById(@PathVariable("id") Long id) {
        return this.bookingService.findBookingById(id);
    }

    @PostMapping("uploadTablePlan/{fkBooking}/{username}")
    public Map<String, Object> uploadTablePlan(MultipartFile file,
                                               @PathVariable("fkBooking") Long fkBooking,
                                               @PathVariable("username") String username) {
        return this.bookingService.uploadTablePlan(file, fkBooking, username);
    }

    @GetMapping("findTablePlanHeader/{fkBooking}")
    public List<EdgeDocument> findTablePlanHeader(@PathVariable("fkBooking") Long fkBooking) {
        return this.bookingService.findTablePlanHeader(fkBooking);
    }

    @GetMapping("findTablePlan/{fkDocument}")
    public List<BookingTablePlanDao> findTablePlan(@PathVariable("fkDocument") Long fkDocument) {
        return this.bookingService.findTablePlan(fkDocument);
    }

    @GetMapping("findBookingCheckListTemplate/{fkBooking}")
    public BookingCheckListTemplate findBookingCheckListTemplate(@PathVariable("fkBooking") Long fkBooking) {
        return this.bookingService.findBookingCheckListTemplate(fkBooking);
    }

    @GetMapping("findBookingCheckListTemplateItem/{fkBooking}")
    public List<BookingCheckListTemplateItem> findBookingCheckListTemplateItem(@PathVariable("fkBooking") Long fkBooking) {
        return this.bookingService.findBookingCheckListTemplateItem(fkBooking);
    }

    @PostMapping("createBookingCheckListTemplate")
    public void createBookingCheckListTemplate(@RequestBody BookingCheckListTemplate checkListTemplate) {
        this.bookingService.createBookingCheckListTemplate(checkListTemplate);
    }

    @GetMapping("checkBookingCheckListItemDone/{fkId}")
    public void checkBookingCheckListItemDone(@PathVariable("fkId") Long fkId) {
        this.bookingService.checkBookingCheckListItemDone(fkId);
    }

    @PostMapping("saveBookingCheckListItem")
    public void saveBookingCheckListItem(@RequestBody BookingCheckListTemplateItem templateItem){
        this.bookingService.saveBookingCheckListItem(templateItem);
    }
}
