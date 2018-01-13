package com.spsolutions.grand.resources;

import com.spsolutions.grand.dao.AllocatedSystemFeature;
import com.spsolutions.grand.dao.MenuDao;
import com.spsolutions.grand.dao.SystemFeature;
import com.spsolutions.grand.domain.Menu;
import com.spsolutions.grand.domain.Role;
import com.spsolutions.grand.domain.User;
import com.spsolutions.grand.service.MenuService;
import com.spsolutions.grand.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

/**
 * @author Stelan Briyan
 */
@RestController
@RequestMapping(value = "/user/")
public class UserAPI {

    @Autowired
    private MenuService menuService;

    @Autowired
    private UserService userService;

    @GetMapping(value = "findUser/{username}")
    public User findUser(@PathVariable("username") String username) {
        return userService.findUser(username);
    }

    @PostMapping(value = "updateUser")
    public void updateUser(@RequestBody User user) {
        userService.updateUser(user);
    }

    @PostMapping(value = "saveUser")
    public void saveUser(@RequestBody User user) {
        userService.saveUser(user);
    }

    @GetMapping(value = "findAllUsers")
    public List<User> findAllUsers() {
        return this.userService.findAllUsers();
    }

    @GetMapping(value = "findActiveUsers")
    public List<User> findActiveUsers() {
        return this.userService.findActiveUsers();
    }

    @GetMapping(value = "activateUser/{id}")
    public void activateUser(@PathVariable("id") Long id) {
        this.userService.activateUser(id);
    }

    @GetMapping(value = "deactivateUser/{id}")
    public void deactivateUser(@PathVariable("id") Long id) {
        this.userService.deactivateUser(id);
    }

    @GetMapping(value = "findRoleByUsername/{username}")
    public List<Role> findRoleByUsername(@PathVariable("username") String username) {
        return userService.findRoleByUsername(username);
    }

    @GetMapping(value = "findMenuByUsername/{username}")
    public List<MenuDao> findMenuByUsername(@PathVariable("username") String username) {
        return menuService.findMenuByUsername(username);
    }

    @PostMapping(value = "saveRole")
    public void saveRole(@RequestBody Role role) {
        userService.saveRole(role);
    }

    @GetMapping(value = "findActiveRole")
    public List<Role> findActiveRole() {
        return userService.findActiveRole();
    }

    @GetMapping(value = "findUserRoleMapper/{id}")
    public List<Long> findUserRoleMapper(@PathVariable("id") Long id) {
        return userService.findUserRoleMapper(id);
    }

    @GetMapping(value = "assignRole/{roleId}/{userId}/{status}")
    public void assignRole(@PathVariable("roleId") Long roleId,
                           @PathVariable("userId") Long userId,
                           @PathVariable("status") Boolean status) {
        userService.assignRole(roleId, userId, status);
    }

    @GetMapping(value = "findMenus/{roleId}")
    public List<Menu> findMenus(@PathVariable("roleId") Long roleId) {
        return userService.findMenus(roleId);
    }

    @GetMapping(value = "assignMenuToRole/{roleId}/{menuId}/{status}")
    public void assignMenuToRole(@PathVariable("roleId") Long roleId,
                                 @PathVariable("menuId") Long menuId,
                                 @PathVariable("status") Boolean status) {
        userService.assignMenuToRole(roleId, menuId, status);
    }

    @GetMapping(value = "assignSubMenuToRole/{roleId}/{subMenuId}/{status}")
    public void assignSubMenuToRole(@PathVariable("roleId") Long roleId,
                                    @PathVariable("subMenuId") Long subMenuId,
                                    @PathVariable("status") Boolean status) {
        userService.assignSubMenuToRole(roleId, subMenuId, status);
    }

    @GetMapping(value = "findAccessCode/{username}")
    public List<String> findAccessCode(@PathVariable("username") String username) {
        return userService.findAccessCode(username);
    }

    @GetMapping(value = "findUsersByAccessCode/{code}")
    public Set<User> findUsersByAccessCode(@PathVariable("code") String code) {
        return userService.findUsersByAccessCode(code);
    }

    @GetMapping(value = "findSystemFeatures")
    public List<SystemFeature> findSystemFeatures() {
        return userService.findSystemFeatures();
    }

    @GetMapping(value = "findPrivillegesByUserId/{fkUser}")
    public List<AllocatedSystemFeature> findPrivillegesByUserId(@PathVariable("fkUser") Long fkUser) {
        return userService.findPrivillegesByUserId(fkUser);
    }

    @PostMapping(value = "savePrivileges")
    public void savePrivileges(@RequestBody AllocatedSystemFeature feature) {
        userService.savePrivileges(feature);
    }

    @GetMapping(value = "deletePrivilege/{id}")
    public void deletePrivilege(@PathVariable("id") Long id) {
        userService.deletePrivilege(id);
    }

    @GetMapping(value = "findUsersByRoleGroup/{code}")
    public Set<User> findUsersByRoleGroup(@PathVariable("code") String code) {
        return userService.findUsersByRoleGroup(code);
    }

}
