package com.spsolutions.grand.service.roster;

import com.spsolutions.grand.dao.roster.BookingDao;
import com.spsolutions.grand.domain.booking.Booking;
import com.spsolutions.grand.mappers.roster.RosterBookingMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *
 */
@Service
public class RosterBookingService {

    @Autowired
    private RosterBookingMapper rosterBookingMapper;

    /**
     * This will be used to retrieve all bookings which are active
     * @return List of active bookings
     */
    public List<Booking> getAllActiveBookings(){
        return rosterBookingMapper.getAllActiveBookings();
    }

    /**
     * This will be used to retrieve all booking which are active, the retrieved columns are
     * customized,
     * @return
     */
    public List<BookingDao> getAllActiveCustomBooking(){
        return rosterBookingMapper.getAllActiveCustomBooking();
    }
}
