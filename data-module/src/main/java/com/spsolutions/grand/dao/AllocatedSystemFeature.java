package com.spsolutions.grand.dao;

import com.spsolutions.grand.domain.common.CommonDomain;

public class AllocatedSystemFeature extends CommonDomain {
    private Long fkSystemFeatures;
    private Long fkRole;
    private Long fkUser;
    private String code;
    private String description;
    private boolean read;
    private boolean write;
    private boolean delete;
    private boolean update;
    private boolean privileges;

    public Long getFkRole() {
        return fkRole;
    }

    public void setFkRole(Long fkRole) {
        this.fkRole = fkRole;
    }

    public Long getFkUser() {
        return fkUser;
    }

    public void setFkUser(Long fkUser) {
        this.fkUser = fkUser;
    }

    public Long getFkSystemFeatures() {
        return fkSystemFeatures;
    }

    public void setFkSystemFeatures(Long fkSystemFeatures) {
        this.fkSystemFeatures = fkSystemFeatures;
    }

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

    public boolean isRead() {
        return read;
    }

    public void setRead(boolean read) {
        this.read = read;
    }

    public boolean isWrite() {
        return write;
    }

    public void setWrite(boolean write) {
        this.write = write;
    }

    public boolean isDelete() {
        return delete;
    }

    public void setDelete(boolean delete) {
        this.delete = delete;
    }

    public boolean isUpdate() {
        return update;
    }

    public void setUpdate(boolean update) {
        this.update = update;
    }

    public boolean isPrivileges() {
        return privileges;
    }

    public void setPrivileges(boolean privileges) {
        this.privileges = privileges;
    }
}
