package com.am.chat.springmvc.util;

import org.springframework.format.Formatter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;


public class StringDateFormatter implements Formatter<Date> {
    private static final SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd");


    @Override
    public Date parse(String text, Locale locale) throws ParseException {
        Date date = null;
        try {
            date = formater.parse(text);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    @Override
    public String print(Date object, Locale locale) {
        return formater.format(object);
    }
}
