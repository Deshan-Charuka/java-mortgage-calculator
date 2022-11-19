package com.charuka.deshan;


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

        var calculator = new MortgageCalculator(principal,annualInterest,years);
        var report = new MortgageReport(calculator);
        //Calculation
        report.printMortgage();
        //Payments Schedule
        report.printPaymentSchedule();

    }

}
