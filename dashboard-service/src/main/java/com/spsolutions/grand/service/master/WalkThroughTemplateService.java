package com.spsolutions.grand.service.master;

import com.spsolutions.grand.domain.master.WalkThroughTemplate;
import com.spsolutions.grand.mappers.master.WalkThroughTemplateMapper;
import com.spsolutions.grand.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WalkThroughTemplateService {

    @Autowired
    private WalkThroughTemplateMapper templateMapper;

    @Autowired
    private FileService fileService;

    public Long createTemplate(WalkThroughTemplate template) {
        this.templateMapper.createTemplate(template);
        return template.getId();
    }

    public List<WalkThroughTemplate> findTemplates() {
        List<WalkThroughTemplate> templates = this.templateMapper.findTemplates();
//        templates.stream().forEach(template -> {
//            EventType eventType = template.getEventType();
//            if (eventType != null && eventType.getThumbnail() != null) {
//                eventType.setThumbnail(this.fileService.findThumbnail(eventType.getThumbnail(), eventType.getExt()));
//            }
//        });
        return templates;
    }

    public List<WalkThroughTemplate> findActiveTemplates(Long fkEventType) {
        return this.templateMapper.findActiveTemplates(fkEventType);
    }
}
