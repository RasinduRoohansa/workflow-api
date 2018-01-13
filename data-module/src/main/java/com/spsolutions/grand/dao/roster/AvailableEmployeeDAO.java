package com.spsolutions.grand.dao.roster;


import java.util.Date;

/**
 * Data Access object to be used in Event RosterEmployee Allocation API
 *
 * And this will contain employee who have not allocated to any of the even
 */
public class AvailableEmployeeDAO {

    /** Id of the employee table */
    private Long id;
    /*Person who created the employee entry*/
    private String createdBy;
    private Date createdDate;
    private boolean isActive;
    private Long userId;
    private Long employeeTypeId;
    private String empType;
    /** Full name of the user/employee*/
    private String userName;


    /** Id of the employee table */
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getEmployeeTypeId() {
        return employeeTypeId;
    }

    public void setEmployeeTypeId(Long employeeTypeId) {
        this.employeeTypeId = employeeTypeId;
    }

    public String getEmpType() {
        return empType;
    }

    public void setEmpType(String empType) {
        this.empType = empType;
    }

    /** Full name of the user/employee*/
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
