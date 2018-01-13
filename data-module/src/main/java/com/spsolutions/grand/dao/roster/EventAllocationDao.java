package com.spsolutions.grand.dao.roster;


import java.util.Date;

/**
 * Data Access object to be used in Event RosterEmployee Allocation API
 */
public class EventAllocationDao {

    private Long id;
    /** Event allocation created user */
    private String createdBy;
    private Date createdDate;
    private boolean isActive;
    /** AKA booking id */
    private Long eventId;
    private Long employeeTypeId;
    private Integer noOfEmployee;
    private Integer noOfPeople;
    private String employeeType;
    /** No of active allocated employees will be in here */
    private Integer allocatedCount;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    /** Event allocation created user */
    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    /** AKA booking id */
    public Long getEventId() {
        return eventId;
    }

    public void setEventId(Long eventId) {
        this.eventId = eventId;
    }

    public Long getEmployeeTypeId() {
        return employeeTypeId;
    }

    public void setEmployeeTypeId(Long employeeTypeId) {
        this.employeeTypeId = employeeTypeId;
    }

    public Integer getNoOfEmployee() {
        return noOfEmployee;
    }

    public void setNoOfEmployee(Integer noOfEmployee) {
        this.noOfEmployee = noOfEmployee;
    }

    public Integer getNoOfPeople() {
        return noOfPeople;
    }

    public void setNoOfPeople(Integer noOfPeople) {
        this.noOfPeople = noOfPeople;
    }

    public String getEmployeeType() {
        return employeeType;
    }

    public void setEmployeeType(String employeeType) {
        this.employeeType = employeeType;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    /** No of active allocated employees will be in here */
    public Integer getAllocatedCount() {
        return allocatedCount;
    }

    public void setAllocatedCount(Integer allocatedCount) {
        this.allocatedCount = allocatedCount;
    }
}
