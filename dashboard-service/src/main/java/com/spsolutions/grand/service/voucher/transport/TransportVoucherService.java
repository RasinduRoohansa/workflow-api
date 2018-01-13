package com.spsolutions.grand.service.voucher.transport;

import com.spsolutions.grand.dao.TransportVoucherDao;
import com.spsolutions.grand.mappers.customer.CustomerMapper;
import com.spsolutions.grand.mappers.vouchers.transport.TransportVoucherMapper;
import com.spsolutions.grand.service.FileService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * @author RasinduRoohansa
 * @since 28-12-2017
 */
@Service
public class TransportVoucherService {
    private final static Logger LOGGER = LoggerFactory.getLogger(TransportVoucherService.class);

    @Autowired
    private TransportVoucherMapper transportVoucherMapper;

    @Autowired
    private FileService fileService;

    private DateFormat timeFormat = new SimpleDateFormat("hh:mm a");

    public List<TransportVoucherDao> getTransportVoucherList(){
        List<TransportVoucherDao> transportVoucherList=transportVoucherMapper.getTransportVoucherList();
        transportVoucherList.stream().forEach(transportVoucher -> {
            if (transportVoucher.getThumbnail() != null) {
                transportVoucher.setThumbnail(this.fileService.findThumbnail(transportVoucher.getThumbnail(), transportVoucher.getExt()));
            }
        });
        return transportVoucherList;
    }
}
