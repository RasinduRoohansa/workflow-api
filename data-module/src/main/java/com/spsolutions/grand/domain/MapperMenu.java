package com.spsolutions.grand.domain;

public class MapperMenu {
    private Long id;
    private Long fkRole;
    private Long fkSubMenu;
    private Long fkMenu;
    private boolean activated;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getFkRole() {
        return fkRole;
    }

    public void setFkRole(Long fkRole) {
        this.fkRole = fkRole;
    }

    public Long getFkSubMenu() {
        return fkSubMenu;
    }

    public void setFkSubMenu(Long fkSubMenu) {
        this.fkSubMenu = fkSubMenu;
    }

    public Long getFkMenu() {
        return fkMenu;
    }

    public void setFkMenu(Long fkMenu) {
        this.fkMenu = fkMenu;
    }

    public boolean isActivated() {
        return activated;
    }

    public void setActivated(boolean activated) {
        this.activated = activated;
    }
}
