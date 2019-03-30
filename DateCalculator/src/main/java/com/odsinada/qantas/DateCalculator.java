package com.odsinada.qantas;

public class DateCalculator {
    public static void main(String[] args) {

        new DateCalculator().getDaysBetween(args[0], args[1]);

    }

    public int getDaysBetween(String argA, String argB) {
        String[] tokenA = argA.split("-");
        String[] tokenB = argB.split("-");

        JDate dateA = new JDate(Integer.parseInt(tokenA[0])
                , Integer.parseInt(tokenA[1])
                , Integer.parseInt(tokenA[2]));
        JDate dateB = new JDate(Integer.parseInt(tokenB[0])
                , Integer.parseInt(tokenB[1])
                , Integer.parseInt(tokenB[2]));

        if(dateA.isBeyond(dateB)){
            return calculate(dateB, dateA);
        } else {
            return calculate(dateA, dateB);
        }

    }

    private int calculate(JDate startDate, JDate endDate) {
        JDate runningDate = JDate.clone(startDate);
        int totalDays = 0;

        while (!runningDate.isBeyond(endDate)) {
            JDate runningEndDate = null;

            if (runningDate.isSameMonthYear(endDate)) {
                runningEndDate = endDate;
            } else {
                runningEndDate = JDate.getMonthEnd(runningDate);
            }

            int absoluteDayCount = getAbsoluteDayCount(runningDate, runningEndDate);
            totalDays += absoluteDayCount;
            System.out.println(String.format("from %s to %s: %s days (%s total days)"
                    , runningDate, runningEndDate, absoluteDayCount, totalDays));

            runningDate = JDate.getNextMonthStart(runningEndDate);
        }

        // exclude start and end dates in total days
        return Math.max(0, totalDays - 2);

    }

    private int getAbsoluteDayCount(JDate runningDate, JDate endDate) {
        return endDate.getDay() - runningDate.getDay() + 1;
    }
}
