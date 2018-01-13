package com.spsolutions.grand.domain.master;

import com.spsolutions.grand.domain.common.CommonDomain;

public class VenueSpace extends CommonDomain{
    private Long fkVenue;
    private String name;
    private String description;
    private String image;
    private int max;
    private int min;
    private String documentPath;
    private Long fkDocument;
    private String thumbnail;
    private String ext;

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

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public Long getFkVenue() {
        return fkVenue;
    }

    public void setFkVenue(Long fkVenue) {
        this.fkVenue = fkVenue;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDocumentPath() {
        return documentPath;
    }

    public void setDocumentPath(String documentPath) {
        this.documentPath = documentPath;
    }

    public Long getFkDocument() {
        return fkDocument;
    }

    public void setFkDocument(Long fkDocument) {
        this.fkDocument = fkDocument;
    }
}
