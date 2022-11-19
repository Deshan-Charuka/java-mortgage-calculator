package com.charuka.deshan;

/**
 * @author : Deshan Charuka <d.c.0729439631@gmail.com>
 * @since : 2022-11-20
 **/
public class MortgageCalculator {
     private int principal;
     private float annualInterest;
     private byte years;

    public MortgageCalculator(int principal, float annualInterest, byte years) {
        this.principal = principal;
        this.annualInterest = annualInterest;
        this.years = years;
    }

    public double calculateBalance(short numberOfPaymentsMade) {
        float monthlyInterest = (annualInterest / Main.PERCENT) / Main.MONTHS_IN_YEAR;
        short periodMonths = (short) (years * Main.MONTHS_IN_YEAR);

        double loanBalance = (principal * (Math.pow(1 + monthlyInterest, periodMonths) - Math.pow(1 + monthlyInterest, numberOfPaymentsMade))) / ((Math.pow(1 + monthlyInterest, periodMonths)) - 1);

        return loanBalance;
    }

    public double calculateMortgage() {
        float monthlyInterest = (annualInterest / Main.PERCENT) / Main.MONTHS_IN_YEAR;
        short periodMonths = (short) (years * Main.MONTHS_IN_YEAR);

        double mortgage = principal * (monthlyInterest * Math.pow((1 + monthlyInterest), periodMonths) / (Math.pow((1 + monthlyInterest), periodMonths) - 1));

        return mortgage;

    }
}
