package com.spsolutions.grand.domain.master;

import com.spsolutions.grand.domain.common.CommonDomain;

public class Item extends CommonDomain{
    private String itemName;
    private String description;
    private String category;
    private Long fkItemCategory;
    private String image;
    private String ext;
    private Long fkDocument;

    public String getExt() {
        return ext;
    }

    public void setExt(String ext) {
        this.ext = ext;
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

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getFkItemCategory() {
        return fkItemCategory;
    }

    public void setFkItemCategory(Long fkItemCategory) {
        this.fkItemCategory = fkItemCategory;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
