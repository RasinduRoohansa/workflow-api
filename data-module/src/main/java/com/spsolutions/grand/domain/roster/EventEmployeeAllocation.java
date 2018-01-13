package com.spsolutions.grand.domain.roster;

import com.spsolutions.grand.domain.common.CommonDomain;

/**
 *  Respective database table name is "ROSTER_EVENT_ALLOCATION_MAPPER"
 */
public class EventEmployeeAllocation extends CommonDomain {

    /** This is also known as booking id*/
    private long eventId;
    private long employeeTypeId;
    private int  noOfEmployee;
    private int  noOfPeople;

    /** This is also known as booking id*/
    public long getEventId() {
        return eventId;
    }

    public void setEventId(long eventId) {
        this.eventId = eventId;
    }

    public long getEmployeeTypeId() {
        return employeeTypeId;
    }

    public void setEmployeeTypeId(long employeeTypeId) {
        this.employeeTypeId = employeeTypeId;
    }

    public int getNoOfEmployee() {
        return noOfEmployee;
    }

    public void setNoOfEmployee(int noOfEmployee) {
        this.noOfEmployee = noOfEmployee;
    }

    public int getNoOfPeople() {
        return noOfPeople;
    }

    public void setNoOfPeople(int noOfPeople) {
        this.noOfPeople = noOfPeople;
    }
}
