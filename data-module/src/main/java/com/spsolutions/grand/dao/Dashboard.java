package com.spsolutions.grand.dao;

import com.spsolutions.grand.domain.enquiry.Enquiry;
import com.spsolutions.grand.domain.location.EdgeLocation;

import java.util.List;

public class Dashboard {
    private List<Enquiry> enquiry;
    private List<EdgeLocation> mapLocation;

    public List<EdgeLocation> getMapLocation() {
        return mapLocation;
    }

    public void setMapLocation(List<EdgeLocation> mapLocation) {
        this.mapLocation = mapLocation;
    }

    public List<Enquiry> getEnquiry() {
        return enquiry;
    }

    public void setEnquiry(List<Enquiry> enquiry) {
        this.enquiry = enquiry;
    }
}
