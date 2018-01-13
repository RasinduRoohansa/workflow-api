package com.spsolutions.grand.domain.enquiry;

import com.spsolutions.grand.domain.common.CommonDomain;

public class Walkthrough extends CommonDomain{
    private Long fkQuoteEnquiry;
    private Long fkQuestionTemplate;
    private boolean current;

    public Long getFkQuoteEnquiry() {
        return fkQuoteEnquiry;
    }

    public void setFkQuoteEnquiry(Long fkQuoteEnquiry) {
        this.fkQuoteEnquiry = fkQuoteEnquiry;
    }

    public Long getFkQuestionTemplate() {
        return fkQuestionTemplate;
    }

    public void setFkQuestionTemplate(Long fkQuestionTemplate) {
        this.fkQuestionTemplate = fkQuestionTemplate;
    }

    public boolean isCurrent() {
        return current;
    }

    public void setCurrent(boolean current) {
        this.current = current;
    }
}
