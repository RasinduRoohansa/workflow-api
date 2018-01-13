package com.spsolutions.grand.resources.master;

import com.spsolutions.grand.domain.master.Supplier;
import com.spsolutions.grand.service.master.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Stelan Briyan
 */
@RestController
@RequestMapping(value = "/supplier/")
public class SupplierAPI {
    @Autowired
    private SupplierService supplierService;

    @PostMapping(value = "saveSupplier")
    public void saveSupplier(@RequestBody Supplier supplier) {
        supplierService.saveSupplier(supplier);
    }

    @GetMapping(value = "findAllSupplier")
    public List<Supplier> findAllSupplier() {
        return supplierService.findAllSupplier();
    }

    @GetMapping(value = "findActiveSupplier")
    public List<Supplier> findActiveSupplier() {
        return supplierService.findActiveSupplier();
    }

}
