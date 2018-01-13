package com.spsolutions.grand.domain.master;

import com.spsolutions.grand.domain.common.CommonDomain;

public class WalkThroughTemplate extends CommonDomain{
    private Long fkEventType;
    private String name;
    private EventType eventType;

    public EventType getEventType() {
        return eventType;
    }

    public void setEventType(EventType eventType) {
        this.eventType = eventType;
    }

    public Long getFkEventType() {
        return fkEventType;
    }

    public void setFkEventType(Long fkEventType) {
        this.fkEventType = fkEventType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
