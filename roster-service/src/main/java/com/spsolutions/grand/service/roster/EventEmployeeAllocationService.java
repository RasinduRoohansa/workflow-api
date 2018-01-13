package com.spsolutions.grand.service.roster;

import com.spsolutions.grand.dao.roster.AvailableEmployeeDAO;
import com.spsolutions.grand.dao.roster.EventAllocationDao;
import com.spsolutions.grand.domain.roster.EventEmployeeAllocation;
import com.spsolutions.grand.mappers.roster.EventEmployeeAllocationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *
 */
@Service
public class EventEmployeeAllocationService {

    @Autowired
    private EventEmployeeAllocationMapper eventEmployeeAllocationMapper;

    public Long saveEventEmployeeAllocationMapper(EventEmployeeAllocation eventEmployeeAllocation){
        this.eventEmployeeAllocationMapper.saveEventEmployeeAllocationMapper(eventEmployeeAllocation);
        if(eventEmployeeAllocation!= null){
            return eventEmployeeAllocation.getEventId();
        }else{
            return -9999L;
        }
    }

    public List<EventAllocationDao> getRosterEventAllocationByBookingId(Long bookingId){
        return eventEmployeeAllocationMapper.getRosterEventAllocationByBookingId(bookingId);
    }

    public List<AvailableEmployeeDAO> getAvailableEmployees(Long empTypeId){
        return eventEmployeeAllocationMapper.getAvailableEmployees(empTypeId);
    }

}
