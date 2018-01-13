package com.spsolutions.grand.mappers.location;

import com.spsolutions.grand.domain.location.EdgeLocation;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LocationMapper {
    void saveLocation(EdgeLocation location);
}
