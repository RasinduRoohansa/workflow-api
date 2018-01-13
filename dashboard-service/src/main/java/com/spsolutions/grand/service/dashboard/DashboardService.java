package com.spsolutions.grand.service.dashboard;

import com.spsolutions.grand.dao.Dashboard;
import com.spsolutions.grand.service.event.EnquiryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DashboardService {
    @Autowired
    private EnquiryService enquiryService;

    public Dashboard findDashboardSummery() {
        Dashboard dashboard = new Dashboard();
        this.enquiryService.findLatestWalkthrough(3);
        dashboard.setEnquiry(this.enquiryService.findLatestWalkthrough(4));

        dashboard.setMapLocation(this.enquiryService.findWalkThroughMapLocation(10));
        return dashboard;
    }
}
