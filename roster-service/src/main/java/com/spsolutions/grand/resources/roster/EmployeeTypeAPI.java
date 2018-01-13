package com.spsolutions.grand.resources.roster;


import com.spsolutions.grand.domain.roster.EmployeeType;
import com.spsolutions.grand.service.roster.EmployeeTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping(value = "/employeeType/")
public class EmployeeTypeAPI {

    @Autowired
    private EmployeeTypeService employeeTypeService;


    @GetMapping(value = "testEmployeeType")
    public String isItWorking(){
        return "okay : EMPLOYEE TYPE IS WORKING";
    }


    @PostMapping("addEmployeeType")
    public HashMap<String,String> addEmployeeType(@RequestBody EmployeeType employeeType){
        HashMap<String,String> map = new HashMap<>();
        Long res = employeeTypeService.saveEmployeeTypeMapper(employeeType);
        if(res != -9999L){
            map.put("msg","RosterEmployee Type Successfully Saved");

        }else{
            map.put("msg","RosterEmployee Type save failed");
        }

        return map;

    }

    @GetMapping("findAllEmployeeType")
    public List<EmployeeType> findAllEmployeeType(){
        return employeeTypeService.findAllEmployeeType();
    }



}
