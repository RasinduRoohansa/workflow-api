package com.spsolutions.grand.dao.roster;


import java.util.Date;

/**
 * Data Access object for to be used in BookingAPI
 * @author Yasitha
 * */
public class BookingDao {

    private Long id;
    private String bookingNumber;
    /** Name of the user who created the booking entry*/
    private String bookingCreatedBy;
    /** The date booking was created*/
    private Date createDate;
    private String customer;
    private String salesPerson;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBookingNumber() {
        return bookingNumber;
    }

    public void setBookingNumber(String bookingNumber) {
        this.bookingNumber = bookingNumber;
    }

    /** Name of the user who created the booking entry*/
    public String getBookingCreatedBy() {
        return bookingCreatedBy;
    }

    public void setBookingCreatedBy(String bookingCreatedBy) {
        this.bookingCreatedBy = bookingCreatedBy;
    }

    /** The date booking was created*/
    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public String getSalesPerson() {
        return salesPerson;
    }

    public void setSalesPerson(String salesPerson) {
        this.salesPerson = salesPerson;
    }
}
