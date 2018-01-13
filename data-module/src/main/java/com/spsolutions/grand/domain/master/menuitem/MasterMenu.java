package com.spsolutions.grand.domain.master.menuitem;

import com.spsolutions.grand.domain.common.CommonDomain;

/**
 * @author kalana
 */
public class MasterMenu extends CommonDomain {
    private String menuName;
    private String menuCode;
    private String menuDescription;
    private String menuCost;
    private String menuPrice;
    private String menuMarkupPrice;
    private String altPath;
    private String extension;
    private String image;
    private Long fkDocumentId;
    private boolean update;

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String getMenuCode() {
        return menuCode;
    }

    public void setMenuCode(String menuCode) {
        this.menuCode = menuCode;
    }

    public String getMenuDescription() {
        return menuDescription;
    }

    public void setMenuDescription(String menuDescription) {
        this.menuDescription = menuDescription;
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
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

    public String getMenuCost() {
        return menuCost;
    }

    public void setMenuCost(String menuCost) {
        this.menuCost = menuCost;
    }

    public String getMenuPrice() {
        return menuPrice;
    }

    public void setMenuPrice(String menuPrice) {
        this.menuPrice = menuPrice;
    }

    public String getMenuMarkupPrice() {
        return menuMarkupPrice;
    }

    public void setMenuMarkupPrice(String menuMarkupPrice) {
        this.menuMarkupPrice = menuMarkupPrice;
    }
}
