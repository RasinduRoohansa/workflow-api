package com.spsolutions.grand.service.master;

import com.spsolutions.grand.domain.master.CheckListTemplate;
import com.spsolutions.grand.domain.master.CheckListTemplateItem;
import com.spsolutions.grand.mappers.master.CheckListMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CheckListService {

    @Autowired
    private CheckListMapper checkListMapper;

    public List<CheckListTemplate> findCheckListTemplateByEventType(Long fkEventType) {
        return this.checkListMapper.findCheckListTemplateByEventType(fkEventType);
    }

    public List<CheckListTemplateItem> findCheckListItemByTemplateId(Long fkMasterCheckList) {
        return this.checkListMapper.findCheckListItemByTemplateId(fkMasterCheckList);
    }
}
