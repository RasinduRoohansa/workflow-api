package com.spsolutions.grand.resources.master;

import com.spsolutions.grand.domain.master.CheckListTemplate;
import com.spsolutions.grand.domain.master.CheckListTemplateItem;
import com.spsolutions.grand.service.master.CheckListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/check-list/")
public class CheckListAPI {

    @Autowired
    private CheckListService checkListService;

    @GetMapping("findCheckListTemplateByEventType/{fkEventType}")
    public List<CheckListTemplate> findCheckListTemplateByEventType(@PathVariable("fkEventType") Long fkEventType) {
        return this.checkListService.findCheckListTemplateByEventType(fkEventType);
    }

    @GetMapping("findCheckListItemByTemplateId/{id}")
    public List<CheckListTemplateItem> findCheckListItemByTemplateId(@PathVariable("id") Long id) {
        return this.checkListService.findCheckListItemByTemplateId(id);
    }

}
