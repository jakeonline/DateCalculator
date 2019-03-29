package com.odsinada.qantas;

public class TheDate {
    private TheMonth month;
    private TheDay day;
    private final TheYear year;

    public TheDate(String year, String month, String day) {
        this.year = new TheYear(Integer.parseInt(year));
        this.month = new TheMonth(Integer.parseInt(month), this.year.getYear());
        this.day = new TheDay(Integer.parseInt(day));
    }

    public TheDate(TheDate theDate) {
        this.year = new TheYear(theDate.getYear());
        this.month = new TheMonth(theDate.getMonth(), theDate.getYear());
        this.day = new TheDay(theDate.getDay().getDays());
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

    public static int getDaysBetweenNew(TheDate startDate, TheDate endDate) {
        TheDate runningDate = new TheDate(startDate);
        int totalDays = 0;


        for(int i = runningDate.getMonth().getMonth(); i < endDate.getMonth().getMonth(); i++) {
            TheDate runningDateMonthEnd = new TheDate(runningDate);
            runningDateMonthEnd.setToMonthEnd();
            totalDays += getAbsoluteDayCount(runningDate, runningDateMonthEnd);

            runningDate = getNextMonthStart(runningDateMonthEnd);
        }

        if (endDate.getMonth().getMonth() == runningDate.getMonth().getMonth()) {

            totalDays += getAbsoluteDayCount(runningDate, endDate);
        }

        return totalDays - 2;

    }

    private void setToMonthEnd() {
        this.day = new TheDay(this.month.getMonthEndDay());
    }

    private static TheDate getNextMonthStart(TheDate currDate) {
        TheDate nextMonthStart = new TheDate(currDate);
        nextMonthStart.setDay(1);
        nextMonthStart.setMonth(currDate.getMonth().getMonth() + 1
                , currDate.getYear().getYear());
        return nextMonthStart;
    }

    private static int getAbsoluteDayCount(TheDate runningDate, TheDate endDate) {
        return endDate.getDay().getDays() - runningDate.getDay().getDays() + 1;
    }

    public void setDay(int day) {
        this.day = new TheDay(day);
    }

    public void setMonth(int month, int year) {
        this.month = new TheMonth(month, year);
    }

//    public static int getDaysBetweenNew(TheDate startDate, TheDate endDate) {
//        int yearDays = 0;
//
////        for(int i = startDate.getYear(); i < endDate.getYear(); i++)
//
//        // 2001.1 vs 2003.1 - Y .. diff is 2
//        // 2002 vs 2003 - Y
//
//        // 200
//        // is same year?
//        // N
//
//        return 0;
//
//    }
}
