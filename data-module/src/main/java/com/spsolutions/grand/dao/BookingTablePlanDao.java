package com.spsolutions.grand.dao;

import com.spsolutions.grand.domain.booking.BookingTablePlan;

import java.util.List;

public class BookingTablePlanDao {
    private String tableNumber;
    private List<BookingTablePlan> tablePlans;

    public String getTableNumber() {
        return tableNumber;
    }

    public void setTableNumber(String tableNumber) {
        this.tableNumber = tableNumber;
    }

    public List<BookingTablePlan> getTablePlans() {
        return tablePlans;
    }

    public void setTablePlans(List<BookingTablePlan> tablePlans) {
        this.tablePlans = tablePlans;
    }
}
