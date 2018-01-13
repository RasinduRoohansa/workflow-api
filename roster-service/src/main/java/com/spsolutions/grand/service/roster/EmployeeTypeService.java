package com.spsolutions.grand.service.roster;

import com.spsolutions.grand.domain.roster.EmployeeType;
import com.spsolutions.grand.mappers.roster.EmployeeTypeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeTypeService {

    @Autowired
    private EmployeeTypeMapper employeeTypeMapper;


    public Long saveEmployeeTypeMapper(EmployeeType employeeType){
        employeeTypeMapper.saveEmployeeTypeMapper(employeeType);
        if(employeeType.getId() !=null){
            return employeeType.getId();
        }else{
            return -9999L;
        }
    }

    public List<EmployeeType> findAllEmployeeType(){
        List<EmployeeType> employeeTypeList = employeeTypeMapper.findAllEmployeeType();

        return employeeTypeList;
    }

}
