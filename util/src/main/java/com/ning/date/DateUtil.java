package com.ning.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
    public static String yyyyMMdd_hhmmss = "yyyy-MM-dd hh:mm:ss";
    private static final SimpleDateFormat DEFAULT_SIMPLE_DATEFORMAT = new SimpleDateFormat(yyyyMMdd_hhmmss);
    public static String currentTimeStr(){
        return DEFAULT_SIMPLE_DATEFORMAT.format(new Date());
    }

    public static void main(String[] args) throws ParseException {
        System.out.println(DEFAULT_SIMPLE_DATEFORMAT.parse("2023-12-12 11:11:11"));
    }

}
