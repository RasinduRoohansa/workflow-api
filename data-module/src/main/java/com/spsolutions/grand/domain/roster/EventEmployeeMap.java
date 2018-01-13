package com.spsolutions.grand.domain.roster;

/** Database model for 'ROSTER_EVENT_EMPLOYEE_MAP'
 */
import com.spsolutions.grand.domain.common.CommonDomain;

public class EventEmployeeMap extends CommonDomain{

    /** ID for the event AKA booking id */
    private long eventId;
    /** ID for the employee AKA User id */
    private long empID;
    /** ID for the employee Type*/
    private long empTypeId;


    /** ID for the event*/
    public long getEventId() {
        return eventId;
    }

    public void setEventId(long eventId) {
        this.eventId = eventId;
    }

    /** ID for the employee AKA User id */
    public long getEmpID() {
        return empID;
    }

    public void setEmpID(long empID) {
        this.empID = empID;
    }

    /** ID for the employee Type*/
    public long getEmpTypeId() {
        return empTypeId;
    }

    public void setEmpTypeId(long empTypeId) {
        this.empTypeId = empTypeId;
    }
}
