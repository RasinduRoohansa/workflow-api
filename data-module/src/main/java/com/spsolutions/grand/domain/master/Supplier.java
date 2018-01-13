package com.spsolutions.grand.domain.master;

import com.spsolutions.grand.domain.common.CommonDomain;

public class Supplier extends CommonDomain {
    private String supplierName;
    private String code;
    private String companyName;
    private String streetOne;
    private String streetTwo;
    private String city;
    private String country;
    private String telephoneOne;
    private String telephoneTwo;
    private String fax;
    private String email;


    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
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

    public String getTelephoneTwo() {
        return telephoneTwo;
    }

    public void setTelephoneTwo(String telephoneTwo) {
        this.telephoneTwo = telephoneTwo;
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
}
