package com.spsolutions.grand.dao;

import com.spsolutions.grand.domain.common.CommonDomain;

public class ItemPackage extends CommonDomain{
    private Long fkMasterPackage;
    private Long fkMasterItem;

    public Long getFkMasterPackage() {
        return fkMasterPackage;
    }

    public void setFkMasterPackage(Long fkMasterPackage) {
        this.fkMasterPackage = fkMasterPackage;
    }

    public Long getFkMasterItem() {
        return fkMasterItem;
    }

    public void setFkMasterItem(Long fkMasterItem) {
        this.fkMasterItem = fkMasterItem;
    }
}
