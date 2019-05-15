package br.com.etechoracio.boaviagem.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateTimeUtils {
    public static final DateFormat DATE_FORMAT = new SimpleDateFormat("dd/MM/yyyy");

    public static String formatDate(int dia, int mes, int ano){
        try {
            Calendar calendar = Calendar.getInstance();
            calendar.set(ano, mes, dia);
            return DATE_FORMAT.format(calendar.getTime());
        }
        catch (Exception e){
            return null;

        }
    }/*
    public static Date toDate(String date)
    {
      //  return DATE_FORMAT.parse()
    }*/
}


