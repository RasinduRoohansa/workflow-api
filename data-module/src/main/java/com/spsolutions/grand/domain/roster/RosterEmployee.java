package com.spsolutions.grand.domain.roster;

import com.spsolutions.grand.domain.common.CommonDomain;

/** Data model for the database model "ROSTER_EMPLOYEE"
 * @author Yasitha Goonetilleke
 **/
public class RosterEmployee extends CommonDomain{

    /** This id is from User Table*/
    private Long userId;
    private Long empTypeId;


    /** This id is from User Table*/
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getEmpTypeId() {
        return empTypeId;
    }

    public void setEmpTypeId(Long empTypeId) {
        this.empTypeId = empTypeId;
    }
}
