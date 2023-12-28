package com.common.utils;

import java.util.Date;
import org.joda.time.DateTime;


/**
 * @author aibinru:am19136754034@gmail.com
 * @date 23-12-28 16:30
 * @description:
 */
public class DateUtils {

    /**
     * 对日期的【分钟】进行加/减
     *
     * @param date 日期
     * @param minutes 分钟数，负数为减
     * @return 加/减几分钟后的日期
     */
    public static Date addDateMinutes(Date date, int minutes) {
        DateTime dateTime = new DateTime(date);
        return dateTime.plusMinutes(minutes).toDate();
    }
}
