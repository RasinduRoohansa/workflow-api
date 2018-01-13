package com.spsolutions.grand.mappers.roster;


import com.spsolutions.grand.dao.roster.AvailableEmployeeDAO;
import com.spsolutions.grand.domain.roster.EventEmployeeMap;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface EventEmployeeMapper {

    public void saveEventEmployeeMapper(EventEmployeeMap eventEmployeeMap);

    public List<AvailableEmployeeDAO> getAllSelectedEmployees(@Param("idbooking") Long idBooking,@Param("idEmTyp") Long idEmpType );


}
