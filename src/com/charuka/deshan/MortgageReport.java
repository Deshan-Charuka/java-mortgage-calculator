package com.charuka.deshan;

import java.text.NumberFormat;

/**
 * @author : Deshan Charuka <d.c.0729439631@gmail.com>
 * @since : 2022-11-19
 **/
public class MortgageReport {

    private MortgageCalculator calculator;

    public MortgageReport(MortgageCalculator calculator) {
        this.calculator = calculator;
    }

    public void printPaymentSchedule() {
        short monthsPaid = 1;
        System.out.println("Payment Schedule");
        System.out.println("----------------");
        for (double loanBalance : calculator.getRemainingBalances()){
            System.out.println(NumberFormat.getCurrencyInstance().format(loanBalance));
        }
    }

    public void printMortgage() {
        double mortgage = calculator.calculateMortgage();
        String formattedMortgage = NumberFormat.getCurrencyInstance().format(mortgage);
        System.out.println("Mortgage");
        System.out.println("--------");
        System.out.println("Monthly payments: " + formattedMortgage);
    }
}
