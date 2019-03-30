package com.odsinada.qantas;

public class JYear {
    private final int year;

    public JYear(int year) {
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
