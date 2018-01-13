package com.spsolutions.grand.mappers.activitylog;

import com.spsolutions.grand.domain.activitylog.ActivityLog;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ActivityLogMapper {
    List<ActivityLog> findActLogByEnquiryId(Long fkEnquiry);

    void createActLog(ActivityLog activityLog);
}
