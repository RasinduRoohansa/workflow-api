package com.spsolutions.grand.mappers.customer;

import com.spsolutions.grand.domain.common.Customer;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CustomerMapper {
    void saveCustomer(Customer customer);

    Customer findCustomerById(Long fkCustomer);
}
