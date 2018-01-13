package com.spsolutions.grand.resources.event;

import com.spsolutions.grand.dao.EnquiryAllocationDao;
import com.spsolutions.grand.dao.EnquiryDriverAllocationDao;
import com.spsolutions.grand.dao.WalkThroughTime;
import com.spsolutions.grand.domain.enquiry.Enquiry;
import com.spsolutions.grand.service.event.EnquiryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Stelan Briyan
 */
@RestController
@RequestMapping(value = "/enquiry/")
public class EnquiryAPI {

    @Autowired
    private EnquiryService enquiryService;

    @GetMapping("getNotAllocatedEnquiry")
    public List<Enquiry> getNotAllocatedEnquiry() {
        return enquiryService.getNotAllocatedEnquiry();
    }

    @GetMapping("getAllocatedEnquiry")
    public List<Enquiry> getEnquires() {
        return enquiryService.getAllocatedEnquiry();
    }

    @GetMapping("getAllocatedEnquiryByUsers/{username}")
    public List<Enquiry> getAllocatedEnquiryByUsers(@PathVariable("username") String username) {
        return enquiryService.getAllocatedEnquiryByUsers(username);
    }

   @GetMapping("getEnquiry/{status}")
    public List<Enquiry> getEnquiry(@PathVariable("status") String status) {
        return enquiryService.getEnquiry(status);
    }

   @GetMapping("getEnquiryById/{id}")
    public Enquiry getEnquiryById(@PathVariable("id") Long id) {
        return enquiryService.getEnquiryById(id);
    }

   @GetMapping("getEnquiryByWalkThroughId/{id}")
    public Enquiry getEnquiryByWalkThroughId(@PathVariable("id") Long id) {
        return enquiryService.getEnquiryByWalkThroughId(id);
    }

    @PostMapping("allocateEnquiry")
    public void allocateEnquiry(@RequestBody EnquiryAllocationDao allocationDao) {
        enquiryService.allocateEnquiry(allocationDao);
    }

    @PostMapping("reserveTimeWalkThrough")
    public void reserveTimeWalkThrough(@RequestBody WalkThroughTime throughTime) {
        enquiryService.reserveTimeWalkThrough(throughTime);
    }

    @PostMapping("allocateDriver")
    public void allocateDriver(@RequestBody EnquiryAllocationDao allocationDao) {
        enquiryService.allocateDriver(allocationDao);
    }

    @GetMapping("getEnquiryForDriverAllocation/{status}")
    public List<EnquiryDriverAllocationDao> getEnquiryForDriverAllocation(@PathVariable("status") String status) {
        return enquiryService.getEnquiryByIdForDriverAllocation();
    }

    @PostMapping("unAllocateTransport")
    public void unAllocateTransport(@RequestBody Enquiry enquiry) {
         enquiryService.unAllocateTransport(enquiry);
    }

    @GetMapping("findReserveTimeWalkThrough/{id}")
    public WalkThroughTime findReserveTimeWalkThrough(@PathVariable("id") Long id) {
        return enquiryService.findReserveTimeWalkThrough(id);
    }

}
