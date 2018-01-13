package com.spsolutions.grand.mappers.roster;

import com.spsolutions.grand.dao.roster.BookingDao;
import com.spsolutions.grand.domain.booking.Booking;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RosterBookingMapper {


    /**
     * This will be used to retrieve all bookings which are active
     * @return List of active bookings
     */
    public List<Booking> getAllActiveBookings();

    /**
     * This will be used to retrieve all booking which are active, the retrieved columns are
     * customized,
     * @return
     */
    public List<BookingDao> getAllActiveCustomBooking();

}
