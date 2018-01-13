package com.spsolutions.grand.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
    private static final DateFormat FILE_NAME_DATE_FORMAT = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss_SSS");

    public static String getFileNameDate() {
        Date now = new Date();
        return FILE_NAME_DATE_FORMAT.format(now);
    }
}
