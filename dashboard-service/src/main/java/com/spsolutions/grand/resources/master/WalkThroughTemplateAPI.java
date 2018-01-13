package com.spsolutions.grand.resources.master;

import com.spsolutions.grand.domain.master.WalkThroughTemplate;
import com.spsolutions.grand.service.master.WalkThroughTemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Stelan Briyan
 */
@RestController
@RequestMapping(value = "/template/")
public class WalkThroughTemplateAPI {
    @Autowired
    private WalkThroughTemplateService templateService;

    @PostMapping("createTemplate")
    public Long createTemplate(@RequestBody WalkThroughTemplate template) {
        return this.templateService.createTemplate(template);
    }

    @GetMapping("findTemplates")
    public List<WalkThroughTemplate> findTemplates() {
        return this.templateService.findTemplates();
    }

    @GetMapping("findActiveTemplates/{fkEventType}")
    public List<WalkThroughTemplate> findActiveTemplates(@PathVariable("fkEventType") Long fkEventType) {
        return this.templateService.findActiveTemplates(fkEventType);
    }
}
