package com.spsolutions.grand.resources.master;

import com.spsolutions.grand.domain.master.Driver;
import com.spsolutions.grand.service.master.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author RasinduRoohansa
 * @since 19-12-2017
 */
@RestController
@RequestMapping(value = "/driver/")
public class DriverAPI {


    @Autowired
    private DriverService driverService;

    @PostMapping(value = "saveDriver")
    public void saveSupplier(@RequestBody Driver driver) {
        driverService.saveDriver(driver);
    }

    @GetMapping(value = "findAllDriver")
    public List<Driver> findAllDriver() {
        return driverService.findAllDriver();
    }

    @GetMapping(value = "findActiveDriver")
    public List<Driver> findActiveSupplier() {
        return driverService.findAllActiverDrivers();
    }

}
