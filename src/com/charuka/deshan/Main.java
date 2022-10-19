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
        int principal;
        float annualInterest,monthlyInterest;
        short periodMonths;


        while(true){
            System.out.print("Principal($1K - $1M): ");
            principal = scanner.nextInt();
            if(principal >= 1000 && principal <= 1_000_000)
                break;
            else
                System.out.println("Please enter a value between 1,000 and 1,000,000");
        }

        while(true){
            System.out.print("Annual Interest Rate: ");
            annualInterest = scanner.nextFloat();
            if(annualInterest > 0 && annualInterest <= 30){
                monthlyInterest = (annualInterest/PERCENT)/MONTHS_IN_YEAR;
                break;
            }else
                System.out.println("Please enter a value greater than 0 and less than or equal to 30");
        }

        while(true){
            System.out.print("Period (Years): ");
            periodMonths = (short) (scanner.nextByte() * MONTHS_IN_YEAR);
            if(periodMonths >= 12 && periodMonths <= 360)
                break;
            else
                System.out.println("Enter a value between 1 and 30");
        }

        //Calculation
        double mortgage = principal * (monthlyInterest* Math.pow((1+monthlyInterest),periodMonths)/(Math.pow((1+monthlyInterest),periodMonths)-1));
        String formattedMortgage = NumberFormat.getCurrencyInstance().format(mortgage);
        System.out.println("Mortgage: "+formattedMortgage);

    }
}
