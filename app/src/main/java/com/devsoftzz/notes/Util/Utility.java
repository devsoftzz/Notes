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
                return "JAN";
            case "02":
                return "FEB";
            case "03":
                return "MAR";
            case "04":
                return "APR";
            case "05":
                return "MAY";
            case "06":
                return "JUN";
            case "07":
                return "JUL";
            case "08":
                return "AUG";
            case "09":
                return "SEP";
            case "10":
                return "OCT";
            case "11":
                return "NOV";
            case "12":
                return "DEC";
                default:
                    return monthNumber;
        }
    }
}
