package com.springboot.cvc.hotel.domain.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class DateUtils {
    public static long getPeriod(String startDay, String finalDay) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH);
            Date firstDate = sdf.parse(startDay);
            Date finalDate = sdf.parse(finalDay);
            long diffInMillies = Math.abs(finalDate.getTime() - firstDate.getTime());
            return TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);
        } catch (ParseException e) {
            throw new RuntimeException("Erro ao processar período");
        }
    }
}
