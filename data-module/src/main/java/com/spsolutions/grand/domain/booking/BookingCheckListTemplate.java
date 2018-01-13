package com.spsolutions.grand.domain.booking;

import com.spsolutions.grand.domain.common.CommonDomain;

public class BookingCheckListTemplate extends CommonDomain {
    private Long fkBooking;
    private Long fkMasterCheckList;
    private Long fkUser;

    public Long getFkBooking() {
        return fkBooking;
    }

    public void setFkBooking(Long fkBooking) {
        this.fkBooking = fkBooking;
    }

    public Long getFkMasterCheckList() {
        return fkMasterCheckList;
    }

    public void setFkMasterCheckList(Long fkMasterCheckList) {
        this.fkMasterCheckList = fkMasterCheckList;
    }

    public Long getFkUser() {
        return fkUser;
    }

    public void setFkUser(Long fkUser) {
        this.fkUser = fkUser;
    }
}
