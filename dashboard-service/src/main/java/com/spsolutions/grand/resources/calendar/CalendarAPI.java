package com.spsolutions.grand.resources.calendar;

import com.spsolutions.grand.domain.calendar.EdgeCalendar;
import com.spsolutions.grand.service.calendar.CalendarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Stelan Briyan
 */
@RestController
@RequestMapping(value = "/calendar/")
public class CalendarAPI {

    @Autowired
    private CalendarService calendarService;

    @GetMapping("findCalendarByUser/{username}")
    public List<EdgeCalendar> findCalendarByUser(@PathVariable("username") String username) {
        return this.calendarService.findCalendarByUser(username);
    }
}
