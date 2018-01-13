package com.spsolutions.grand.domain.roster;


import com.spsolutions.grand.domain.common.CommonDomain;

/**
 * Database model for "ROSTER_EMPLOYEE_TYPE"
 */
public class EmployeeType extends CommonDomain {


    private String employeeType;
    private String icon;


    public String getEmployeeType() {
        return employeeType;
    }

    public void setEmployeeType(String employeeType) {
        this.employeeType = employeeType;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }
}
