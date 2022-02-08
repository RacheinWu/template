package com.rachein.demo.utils;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 用于各种时间
 */
public class DateUtil {

    /**
     * @return yyyy-MM-dd HH:mm
     */
    public static String yyyy_MM_dd_HH_mm() {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm").format(new Date());
    }

    /**
     * @return yyyy-MM-dd HH:mm
     */
//    public static Date yyyy_MM_dd_HH_mm_ss() {
//        String format = new SimpleDateFormat("yyyy-MM-dd HH:mm").format(new Date());
//
//    }



}
