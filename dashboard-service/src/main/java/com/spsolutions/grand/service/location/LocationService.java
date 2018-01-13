package com.spsolutions.grand.service.location;

import com.spsolutions.grand.domain.location.EdgeLocation;
import com.spsolutions.grand.mappers.location.LocationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LocationService {
    @Autowired
    private LocationMapper locationMapper;

    public void saveLocation(EdgeLocation location) {
        this.locationMapper.saveLocation(location);
    }
}
