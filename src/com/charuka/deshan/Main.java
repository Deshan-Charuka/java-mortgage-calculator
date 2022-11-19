package com.charuka.deshan;


import java.text.NumberFormat;

/**
 * @author : Deshan Charuka <d.c.0729439631@gmail.com>
 * @since : 2022-10-15
 **/
public class Main {
    final static byte MONTHS_IN_YEAR = 12;
    final static byte PERCENT = 100;

    public static void main(String[] args) {

        int principal = (int) Console.readNumber("Principal($1K - $1M)", 1000, 1_000_000);
        float annualInterest = (float) Console.readNumber("Annual Interest Rate", 1, 30);
        byte years = (byte) Console.readNumber("Period (Years)", 1, 30);

        //Calculation
        printMortgage(principal, annualInterest, years);
        //Payments Schedule
        printPaymentSchedule(principal, annualInterest, years);

    }

    private static void printMortgage(int principal, float annualInterest, byte years) {
        double mortgage = calculateMortgage(principal, annualInterest, years);
        String formattedMortgage = NumberFormat.getCurrencyInstance().format(mortgage);
        System.out.println("Mortgage");
        System.out.println("--------");
        System.out.println("Monthly payments: " + formattedMortgage);
    }

    private static void printPaymentSchedule(int principal, float annualInterest, byte years) {
        short monthsPaid = 1;
        System.out.println("Payment Schedule");
        System.out.println("----------------");
        while (monthsPaid <= years * MONTHS_IN_YEAR) {
            double loanBalance = calculateBalance(principal, annualInterest, years, monthsPaid);
            String formattedBalance = NumberFormat.getCurrencyInstance().format(loanBalance);
            System.out.println(formattedBalance);
            ++monthsPaid;
        }
    }

    public static double calculateBalance(int principal, float annualInterest, byte years, short numberOfPaymentsMade) {
        float monthlyInterest = (annualInterest / PERCENT) / MONTHS_IN_YEAR;
        short periodMonths = (short) (years * MONTHS_IN_YEAR);

        double loanBalance = (principal * (Math.pow(1 + monthlyInterest, periodMonths) - Math.pow(1 + monthlyInterest, numberOfPaymentsMade))) / ((Math.pow(1 + monthlyInterest, periodMonths)) - 1);

        return loanBalance;
    }

     public static double calculateMortgage(int principal, float annualInterest, byte years) {
        float monthlyInterest = (annualInterest / PERCENT) / MONTHS_IN_YEAR;
        short periodMonths = (short) (years * MONTHS_IN_YEAR);

        double mortgage = principal * (monthlyInterest * Math.pow((1 + monthlyInterest), periodMonths) / (Math.pow((1 + monthlyInterest), periodMonths) - 1));

        return mortgage;

    }
}
