package com.spsolutions.grand.service.roster;


import com.spsolutions.grand.dao.roster.AvailableEmployeeDAO;
import com.spsolutions.grand.domain.roster.EventEmployeeMap;
import com.spsolutions.grand.mappers.roster.EventEmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventEmployeeMapService {

    @Autowired
    private EventEmployeeMapper eventEmployeeMapper;

    public Long saveEventEmployeeMapper(EventEmployeeMap eventEmployeeMap){
        eventEmployeeMapper.saveEventEmployeeMapper(eventEmployeeMap);
        if(eventEmployeeMap!=null){
            return eventEmployeeMap.getId();
        }else{
            return -9999L;
        }
    }

    public List<AvailableEmployeeDAO> getAllSelectedEmployees(Long bId, Long eTId){
        return eventEmployeeMapper.getAllSelectedEmployees(bId, eTId);
    }


}
