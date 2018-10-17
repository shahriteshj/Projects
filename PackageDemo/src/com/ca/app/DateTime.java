package com.ca.app;

import java.time.*;
import java.time.temporal.ChronoUnit;

public class DateTime {
    public static void main(String[] args) {
        LocalDate now = LocalDate.now();
        LocalDate independence = LocalDate.of(1947, Month.AUGUST, 15);
        System.out.println(independence);
        System.out.println("Now: "+ now);
        System.out.println("Tomorrow: "+now.plusDays(1));
        System.out.println("Last month: " + now.minusMonths(1));
        System.out.println("is Leap?: "+ now.isLeapYear());
        System.out.println("Move to 30th day of month: "+ now.withDayOfMonth(30));

        ZonedDateTime currentTime = ZonedDateTime.now();
        ZonedDateTime currentTimeInParis = ZonedDateTime.now(ZoneId.of("Asia/Singapore"));
        System.out.println(currentTime);
        System.out.println(currentTimeInParis);

        LocalDate startDate = LocalDate.of(2011,Month.SEPTEMBER,04);
        LocalDate endDate = LocalDate.now();
        Period period = startDate.until(endDate);
        //Duration dur = Duration.between( startDate,endDate);
        System.out.println(period.getDays() +" " + period.getMonths()+ " " + period.getYears());
        System.out.println(period.get(ChronoUnit.DAYS));
        //System.out.println(dur.toString());

    }
}
