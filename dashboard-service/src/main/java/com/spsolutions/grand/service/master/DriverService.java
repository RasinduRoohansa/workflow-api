package com.spsolutions.grand.service.master;

import com.spsolutions.grand.domain.EdgeDocument;
import com.spsolutions.grand.domain.master.Driver;
import com.spsolutions.grand.domain.master.Supplier;
import com.spsolutions.grand.mappers.DocumentMapper;
import com.spsolutions.grand.mappers.master.DriverMapper;
import com.spsolutions.grand.mappers.master.SupplierMapper;
import com.spsolutions.grand.service.FileService;
import com.spsolutions.grand.util.ArchiveUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author RasinduRoohansa
 * @since 18-12-2017
 */
@Service
public class DriverService {

    @Value("${archive.path}")
    private String archivePath;

    @Autowired
    private DriverMapper driverMapper;

    @Autowired
    private DocumentMapper documentMapper;

    @Autowired
    private FileService fileService;


    public void saveDriver(Driver driver) {
        driver.setCreatedDate(new Date());
        if (driver.getImage() != null) {
            EdgeDocument edgeDocument = new ArchiveUtils().writeToFile(driver.getImage(), this.archivePath, driver.getFullName(), true);
            edgeDocument.setCreatedBy(driver.getCreatedBy());
            if (edgeDocument != null) {
                this.documentMapper.saveDocument(edgeDocument);
                driver.setFkDocument(edgeDocument.getId());
            }
            if (driver.isUpdate()) {
                this.driverMapper.updateDriver(driver);
            } else {
                driverMapper.saveDriver(driver);
            }
        }

    }

    public List<Driver> findAllDriver() {
        List<Driver> driverList=driverMapper.findAllDriver();
        driverList.stream().forEach(driver -> {
            if (driver.getThumbnail() != null) {
                driver.setThumbnail(this.fileService.findThumbnail(driver.getThumbnail(), driver.getExt()));
            }
        });
        return driverList;
    }

    public List<Driver> findAllActiverDrivers() {
        List<Driver> driverList=driverMapper.findAllActiveDrivers();
        driverList.stream().forEach(driver -> {
            if (driver.getThumbnail() != null) {
                driver.setThumbnail(this.fileService.findThumbnail(driver.getThumbnail(), driver.getExt()));
            }
        });
        return driverList;
    }
}
