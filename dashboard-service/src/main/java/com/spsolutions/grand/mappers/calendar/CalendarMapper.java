package com.spsolutions.grand.mappers.calendar;

import com.spsolutions.grand.domain.calendar.EdgeCalendar;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CalendarMapper {
    List<EdgeCalendar> findCalendarByUser(String username);

    void saveCalendar(EdgeCalendar calendar);
}
