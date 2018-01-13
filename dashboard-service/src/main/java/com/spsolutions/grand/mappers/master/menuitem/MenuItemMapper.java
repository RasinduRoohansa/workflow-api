package com.spsolutions.grand.mappers.master.menuitem;

import com.spsolutions.grand.domain.master.menuitem.MasterMainMenuItemCategory;
import com.spsolutions.grand.domain.master.menuitem.MasterMenu;
import com.spsolutions.grand.domain.master.menuitem.MasterMenuItem;
import com.spsolutions.grand.domain.master.menuitem.MasterSubMenuItemCategory;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author kalana
 */
@Mapper
public interface MenuItemMapper {

    List<MasterMainMenuItemCategory> findActiveMasterMainMenuCategories();

    List<MasterSubMenuItemCategory> findActiveMasterSubMenuCategories(Long fkMasterMainItemCategoryId);

    void saveMasterMenuItem(MasterMenuItem masterMenuItem);

    List<MasterMenuItem> findAllActiveMenuItems();

    void saveMasterMenu(MasterMenu masterMenu);

    List<MasterMenu> findActiveAllMenus();

    List<MasterMenuItem> findMenuItemsByMenuId(@Param("fkMenu") Long fkMenu,
                                               @Param("fkCategory") Long fkCategory);

    List<MasterSubMenuItemCategory> findActiveMasterSubMenu();

    List<MasterMenuItem> findMenuItemsBySubMenuId(@Param("fkMenu") Long fkMenu,
                                                  @Param("fkCategory") Long fkCategory);
}
