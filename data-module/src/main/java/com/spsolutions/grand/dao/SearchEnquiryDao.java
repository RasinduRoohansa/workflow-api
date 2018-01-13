package com.spsolutions.grand.dao;

import java.util.Date;

public class SearchEnquiryDao {
    private Date startDate;
    private Date endDate;
    private int pax;
    private Long fkEventType;

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
}
