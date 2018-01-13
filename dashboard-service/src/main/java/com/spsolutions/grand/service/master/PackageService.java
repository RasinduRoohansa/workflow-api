package com.spsolutions.grand.service.master;

import com.spsolutions.grand.dao.ItemPackage;
import com.spsolutions.grand.dao.UploadImage;
import com.spsolutions.grand.domain.EdgeDocument;
import com.spsolutions.grand.domain.MapperTaxPackage;
import com.spsolutions.grand.domain.Tax;
import com.spsolutions.grand.domain.master.Item;
import com.spsolutions.grand.domain.master.Package;
import com.spsolutions.grand.mappers.DocumentMapper;
import com.spsolutions.grand.mappers.master.PackageMapper;
import com.spsolutions.grand.service.FileService;
import com.spsolutions.grand.util.ArchiveUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PackageService {

    @Autowired
    private PackageMapper packageMapper;

    @Autowired
    private FileService fileService;

    @Autowired
    private DocumentMapper documentMapper;

    @Value("${archive.path}")
    private String archivePath;

    public Long createPackage(Package itemPackage) {
        if (itemPackage.getImage() != null && itemPackage.getFkDocument() == null) {
            EdgeDocument edgeDocument = new ArchiveUtils().writeToFile(itemPackage.getImage(), this.archivePath, String.valueOf(itemPackage.getId()), true);
            edgeDocument.setCreatedBy(itemPackage.getCreatedBy());
            this.documentMapper.saveDocument(edgeDocument);
            itemPackage.setFkDocument(edgeDocument.getId());
        }

        if (itemPackage.isUpdate()) {
            packageMapper.updatePackage(itemPackage);

        } else {
            packageMapper.createPackage(itemPackage);

            List<Tax> taxs = itemPackage.getTax();
            taxs.stream().forEach(tax -> {
                MapperTaxPackage taxPackage = new MapperTaxPackage();
                taxPackage.setFkTaxAudit(tax.getId());
                taxPackage.setFkPackage(itemPackage.getId());
                this.packageMapper.saveMapperPackageTax(taxPackage);
            });
        }
        return itemPackage.getId();
    }

    public List<Package> getAllPackages() {
        return this.packageMapper.getAllPackages();
    }

    public Package findPackageById(Long packageId) {
        Package packageById = this.packageMapper.findPackageById(packageId);

        packageById.setTax(this.packageMapper.findPackageTaxes(packageId));

        if (packageById.getFkDocument() != null) {
            packageById.setImage(fileService.findThumbnail(packageById.getAltPath(), packageById.getExt()));
        }

        return packageById;
    }

    public void savePackageItem(Package supplierPackage) {
        List<Item> packageItems = supplierPackage.getPackageItems();

        ItemPackage itemPackage = new ItemPackage();
        itemPackage.setFkMasterPackage(supplierPackage.getId());
        itemPackage.setCreatedBy(supplierPackage.getCreatedBy());

        this.packageMapper.deactivatePackageItems(supplierPackage.getId());
        packageItems.stream().forEach(item -> {
            itemPackage.setFkMasterItem(item.getId());

            ItemPackage existingItemPackage = this.packageMapper.findItemPackage(itemPackage.getFkMasterItem(), itemPackage.getFkMasterPackage());

            if (existingItemPackage == null) {
                this.packageMapper.savePackageItem(itemPackage);
            } else {
                existingItemPackage.setActivated(true);
                this.packageMapper.activatePackageItem(existingItemPackage.getId());
            }

        });
    }

    public List<Item> findPackageItem(Long fkMasterPackage) {
        List<Item> packageItems = this.packageMapper.findPackageItem(fkMasterPackage);
        packageItems.stream().forEach(item -> {
            if (item.getImage() != null) {
                item.setImage(this.fileService.findThumbnail(item.getImage(), item.getExt()));
            }
        });
        return packageItems;
    }

    public void activatePackage(Long id) {
        this.packageMapper.activatePackage(id);
    }

    public void deactivatePackage(Long id) {
        this.packageMapper.deactivatePackage(id);
    }

    public void saveImageForPackages(UploadImage uploadImage) {
        if (uploadImage.getImage() != null) {
            EdgeDocument edgeDocument = new ArchiveUtils().writeToFile(uploadImage.getImage(), this.archivePath, String.valueOf(uploadImage.getFkId()), true);
            edgeDocument.setCreatedBy(uploadImage.getCreatedBy());
            documentMapper.saveDocument(edgeDocument);

            if (edgeDocument.getId() != null) {
                documentMapper.saveImageForPackages(edgeDocument.getId(), uploadImage.getFkId());
            }
        }
    }

    public List<UploadImage> findPackageImages(Long fkMasterPackage) {
        List<EdgeDocument> images = documentMapper.findPackageImages(fkMasterPackage);

        List<UploadImage> list = new ArrayList<>();
        for (EdgeDocument img : images) {
            if (img.getAltPath() != null) {
                UploadImage image = new UploadImage();
                image.setImage(fileService.findThumbnail(img.getAltPath(), img.getExt()));
                image.setFkId(img.getId());
                list.add(image);
            }
        }
        return list;
    }
}
