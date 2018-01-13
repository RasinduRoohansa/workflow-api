package com.spsolutions.grand.resources.cart;

import com.spsolutions.grand.dao.cart.CartPackage;
import com.spsolutions.grand.dao.cart.CartSummery;
import com.spsolutions.grand.dao.cart.SearchCart;
import com.spsolutions.grand.domain.master.Package;
import com.spsolutions.grand.service.cart.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Stelan Briyan
 */
@RestController
@RequestMapping(value = "/cart/")
public class CartAPI {

    @Autowired
    private CartService cartService;

    @PostMapping("findPackages")
    public List<Package> findPackages(@RequestBody SearchCart cart) {
        return this.cartService.findPackages(cart);
    }

    @PostMapping("findPackagesCount")
    public Long findPackagesCount(@RequestBody SearchCart cart) {
        return this.cartService.findPackagesCount(cart);
    }

    @PostMapping("addPackageToCart")
    public void addPackageToCart(@RequestBody CartPackage cartPackage) {
        this.cartService.addPackageToCart(cartPackage);
    }

    @PostMapping("updatePackageToCart")
    public void updatePackageToCart(@RequestBody CartPackage cartPackage) {
        this.cartService.updatePackageToCart(cartPackage);
    }

    @GetMapping("findCartSummeryDetail/{fkWalkThrough}")
    public CartSummery findCartSummeryDetail(@PathVariable("fkWalkThrough") Long fkWalkThrough) {
        return this.cartService.findCartSummeryDetail(fkWalkThrough);
    }

    @GetMapping("findCartPackageByIds/{fkWalkThrough}/{packageId}")
    public CartPackage findCartPackageByIds(@PathVariable("fkWalkThrough") Long fkWalkThrough, @PathVariable("packageId") Long packageId) {
        return this.cartService.findCartPackageByIds(fkWalkThrough, packageId);
    }

    @GetMapping("findCartPackageItems/{fkWalkThrough}")
    public List<CartPackage> findCartPackageItems(@PathVariable("fkWalkThrough") Long fkWalkThrough) {
        return this.cartService.findCartPackageItems(fkWalkThrough);
    }
}
