package com.spsolutions.grand.mappers.mapperutil;

import com.spsolutions.grand.domain.SystemIDGenerator;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface GeneratorMapper {
    SystemIDGenerator findSystemIDGenerator(String type);

    void updateSystemIDGenerator(SystemIDGenerator idGenerator);
}
