package com.spsolutions.grand.domain;

import java.util.Date;

public class MapperUserRole {
    private Long id;
    private Long fkRole;
    private Long fkUser;
    private Date createdDate;
    private boolean activated;

    public boolean isActivated() {
        return activated;
    }

    public void setActivated(boolean activated) {
        this.activated = activated;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getFkRole() {
        return fkRole;
    }

    public void setFkRole(Long fkRole) {
        this.fkRole = fkRole;
    }

    public Long getFkUser() {
        return fkUser;
    }

    public void setFkUser(Long fkUser) {
        this.fkUser = fkUser;
    }
}
