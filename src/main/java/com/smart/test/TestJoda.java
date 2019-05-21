package com.smart.test;

import org.joda.time.*;
import org.testng.annotations.Test;

import java.util.Locale;

public class TestJoda {
    @Test
    public void testJoda_1(){
        DateTime dt  = new DateTime();
        System.out.println(dt.getMillis());
        System.out.println(dt.getChronology().dayOfWeek().getType());
        System.out.println(dt.getChronology().dayOfWeek().get(dt.getMillis()));

        System.out.println(dt.withZone(DateTimeZone.forID("Europe/London")));
        System.out.println(dt.withZoneRetainFields(DateTimeZone.forID("Europe/London")));

    }
}
