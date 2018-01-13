package com.spsolutions.grand.mappers;

import com.spsolutions.grand.dao.SubMenuDao;
import com.spsolutions.grand.domain.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Stelan Briyan
 */
@Mapper
public interface MenuMapper {

    List<EdgeMenuItem> findMenuItemByUsername(String username);

    List<SubMenuDao> findSubMenuItemByUsername(@Param("username") String username,
                                               @Param("menuId") Long menuId);

    List<Menu> findMenus(Long roleId);

    List<SubMenu> findSubMenuByMenuId(@Param("roleId") Long roleId,
                                      @Param("id") Long id);

    void assignMenuToRole(@Param("roleId") Long roleId,
                          @Param("menuId") Long menuId);

    void assignSubMenuToRole(@Param("roleId") Long roleId,
                             @Param("submenuId") Long submenuId);

    MapperMenu findMenu(@Param("roleId") Long roleId, @Param("menuId") Long menuId);

    MapperMenu findSubMenu(@Param("roleId") Long roleId, @Param("submenuId") Long subMenuId);

    void updateMenuMapper(MapperMenu mapperMenu);

}
