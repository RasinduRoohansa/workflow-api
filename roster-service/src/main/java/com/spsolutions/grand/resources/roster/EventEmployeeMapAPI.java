package com.spsolutions.grand.resources.roster;


import com.spsolutions.grand.dao.roster.AvailableEmployeeDAO;
import com.spsolutions.grand.domain.roster.EventEmployeeMap;
import com.spsolutions.grand.service.roster.EventEmployeeMapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping(value = "/eventEmployeeMap/")
public class EventEmployeeMapAPI {


    @Autowired
    private EventEmployeeMapService eventEmployeeMapService;

    @GetMapping(value = "testEventEmployeeMap")
    public String isItWorking() {
        return "okay : EVENT EMPLOYEE MAP IS WORKING";

    }

    @PostMapping("addEventEmployeeMapper")
    public HashMap<String, String> saveEventEmployeeMapper(@RequestBody EventEmployeeMap eventEmployeeMap) {
        Long res = eventEmployeeMapService.saveEventEmployeeMapper(eventEmployeeMap);
        HashMap<String, String> map = new HashMap<>();

        if (res != -9999L) {
            map.put("msg", "Event RosterEmployee Mapping Successfully Saved");

        } else {
            map.put("msg", "Event RosterEmployee Mapping save failed");
        }

        return map;


    }

    @GetMapping("getAllSelectedEmployees/{bkId}/{emPId}")
    public List<AvailableEmployeeDAO> getAllSelectedEmployees(@PathVariable("bkId") Long bkId,
                                                              @PathVariable("emPId") Long emPId) {
        return eventEmployeeMapService.getAllSelectedEmployees(bkId, emPId);
    }


}
