package com.spsolutions.grand.dao;

import com.spsolutions.grand.domain.common.CommonDomain;

public class SystemFeature extends CommonDomain {
    private String code;
    private String description;
    private boolean privileges;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isPrivileges() {
        return privileges;
    }

    public void setPrivileges(boolean privileges) {
        this.privileges = privileges;
    }
}
