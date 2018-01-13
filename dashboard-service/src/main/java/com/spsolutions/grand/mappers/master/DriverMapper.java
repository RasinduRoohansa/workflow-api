package com.spsolutions.grand.mappers.master;

import com.spsolutions.grand.domain.master.Driver;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author RasinduRoohansa
 * @since 18-12-2017
 */
@Mapper
public interface DriverMapper {
    void saveDriver(Driver driver);

    List<Driver> findAllDriver();

    List<Driver> findAllActiveDrivers();

    void updateDriver(Driver driver);

    Driver findDriverById(Long id);
}
