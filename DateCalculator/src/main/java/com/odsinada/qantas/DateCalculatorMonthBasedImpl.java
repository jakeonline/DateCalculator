package com.odsinada.qantas;

import com.odsinada.qantas.DateCalculator;
import com.odsinada.qantas.JDate;
import com.odsinada.qantas.JDateIdentifier;
import com.odsinada.qantas.JDateParams;

public class DateCalculatorMonthBasedImpl implements DateCalculator {
    private final JDateIdentifier jDateIdentifier;

    public DateCalculatorMonthBasedImpl(JDateIdentifier jDateIdentifier) {
        if(jDateIdentifier == null){
            throw new IllegalArgumentException("JDateIdentifier parameter is not provided.");
        }
        this.jDateIdentifier = jDateIdentifier;
    }

    @Override
    public int getDaysBetween(JDate dateA, JDate dateB) {
        JDateParams params = jDateIdentifier.getDateParams(dateA, dateB);
        JDate startDate = params.getStartDate();
        JDate endDate = params.getEndDate();

        JDate runningDate = JDate.clone(startDate);
        int totalDays = 0;

        while (!runningDate.isPast(endDate)) {
            JDate runningEndDate = null;

            if (runningDate.isSameMonthYear(endDate)) {
                runningEndDate = endDate;
            } else {
                runningEndDate = JDate.getMonthEnd(runningDate);
            }

            int subtotalDayCount = getDayCountInclusive(runningDate, runningEndDate);
            totalDays += subtotalDayCount;
            System.out.println(String.format("from %s to %s: %s days (%s total days)"
                    , runningDate, runningEndDate, subtotalDayCount, totalDays));

            runningDate = JDate.getNextMonthStart(runningEndDate);
        }

        // exclude start and end dates in total days
        // minimum of 0 total days
        return Math.max(0, totalDays - 2);

    }

    private int getDayCountInclusive(JDate runningDate, JDate endDate) {
        return endDate.getDay() - runningDate.getDay() + 1;
    }
}
