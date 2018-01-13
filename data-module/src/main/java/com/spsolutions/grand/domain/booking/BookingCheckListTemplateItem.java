package com.spsolutions.grand.domain.booking;

import com.spsolutions.grand.domain.common.CommonDomain;

import java.util.Date;

public class BookingCheckListTemplateItem extends CommonDomain {
    private Long fkBookingCheckList;
    private Long fkMasterCheckListItem;
    private String itemName;
    private Boolean sheduled;
    private String sheduleType;
    private Integer sheduleMinute;
    private Date sheduleTime;
    private Date doneTime;
    private Boolean done;

    public Date getDoneTime() {
        return doneTime;
    }

    public void setDoneTime(Date doneTime) {
        this.doneTime = doneTime;
    }

    public Boolean getDone() {
        return done;
    }

    public void setDone(Boolean done) {
        this.done = done;
    }

    public Long getFkBookingCheckList() {
        return fkBookingCheckList;
    }

    public void setFkBookingCheckList(Long fkBookingCheckList) {
        this.fkBookingCheckList = fkBookingCheckList;
    }

    public Long getFkMasterCheckListItem() {
        return fkMasterCheckListItem;
    }

    public void setFkMasterCheckListItem(Long fkMasterCheckListItem) {
        this.fkMasterCheckListItem = fkMasterCheckListItem;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public Boolean getSheduled() {
        return sheduled;
    }

    public void setSheduled(Boolean sheduled) {
        this.sheduled = sheduled;
    }

    public String getSheduleType() {
        return sheduleType;
    }

    public void setSheduleType(String sheduleType) {
        this.sheduleType = sheduleType;
    }

    public Integer getSheduleMinute() {
        return sheduleMinute;
    }

    public void setSheduleMinute(Integer sheduleMinute) {
        this.sheduleMinute = sheduleMinute;
    }

    public Date getSheduleTime() {
        return sheduleTime;
    }

    public void setSheduleTime(Date sheduleTime) {
        this.sheduleTime = sheduleTime;
    }
}
