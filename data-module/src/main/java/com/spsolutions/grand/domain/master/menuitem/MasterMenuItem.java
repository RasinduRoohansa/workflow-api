package com.spsolutions.grand.domain.master.menuitem;

import com.spsolutions.grand.domain.common.CommonDomain;

/**
 * @author kalana
 */
public class MasterMenuItem extends CommonDomain {
    private String itemName;
    private String itemCode;
    private String itemDescription;
    private String itemCost;
    private String itemPrice;
    private String categoryName;
    private String altPath;
    private String extension;
    private String image;
    private Long fkMasterSubItemCategoryId;
    private Long fkDocumentId;
    private boolean update;

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }

    public String getItemCost() {
        return itemCost;
    }

    public void setItemCost(String itemCost) {
        this.itemCost = itemCost;
    }

    public String getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(String itemPrice) {
        this.itemPrice = itemPrice;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Long getFkMasterSubItemCategoryId() {
        return fkMasterSubItemCategoryId;
    }

    public void setFkMasterSubItemCategoryId(Long fkMasterSubItemCategoryId) {
        this.fkMasterSubItemCategoryId = fkMasterSubItemCategoryId;
    }

    public Long getFkDocumentId() {
        return fkDocumentId;
    }

    public void setFkDocumentId(Long fkDocumentId) {
        this.fkDocumentId = fkDocumentId;
    }

    public boolean isUpdate() {
        return update;
    }

    public void setUpdate(boolean update) {
        this.update = update;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getAltPath() {
        return altPath;
    }

    public void setAltPath(String altPath) {
        this.altPath = altPath;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }
}
