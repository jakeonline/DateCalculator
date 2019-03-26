package com.odsinada.qantas;

public class DateCalculator {
    public int getDaysBetween(String startDate, String endDate) {
        String[] startTokens = startDate.split("-");
        String[] endTokens = endDate.split("-");

        TheDate theStartDate = new TheDate(startTokens[0], startTokens[1], startTokens[2]);
        TheDate theEndDate = new TheDate(endTokens[0], endTokens[1], endTokens[2]);

        return TheDate.getDaysBetween(theStartDate, theEndDate);
    }
}
