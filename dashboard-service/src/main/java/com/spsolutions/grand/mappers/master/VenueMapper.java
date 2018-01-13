package com.spsolutions.grand.mappers.master;

import com.spsolutions.grand.dao.VenueSpacesDao;
import com.spsolutions.grand.domain.Facility;
import com.spsolutions.grand.domain.master.Venue;
import com.spsolutions.grand.domain.master.VenueSpace;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface VenueMapper {
    void saveVenue(Venue venue);

    List<Venue> findAllVenue();

    void saveVenueSpace(VenueSpace venueSpace);

    List<VenueSpace> findVenueSpace(Long fkVenue);

    VenueSpacesDao findSpaceDetail(Long fkSpace);

    Venue findVenue(Long fkVenue);

    void updateVenueSpace(VenueSpace venueSpace);

    void saveFacility(Facility facility);

    List<Facility> findFacility(Long fkVenueSpace);

    void activateVenueSpace(Long id);

    void deactivateVenueSpace(Long id);
}
