package com.spsolutions.grand.service.activitylog;

import com.spsolutions.grand.constant.LoggerConstants;
import com.spsolutions.grand.dao.ActivityLogDayDao;
import com.spsolutions.grand.domain.activitylog.ActivityLog;
import com.spsolutions.grand.mappers.activitylog.ActivityLogMapper;
import com.spsolutions.grand.util.ArchiveUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class ActivityLogService {
    final static Logger logger = Logger.getLogger(ArchiveUtils.class);
    private DateFormat ddMMyyyy = new SimpleDateFormat("dd-MM-yyyy");

    @Autowired
    private ActivityLogMapper activityLogMapper;

    public List<ActivityLogDayDao> findActLogByEnquiryId(Long fkEnquiry) {
        Map<String, List<ActivityLog>> map = new HashMap<>();

        List<ActivityLog> logs = this.activityLogMapper.findActLogByEnquiryId(fkEnquiry);

        logs.stream().forEach(log -> {
            String createdDate = ddMMyyyy.format(log.getCreatedDate());

            List<ActivityLog> logList = map.get(createdDate);
            if (logList == null) {
                logList = new ArrayList<>();
            }
            logList.add(log);

            map.put(createdDate, logList);
        });

        List<ActivityLogDayDao> dayDaos = new ArrayList<>();
        for (String key : map.keySet()) {
            ActivityLogDayDao dayDao = new ActivityLogDayDao();
            if (ddMMyyyy.format(new Date()).equals(key)) {
                dayDao.setToday(true);
            }
            try {
                dayDao.setDate(ddMMyyyy.parse(key));
            } catch (ParseException e) {
                logger.error(e.getMessage(), e);
            }
            dayDao.setLogs(map.get(key));
            dayDaos.add(dayDao);
        }

        return dayDaos;
    }

    public void createActLog(LoggerConstants type, String description, String createdBy, Long fkQuoteEnquiry) {
        ActivityLog activityLog = new ActivityLog();
        activityLog.setLogType(type.getType());
        activityLog.setDescription(description);
        activityLog.setCreatedBy(createdBy);
        activityLog.setFkQuoteEnquiry(fkQuoteEnquiry);
        this.activityLogMapper.createActLog(activityLog);
    }
}
