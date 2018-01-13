package com.spsolutions.grand.domain.master.menuitem;


import com.spsolutions.grand.domain.common.CommonDomain;

/**
 * @author kalana
 */
public class MasterSubMenuItemCategory extends CommonDomain {
    private String categoryName;
    private Long fkDocument;
    private String altPath;
    private String extension;


    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
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
}
