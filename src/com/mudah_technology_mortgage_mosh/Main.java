package com.mudah_technology_mortgage_mosh;

import java.sql.SQLOutput;
import java.text.NumberFormat;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        final byte MONTH_IN_YEAR = 12;
        final byte PERCENT = 100;
        int principal =0;
        float monthlyInterest =0;

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Principal : ");
            principal = scanner.nextInt();
            if (principal >= 1000 && principal <= 1_000_000) break;
            System.out.println("Enter a value between 1000 and 1 000 000");
        }

        while (true) {
            System.out.print("Annual Interest Rate: ");
            float annualInterest = scanner.nextFloat();
            if (annualInterest >= 1 && annualInterest <= 50) break;
            monthlyInterest = annualInterest / PERCENT / MONTH_IN_YEAR;
            System.out.println("Enter a value between 5 and 50");
        }

        System.out.print("Period (Years): ");
        byte years = scanner.nextByte();
        int numberOfPayments = years * MONTH_IN_YEAR;

        double mortgage = principal
                    * (monthlyInterest * Math.pow(1 + monthlyInterest,numberOfPayments)
                    / (Math.pow(1 + monthlyInterest,numberOfPayments) - 1));

        String mortgageFormatted = NumberFormat.getCurrencyInstance().format(mortgage);
        System.out.println("Mortgage: " + mortgageFormatted);

    }
}
