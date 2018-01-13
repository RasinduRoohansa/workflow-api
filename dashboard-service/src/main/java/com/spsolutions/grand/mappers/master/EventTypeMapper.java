package com.spsolutions.grand.mappers.master;

import com.spsolutions.grand.domain.master.EventType;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author Stelan Briyan
 */
@Mapper
public interface EventTypeMapper {
    void saveEventType(EventType eventType);

    List<EventType> findAllEventType();

    void updateEventType(EventType eventType);

    List<EventType> getActiveEventType();
}
