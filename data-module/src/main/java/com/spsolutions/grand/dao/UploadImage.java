package com.spsolutions.grand.dao;

import com.spsolutions.grand.domain.common.CommonDomain;

public class UploadImage extends CommonDomain {
    private Long fkId;
    private String image;

    public Long getFkId() {
        return fkId;
    }

    public void setFkId(Long fkId) {
        this.fkId = fkId;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
