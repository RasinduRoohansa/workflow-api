package com.spsolutions.grand.domain.master;

import com.spsolutions.grand.domain.common.CommonDomain;

import java.util.List;

public class Venue extends CommonDomain {
    private String venueName;
    private String streetOne;
    private String streetTwo;
    private String country;
    private String city;
    private String state;
    private String web;
    private String phone;
    private String email;
    private String description;
    private List<VenueSpace> spaces;

    public String getVenueName() {
        return venueName;
    }

    public void setVenueName(String venueName) {
        this.venueName = venueName;
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

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
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

    public String getWeb() {
        return web;
    }

    public void setWeb(String web) {
        this.web = web;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<VenueSpace> getSpaces() {
        return spaces;
    }

    public void setSpaces(List<VenueSpace> spaces) {
        this.spaces = spaces;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
