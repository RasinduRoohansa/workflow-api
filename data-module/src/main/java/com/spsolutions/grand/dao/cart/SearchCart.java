package com.spsolutions.grand.dao.cart;

public class SearchCart {
    private String search;
    private Long fkItemCategory;
    private double from;
    private double to;
    private int offset;

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public double getFrom() {
        return from;
    }

    public void setFrom(double from) {
        this.from = from;
    }

    public double getTo() {
        return to;
    }

    public void setTo(double to) {
        this.to = to;
    }

    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
    }

    public Long getFkItemCategory() {
        return fkItemCategory;
    }

    public void setFkItemCategory(Long fkItemCategory) {
        this.fkItemCategory = fkItemCategory;
    }
}
