package com.devsoftzz.notes.Util;

import android.annotation.SuppressLint;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Utility {

    public static String getTimeStamp(){

        @SuppressLint("SimpleDateFormat") SimpleDateFormat dateFormat = new SimpleDateFormat("MM-yyyy");
        String currentDate = dateFormat.format(new Date());
        String month = getMonthFromNumber(currentDate.substring(0,2));
        currentDate = month + "\n" + currentDate.substring(3);
        return currentDate;
    }
    public static String getMonthFromNumber(String monthNumber){
        switch (monthNumber){
            case "01":
                return "Jan";
            case "02":
                return "Feb";
            case "03":
                return "Mar";
            case "04":
                return "Apr";
            case "05":
                return "May";
            case "06":
                return "Jun";
            case "07":
                return "Jul";
            case "08":
                return "Aug";
            case "09":
                return "Sep";
            case "10":
                return "Oct";
            case "11":
                return "Nov";
            case "12":
                return "Dec";
                default:
                    return monthNumber;
        }
    }
}
