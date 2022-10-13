package com.example.springboot.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class TimeChecker {

    public String getExpirationtime(){
        Date currentTime = new Date();
        Date expirationTime = new Date(currentTime.getTime() + 24 * 60 * 60 * 1000);
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return df.format(expirationTime);
    }

    public boolean checkTime(String expTime_s) {
        Date curTime = new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date expTime = null;
        try {
            expTime = df.parse(expTime_s);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return !curTime.after(expTime);
    }

}
