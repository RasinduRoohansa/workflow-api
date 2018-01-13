package com.spsolutions.grand.dao;

import java.util.List;

public class MenuDao {
    private String id;
    private String menu;
    private String url;
    private double priority;
    private String icon;
    private List<SubMenuDao> subMenu;

    public MenuDao(String id, String menu, String url, double priority, String icon) {
        this.id = id;
        this.menu = menu;
        this.url = url;
        this.priority = priority;
        this.icon = icon;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getPriority() {
        return priority;
    }

    public void setPriority(double priority) {
        this.priority = priority;
    }

    public String getMenu() {
        return menu;
    }

    public void setMenu(String menu) {
        this.menu = menu;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<SubMenuDao> getSubMenu() {
        return subMenu;
    }

    public void setSubMenu(List<SubMenuDao> subMenu) {
        this.subMenu = subMenu;
    }
}
