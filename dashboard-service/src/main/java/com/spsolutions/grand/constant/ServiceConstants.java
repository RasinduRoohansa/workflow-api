package com.spsolutions.grand.constant;

public enum ServiceConstants {
    BOOKING_TYPE("BOOKING"), VOUCHER_TYPE("VOUCHER"), INVOICE_TYPE("INVOICE");

    private String cons;

    ServiceConstants(String cons) {
        this.cons = cons;
    }

    public String getType() {
        return cons;
    }
}