package com.mudah_technology_mortgage_mosh;

import java.sql.SQLOutput;
import java.text.NumberFormat;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        final byte MONTH_IN_YEAR = 12;
        final byte PERCENT = 100;

        System.out.print("Principal : ");
        Scanner scanner = new Scanner(System.in);
        int principal = scanner.nextInt();

        System.out.print("Annual Interest Rate: ");
        float annualInterest = scanner.nextFloat();
        float monthlyInterest = annualInterest / PERCENT / MONTH_IN_YEAR;

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
