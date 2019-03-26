package com.odsinada.qantas;

public class TheDate {
    private final TheMonth month;
    private final TheDay day;
    private final TheYear year;

    public TheDate(String year, String month, String day) {
        this.year = new TheYear(Integer.parseInt(year));
        this.month = new TheMonth(Integer.parseInt(month), this.year);
        this.day = new TheDay(Integer.parseInt(day));
    }

    public TheMonth getMonth() {
        return month;
    }

    public TheDay getDay() {
        return day;
    }

    public TheYear getYear() {
        return year;
    }

    public static int getDaysBetween(TheDate startDate, TheDate endDate) {

        int yearDays = TheYear.getDaysBetweenExclusive(startDate.getYear(), endDate.getYear());

        return yearDays + endDate.getDayPoint() - startDate.getDayPoint() - 1;

    }

    public int getDayPoint() {
        return month.getDaysPrior() + day.getDays();
    }
}
