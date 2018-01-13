package com.spsolutions.grand.domain;

public class MapperUserMenu {
    private Long id;
    private User user;
    private Role role;
    private EdgeMenuItem edgeMenuItem;
    private EdgeSubmenuItem edgeSubmenuItem;
    private boolean activated;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public EdgeMenuItem getEdgeMenuItem() {
        return edgeMenuItem;
    }

    public void setEdgeMenuItem(EdgeMenuItem edgeMenuItem) {
        this.edgeMenuItem = edgeMenuItem;
    }

    public EdgeSubmenuItem getEdgeSubmenuItem() {
        return edgeSubmenuItem;
    }

    public void setEdgeSubmenuItem(EdgeSubmenuItem edgeSubmenuItem) {
        this.edgeSubmenuItem = edgeSubmenuItem;
    }

    public boolean isActivated() {
        return activated;
    }

    public void setActivated(boolean activated) {
        this.activated = activated;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
