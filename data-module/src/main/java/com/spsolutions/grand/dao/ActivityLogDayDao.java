package com.spsolutions.grand.dao;

import com.spsolutions.grand.domain.activitylog.ActivityLog;

import java.util.Date;
import java.util.List;

public class ActivityLogDayDao {
    private Date date;
    private boolean today;
    private List<ActivityLog> logs;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public List<ActivityLog> getLogs() {
        return logs;
    }

    public void setLogs(List<ActivityLog> logs) {
        this.logs = logs;
    }

    public boolean isToday() {
        return today;
    }

    public void setToday(boolean today) {
        this.today = today;
    }
}
