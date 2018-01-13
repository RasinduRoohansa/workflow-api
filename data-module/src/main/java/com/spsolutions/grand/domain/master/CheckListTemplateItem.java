package com.spsolutions.grand.domain.master;

import com.spsolutions.grand.domain.common.CommonDomain;

import java.util.Date;

public class CheckListTemplateItem extends CommonDomain {
    private Long fkMasterCheckList;
    private String itemName;
    private Boolean sheduled;
    private String sheduleType;
    private Integer sheduleMinute;
    private Date sheduleTime;

    public Long getFkMasterCheckList() {
        return fkMasterCheckList;
    }

    public void setFkMasterCheckList(Long fkMasterCheckList) {
        this.fkMasterCheckList = fkMasterCheckList;
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
