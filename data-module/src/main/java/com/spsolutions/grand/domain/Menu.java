package com.spsolutions.grand.domain;

import java.util.List;

public class Menu {
    private Long id;
    private String menu;
    private boolean selected;
    private List<SubMenu> subMenu;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMenu() {
        return menu;
    }

    public void setMenu(String menu) {
        this.menu = menu;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    public List<SubMenu> getSubMenu() {
        return subMenu;
    }

    public void setSubMenu(List<SubMenu> subMenu) {
        this.subMenu = subMenu;
    }
}
