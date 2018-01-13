package com.spsolutions.grand.dao;

import com.spsolutions.grand.domain.common.CommonDomain;

import java.util.Date;

/**
 * @author RasinduRoohansa
 * @since  28-12-2017
 */
public class TransportVoucherDao extends CommonDomain {
        private String customerName,driverName,bookingNumber,pickupLocation,driverImage,customerImage,thumbnail,ext,customerProfilePic,voucherNumber,pax,voucherType;
        private Date eventFromDate,eventToDate,pickUpTime;
        private Double lan,lon;
        private Long fkSysIdGenerator,fkBooking;
        private Boolean active;

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public String getBookingNumber() {
        return bookingNumber;
    }

    public void setBookingNumber(String bookingNumber) {
        this.bookingNumber = bookingNumber;
    }

    public String getPickupLocation() {
        return pickupLocation;
    }

    public void setPickupLocation(String pickupLocation) {
        this.pickupLocation = pickupLocation;
    }

    public Date getEventFromDate() {
        return eventFromDate;
    }

    public void setEventFromDate(Date eventFromDate) {
        this.eventFromDate = eventFromDate;
    }

    public Date getEventToDate() {
        return eventToDate;
    }

    public void setEventToDate(Date eventToDate) {
        this.eventToDate = eventToDate;
    }

    public String getDriverImage() {
        return driverImage;
    }

    public void setDriverImage(String driverImage) {
        this.driverImage = driverImage;
    }

    public String getCustomerImage() {
        return customerImage;
    }

    public void setCustomerImage(String customerImage) {
        this.customerImage = customerImage;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getExt() {
        return ext;
    }

    public void setExt(String ext) {
        this.ext = ext;
    }

    public String getCustomerProfilePic() {
        return customerProfilePic;
    }

    public void setCustomerProfilePic(String customerProfilePic) {
        this.customerProfilePic = customerProfilePic;
    }

    public String getVoucherNumber() {
        return voucherNumber;
    }

    public void setVoucherNumber(String voucherNumber) {
        this.voucherNumber = voucherNumber;
    }

    public String getPax() {
        return pax;
    }

    public void setPax(String pax) {
        this.pax = pax;
    }

    public Double getLan() {
        return lan;
    }

    public void setLan(Double lan) {
        this.lan = lan;
    }

    public Double getLon() {
        return lon;
    }

    public void setLon(Double lon) {
        this.lon = lon;
    }

    public String getVoucherType() {
        return voucherType;
    }

    public void setVoucherType(String voucherType) {
        this.voucherType = voucherType;
    }

    public Long getFkSysIdGenerator() {
        return fkSysIdGenerator;
    }

    public void setFkSysIdGenerator(Long fkSysIdGenerator) {
        this.fkSysIdGenerator = fkSysIdGenerator;
    }

    public Long getFkBooking() {
        return fkBooking;
    }

    public void setFkBooking(Long fkBooking) {
        this.fkBooking = fkBooking;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Date getPickUpTime() {
        return pickUpTime;
    }

    public void setPickUpTime(Date pickUpTime) {
        this.pickUpTime = pickUpTime;
    }
}
