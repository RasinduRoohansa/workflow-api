package com.spsolutions.grand.dao.cart;

import com.spsolutions.grand.domain.common.CommonDomain;

public class CartPackage extends CommonDomain {
    private Long fkWalkThrough;
    private Long fkPackage;
    private Double totalCost;
    private Double cost;
    private Double taxRate;
    private Double markup;
    private Double qty;
    private String qtyType;
    private String packageName;
    private String image;
    private String ext;

    public String getExt() {
        return ext;
    }

    public void setExt(String ext) {
        this.ext = ext;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public Double getQty() {
        return qty;
    }

    public void setQty(Double qty) {
        this.qty = qty;
    }

    public String getQtyType() {
        return qtyType;
    }

    public void setQtyType(String qtyType) {
        this.qtyType = qtyType;
    }

    public Double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(Double totalCost) {
        this.totalCost = totalCost;
    }

    public Double getTaxRate() {
        return taxRate;
    }

    public void setTaxRate(Double taxRate) {
        this.taxRate = taxRate;
    }

    public Double getMarkup() {
        return markup;
    }

    public void setMarkup(Double markup) {
        this.markup = markup;
    }

    public Long getFkWalkThrough() {
        return fkWalkThrough;
    }

    public void setFkWalkThrough(Long fkWalkThrough) {
        this.fkWalkThrough = fkWalkThrough;
    }

    public Long getFkPackage() {
        return fkPackage;
    }

    public void setFkPackage(Long fkPackage) {
        this.fkPackage = fkPackage;
    }
}
