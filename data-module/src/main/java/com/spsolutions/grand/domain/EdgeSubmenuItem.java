package com.spsolutions.grand.domain;

public class EdgeSubmenuItem {
    private Long id;
    private String menuName;
    private boolean activated;
    private EdgeMenuItem edgeMenuItem;
    private double priority;
    private String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Double getPriority() {
        return priority;
    }

    public void setPriority(Double priority) {
        this.priority = priority;
    }

    public EdgeMenuItem getEdgeMenuItem() {
        return edgeMenuItem;
    }

    public void setEdgeMenuItem(EdgeMenuItem edgeMenuItem) {
        this.edgeMenuItem = edgeMenuItem;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public boolean isActivated() {
        return activated;
    }

    public void setActivated(boolean activated) {
        this.activated = activated;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setPriority(double priority) {
        this.priority = priority;
    }
}
