package com.charuka.deshan;


/**
 * @author : Deshan Charuka <d.c.0729439631@gmail.com>
 * @since : 2022-10-15
 **/
public class Main {

    public static void main(String[] args) {
        var mortgage = new Mortgage();

        int principal = (int) mortgage.readNumber("Principal($1K - $1M)", 1000, 1_000_000);
        float annualInterest = (float) mortgage.readNumber("Annual Interest Rate", 1, 30);
        byte years = (byte) mortgage.readNumber("Period (Years)", 1, 30);

        mortgage.setPrincipal(principal);
        mortgage.setAnnualInterest(annualInterest);
        mortgage.setYears(years);

        //Calculation
        mortgage.printMortgage();
        //Payments Schedule
        mortgage.printPaymentSchedule();

    }

}
