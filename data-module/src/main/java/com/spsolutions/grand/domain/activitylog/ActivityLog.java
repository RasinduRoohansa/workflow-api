package com.spsolutions.grand.domain.activitylog;

import com.spsolutions.grand.domain.common.CommonDomain;

public class ActivityLog extends CommonDomain {
    private String description;
    private String logType;
    private Long fkQuoteEnquiry;

    public Long getFkQuoteEnquiry() {
        return fkQuoteEnquiry;
    }

    public void setFkQuoteEnquiry(Long fkQuoteEnquiry) {
        this.fkQuoteEnquiry = fkQuoteEnquiry;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLogType() {
        return logType;
    }

    public void setLogType(String logType) {
        this.logType = logType;
    }
}
