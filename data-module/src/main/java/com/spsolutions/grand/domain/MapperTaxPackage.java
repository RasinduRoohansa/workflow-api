package com.spsolutions.grand.domain;

public class MapperTaxPackage {
    private Long fkPackage;
    private Long fkTaxAudit;

    public Long getFkPackage() {
        return fkPackage;
    }

    public void setFkPackage(Long fkPackage) {
        this.fkPackage = fkPackage;
    }

    public Long getFkTaxAudit() {
        return fkTaxAudit;
    }

    public void setFkTaxAudit(Long fkTaxAudit) {
        this.fkTaxAudit = fkTaxAudit;
    }
}
