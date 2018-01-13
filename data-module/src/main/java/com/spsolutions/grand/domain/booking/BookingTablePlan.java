package com.spsolutions.grand.domain.booking;

import com.spsolutions.grand.domain.common.CommonDomain;

public class BookingTablePlan extends CommonDomain {
    private String tableNumber;
    private String salutation;
    private String fullName;
    private String contact;
    private Long fkBooking;
    private Long fkDocument;


    public Long getFkBooking() {
        return fkBooking;
    }

    public void setFkBooking(Long fkBooking) {
        this.fkBooking = fkBooking;
    }

    public Long getFkDocument() {
        return fkDocument;
    }

    public void setFkDocument(Long fkDocument) {
        this.fkDocument = fkDocument;
    }

    public String getTableNumber() {
        return tableNumber;
    }

    public void setTableNumber(String tableNumber) {
        this.tableNumber = tableNumber;
    }

    public String getSalutation() {
        return salutation;
    }

    public void setSalutation(String salutation) {
        this.salutation = salutation;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }
}
