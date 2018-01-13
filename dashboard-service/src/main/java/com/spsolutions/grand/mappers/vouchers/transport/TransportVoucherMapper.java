package com.spsolutions.grand.mappers.vouchers.transport;

import com.spsolutions.grand.dao.TransportVoucherDao;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TransportVoucherMapper {

    List<TransportVoucherDao> getTransportVoucherList();
}
