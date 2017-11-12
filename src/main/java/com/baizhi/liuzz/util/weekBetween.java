package com.baizhi.liuzz.util;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by Administrator on 2017/11/1.
 */
public class weekBetween {
    public static int getWeeks(Date newtime,Date oldtime){
        Calendar cal = Calendar.getInstance();
        cal.setTime(newtime);
        long time1 = cal.getTimeInMillis();

        cal.setTime(oldtime);
        long time2 = cal.getTimeInMillis();
        long between_week=(time1-time2)/(1000*3600*24*7);
        return Integer.parseInt(String.valueOf(between_week));
    }
}
