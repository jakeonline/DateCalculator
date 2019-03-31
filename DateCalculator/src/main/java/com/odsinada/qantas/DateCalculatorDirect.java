package com.odsinada.qantas;

public class DateCalculatorDirect {

    private DateCalculator calculator;

    public static void main(String[] args) {
        DateCalculatorDirect app = new DateCalculatorDirect();

        int daysBetween = app.run(args[0], args[1]);
        System.out.println("Total days exclusive of input dates is: " + daysBetween);
    }

    public int run(String argA, String argB) {
        String[] tokenA = argA.trim().split("-");
        String[] tokenB = argB.trim().split("-");

        JDate dateA = new JDate(Integer.parseInt(tokenA[0])
                , Integer.parseInt(tokenA[1])
                , Integer.parseInt(tokenA[2]));
        JDate dateB = new JDate(Integer.parseInt(tokenB[0])
                , Integer.parseInt(tokenB[1])
                , Integer.parseInt(tokenB[2]));


        int daysBetween = 0;

        try {
            daysBetween = getCalculator().getDaysBetween(dateA, dateB);
        } catch (Exception exc) {
            throw new RuntimeException("Date calculation failed.", exc);
        }

        return daysBetween;
    }

    private DateCalculator getCalculator() {
        JDateIdentifier jDateIdentifier = new JDateIdentifierImpl();
        calculator = new DateCalculatorMonthBasedImpl(jDateIdentifier);
        return calculator;
    }
}
