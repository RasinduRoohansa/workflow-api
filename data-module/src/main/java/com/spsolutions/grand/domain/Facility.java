package com.spsolutions.grand.domain;

import com.spsolutions.grand.domain.common.CommonDomain;

public class Facility extends CommonDomain {
    private Long fkVenueSpace;
    private String facility;

    public Long getFkVenueSpace() {
        return fkVenueSpace;
    }

    public void setFkVenueSpace(Long fkVenueSpace) {
        this.fkVenueSpace = fkVenueSpace;
    }

    public String getFacility() {
        return facility;
    }

    public void setFacility(String facility) {
        this.facility = facility;
    }
}
