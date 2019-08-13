package com.eugeneponomarev.weatherdarksky.Common;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DataConverters {

    public static String converterDataTime(){
        DateFormat dateFormat = new SimpleDateFormat("HH:mm");
        Calendar calendar = Calendar.getInstance();
        String dataTime = dateFormat.format(calendar.getTime());
        return dataTime;
    }
    public static String converterData(long dt){
        DateFormat dateFormat = new SimpleDateFormat("EEE dd.MM.yyyy");
        Calendar calendar = Calendar.getInstance();
        String dataTime = dateFormat.format(calendar.getTime());
        return dataTime;
    }
    public static String converterDataTime2(){
        DateFormat dateFormat = new SimpleDateFormat("HH.mm");
        Calendar calendar = Calendar.getInstance();
        String dataTime = dateFormat.format(calendar.getTime());
        return dataTime;
    }

}
