package com.spsolutions.grand.dao;

public class EnquiryClientStory {
    private Long fkEnquiryId;
    private String clientStory;

    public Long getFkEnquiryId() {
        return fkEnquiryId;
    }

    public void setFkEnquiryId(Long fkEnquiryId) {
        this.fkEnquiryId = fkEnquiryId;
    }

    public String getClientStory() {
        return clientStory;
    }

    public void setClientStory(String clientStory) {
        this.clientStory = clientStory;
    }
}
