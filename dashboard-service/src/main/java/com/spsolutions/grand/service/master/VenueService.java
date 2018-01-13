package com.spsolutions.grand.service.master;

import com.spsolutions.grand.dao.UploadImage;
import com.spsolutions.grand.dao.VenueSpacesDao;
import com.spsolutions.grand.domain.EdgeDocument;
import com.spsolutions.grand.domain.Facility;
import com.spsolutions.grand.domain.master.Venue;
import com.spsolutions.grand.domain.master.VenueSpace;
import com.spsolutions.grand.mappers.DocumentMapper;
import com.spsolutions.grand.mappers.master.VenueMapper;
import com.spsolutions.grand.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Stelan Briyan
 */
@Service
public class VenueService {

    @Autowired
    private VenueMapper venueMapper;

    @Autowired
    private DocumentMapper documentMapper;

    @Autowired
    private FileService fileService;

    public void saveVenue(Venue venue) {
        this.venueMapper.saveVenue(venue);
    }

    public List<Venue> findAllVenue() {
        List<Venue> venues = venueMapper.findAllVenue();
        if (venues != null) {
            venues.stream().forEach(venue -> venue.setSpaces(findVenueSpace(venue.getId())));
        }
        return venues;
    }

    public void saveVenueSpace(VenueSpace venueSpace, EdgeDocument edgeDocument) {
        if (edgeDocument != null) {
            edgeDocument.setCreatedBy(venueSpace.getCreatedBy());
            documentMapper.saveDocument(edgeDocument);
            venueSpace.setFkDocument(edgeDocument.getId());
            venueMapper.saveVenueSpace(venueSpace);
        } else {
            venueMapper.saveVenueSpace(venueSpace);
        }
    }

    public List<VenueSpace> findVenueSpace(Long fkVenue) {
        List<VenueSpace> venueSpace = venueMapper.findVenueSpace(fkVenue);
        venueSpace.stream().forEach(space -> {
            if (space.getThumbnail() != null) {
                space.setThumbnail(this.fileService.findThumbnail(space.getThumbnail(), space.getExt()));
            }
        });
        return venueSpace;
    }

    public void saveImageForVenueSpace(EdgeDocument edgeDocument, Long fkId) {
        documentMapper.saveDocument(edgeDocument);

        if (edgeDocument.getId() != null) {
            documentMapper.saveImageForVenueSpace(edgeDocument.getId(), fkId);
        }
    }

    public void updateVenueSpace(VenueSpace venueSpace, EdgeDocument edgeDocument) {
        if (edgeDocument != null) {
            edgeDocument.setCreatedBy(venueSpace.getCreatedBy());
            documentMapper.saveDocument(edgeDocument);
            venueSpace.setFkDocument(edgeDocument.getId());
            venueMapper.updateVenueSpace(venueSpace);
        } else {
            venueMapper.updateVenueSpace(venueSpace);
        }
    }

    public VenueSpacesDao findVenueSpaceBySpaceId(Long fkSpace) {
        VenueSpacesDao spaceDetail = venueMapper.findSpaceDetail(fkSpace);

        if (spaceDetail.getFkDocument() != null) {
            spaceDetail.setImage(fileService.findImage(spaceDetail.getFkDocument()));
        }
        spaceDetail.setVenue(venueMapper.findVenue(spaceDetail.getFkVenue()));

        List<EdgeDocument> images = documentMapper.findVenueSpaceImages(fkSpace);

        List<UploadImage> list = new ArrayList<>();
        for (EdgeDocument img : images) {
            if (img.getAltPath() != null) {
                UploadImage image = new UploadImage();
                image.setImage(fileService.findThumbnail(img.getAltPath(), img.getExt()));
                image.setFkId(img.getId());
                list.add(image);
            }
        }
        spaceDetail.setImages(list);
        return spaceDetail;
    }

    public void saveFacility(Facility facility) {
        venueMapper.saveFacility(facility);
    }

    public List<Facility> findFacility(Long fkVenueSpace) {
        return venueMapper.findFacility(fkVenueSpace);
    }

    public boolean deactivateVenueSpace(Long id) {
        venueMapper.deactivateVenueSpace(id);
        return true;
    }

    public boolean activateVenueSpace(Long id) {
        venueMapper.activateVenueSpace(id);
        return true;
    }
}
