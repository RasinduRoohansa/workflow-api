package com.spsolutions.grand.mappers.roster;

import com.spsolutions.grand.domain.EdgeDocument;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface RosterDocumentMapper {
    void saveDocument(EdgeDocument edgeDocument);

    void saveImageForVenueSpace(@Param("id") Long id, @Param("fkId") Long fkId);

    EdgeDocument findImage(Long id);

    List<EdgeDocument> findVenueSpaceImages(Long fkSpace);

    void saveImageForPackages(@Param("id") Long id, @Param("fkId") Long fkId);

    List<EdgeDocument> findPackageImages(Long fkMasterPackage);
}
