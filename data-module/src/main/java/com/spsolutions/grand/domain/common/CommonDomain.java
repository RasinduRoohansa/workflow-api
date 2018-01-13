package com.spsolutions.grand.domain.common;

import java.util.Date;

public class CommonDomain {
    private Long id;
    private String createdBy;
    private String createdByFullname;
    private Date createdDate;
    private boolean activated;

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

    public boolean isActivated() {
        return activated;
    }

    public void setActivated(boolean activated) {
        this.activated = activated;
    }

    public String getCreatedByFullname() {
        return createdByFullname;
    }

    public void setCreatedByFullname(String createdByFullname) {
        this.createdByFullname = createdByFullname;
    }
}
