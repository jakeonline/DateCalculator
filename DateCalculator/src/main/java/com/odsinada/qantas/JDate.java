package com.odsinada.qantas;

public class JDate {
    private JYear year;
    private JMonth month;
    private int day;

    public JDate(int year, int month, int day) {
        this.year = new JYear(year);
        this.month = new JMonth(month, year);
        this.day = day;
    }

    public static JDate getMonthEnd(JDate modelDate) {
        return new JDate(modelDate.getYear()
                , modelDate.getMonth()
                , modelDate.getMonthEndDay());
    }

    public static JDate getNextMonthStart(JDate modelDate) {
        int year = modelDate.getYear();

        int nextMonth = modelDate.getMonth() + 1;
        if (nextMonth > 12) {
            nextMonth = 1;
            year = year + 1;
        }

        return new JDate(year
                , nextMonth
                , 1);
    }

    public static JDate clone(JDate modelDate) {
        return new JDate(modelDate.getYear()
                , modelDate.getMonth()
                , modelDate.getDay());
    }

    public int getMonth() {
        return month.getMonth();
    }

    public int getMonthEndDay() {
        return month.getMonthEndDay();
    }

    public int getDay() {
        return this.day;
    }

    public int getYear() {
        return year.getYear();
    }

    public boolean isPast(JDate endDate) {
        if (getYear() > endDate.getYear()
                || (getYear() == endDate.getYear() && getMonth() > endDate.getMonth())
                || (getYear() == endDate.getYear() && getMonth() == endDate.getMonth() && getDay() > endDate.getDay())) {
            return true;
        }
        return false;
    }

    public boolean isSameMonthYear(JDate endDate) {
        if (getYear() == endDate.getYear()
                && getMonth() == endDate.getMonth()) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return String.format("%s-%s-%s", getYear(), getMonth(), getDay());
    }

}






