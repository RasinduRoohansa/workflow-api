package com.spsolutions.grand.dao;

import com.spsolutions.grand.domain.calendar.EdgeCalendar;
import com.spsolutions.grand.domain.common.CommonDomain;
import com.spsolutions.grand.domain.common.Customer;
import com.spsolutions.grand.domain.location.EdgeLocation;
import com.spsolutions.grand.domain.master.Driver;

import java.util.Date;

/**
 * @author RasinduRoohansa
 * @since  26-12-2017
 */
public class EnquiryDriverAllocationDao extends CommonDomain {
    private Date startDate,endDate;
    private Integer pax,startTime,endTime,status;
    private Long fkEventType,fkVenueSpace,fkCustomer,fkDocument,fkDriver;
    private String description,eventType,venueName,allocatedBy,allocatedTo, allocatedToUsername;
    private Boolean processed;
    private Boolean allocated;
    private Date allocatedDate;
    private Driver driver;
    private Customer customer;

    private Long fkDriverAllocation;
    private Date pickTime;
    private EdgeCalendar calendar;
    private EdgeLocation location;

    public Long getFkDriverAllocation() {
        return fkDriverAllocation;
    }

    public void setFkDriverAllocation(Long fkDriverAllocation) {
        this.fkDriverAllocation = fkDriverAllocation;
    }

    public Date getPickTime() {
        return pickTime;
    }

    public void setPickTime(Date pickTime) {
        this.pickTime = pickTime;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Integer getPax() {
        return pax;
    }

    public void setPax(Integer pax) {
        this.pax = pax;
    }

    public Integer getStartTime() {
        return startTime;
    }

    public void setStartTime(Integer startTime) {
        this.startTime = startTime;
    }

    public Integer getEndTime() {
        return endTime;
    }

    public void setEndTime(Integer endTime) {
        this.endTime = endTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Long getFkEventType() {
        return fkEventType;
    }

    public void setFkEventType(Long fkEventType) {
        this.fkEventType = fkEventType;
    }

    public Long getFkVenueSpace() {
        return fkVenueSpace;
    }

    public void setFkVenueSpace(Long fkVenueSpace) {
        this.fkVenueSpace = fkVenueSpace;
    }

    public Long getFkCustomer() {
        return fkCustomer;
    }

    public void setFkCustomer(Long fkCustomer) {
        this.fkCustomer = fkCustomer;
    }

    public Long getFkDocument() {
        return fkDocument;
    }

    public void setFkDocument(Long fkDocument) {
        this.fkDocument = fkDocument;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public String getVenueName() {
        return venueName;
    }

    public void setVenueName(String venueName) {
        this.venueName = venueName;
    }

    public String getAllocatedBy() {
        return allocatedBy;
    }

    public void setAllocatedBy(String allocatedBy) {
        this.allocatedBy = allocatedBy;
    }

    public String getAllocatedTo() {
        return allocatedTo;
    }

    public void setAllocatedTo(String allocatedTo) {
        this.allocatedTo = allocatedTo;
    }

    public String getAllocatedToUsername() {
        return allocatedToUsername;
    }

    public void setAllocatedToUsername(String allocatedToUsername) {
        this.allocatedToUsername = allocatedToUsername;
    }

    public Boolean getProcessed() {
        return processed;
    }

    public void setProcessed(Boolean processed) {
        this.processed = processed;
    }

    public Boolean getAllocated() {
        return allocated;
    }

    public void setAllocated(Boolean allocated) {
        this.allocated = allocated;
    }

    public Date getAllocatedDate() {
        return allocatedDate;
    }

    public void setAllocatedDate(Date allocatedDate) {
        this.allocatedDate = allocatedDate;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public Long getFkDriver() {
        return fkDriver;
    }

    public void setFkDriver(Long fkDriver) {
        this.fkDriver = fkDriver;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public EdgeCalendar getCalendar() {
        return calendar;
    }

    public void setCalendar(EdgeCalendar calendar) {
        this.calendar = calendar;
    }

    public EdgeLocation getLocation() {
        return location;
    }

    public void setLocation(EdgeLocation location) {
        this.location = location;
    }
}
