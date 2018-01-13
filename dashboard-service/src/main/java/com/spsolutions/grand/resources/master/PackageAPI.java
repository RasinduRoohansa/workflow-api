package com.spsolutions.grand.resources.master;

import com.spsolutions.grand.dao.UploadImage;
import com.spsolutions.grand.domain.master.Item;
import com.spsolutions.grand.domain.master.Package;
import com.spsolutions.grand.service.master.PackageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Stelan Briyan
 */
@RestController
@RequestMapping(value = "/package/")
public class PackageAPI {

    @Autowired
    private PackageService packageService;


    @PostMapping("createPackage")
    public Long createPackage(@RequestBody Package itemPackage) {
        return this.packageService.createPackage(itemPackage);
    }

    @GetMapping("getAllPackages")
    public List<Package> getAllPackages() {
        return this.packageService.getAllPackages();
    }

    @GetMapping("findPackageById/{packageId}")
    public Package findPackageById(@PathVariable("packageId") Long packageId) {
        return this.packageService.findPackageById(packageId);
    }

    @PostMapping("savePackageItem")
    public void savePackageItem(@RequestBody Package supplierPackage) {
        this.packageService.savePackageItem(supplierPackage);
    }

    @GetMapping("findPackageItem/{fkMasterPackage}")
    public List<Item> findPackageItem(@PathVariable("fkMasterPackage") Long fkMasterPackage) {
        return this.packageService.findPackageItem(fkMasterPackage);
    }

    @GetMapping("activatePackage/{id}")
    public void activatePackage(@PathVariable("id") Long id) {
        this.packageService.activatePackage(id);
    }

    @GetMapping("deactivatePackage/{id}")
    public void deactivatePackage(@PathVariable("id") Long id) {
        this.packageService.deactivatePackage(id);
    }

    @PostMapping(value = "saveImageForPackages")
    public void saveImageForPackages(@RequestBody UploadImage uploadImage) {
        this.packageService.saveImageForPackages(uploadImage);
    }

    @GetMapping("findPackageImages/{fkMasterPackage}")
    public List<UploadImage> findPackageImages(@PathVariable("fkMasterPackage") Long fkMasterPackage) {
        return this.packageService.findPackageImages(fkMasterPackage);
    }
}
