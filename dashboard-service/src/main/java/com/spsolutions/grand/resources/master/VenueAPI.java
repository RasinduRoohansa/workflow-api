package com.spsolutions.grand.resources.master;

import com.spsolutions.grand.dao.UploadImage;
import com.spsolutions.grand.dao.VenueSpacesDao;
import com.spsolutions.grand.domain.EdgeDocument;
import com.spsolutions.grand.domain.Facility;
import com.spsolutions.grand.domain.master.Venue;
import com.spsolutions.grand.domain.master.VenueSpace;
import com.spsolutions.grand.service.master.VenueService;
import com.spsolutions.grand.util.ArchiveUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Stelan Briyan
 */
@RestController
@RequestMapping(value = "/master/")
public class VenueAPI {

    @Autowired
    private VenueService venueService;

    @Value("${archive.path}")
    private String archivePath;

    @PostMapping(value = "saveVenue")
    public void saveVenue(@RequestBody Venue venue) {
        venueService.saveVenue(venue);
    }

    @GetMapping(value = "findAllVenue")
    public List<Venue> findAllVenue() {
        return venueService.findAllVenue();
    }

    @PostMapping(value = "saveVenueSpace")
    public void saveVenueSpace(@RequestBody VenueSpace venueSpace) {
        if (venueSpace.getImage() != null) {
            venueService.saveVenueSpace(venueSpace, new ArchiveUtils().writeToFile(venueSpace.getImage(), this.archivePath, venueSpace.getName(), true));
        } else {
            venueService.saveVenueSpace(venueSpace, null);
        }
    }

    @PostMapping(value = "updateVenueSpace")
    public void updateVenueSpace(@RequestBody VenueSpace venueSpace) {
        if (venueSpace.getFkDocument() == null && venueSpace.getImage() != null) {
            venueService.updateVenueSpace(venueSpace, new ArchiveUtils().writeToFile(venueSpace.getImage(), this.archivePath, venueSpace.getName(), true));
        } else {
            venueService.updateVenueSpace(venueSpace, null);
        }
    }

    @PostMapping(value = "saveImageForVenueSpace")
    public void saveImageForVenueSpace(@RequestBody UploadImage uploadImage) {
        if (uploadImage.getImage() != null) {
            EdgeDocument edgeDocument = new ArchiveUtils().writeToFile(uploadImage.getImage(), this.archivePath, String.valueOf(uploadImage.getFkId()), true);
            edgeDocument.setCreatedBy(uploadImage.getCreatedBy());
            venueService.saveImageForVenueSpace(edgeDocument, uploadImage.getFkId());
        }
    }

    @GetMapping(value = "findVenueSpace/{fkVenue}")
    public List<VenueSpace> findVenueSpace(@PathVariable("fkVenue") Long fkVenue) {
        return venueService.findVenueSpace(fkVenue);
    }

    @GetMapping(value = "activateVenueSpace/{id}")
    public boolean activateVenueSpace(@PathVariable("id") Long id) {
        return venueService.activateVenueSpace(id);
    }

    @GetMapping(value = "deactivateVenueSpace/{id}")
    public boolean deactivateVenueSpace(@PathVariable("id") Long id) {
        return venueService.deactivateVenueSpace(id);
    }

    @GetMapping(value = "findVenueSpaceBySpaceId/{fkSpace}")
    public VenueSpacesDao findVenueSpaceBySpaceId(@PathVariable("fkSpace") Long fkSpace) {
        return venueService.findVenueSpaceBySpaceId(fkSpace);
    }

    @PostMapping(value = "saveFacility")
    public void saveFacility(@RequestBody Facility facility) {
        venueService.saveFacility(facility);
    }

    @GetMapping(value = "findFacility/{fkVenueSpace}")
    public List<Facility> findFacility(@PathVariable("fkVenueSpace") Long fkVenueSpace) {
        return venueService.findFacility(fkVenueSpace);
    }

}
