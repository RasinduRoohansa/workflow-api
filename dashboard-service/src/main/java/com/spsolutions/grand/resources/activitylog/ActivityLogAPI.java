package com.spsolutions.grand.resources.activitylog;

import com.spsolutions.grand.dao.ActivityLogDayDao;
import com.spsolutions.grand.service.activitylog.ActivityLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Stelan Briyan
 */
@RestController
@RequestMapping(value = "/activity-log/")
public class ActivityLogAPI {

    @Autowired
    private ActivityLogService logService;

    @GetMapping("findActLogByEnquiryId/{id}")
    public List<ActivityLogDayDao> findActLogByEnquiryId(@PathVariable("id") Long fkEnquiry) {
        return logService.findActLogByEnquiryId(fkEnquiry);
    }
}
