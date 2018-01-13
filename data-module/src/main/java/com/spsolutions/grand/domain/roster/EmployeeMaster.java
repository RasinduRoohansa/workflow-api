package com.spsolutions.grand.domain.roster;

import com.spsolutions.grand.domain.common.CommonDomain;

import java.util.Date;

public class EmployeeMaster extends CommonDomain {

    private String fullName;
    private String code;
    private String streetOne;
    private String streetTwo;
    private String city;
    private String state;
    private String zipCode;
    private String country;
    private String telephoneOne;
    private String mobile;
    private String fax;
    private String email;
    private String createdBy;
    private Date createdDate;
    private Long fkDocument;
    private String image;
    private String thumbnail;
    private String ext;
    private boolean update;
    private Long fkEmpType;



    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getStreetOne() {
        return streetOne;
    }

    public void setStreetOne(String streetOne) {
        this.streetOne = streetOne;
    }

    public String getStreetTwo() {
        return streetTwo;
    }

    public void setStreetTwo(String streetTwo) {
        this.streetTwo = streetTwo;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getTelephoneOne() {
        return telephoneOne;
    }

    public void setTelephoneOne(String telephoneOne) {
        this.telephoneOne = telephoneOne;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public Long getFkDocument() {
        return fkDocument;
    }

    public void setFkDocument(Long fkDocument) {
        this.fkDocument = fkDocument;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
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

    public boolean isUpdate() {
        return update;
    }

    public void setUpdate(boolean update) {
        this.update = update;
    }

    public Long getFkEmpType() {
        return fkEmpType;
    }

    public void setFkEmpType(Long fkEmpType) {
        this.fkEmpType = fkEmpType;
    }
}
