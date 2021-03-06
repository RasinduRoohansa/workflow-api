package com.spsolutions.grand.mappers;

import com.spsolutions.grand.domain.EdgeDocument;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface DocumentMapper {
    void saveDocument(EdgeDocument edgeDocument);

    void saveImageForVenueSpace(@Param("id") Long id, @Param("fkId") Long fkId);

    EdgeDocument findImage(Long id);

    List<EdgeDocument> findVenueSpaceImages(Long fkSpace);

    void saveImageForPackages(@Param("id") Long id, @Param("fkId") Long fkId);

    List<EdgeDocument> findPackageImages(Long fkMasterPackage);

    List<EdgeDocument> findTablePlanHeader(Long fkBooking);
}
