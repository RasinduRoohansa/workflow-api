package com.spsolutions.grand.mappers.master;

import com.spsolutions.grand.domain.master.CheckListTemplate;
import com.spsolutions.grand.domain.master.CheckListTemplateItem;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CheckListMapper {
    List<CheckListTemplate> findCheckListTemplateByEventType(Long fkEventType);

    List<CheckListTemplateItem> findCheckListItemByTemplateId(Long fkMasterCheckList);
}
