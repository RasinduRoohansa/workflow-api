package com.spsolutions.grand.service;

import com.spsolutions.grand.dao.MenuDao;
import com.spsolutions.grand.dao.SubMenuDao;
import com.spsolutions.grand.domain.EdgeMenuItem;
import com.spsolutions.grand.mappers.MenuMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Stelan Briyan
 */
@Service
public class MenuService {

    @Autowired
    private MenuMapper menuMapper;

    public List<MenuDao> findMenuByUsername(String username) {
        List<MenuDao> menuDaos = new ArrayList<>();
        List<EdgeMenuItem> menuItems = menuMapper.findMenuItemByUsername(username);

        if (menuItems != null) {
            menuItems.stream().forEach(menu -> {
                MenuDao menuDao = new MenuDao("menu".concat(menu.getId().toString()),
                        menu.getMenuName(),
                        menu.getUrl(),
                        menu.getPriority(),
                        menu.getIcon());

                List<SubMenuDao> subMenuDaos = menuMapper.findSubMenuItemByUsername(username, menu.getId());
                if (subMenuDaos != null && subMenuDaos.size() > 0) {
                    menuDao.setSubMenu(subMenuDaos);
                }

                menuDaos.add(menuDao);
            });
        }

        return menuDaos;
    }
}
