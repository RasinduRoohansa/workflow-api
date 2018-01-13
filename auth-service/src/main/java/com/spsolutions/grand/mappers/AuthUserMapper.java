package com.spsolutions.grand.mappers;

import com.spsolutions.grand.domain.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author Stelan Briyan
 */
@Mapper
public interface AuthUserMapper {

    User findByUsername(String username);

    User findByEmail(String email);
}
