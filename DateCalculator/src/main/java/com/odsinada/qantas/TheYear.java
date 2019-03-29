package com.odsinada.qantas;

public class TheYear {
    private final int year;

    public TheYear(int year) {
        this.year = year;
    }

    public TheYear(TheYear modelYear) {
        this.year = modelYear.getYear();
    }

    public static int getDaysBetweenExclusive(TheYear startYear, TheYear endYear) {
        int totalDays = 0;
        for (int i = startYear.getYear() + 1; i < endYear.getYear(); i++) {
            totalDays += new TheYear(i).getDays();
        }

        return totalDays;
    }

    public int getDays() {
        return isLeapYear() ? 366 : 365;
    }

    public int getYear() {
        return this.year;
    }

    public boolean isLeapYear() {
        boolean nonDivisibleByFour = getYear() % 4 != 0;
        boolean nonLeapYearCentury = getYear() % 100 == 0 && getYear() % 400 != 0;
        if (nonDivisibleByFour
                || nonLeapYearCentury) {
            return false;
        }
        return true;
    }
}
