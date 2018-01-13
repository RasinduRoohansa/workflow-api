package com.spsolutions.grand.constant;

public enum LoggerConstants {
    CREATE("create"), VIEW("view"), DELETE("delete"), EDIT("edit"),

    LOG_1("created a enquiry through the enquiry page."),
    LOG_2("Enquiry is allocated to the Sales Manager."),
    LOG_4("Event calendar updated."),
    LOG_5("Question template is assigned to the enquiry"),
    LOG_3("Pickup location details saved.");

    private String cons;

    LoggerConstants(String cons) {
        this.cons = cons;
    }

    public String getType() {
        return cons;
    }
}
