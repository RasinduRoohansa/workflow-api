package com.spsolutions.grand.dao;

import com.spsolutions.grand.domain.calendar.EdgeCalendar;
import com.spsolutions.grand.domain.common.CommonDomain;
import com.spsolutions.grand.domain.enquiry.Enquiry;
import com.spsolutions.grand.domain.location.EdgeLocation;

import java.util.Date;

public class WalkThroughTime extends CommonDomain {
    private Long fkEnquiry;
    private Long fkCalendar;
    private Long fkLocation;
    private boolean transport;
    private String pickupTime;
    private Date time;
    private String message;
    private EdgeLocation location;
    private EdgeCalendar calendar;
    private Enquiry enquiry;

    public Enquiry getEnquiry() {
        return enquiry;
    }

    public void setEnquiry(Enquiry enquiry) {
        this.enquiry = enquiry;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Long getFkCalendar() {
        return fkCalendar;
    }

    public void setFkCalendar(Long fkCalendar) {
        this.fkCalendar = fkCalendar;
    }

    public Long getFkLocation() {
        return fkLocation;
    }

    public void setFkLocation(Long fkLocation) {
        this.fkLocation = fkLocation;
    }

    public EdgeLocation getLocation() {
        return location;
    }

    public void setLocation(EdgeLocation location) {
        this.location = location;
    }

    public EdgeCalendar getCalendar() {
        return calendar;
    }

    public void setCalendar(EdgeCalendar calendar) {
        this.calendar = calendar;
    }

    public Long getFkEnquiry() {
        return fkEnquiry;
    }

    public void setFkEnquiry(Long fkEnquiry) {
        this.fkEnquiry = fkEnquiry;
    }

    public boolean isTransport() {
        return transport;
    }

    public void setTransport(boolean transport) {
        this.transport = transport;
    }

    public String getPickupTime() {
        return pickupTime;
    }

    public void setPickupTime(String pickupTime) {
        this.pickupTime = pickupTime;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
