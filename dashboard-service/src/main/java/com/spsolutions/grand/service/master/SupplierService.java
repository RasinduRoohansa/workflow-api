package com.spsolutions.grand.service.master;

import com.spsolutions.grand.domain.master.Supplier;
import com.spsolutions.grand.mappers.master.SupplierMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupplierService {

    @Autowired
    private SupplierMapper supplierMapper;

    public void saveSupplier(Supplier supplier) {
        supplierMapper.saveSupplier(supplier);
    }

    public List<Supplier> findAllSupplier() {
        return supplierMapper.findAllSupplier();
    }

    public List<Supplier> findActiveSupplier() {
        return supplierMapper.findActiveSupplier();
    }
}
