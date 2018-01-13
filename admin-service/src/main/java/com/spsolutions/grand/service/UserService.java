package com.spsolutions.grand.service;

import com.spsolutions.grand.dao.AllocatedSystemFeature;
import com.spsolutions.grand.dao.SystemFeature;
import com.spsolutions.grand.domain.*;
import com.spsolutions.grand.mappers.MenuMapper;
import com.spsolutions.grand.mappers.SystemFeatureMapper;
import com.spsolutions.grand.mappers.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Stelan Briyan
 */
@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private MenuMapper menuMapper;

    @Autowired
    private SystemFeatureMapper featureMapper;

    public List<Role> findRoleByUsername(String username) {
        return userMapper.findRoleByUsername(username);
    }

    public List<User> findAllUsers() {
        return userMapper.findAllUsers();
    }

    public void activateUser(Long id) {
        userMapper.activateUser(id);
    }

    public void deactivateUser(Long id) {
        userMapper.deactivateUser(id);
    }

    public void saveRole(Role role) {
        userMapper.saveRole(role);
    }

    public List<User> findActiveUsers() {
        return userMapper.findActiveUsers();
    }

    public List<Role> findActiveRole() {
        return userMapper.findActiveRole();
    }

    public List<Long> findUserRoleMapper(Long id) {
        return userMapper.findUserRoleMapperIds(id);
    }

    public void assignRole(Long roleId, Long userId, Boolean status) {
        MapperUserRole userRole = userMapper.findRoleMapper(roleId, userId);
        if (userRole == null) {
            userMapper.assignRole(roleId, userId);
        } else {
            userMapper.updateRoleAssign(roleId, userId, status);
        }
    }

    public List<Menu> findMenus(Long roleId) {
        List<Menu> menus = menuMapper.findMenus(roleId);

        if (menus.size() > 0) {
            menus.stream().forEach(value -> {
                value.setSubMenu(menuMapper.findSubMenuByMenuId(roleId, value.getId()));
            });
        }

        return menus;
    }

    public void assignMenuToRole(Long roleId, Long menuId, Boolean status) {
        MapperMenu mapperMenu = menuMapper.findMenu(roleId, menuId);
        if (mapperMenu == null) {
            menuMapper.assignMenuToRole(roleId, menuId);
        } else {
            mapperMenu.setActivated(status);
            menuMapper.updateMenuMapper(mapperMenu);
        }
    }

    public void assignSubMenuToRole(Long roleId, Long subMenuId, Boolean status) {
        MapperMenu mapperMenu = menuMapper.findSubMenu(roleId, subMenuId);
        if (mapperMenu == null) {
            menuMapper.assignSubMenuToRole(roleId, subMenuId);
        } else {
            mapperMenu.setActivated(status);
            menuMapper.updateMenuMapper(mapperMenu);
        }
    }

    public User findUser(String username) {
        return userMapper.findUser(username);
    }

    public void updateUser(User user) {
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userMapper.updateUser(user);
    }

    public void saveUser(User user) {
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        user.setPassword(passwordEncoder.encode("123456"));
        userMapper.saveUser(user);
    }

    public List<String> findAccessCode(String username) {
        return featureMapper.findAccessCode(username);
    }

    public Set<User> findUsersByAccessCode(String code) {
        Set<User> users = new HashSet<>();

        List<User> usersR = featureMapper.findUsersByAccessCodeR(code);
        users.addAll(usersR);

        List<User> usersU = featureMapper.findUsersByAccessCodeU(code);
        users.addAll(usersU);

        users.remove(null);

        return users;
    }

    public List<SystemFeature> findSystemFeatures() {
        return featureMapper.findSystemFeatures();
    }

    public List<AllocatedSystemFeature> findPrivillegesByUserId(Long fkUser) {
        return featureMapper.findPrivillegesByUserId(fkUser);
    }

    public void savePrivileges(AllocatedSystemFeature feature) {
        AllocatedSystemFeature systemFeature = featureMapper.findPrivileges(feature.getFkSystemFeatures(), feature.getFkUser());
        if (systemFeature == null) {
            featureMapper.savePrivileges(feature);
        } else {
            systemFeature.setRead(feature.isRead());
            systemFeature.setWrite(feature.isWrite());
            systemFeature.setDelete(feature.isDelete());
            systemFeature.setUpdate(feature.isUpdate());
            featureMapper.updatePrivileges(systemFeature);
        }
    }

    public void deletePrivilege(Long id) {
        featureMapper.deletePrivilege(id);
    }

    public Set<User> findUsersByRoleGroup(String code) {
        return userMapper.findUsersByRoleGroup(code);
    }
}
