package com.spsolutions.grand.mappers;

import com.spsolutions.grand.dao.AllocatedSystemFeature;
import com.spsolutions.grand.dao.SystemFeature;
import com.spsolutions.grand.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface SystemFeatureMapper {
    List<String> findAccessCode(String username);

    List<User> findUsersByAccessCodeU(String code);

    List<User> findUsersByAccessCodeR(String code);

    List<SystemFeature> findSystemFeatures();

    List<AllocatedSystemFeature> findPrivillegesByUserId(Long fkUser);

    void savePrivileges(AllocatedSystemFeature feature);

    AllocatedSystemFeature findPrivileges(@Param("fkSystemFeatures") Long fkSystemFeatures,
                                              @Param("fkUser") Long fkUser);

    void updatePrivileges(AllocatedSystemFeature feature);

    void deletePrivilege(Long id);
}
