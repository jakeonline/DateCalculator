package com.odsinada.qantas;

public class TheYear {
    private final int year;

    public TheYear(int year) {
        this.year = year;
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
