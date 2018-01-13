package com.spsolutions.grand.mappers.roster;

import com.spsolutions.grand.dao.roster.AvailableEmployeeDAO;
import com.spsolutions.grand.dao.roster.EventAllocationDao;
import com.spsolutions.grand.domain.roster.EventEmployeeAllocation;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface EventEmployeeAllocationMapper {

    public void saveEventEmployeeAllocationMapper(EventEmployeeAllocation eventEmployeeAllocation);

    public List<EventAllocationDao> getRosterEventAllocationByBookingId(Long bookingId);

    public List<AvailableEmployeeDAO> getAvailableEmployees(Long empTypeId);
}
