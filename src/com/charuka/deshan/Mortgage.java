package com.charuka.deshan;

import java.text.NumberFormat;
import java.util.Scanner;

/**
 * @author : Deshan Charuka <d.c.0729439631@gmail.com>
 * @since : 2022-10-23
 **/
public class Mortgage {
    final static byte MONTHS_IN_YEAR = 12;
    final static byte PERCENT = 100;

    private int principal;
    private float annualInterest;
    private byte years;

    private int getPrincipal() {
        return principal;
    }

    public void setPrincipal(int principal) {
        this.principal = principal;
    }

    private float getAnnualInterest() {
        return annualInterest;
    }

    public void setAnnualInterest(float annualInterest) {
        this.annualInterest = annualInterest;
    }

    private byte getYears() {
        return years;
    }

    public void setYears(byte years) {
        this.years = years;
    }


    public void printMortgage() {
        double mortgage = calculateMortgage();
        String formattedMortgage = NumberFormat.getCurrencyInstance().format(mortgage);
        System.out.println("Mortgage");
        System.out.println("--------");
        System.out.println("Monthly payments: " + formattedMortgage);
    }

    public void printPaymentSchedule() {
        short monthsPaid = 1;
        System.out.println("Payment Schedule");
        System.out.println("----------------");
        while (monthsPaid <= years * MONTHS_IN_YEAR) {
            double loanBalance = calculateBalance(monthsPaid);
            String formattedBalance = NumberFormat.getCurrencyInstance().format(loanBalance);
            System.out.println(formattedBalance);
            ++monthsPaid;
        }
    }

    private double calculateBalance(short numberOfPaymentsMade) {
        float monthlyInterest = (annualInterest / PERCENT) / MONTHS_IN_YEAR;
        short periodMonths = (short) (years * MONTHS_IN_YEAR);

        double loanBalance = (principal * (Math.pow(1 + monthlyInterest, periodMonths) - Math.pow(1 + monthlyInterest, numberOfPaymentsMade))) / ((Math.pow(1 + monthlyInterest, periodMonths)) - 1);

        return loanBalance;
    }

    public double readNumber(String prompt, double min, double max) {
        Scanner scanner = new Scanner(System.in);
        double value;
        while (true) {
            System.out.print(prompt + ": ");
            value = scanner.nextFloat();
            if (value >= min && value <= max) break;
            System.out.println("Please enter a value between " + (int) min + " and " + (int) max);
        }
        return value;
    }

    private double calculateMortgage() {
        float monthlyInterest = (annualInterest / PERCENT) / MONTHS_IN_YEAR;
        short periodMonths = (short) (years * MONTHS_IN_YEAR);

        double mortgage = principal * (monthlyInterest * Math.pow((1 + monthlyInterest), periodMonths) / (Math.pow((1 + monthlyInterest), periodMonths) - 1));

        return mortgage;

    }
}
