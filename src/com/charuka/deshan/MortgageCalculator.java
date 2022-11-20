package com.charuka.deshan;

import java.text.NumberFormat;

/**
 * @author : Deshan Charuka <d.c.0729439631@gmail.com>
 * @since : 2022-11-20
 **/
public class MortgageCalculator {
    private final static byte MONTHS_IN_YEAR = 12;
    private final static byte PERCENT = 100;
    private int principal;
     private float annualInterest;
     private byte years;

    public MortgageCalculator(int principal, float annualInterest, byte years) {
        this.principal = principal;
        this.annualInterest = annualInterest;
        this.years = years;
    }

    public double calculateBalance(short numberOfPaymentsMade) {
        float monthlyInterest = getMonthlyInterest();
        short periodMonths = getPeriodMonths();

        double loanBalance = (principal * (Math.pow(1 + monthlyInterest, periodMonths) - Math.pow(1 + monthlyInterest, numberOfPaymentsMade))) / ((Math.pow(1 + monthlyInterest, periodMonths)) - 1);

        return loanBalance;
    }

    public double calculateMortgage() {
        float monthlyInterest = getMonthlyInterest();
        short periodMonths = getPeriodMonths();

        double mortgage = principal * (monthlyInterest * Math.pow((1 + monthlyInterest), periodMonths) / (Math.pow((1 + monthlyInterest), periodMonths) - 1));

        return mortgage;

    }

    public double[] getRemainingBalances(){
        short monthsPaid = 1;
        var balances = new double[getPeriodMonths()]
        while (monthsPaid <= balances.length) {
            balances[monthsPaid-1] = calculateBalance(monthsPaid);
            ++monthsPaid;
        }
        return balances;
    }

    private short getPeriodMonths() {
        return (short) (years * MONTHS_IN_YEAR);
    }

    private float getMonthlyInterest() {
        return (annualInterest / PERCENT) / MONTHS_IN_YEAR;
    }
}
