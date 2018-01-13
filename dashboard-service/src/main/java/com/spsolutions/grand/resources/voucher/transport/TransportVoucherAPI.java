package com.spsolutions.grand.resources.voucher.transport;

import com.spsolutions.grand.dao.TransportVoucherDao;
import com.spsolutions.grand.service.voucher.transport.TransportVoucherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Stelan Briyan
 */
@RestController
@RequestMapping(value = "/transportVoucher/")
public class TransportVoucherAPI {

    @Autowired
    private TransportVoucherService transportVoucherService;

    @GetMapping("getTransportVoucherList")
    public List<TransportVoucherDao> getNotAllocatedEnquiry() {
        return transportVoucherService.getTransportVoucherList();
    }

}
