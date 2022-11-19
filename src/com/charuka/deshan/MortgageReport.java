package com.charuka.deshan;

import java.text.NumberFormat;

/**
 * @author : Deshan Charuka <d.c.0729439631@gmail.com>
 * @since : 2022-11-19
 **/
public class MortgageReport {

    private static MortgageCalculator calculator;

    public static void printMortgage(int principal, float annualInterest, byte years) {
        calculator = new MortgageCalculator(principal, annualInterest, years);

        double mortgage = calculator.calculateMortgage();
        String formattedMortgage = NumberFormat.getCurrencyInstance().format(mortgage);
        System.out.println("Mortgage");
        System.out.println("--------");
        System.out.println("Monthly payments: " + formattedMortgage);
    }

    public static void printPaymentSchedule(int principal, float annualInterest, byte years) {
        short monthsPaid = 1;
        System.out.println("Payment Schedule");
        System.out.println("----------------");
        while (monthsPaid <= years * Main.MONTHS_IN_YEAR) {
            double loanBalance = MortgageCalculator.calculateBalance(monthsPaid);
            String formattedBalance = NumberFormat.getCurrencyInstance().format(loanBalance);
            System.out.println(formattedBalance);
            ++monthsPaid;
        }
    }
}
