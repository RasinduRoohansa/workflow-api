package com.spsolutions.grand.resources.roster;


import com.spsolutions.grand.dao.roster.BookingDao;
import com.spsolutions.grand.domain.booking.Booking;
import com.spsolutions.grand.service.roster.RosterBookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/roasterBookingAPI/")
public class RosterBookingsAPI {

    @Autowired
    private RosterBookingService rosterBookingService;

    /**
     * This will be used to retrieve all bookings which are active
     * @return List of active bookings
     */
    @GetMapping("getAllActiveBookings")
    public List<Booking> getAllActiveBookings(){
        return rosterBookingService.getAllActiveBookings();
    }

    /**
     * This will be used to retrieve all booking which are active, the retrieved columns are
     * customized,
     * @return
     */
    @GetMapping("getAllActiveCustomBooking")
    public List<BookingDao> getAllActiveCustomBooking(){
        return rosterBookingService.getAllActiveCustomBooking();
    }
}




