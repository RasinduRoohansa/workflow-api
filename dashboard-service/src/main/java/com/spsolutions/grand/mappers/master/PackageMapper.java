package com.spsolutions.grand.mappers.master;

import com.spsolutions.grand.dao.cart.CartPackage;
import com.spsolutions.grand.dao.ItemPackage;
import com.spsolutions.grand.dao.cart.CartSummery;
import com.spsolutions.grand.dao.cart.SearchCart;
import com.spsolutions.grand.domain.EdgeDocument;
import com.spsolutions.grand.domain.MapperTaxPackage;
import com.spsolutions.grand.domain.Tax;
import com.spsolutions.grand.domain.master.Item;
import com.spsolutions.grand.domain.master.Package;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface PackageMapper {
    Long createPackage(Package itemPackage);

    List<Package> getAllPackages();

    Package findPackageById(Long packageId);

    void savePackageItem(ItemPackage itemPackage);

    ItemPackage findItemPackage(@Param("fkMasterItem") Long fkMasterItem,
                                @Param("fkMasterPackage") Long fkMasterPackage);

    void activatePackageItem(Long id);

    void deactivatePackageItems(Long id);

    List<Item> findPackageItem(Long fkMasterPackage);

    void saveMapperPackageTax(MapperTaxPackage taxPackage);

    void activatePackage(Long id);

    void deactivatePackage(Long id);

    List<Tax> findPackageTaxes(Long packageId);

    void updatePackage(Package itemPackage);

    List<Package> findPackages(SearchCart cart);

    Long findPackagesCount(SearchCart cart);

    void addPackageToCart(CartPackage cartPackage);

    CartSummery findCartSummeryDetail(Long fkWalkThrough);

    CartPackage findCartPackageByIds(@Param("fkWalkThrough") Long fkWalkThrough,
                                     @Param("packageId") Long packageId);

    void updatePackageToCart(CartPackage cartPackage);

    List<CartPackage> findCartPackageItems(Long fkWalkThrough);

    void saveImageForPackages(EdgeDocument edgeDocument, Long fkId);
}
