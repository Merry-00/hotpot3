package com.gcl.demo.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class getNowTime {
    public  Date getNowTime() {
        Calendar calendar = Calendar.getInstance();
        System.out.println(calendar);
        String pattern = "yyyy年MM月dd日 HH时mm分ss秒";
        SimpleDateFormat calendarFormat = new SimpleDateFormat(pattern);
        String s=calendarFormat.format(calendar.getTime());
        System.out.println (s);
        //将String类型转换成Date类型
        java.text.SimpleDateFormat formatter = new SimpleDateFormat( "yyyy年MM月dd日 HH时mm分ss秒");
        Date date = null;
        try {
            date = formatter.parse(s);
        } catch (ParseException e) {
            e.printStackTrace ();
        }
        return date;
    }
}
