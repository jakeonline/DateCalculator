package com.odsinada.qantas;

public class TheDate {
    private TheYear year;
    private TheMonth month;
    private int day;

    public TheDate(int year, int month, int day) {
        this.year = new TheYear(year);
        this.month = new TheMonth(month, year);
        this.day = day;
    }

    public static int getDaysBetween(TheDate startDate, TheDate endDate) {
        TheDate runningDate = clone(startDate);
        int totalDays = 0;

        while (!runningDate.isBeyond(endDate)) {
            TheDate runningEndDate = null;

            if (runningDate.isSameMonthYear(endDate)) {
                runningEndDate = endDate;
            } else {
                runningEndDate = getMonthEnd(runningDate);
            }

            int absoluteDayCount = getAbsoluteDayCount(runningDate, runningEndDate);
            totalDays += absoluteDayCount;
            System.out.println(String.format("from %s to %s: %s days (%s total days)"
                    , runningDate, runningEndDate, absoluteDayCount, totalDays));

            runningDate = getNextMonthStart(runningEndDate);
        }

        // exclude start and end dates
        return Math.max(0, totalDays - 2);

    }

    private static TheDate getMonthEnd(TheDate modelDate) {
        return new TheDate(modelDate.getYear()
                , modelDate.getMonth()
                , modelDate.getMonthEndDay());
    }

    private static TheDate getNextMonthStart(TheDate modelDate) {
        int year = modelDate.getYear();

        int nextMonth = modelDate.getMonth() + 1;
        if (nextMonth > 12) {
            nextMonth = 1;
            year = year + 1;
        }

        return new TheDate(year
                , nextMonth
                , 1);
    }

    private static TheDate clone(TheDate modelDate) {
        return new TheDate(modelDate.getYear()
                , modelDate.getMonth()
                , modelDate.getDay());
    }

    private static int getAbsoluteDayCount(TheDate runningDate, TheDate endDate) {
        return endDate.getDay() - runningDate.getDay() + 1;
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

    private boolean isBeyond(TheDate endDate) {
        if (getYear() > endDate.getYear()
                || (getYear() == endDate.getYear() && getMonth() > endDate.getMonth())
                || (getYear() == endDate.getYear() && getMonth() == endDate.getMonth() && getDay() > endDate.getDay())) {
            return true;
        }
        return false;
    }

    private boolean isSameMonthYear(TheDate endDate) {
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






