package com.spsolutions.grand.resources.roster;

import com.spsolutions.grand.domain.roster.EmployeeMaster;
import com.spsolutions.grand.mappers.roster.EmployeeMapper;
import com.spsolutions.grand.service.roster.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping(value = "/employeeAPI/")
public class EmployeeAPI {

    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeAPI.class.getName());

    @Autowired
    EmployeeService employeeService;

    @GetMapping(value = "testEmployeeMap")
    public String isItWorking() {
        return "okay : EMPLOYEE MAP IS WORKING";
    }

    @PostMapping("saveEmployeeMapper")
    public HashMap<String, String> saveEmployeeMapper(@RequestBody EmployeeMaster employeeMaster) {
        Long res = employeeService.saveEmployee(employeeMaster);
        HashMap<String, String> map = new HashMap<>();

        if (res != -9999L) {
            map.put("msg", "Event RosterEmployee Mapping Successfully Saved");

        } else {
            map.put("msg", "Event RosterEmployee Mapping save failed");
        }

        return map;
    }

    @GetMapping(value = "findAllEmployees")
    public List<EmployeeMaster> findAllActiveEmployees() {
        return employeeService.findAllActiveEmployees();
    }

    @GetMapping(value = "findAllInActiveEmployees")
    public List<EmployeeMaster> findAllInActiveEmployees() {
        return employeeService.findAllInActiveEmployees();
    }

    @GetMapping(value = "filterEmployees/{keyword}")
    public List<EmployeeMaster> filterEmployee(@PathVariable String keyword) {
        return employeeService.filterEmployee(keyword);
    }


    @PostMapping("updateEmployeeMapper")
    public HashMap<String, String> updateEmployeeMapper(@RequestBody EmployeeMaster employeeMaster) {
        int res = employeeService.updateEmployee(employeeMaster);
        LOGGER.info("update-" + res);
        HashMap<String, String> map = new HashMap<>();

        if (res != -9999L) {
            map.put("msg", "Event RosterEmployee Mapping Successfully Saved");

        } else {
            map.put("msg", "Event RosterEmployee Mapping save failed");
        }

        return map;
    }

    @GetMapping(value = "findEmployeeByID/{id}")
    public EmployeeMaster findActiveEmployeeById(@PathVariable Long id) {
        return employeeService.findActiveEmployeeById(id);
    }


}
