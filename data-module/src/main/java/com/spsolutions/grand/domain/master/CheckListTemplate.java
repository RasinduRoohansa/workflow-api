package com.spsolutions.grand.domain.master;

import com.spsolutions.grand.domain.common.CommonDomain;

public class CheckListTemplate extends CommonDomain {
    private Long fkEventType;
    private String templateName;

    public Long getFkEventType() {
        return fkEventType;
    }

    public void setFkEventType(Long fkEventType) {
        this.fkEventType = fkEventType;
    }

    public String getTemplateName() {
        return templateName;
    }

    public void setTemplateName(String templateName) {
        this.templateName = templateName;
    }
}
