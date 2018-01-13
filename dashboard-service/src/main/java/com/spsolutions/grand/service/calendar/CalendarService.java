package com.spsolutions.grand.service.calendar;

import com.spsolutions.grand.domain.calendar.EdgeCalendar;
import com.spsolutions.grand.domain.location.EdgeLocation;
import com.spsolutions.grand.mappers.calendar.CalendarMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CalendarService {

    @Autowired
    private CalendarMapper calendarMapper;

    public List<EdgeCalendar> findCalendarByUser(String username) {
        return this.calendarMapper.findCalendarByUser(username);
    }

    public void saveCalendar(EdgeCalendar calendar) {
        calendarMapper.saveCalendar(calendar);
    }
}
