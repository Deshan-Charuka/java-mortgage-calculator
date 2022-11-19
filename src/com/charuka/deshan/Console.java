package com.charuka.deshan;

import java.util.Scanner;

/**
 * @author : Deshan Charuka <d.c.0729439631@gmail.com>
 * @since : 2022-10-23
 **/
public class Console {
    private static Scanner scanner = new Scanner(System.in);
    public static double readNumber (String prompt){
        return scanner.nextDouble();
    }
    public static double readNumber(String prompt, double min, double max) {
        double value;
        while (true) {
            System.out.print(prompt + ": ");
            value = scanner.nextDouble();
            if (value >= min && value <= max) break;
            System.out.println("Please enter a value between " + (int) min + " and " + (int) max);
        }
        return value;
    }
}
