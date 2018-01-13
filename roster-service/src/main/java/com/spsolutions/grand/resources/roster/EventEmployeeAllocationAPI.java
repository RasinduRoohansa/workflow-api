package com.spsolutions.grand.resources.roster;

import com.spsolutions.grand.dao.roster.AvailableEmployeeDAO;
import com.spsolutions.grand.dao.roster.EventAllocationDao;
import com.spsolutions.grand.domain.roster.EventEmployeeAllocation;
import com.spsolutions.grand.service.roster.EventEmployeeAllocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

/**
 *
 */
@RestController
@RequestMapping(value = "/eventEmployeeAllocation/")
public class EventEmployeeAllocationAPI {

    @Autowired
    private EventEmployeeAllocationService eventEmployeeAllocationService;


    //@RequestMapping(name = "testEventEmployeeAllocation",method = RequestMethod.GET)
    @GetMapping(value = "testEventEmployeeAllocation")
    public String isItWorking(){

        return  new String("{ 'okay' : 'EMPLOYEE ALLOCATION EMPLOYEE  IS WORKING'}");
    }

    @PostMapping("addEventEmployeeAllocation")
    public HashMap<String,String>  saveEventEmployeeAllocationMapper(@RequestBody EventEmployeeAllocation eventEmployeeAllocation){
        HashMap<String,String> map = new HashMap<>();
        Long res = this.eventEmployeeAllocationService.saveEventEmployeeAllocationMapper(eventEmployeeAllocation);
        if(res != -9999L){
            map.put("msg","Event RosterEmployee Allocation Successfully Saved");

        }else{
            map.put("msg","Event RosterEmployee Allocation save failed");
        }

        return map;

    }

    @GetMapping("getRosterEventAllocationByBookingId/{bookingId}")
    public List<EventAllocationDao> getRosterEventAllocationByBookingId(@PathVariable Long bookingId){
        return eventEmployeeAllocationService.getRosterEventAllocationByBookingId(bookingId);
    }

    @GetMapping("getAvailableEmployees/{empTypeId}")
    public List<AvailableEmployeeDAO> getAvailableEmployees(@PathVariable  Long empTypeId){
        return eventEmployeeAllocationService.getAvailableEmployees(empTypeId);
    }


}
