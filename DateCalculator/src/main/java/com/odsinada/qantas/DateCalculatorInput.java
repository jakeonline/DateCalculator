package com.odsinada.qantas;

import java.util.Scanner;

public class DateCalculatorInput {
    public static void main(String[] args) {
        Scanner myObj = new Scanner(System.in);

        System.out.println("Enter first input date (yyyy-mm-dd): ");
        String dateA = myObj.nextLine();

        System.out.println("Enter second input date (yyyy-mm-dd): ");
        String dateB = myObj.nextLine();

        int daysBetween = new DateCalculator().getDaysBetween(dateA, dateB);
        System.out.println("Total days exclusive of input dates is: " + daysBetween);
    }
}
