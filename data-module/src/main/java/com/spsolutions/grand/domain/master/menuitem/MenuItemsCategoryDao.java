package com.spsolutions.grand.domain.master.menuitem;

import java.util.List;

public class MenuItemsCategoryDao {
    private List<MasterMenuItem> menuItems;
    private MasterSubMenuItemCategory itemCategory;

    public List<MasterMenuItem> getMenuItems() {
        return menuItems;
    }

    public void setMenuItems(List<MasterMenuItem> menuItems) {
        this.menuItems = menuItems;
    }

    public MasterSubMenuItemCategory getItemCategory() {
        return itemCategory;
    }

    public void setItemCategory(MasterSubMenuItemCategory itemCategory) {
        this.itemCategory = itemCategory;
    }
}
