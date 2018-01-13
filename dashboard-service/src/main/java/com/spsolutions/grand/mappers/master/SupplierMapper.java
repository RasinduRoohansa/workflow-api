package com.spsolutions.grand.mappers.master;

import com.spsolutions.grand.domain.master.Supplier;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SupplierMapper {
    void saveSupplier(Supplier supplier);

    List<Supplier> findAllSupplier();

    List<Supplier> findActiveSupplier();
}
