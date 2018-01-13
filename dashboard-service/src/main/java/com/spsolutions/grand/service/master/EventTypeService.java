package com.spsolutions.grand.service.master;

import com.spsolutions.grand.domain.EdgeDocument;
import com.spsolutions.grand.domain.master.EventType;
import com.spsolutions.grand.mappers.DocumentMapper;
import com.spsolutions.grand.mappers.master.EventTypeMapper;
import com.spsolutions.grand.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Stelan Briyan
 */
@Service
public class EventTypeService {

    @Autowired
    private EventTypeMapper typeMapper;

    @Autowired
    private DocumentMapper documentMapper;

    @Autowired
    private FileService fileService;

    public void saveEventType(EventType eventType, EdgeDocument edgeDocument) {
        if (edgeDocument != null) {
            this.documentMapper.saveDocument(edgeDocument);
            eventType.setFkDocument(edgeDocument.getId());
        }
        if (eventType.isUpdate()) {
            this.typeMapper.updateEventType(eventType);
        } else {
            this.typeMapper.saveEventType(eventType);
        }
    }

    public List<EventType> findAllEventType() {
        List<EventType> allEventType = typeMapper.findAllEventType();
        allEventType.stream().forEach(type -> {
            if (type.getThumbnail() != null) {
                type.setThumbnail(this.fileService.findThumbnail(type.getThumbnail(), type.getExt()));
            }
        });
        return allEventType;
    }

    public void updateEventType(EventType eventType) {
        typeMapper.updateEventType(eventType);
    }

    public List<EventType> getActiveEventType() {
        return typeMapper.getActiveEventType();
    }

    public List<EventType> findActiveEventTypes() {
        return typeMapper.getActiveEventType();
    }
}
