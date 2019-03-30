package com.odsinada.qantas;

import java.util.Map;
import java.util.TreeMap;

public class JMonth {

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
    private static final Map<Integer, Month> MONTHS;

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

        MONTHS = new TreeMap<>();
        MONTHS.put(JANUARY.getIndex(), JANUARY);
        MONTHS.put(FEBRUARY.getIndex(), FEBRUARY);
        MONTHS.put(MARCH.getIndex(), MARCH);
        MONTHS.put(APRIL.getIndex(), APRIL);
        MONTHS.put(MAY.getIndex(), MAY);
        MONTHS.put(JUNE.getIndex(), JUNE);
        MONTHS.put(JULY.getIndex(), JULY);
        MONTHS.put(AUGUST.getIndex(), AUGUST);
        MONTHS.put(SEPTEMBER.getIndex(), SEPTEMBER);
        MONTHS.put(OCTOBER.getIndex(), OCTOBER);
        MONTHS.put(NOVEMBER.getIndex(), NOVEMBER);
        MONTHS.put(DECEMBER.getIndex(), DECEMBER);
    }

    private final int month;
    private final JYear year;

    public JMonth(int month, int year) {
        this.month = month;
        this.year = new JYear(year);
    }

    public int getMonth() {
        return month;
    }

    public int getMonthEndDay() {
        int monthEnd = MONTHS.get(this.month).getDayCount();
        if (MONTHS.get(this.month) == FEBRUARY && year.isLeapYear()) {
            monthEnd = monthEnd + 1;
        }

        return monthEnd;
    }
}

class Month {
    final int index;
    final int dayCount;

    int getDayCount() {
        return dayCount;
    }

    int getIndex() {
        return index;
    }

    Month(int index, int dayCount) {
        this.index = index;
        this.dayCount = dayCount;
    }
}
