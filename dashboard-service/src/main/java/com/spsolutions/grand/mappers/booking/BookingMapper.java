package com.spsolutions.grand.mappers.booking;

import com.spsolutions.grand.domain.booking.Booking;
import com.spsolutions.grand.domain.booking.BookingCheckListTemplate;
import com.spsolutions.grand.domain.booking.BookingCheckListTemplateItem;
import com.spsolutions.grand.domain.booking.BookingTablePlan;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BookingMapper {
    void createBookingByWalkThrough(Booking booking);

    List<Booking> findAllBookings();

    Booking findNextBooking();

    Booking findBookingById(Long id);

    void saveTablePlan(BookingTablePlan tablePlan);

    List<BookingTablePlan> findTablePlan(Long fkDocument);

    void createBookingCheckListTemplate(BookingCheckListTemplate checkListTemplate);

    void deactivateBookingCheckList(Long fkBooking);

    BookingCheckListTemplate findBookingCheckListTemplate(Long fkBooking);

    void createBookingCheckListTemplateItem(BookingCheckListTemplateItem templateItem);

    List<BookingCheckListTemplateItem> findBookingCheckListTemplateItem(Long fkBooking);

    void checkBookingCheckListItemDone(Long fkId);
}
