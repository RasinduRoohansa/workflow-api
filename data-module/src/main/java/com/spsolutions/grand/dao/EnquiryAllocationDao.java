package com.spsolutions.grand.dao;

import com.spsolutions.grand.domain.common.CommonDomain;

public class EnquiryAllocationDao extends CommonDomain {
    private Long fkEnquiry;
    private Long fkUser;
    /**
     * @author Rasindu Roohansa
     * @since 19-12-2017
     */
    private Long fkDriver;
    private Long fkVoucher;


    public Long getFkEnquiry() {
        return fkEnquiry;
    }

    public void setFkEnquiry(Long fkEnquiry) {
        this.fkEnquiry = fkEnquiry;
    }

    public Long getFkUser() {
        return fkUser;
    }

    public void setFkUser(Long fkUser) {
        this.fkUser = fkUser;
    }

    public Long getFkDriver() {
        return fkDriver;
    }

    public void setFkDriver(Long fkDriver) {
        this.fkDriver = fkDriver;
    }

    public Long getFkVoucher() {
        return fkVoucher;
    }

    public void setFkVoucher(Long fkVoucher) {
        this.fkVoucher = fkVoucher;
    }
}
