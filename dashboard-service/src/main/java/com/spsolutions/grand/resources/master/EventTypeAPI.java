package com.spsolutions.grand.resources.master;


import com.spsolutions.grand.domain.EdgeDocument;
import com.spsolutions.grand.domain.master.EventType;
import com.spsolutions.grand.service.master.EventTypeService;
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
public class EventTypeAPI {

    @Value("${archive.path}")
    private String archivePath;

    @Autowired
    private EventTypeService typeService;

    @GetMapping(value = "findAllEventTypes")
    public List<EventType> findAllEventTypes() {
        return typeService.findAllEventType();
    }

    @GetMapping(value = "findActiveEventTypes")
    public List<EventType> findActiveEventTypes() {
        return typeService.findActiveEventTypes();
    }

    @PostMapping(value = "saveEventType")
    public void saveEventType(@RequestBody EventType eventType) {
        if (eventType.getImage() != null) {
            EdgeDocument edgeDocument = new ArchiveUtils().writeToFile(eventType.getImage(), this.archivePath, eventType.getEventType(), true);
            edgeDocument.setCreatedBy(eventType.getCreatedBy());
            typeService.saveEventType(eventType, edgeDocument);
        } else {
            typeService.saveEventType(eventType, null);
        }
    }

    @PostMapping(value = "updateEventType")
    public void updateEventType(@RequestBody EventType eventType) {
        typeService.updateEventType(eventType);
    }

}
