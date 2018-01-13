package com.spsolutions.grand.resources.dashboard;

import com.spsolutions.grand.dao.Dashboard;
import com.spsolutions.grand.service.dashboard.DashboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Stelan Briyan
 */
@RestController
@RequestMapping(value = "/")
public class DashboardAPI {

    @Autowired
    private DashboardService dashboardService;

    @GetMapping("findDashboardSummery")
    public Dashboard findDashboardSummery(){
       return this.dashboardService.findDashboardSummery();
    }
}
