package com.ivo.chapter1.creatingAndDestroyingObjects;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

class PersonLow {

    private final Date birthDate;

    // Other fields omitted
    public PersonLow(Date birthDate) {
        this.birthDate = birthDate;
    }

    // DON'T DO THIS!
    public boolean isBabyBoomer() {
        Calendar gmtCal
                = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
        gmtCal.set(1946, Calendar.JANUARY, 1, 0, 0, 0);
        Date boomStart = gmtCal.getTime();
        gmtCal.set(1965, Calendar.JANUARY, 1, 0, 0, 0);
        Date boomEnd = gmtCal.getTime();
        return birthDate.compareTo(boomStart) >= 0
                && birthDate.compareTo(boomEnd) < 0;
    }
}

class PersonHigh {

    private final Date birthDate;

    public PersonHigh(Date birthDate) {
        this.birthDate = birthDate;
    }

    /**
     * The starting and ending dates of the baby boom.
     */
    private static final Date BOOM_START;
    private static final Date BOOM_END;

    static {
        Calendar gmtCal
                = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
        gmtCal.set(1946, Calendar.JANUARY, 1, 0, 0, 0);
        BOOM_START = gmtCal.getTime();
        gmtCal.set(1965, Calendar.JANUARY, 1, 0, 0, 0);
        BOOM_END = gmtCal.getTime();
    }

    public boolean isBabyBoomer() {
        return birthDate.compareTo(BOOM_START) >= 0
                && birthDate.compareTo(BOOM_END) < 0;
    }
}

class AvoidCreatingDuplicateObjectsApp {

    public static void main(String[] args) {
        PersonLow pLow = new PersonLow(new Date());
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 10000000; i++) {
            pLow.isBabyBoomer();
        }
        long endTime = System.currentTimeMillis();
        long time = endTime - startTime;
        System.out.println(time + " ms.");

        PersonHigh pHigh = new PersonHigh(new Date());
        startTime = System.currentTimeMillis();
        for (int i = 0; i < 10000000; i++) {
            pHigh.isBabyBoomer();
        }
        endTime = System.currentTimeMillis();
        time = endTime - startTime;
        System.out.println(time + " ms.");
    }

}
