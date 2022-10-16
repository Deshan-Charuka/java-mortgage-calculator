package com.charuka.deshan;


import java.text.NumberFormat;
import java.util.Scanner;

/**
 * @author : Deshan Charuka <d.c.0729439631@gmail.com>
 * @since : 2022-10-15
 **/
public class Main {
    public static void main(String[] args) {
        final byte MONTHS_IN_YEAR = 12;
        final byte PERCENT = 100;

        Scanner scanner = new Scanner(System.in);
        System.out.print("Principal: ");
        int principal = scanner.nextInt();
        System.out.print("Annual Interest Rate: ");
        float annualInterest = scanner.nextFloat();
        float monthlyInterest = (annualInterest/PERCENT)/MONTHS_IN_YEAR;
        System.out.print("Period (Years): ");
        byte periodMonths = (byte) (scanner.nextByte() * MONTHS_IN_YEAR);

        //Calculation
        double mortgage = principal * (monthlyInterest* Math.pow((1+monthlyInterest),periodMonths)/(Math.pow((1+monthlyInterest),periodMonths)-1));

        String formattedMortgage = NumberFormat.getCurrencyInstance().format(mortgage);

        System.out.println("Mortgage: "+formattedMortgage);

    }
}
