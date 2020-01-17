package com.bankapp.restapi.kindedbankrestapi.common;

import org.apache.commons.lang3.time.DateUtils;

import java.util.Calendar;
import java.util.Date;

/**
 * @project kinded-bank-restapi
 * @autor tejnal on 2020-01-16
 */
public class CustomerAccountUtils {

    public static Date getEndOfDay(Date date) {
        return DateUtils.addMilliseconds(DateUtils.ceiling(date, Calendar.DATE), -1);
    }

    public static Date getStartOfDay(Date date) {
        return DateUtils.truncate(date, Calendar.DATE);
    }

}
