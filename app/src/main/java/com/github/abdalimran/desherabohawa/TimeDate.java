package com.github.abdalimran.desherabohawa;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class TimeDate {
    public static String getDate()
    {
        Date curDate = new Date();
        SimpleDateFormat format = new SimpleDateFormat("MMM d, yyyy");
        String DateToStr = format.format(curDate);
        return DateToStr;
    }

    public static String getWeekDay()
    {
        Calendar dayCalendar = Calendar.getInstance();
        String dayLongName = dayCalendar.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.LONG, Locale.getDefault());
        return dayLongName;
    }

    public static String getTime()
    {
        Date time = new Date();
        DateFormat format = DateFormat.getTimeInstance(DateFormat.SHORT);
        String TimeToStr=format.format(time);
        return TimeToStr;
    }
}
