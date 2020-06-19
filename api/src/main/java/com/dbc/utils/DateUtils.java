package com.dbc.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.Random;

public class DateUtils {
    private static Logger logger = LoggerFactory.getLogger(DateUtils.class);

    public static int NewDateInt() {
        long nowTime = System.currentTimeMillis() / 1000;
        return new Long(nowTime).intValue();
    }

    public static Date IntToDate(int nowTimeInt){
        Date nowTimeDate = null;
        try{
            long nowTimeLong = new Long(nowTimeInt).longValue() * 1000;
            DateFormat ymdhmsFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String nowTimeStr = ymdhmsFormat.format(nowTimeLong);
            nowTimeDate = ymdhmsFormat.parse(nowTimeStr);
        }catch (ParseException e){
            e.printStackTrace();
            logger.error("日期工具类错误：int数值转化为Date数值出错！");
        }
        return nowTimeDate;
    }

    public static String dateFolderStr(LocalDate date, String prefix) {
        return prefix + "_" +date.getYear() + date.getMonthValue() + date.getDayOfMonth();
    }

//    public static int LastWeekTime(){
//        long nowTimeMills = (System.currentTimeMillis() - Num.ONE_WEEK_MILLS) / 1000;
//        return new Long(nowTimeMills).intValue();
//    }
//
//    public static int LastDayTime(){
//        long nowTimeMills = (System.currentTimeMillis() - Num.ONE_DAY_MILLS) / 1000;
//        return new Long(nowTimeMills).intValue();
//    }
}
