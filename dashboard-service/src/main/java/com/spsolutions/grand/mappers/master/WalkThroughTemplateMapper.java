package com.spsolutions.grand.mappers.master;

import com.spsolutions.grand.domain.master.WalkThroughTemplate;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface WalkThroughTemplateMapper {
    Long createTemplate(WalkThroughTemplate template);

    List<WalkThroughTemplate> findTemplates();

    List<WalkThroughTemplate> findActiveTemplates(Long fkEventType);
}
