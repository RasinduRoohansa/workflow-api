package com.spsolutions.grand.dao;

import com.spsolutions.grand.domain.Facility;
import com.spsolutions.grand.domain.common.CommonDomain;
import com.spsolutions.grand.domain.master.Venue;

import java.util.List;

public class VenueSpacesDao extends CommonDomain {
    private Long fkVenue;
    private Long fkDocument;
    private String name;
    private String description;
    private UploadImage image;
    private int max;
    private int min;
    private Venue venue;
    private List<UploadImage> images;
    private List<Facility> facilities;
    private String altPath;
    private String ext;

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public String getAltPath() {
        return altPath;
    }

    public void setAltPath(String altPath) {
        this.altPath = altPath;
    }

    public String getExt() {
        return ext;
    }

    public void setExt(String ext) {
        this.ext = ext;
    }

    public List<UploadImage> getImages() {
        return images;
    }

    public void setImages(List<UploadImage> images) {
        this.images = images;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getFkVenue() {
        return fkVenue;
    }

    public void setFkVenue(Long fkVenue) {
        this.fkVenue = fkVenue;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public Venue getVenue() {
        return venue;
    }

    public void setVenue(Venue venue) {
        this.venue = venue;
    }

    public Long getFkDocument() {
        return fkDocument;
    }

    public void setFkDocument(Long fkDocument) {
        this.fkDocument = fkDocument;
    }

    public UploadImage getImage() {
        return image;
    }

    public void setImage(UploadImage image) {
        this.image = image;
    }

    public List<Facility> getFacilities() {
        return facilities;
    }

    public void setFacilities(List<Facility> facilities) {
        this.facilities = facilities;
    }
}
