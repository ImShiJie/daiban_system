package com.daiban.util;

import org.springframework.util.StringUtils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * @program: daiban
 * @description:将2019-06-03T16:00:00.000Z日期格式转换为2019-06-03 16:00:00格式
 * @author: 施
 * @create: 2019-11-02 16:43
 **/

public class DateUtil {
    public static Date transferDateFormat(String oldDateStr) {
        if (StringUtils.isEmpty(oldDateStr)){
            return null;
        }
        Date date = null;
        Date date1 = null;
        String dateStr = null;
        try {
            dateStr = oldDateStr.replace("Z", " UTC");//是空格+UTC
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS Z");
            date1 = df.parse(dateStr);
            SimpleDateFormat df1 = new SimpleDateFormat("EEE MMM dd HH:mm:ss Z yyyy", Locale.UK);
            date = df1.parse(date1.toString());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }
}
