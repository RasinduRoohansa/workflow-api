package com.spsolutions.grand.domain.master;

import com.spsolutions.grand.domain.Tax;
import com.spsolutions.grand.domain.common.CommonDomain;

import java.util.List;

public class Package extends CommonDomain {
    private String packageName;
    private Long fkSupplier;
    private Long fkDocument;
    private Supplier supplier;
    private String description;
    private String image;
    private String altPath;
    private String ext;
    private String unitType;
    private double cost;
    private double taxRate;
    private double markup;
    private int qty;
    private List<Item> packageItems;
    private List<Tax> tax;
    private boolean update;

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

    public boolean isUpdate() {
        return update;
    }

    public void setUpdate(boolean update) {
        this.update = update;
    }

    public List<Tax> getTax() {
        return tax;
    }

    public void setTax(List<Tax> tax) {
        this.tax = tax;
    }

    public List<Item> getPackageItems() {
        return packageItems;
    }

    public void setPackageItems(List<Item> packageItems) {
        this.packageItems = packageItems;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public Long getFkSupplier() {
        return fkSupplier;
    }

    public void setFkSupplier(Long fkSupplier) {
        this.fkSupplier = fkSupplier;
    }

    public String getUnitType() {
        return unitType;
    }

    public void setUnitType(String unitType) {
        this.unitType = unitType;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public double getTaxRate() {
        return taxRate;
    }

    public void setTaxRate(double taxRate) {
        this.taxRate = taxRate;
    }

    public double getMarkup() {
        return markup;
    }

    public void setMarkup(double markup) {
        this.markup = markup;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }
}
