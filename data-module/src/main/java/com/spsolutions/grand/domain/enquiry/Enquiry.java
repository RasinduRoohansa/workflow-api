package com.spsolutions.grand.domain.enquiry;

import com.spsolutions.grand.domain.common.CommonDomain;
import com.spsolutions.grand.domain.common.Customer;

import java.util.Date;

public class Enquiry extends CommonDomain {
    private Date startDate;
    private Date endDate;
    private int pax;
    private Long fkEventType;
    private Long fkVenueSpace;
    private String description;
    private Long fkCustomer;
    private Customer customer;
    private String eventType;
    private String venueName;
    private String venue;
    private int status;
    private Long fkDocument;
    private boolean processed;
    private boolean allocated;
    private int startTime;
    private int endTime;
    private String hearFrom;
    private String clientStory;
    private boolean clientStoryAdded;

    private Date allocatedDate;
    private String allocatedBy;
    private String allocatedTo, allocatedToUsername;

    public String getVenue() {
        return venue;
    }

    public void setVenue(String venue) {
        this.venue = venue;
    }

    public boolean isClientStoryAdded() {
        return clientStoryAdded;
    }

    public void setClientStoryAdded(boolean clientStoryAdded) {
        this.clientStoryAdded = clientStoryAdded;
    }

    public String getClientStory() {
        return clientStory;
    }

    public void setClientStory(String clientStory) {
        this.clientStory = clientStory;
    }

    public String getHearFrom() {
        return hearFrom;
    }

    public void setHearFrom(String hearFrom) {
        this.hearFrom = hearFrom;
    }

    public String getVenueName() {
        return venueName;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public void setVenueName(String venueName) {
        this.venueName = venueName;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public Long getFkCustomer() {
        return fkCustomer;
    }

    public void setFkCustomer(Long fkCustomer) {
        this.fkCustomer = fkCustomer;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
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

    public int getPax() {
        return pax;
    }

    public void setPax(int pax) {
        this.pax = pax;
    }

    public Long getFkEventType() {
        return fkEventType;
    }

    public void setFkEventType(Long fkEventType) {
        this.fkEventType = fkEventType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isProcessed() {
        return processed;
    }

    public void setProcessed(boolean processed) {
        this.processed = processed;
    }

    public Long getFkVenueSpace() {
        return fkVenueSpace;
    }

    public void setFkVenueSpace(Long fkVenueSpace) {
        this.fkVenueSpace = fkVenueSpace;
    }

    public Long getFkDocument() {
        return fkDocument;
    }

    public void setFkDocument(Long fkDocument) {
        this.fkDocument = fkDocument;
    }

    public boolean isAllocated() {
        return allocated;
    }

    public void setAllocated(boolean allocated) {
        this.allocated = allocated;
    }

    public Date getAllocatedDate() {
        return allocatedDate;
    }

    public void setAllocatedDate(Date allocatedDate) {
        this.allocatedDate = allocatedDate;
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

    public int getStartTime() {
        return startTime;
    }

    public void setStartTime(int startTime) {
        this.startTime = startTime;
    }

    public int getEndTime() {
        return endTime;
    }

    public void setEndTime(int endTime) {
        this.endTime = endTime;
    }
}
