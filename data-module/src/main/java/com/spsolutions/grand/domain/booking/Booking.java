package com.spsolutions.grand.domain.booking;

import com.spsolutions.grand.domain.common.CommonDomain;
import com.spsolutions.grand.domain.enquiry.Enquiry;

import java.util.Date;

public class Booking extends CommonDomain {
    private Long fkWalkThrough;
    private String bookingNumber;
    private Double depositAmount;

    private Date startDate;
    private Date endDate;

    private Enquiry enquiry;

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

    public Enquiry getEnquiry() {
        return enquiry;
    }

    public void setEnquiry(Enquiry enquiry) {
        this.enquiry = enquiry;
    }

    public Double getDepositAmount() {
        return depositAmount;
    }

    public void setDepositAmount(Double depositAmount) {
        this.depositAmount = depositAmount;
    }

    public Long getFkWalkThrough() {
        return fkWalkThrough;
    }

    public void setFkWalkThrough(Long fkWalkThrough) {
        this.fkWalkThrough = fkWalkThrough;
    }

    public String getBookingNumber() {
        return bookingNumber;
    }

    public void setBookingNumber(String bookingNumber) {
        this.bookingNumber = bookingNumber;
    }
}
