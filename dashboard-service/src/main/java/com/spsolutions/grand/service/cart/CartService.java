package com.spsolutions.grand.service.cart;

import com.spsolutions.grand.dao.cart.CartPackage;
import com.spsolutions.grand.dao.cart.CartSummery;
import com.spsolutions.grand.dao.cart.SearchCart;
import com.spsolutions.grand.domain.master.Package;
import com.spsolutions.grand.mappers.master.PackageMapper;
import com.spsolutions.grand.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService {

    @Autowired
    private PackageMapper packageMapper;

    @Autowired
    private FileService fileService;

    public List<Package> findPackages(SearchCart cart) {
        if (cart.getSearch() != null && "".equals(cart.getSearch().trim())) {
            cart.setSearch(null);
        } else if (cart.getSearch() != null) {
            cart.setSearch("%".concat(cart.getSearch().concat("%")));
        }
        List<Package> packages = this.packageMapper.findPackages(cart);
        packages.stream().forEach(item -> {
            if (item.getAltPath() != null) {
                item.setImage(this.fileService.findThumbnail(item.getAltPath(), item.getExt()));
            }
        });
        return packages;
    }

    public Long findPackagesCount(SearchCart cart) {
        return this.packageMapper.findPackagesCount(cart);
    }

    public void addPackageToCart(CartPackage cartPackage) {
        this.packageMapper.addPackageToCart(cartPackage);
    }

    public CartSummery findCartSummeryDetail(Long fkWalkThrough) {
        CartSummery cartSummeryDetail = this.packageMapper.findCartSummeryDetail(fkWalkThrough);

        if (cartSummeryDetail.getItemCount() == null) {
            cartSummeryDetail.setItemCount(0);
        }

        if (cartSummeryDetail.getSubTotal() == null) {
            cartSummeryDetail.setSubTotal(0D);
        }

        if (cartSummeryDetail.getTotal() == null) {
            cartSummeryDetail.setTotal(0D);
        }

        if (cartSummeryDetail.getTax() == null) {
            cartSummeryDetail.setTax(0D);
        }

        return cartSummeryDetail;
    }

    public CartPackage findCartPackageByIds(Long fkWalkThrough, Long packageId) {
        return this.packageMapper.findCartPackageByIds(fkWalkThrough, packageId);
    }

    public void updatePackageToCart(CartPackage cartPackage) {
        this.packageMapper.updatePackageToCart(cartPackage);
    }

    public List<CartPackage> findCartPackageItems(Long fkWalkThrough) {
        List<CartPackage> cartPackageItems = this.packageMapper.findCartPackageItems(fkWalkThrough);
        cartPackageItems.stream().forEach(item -> {
            if (item.getImage() != null) {
                item.setImage(this.fileService.findThumbnail(item.getImage(), item.getExt()));
            }
        });
        return cartPackageItems;
    }
}
