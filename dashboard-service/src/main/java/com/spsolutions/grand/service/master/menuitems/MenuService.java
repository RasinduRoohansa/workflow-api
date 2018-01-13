package com.spsolutions.grand.service.master.menuitems;

import com.spsolutions.grand.domain.EdgeDocument;
import com.spsolutions.grand.domain.master.menuitem.*;
import com.spsolutions.grand.mappers.DocumentMapper;
import com.spsolutions.grand.mappers.master.menuitem.MenuItemMapper;
import com.spsolutions.grand.service.FileService;
import com.spsolutions.grand.util.ArchiveUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author kalana
 */
@Service
public class MenuService {

    @Value("${archive.path}")
    private String archivePath;

    @Autowired
    private MenuItemMapper menuItemMapper;

    @Autowired
    private DocumentMapper documentMapper;


    @Autowired
    private FileService fileService;

    public List<MasterMainMenuItemCategory> findActiveMasterMainMenuCategories() {
        return this.menuItemMapper.findActiveMasterMainMenuCategories();
    }

    public List<MasterSubMenuItemCategory> findActiveMasterSubMenuCategories(Long fkMasterMainItemCategoryId) {
        return this.menuItemMapper.findActiveMasterSubMenuCategories(fkMasterMainItemCategoryId);
    }

    public void saveOrUpdateMasterMenuItem(MasterMenuItem masterMenuItem) {
        if (masterMenuItem.getImage() != null && !masterMenuItem.getImage().isEmpty()) {
            EdgeDocument edgeDocument = new ArchiveUtils().writeToFile(masterMenuItem.getImage(), this.archivePath, "menu_item", true);
            edgeDocument.setCreatedBy(masterMenuItem.getCreatedBy());
            this.documentMapper.saveDocument(edgeDocument);
            masterMenuItem.setFkDocumentId(edgeDocument.getId());
            if (masterMenuItem.isUpdate()) {

            } else {

                this.menuItemMapper.saveMasterMenuItem(masterMenuItem);
            }
        } else {
            if (masterMenuItem.isUpdate()) {

            } else {
                this.menuItemMapper.saveMasterMenuItem(masterMenuItem);
            }
        }
    }

    public List<MasterMenuItem> findAllActiveMenuItems() {
        List<MasterMenuItem> allActiveMenuItems = this.menuItemMapper.findAllActiveMenuItems();
        allActiveMenuItems.stream()
                .filter(menu -> menu.getAltPath() != null)
                .forEach(menu -> {
                    menu.setImage(this.fileService.findThumbnail(menu.getAltPath(), menu.getExtension()));
                });
        return allActiveMenuItems;
    }

    public void saveOrUpdateMasterMenu(MasterMenu masterMenu) {
        if (masterMenu.getImage() != null && !masterMenu.getImage().isEmpty()) {
            EdgeDocument edgeDocument = new ArchiveUtils().writeToFile(masterMenu.getImage(), this.archivePath, "menu", true);
            edgeDocument.setCreatedBy(masterMenu.getCreatedBy());
            this.documentMapper.saveDocument(edgeDocument);
            masterMenu.setFkDocumentId(edgeDocument.getId());
            if (masterMenu.isUpdate()) {

            } else {
                this.menuItemMapper.saveMasterMenu(masterMenu);
            }
        } else {
            if (masterMenu.isUpdate()) {

            } else {
                this.menuItemMapper.saveMasterMenu(masterMenu);
            }
        }
    }

    public List<MasterMenu> findActiveAllMenus() {
        List<MasterMenu> activeAllMenus = this.menuItemMapper.findActiveAllMenus();
        activeAllMenus.stream()
                .filter(menu -> menu.getAltPath() != null)
                .forEach(menu -> menu.setImage(this.fileService.findThumbnail(menu.getAltPath(), menu.getExtension())));
        return activeAllMenus;
    }

    public List<MenuItemsCategoryDao> findMenuItemsByMenuId(Long id) {
        List<MenuItemsCategoryDao> categoryDaos = new ArrayList<>();

        List<MasterSubMenuItemCategory> masterSubMenuItemCategories = this.menuItemMapper.findActiveMasterSubMenu();
        if (masterSubMenuItemCategories != null) {
            masterSubMenuItemCategories.stream().forEach(category -> {
                List<MasterMenuItem> menuItems = this.menuItemMapper.findMenuItemsBySubMenuId(id, category.getId());
                if (menuItems != null && menuItems.size() > 0) {

                    menuItems.stream()
                            .filter(menu -> menu.getAltPath() != null)
                            .forEach(menu -> {
                                menu.setImage(this.fileService.findThumbnail(menu.getAltPath(), menu.getExtension()));
                            });

                    MenuItemsCategoryDao categoryDao = new MenuItemsCategoryDao();
                    categoryDao.setMenuItems(menuItems);
                    categoryDao.setItemCategory(category);
                    categoryDaos.add(categoryDao);

                }
            });
        }

        return categoryDaos;
    }
}
