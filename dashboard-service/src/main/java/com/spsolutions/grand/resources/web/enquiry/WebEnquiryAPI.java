package com.spsolutions.grand.resources.web.enquiry;

import com.spsolutions.grand.dao.ResultResponse;
import com.spsolutions.grand.dao.SearchEnquiryDao;
import com.spsolutions.grand.dao.UploadImage;
import com.spsolutions.grand.dao.VenueSpacesDao;
import com.spsolutions.grand.domain.enquiry.Enquiry;
import com.spsolutions.grand.domain.master.EventType;
import com.spsolutions.grand.service.event.EnquiryService;
import com.spsolutions.grand.service.master.EventTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/web/enquiry/")
public class WebEnquiryAPI {

    @Autowired
    private EnquiryService enquiryService;

    @Autowired
    private EventTypeService eventTypeService;

    @PostMapping(value = "createEnquiry")
    public ResultResponse createEnquiry(@RequestBody Enquiry enquiry) {
        if (enquiry.getCustomer() == null) {
            return new ResultResponse().setMsg("Customer is required!")
                    .setStatus(HttpStatus.BAD_REQUEST.value());
        }
        this.enquiryService.createEnquiry(enquiry);
        return new ResultResponse().setMsg("Thank you for your enquiry a team member from the Grand Receptions will get in touch with your shortly!")
                .setStatus(HttpStatus.OK.value());
    }

    @PostMapping(value = "findAvailableSpaces")
    public List<VenueSpacesDao> findAvailableSpaces(@RequestBody SearchEnquiryDao enquiryDao) {
        return enquiryService.findAvailableSpacesForWeb(enquiryDao);
    }

    @GetMapping(value = "findSpaceDetail/{fkSpace}")
    public VenueSpacesDao findSpaceDetail(@PathVariable("fkSpace") Long fkSpace) {
        return enquiryService.findSpaceDetail(fkSpace);
    }

    @GetMapping(value = "findSpaceImage/{fkSpace}")
    public List<UploadImage> findSpaceImage(@PathVariable("fkSpace") Long fkSpace) {
        return enquiryService.findSpaceImage(fkSpace);
    }


    @GetMapping(value = "getActiveEventType")
    public List<EventType> getActiveEventType() {
        return this.eventTypeService.getActiveEventType();
    }

}
