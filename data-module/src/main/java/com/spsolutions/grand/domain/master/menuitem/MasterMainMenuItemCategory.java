package com.spsolutions.grand.domain.master.menuitem;

import com.spsolutions.grand.domain.common.CommonDomain;

/**
 * @author kalana
 */
public class MasterMainMenuItemCategory extends CommonDomain {

    private String menuName;
    private Long fkDocument;
    private String altPath;
    private String extension;
    private String image;

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public Long getFkDocument() {
        return fkDocument;
    }

    public void setFkDocument(Long fkDocument) {
        this.fkDocument = fkDocument;
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
}
