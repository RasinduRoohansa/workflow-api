package com.spsolutions.grand.mappers;


import com.spsolutions.grand.domain.MapperUserRole;
import com.spsolutions.grand.domain.Role;
import com.spsolutions.grand.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Set;

/**
 * @author Stelan Briyan
 */
@Mapper
public interface UserMapper {
    List<Role> findRoleByUsername(String username);

    List<User> findAllUsers();

    void activateUser(Long id);

    void deactivateUser(Long id);

    void saveRole(Role role);

    List<User> findActiveUsers();

    List<Role> findActiveRole();

    List<Long> findUserRoleMapperIds(Long id);

    void assignRole(@Param("roleId") Long roleId,
                    @Param("userId") Long userId);

    void updateRoleAssign(@Param("roleId") Long roleId,
                          @Param("userId") Long userId,
                          @Param("status") Boolean status);

    MapperUserRole findRoleMapper(@Param("roleId") Long roleId,
                                  @Param("userId") Long userId);

    User findUser(String username);

    void updateUser(User user);

    void saveUser(User user);

    Set<User> findUsersByRoleGroup(String code);
}
