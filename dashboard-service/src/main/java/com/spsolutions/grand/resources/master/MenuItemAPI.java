package com.spsolutions.grand.resources.master;

import com.spsolutions.grand.domain.master.menuitem.*;
import com.spsolutions.grand.service.master.menuitems.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author kalana
 */
@RestController
@RequestMapping(value = "/menuItem/")
public class MenuItemAPI {

    @Autowired
    private MenuService menuService;

    /**
     * create get requests
     */

    @GetMapping(value = "findActiveMasterMainMenuCategories")
    public List<MasterMainMenuItemCategory> findActiveMasterMainMenuCategories() {
        return this.menuService.findActiveMasterMainMenuCategories();
    }

    @GetMapping(value = "findActiveMasterSubMenuCategories/{fkMasterMainItemCategoryId}")
    public List<MasterSubMenuItemCategory> findActiveMasterSubMenuCategories(@PathVariable("fkMasterMainItemCategoryId") Long fkMasterMainItemCategoryId) {
        return this.menuService.findActiveMasterSubMenuCategories(fkMasterMainItemCategoryId);
    }

    @GetMapping(value = "findAllActiveMenuItems")
    public List<MasterMenuItem> findAllActiveMenuItems() {
        return this.menuService.findAllActiveMenuItems();
    }

    @GetMapping(value = "findActiveAllMenus")
    public List<MasterMenu> findActiveAllMenus() {
        return this.menuService.findActiveAllMenus();
    }

    /**
     * create post requests
     */
    @PostMapping(value = "saveMasterMenuItem")
    public void saveMasterMenuItem(@RequestBody MasterMenuItem masterMenuItem) {
        this.menuService.saveOrUpdateMasterMenuItem(masterMenuItem);
    }

    @PostMapping(value = "saveMasterMenu")
    public void saveMasterMenu(@RequestBody MasterMenu masterMenu) {
        this.menuService.saveOrUpdateMasterMenu(masterMenu);
    }

    @GetMapping(value = "findMenuItemsByMenuId/{id}")
    public List<MenuItemsCategoryDao> findMenuItemsByMenuId(@PathVariable("id") Long id) {
        return this.menuService.findMenuItemsByMenuId(id);
    }
}
