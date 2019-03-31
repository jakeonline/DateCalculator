package com.odsinada.qantas;

import java.util.Scanner;

public class DateCalculatorCLI {

    private DateCalculator calculator;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter first input date (yyyy-mm-dd): ");
        String dateA = scanner.nextLine();

        System.out.println("Enter second input date (yyyy-mm-dd): ");
        String dateB = scanner.nextLine();

        DateCalculatorCLI app = new DateCalculatorCLI();

        int daysBetween =  app.run(dateA, dateB);
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
            JDateIdentifier jDateIdentifier = new JDateIdentifierImpl();
            calculator = new DateCalculatorMonthBasedImpl(jDateIdentifier);
            daysBetween = calculator.getDaysBetween(dateA, dateB);
        } catch (Exception exc) {
            throw new RuntimeException("Date calculation failed.", exc);
        }

        return daysBetween;
    }
}
