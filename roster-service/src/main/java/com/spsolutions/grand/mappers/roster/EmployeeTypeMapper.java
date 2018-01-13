package com.spsolutions.grand.mappers.roster;

import com.spsolutions.grand.domain.roster.EmployeeType;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface EmployeeTypeMapper {

    public void saveEmployeeTypeMapper(EmployeeType employeeType);
    public List<EmployeeType> findAllEmployeeType();

}
