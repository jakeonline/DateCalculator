package com.odsinada.qantas;

import java.util.Map;
import java.util.TreeMap;

public class TheMonth {

    private final int month;

    private static final Month JANUARY;
    private static final Month FEBRUARY;
    private static final Month MARCH;
    private static final Month APRIL;
    private static final Month MAY;
    private static final Month JUNE;
    private static final Month JULY;
    private static final Month AUGUST;
    private static final Month SEPTEMBER;
    private static final Month OCTOBER;
    private static final Month NOVEMBER;
    private static final Month DECEMBER;
    private static final Map<Integer, Month> months;
    static {
        JANUARY = new Month(1, 31);
        FEBRUARY = new Month(2, 28);
        MARCH = new Month(3, 31);
        APRIL = new Month(4, 30);
        MAY = new Month(5, 31);
        JUNE = new Month(6, 30);
        JULY = new Month(7, 31);
        AUGUST = new Month(8, 31);
        SEPTEMBER = new Month(9, 30);
        OCTOBER = new Month(10, 31);
        NOVEMBER = new Month(11, 30);
        DECEMBER = new Month(12, 31);

        months = new TreeMap<>();
        months.put(JANUARY.getIndex(), JANUARY);
        months.put(FEBRUARY.getIndex(), FEBRUARY);
        months.put(MARCH.getIndex(), MARCH);
        months.put(APRIL.getIndex(), APRIL);
        months.put(MAY.getIndex(), MAY);
        months.put(JUNE.getIndex(), JUNE);
        months.put(JULY.getIndex(), JULY);
        months.put(AUGUST.getIndex(), AUGUST);
        months.put(SEPTEMBER.getIndex(), SEPTEMBER);
        months.put(OCTOBER.getIndex(), OCTOBER);
        months.put(NOVEMBER.getIndex(), NOVEMBER);
        months.put(DECEMBER.getIndex(), DECEMBER);
    }

    private final TheYear year;


    public TheMonth(int month, TheYear year) {
        this.month = month;
        this.year = year;
    }

    public int getDaysPrior() {
        int daysPrior = 0;
        for (Map.Entry<Integer, Month> month : months.entrySet()) {
            if (month.getValue().getIndex() >= this.month) {
                break;
            }
            daysPrior += getDayCount(month.getValue());
        }

        return daysPrior;
    }

    private int getDayCount(Month month) {
        int dayCount = month.getNumberOfDays();
        if(month == FEBRUARY && year.isLeapYear()){
            dayCount = dayCount + 1;
        }
        return dayCount;
    }

}
