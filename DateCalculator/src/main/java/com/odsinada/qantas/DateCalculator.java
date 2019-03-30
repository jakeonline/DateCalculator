package com.odsinada.qantas;

public class DateCalculator {
    public static void main(String[] args) {

    }

    public int getDaysBetween(String startDate, String endDate) {
        String[] startTokens = startDate.split("-");
        String[] endTokens = endDate.split("-");

        TheDate theStartDate = new TheDate(Integer.parseInt(startTokens[0])
                , Integer.parseInt(startTokens[1])
                , Integer.parseInt(startTokens[2]));
        TheDate theEndDate = new TheDate(Integer.parseInt(endTokens[0])
                , Integer.parseInt(endTokens[1])
                , Integer.parseInt(endTokens[2]));

        return TheDate.getDaysBetween(theStartDate, theEndDate);

    }
}
