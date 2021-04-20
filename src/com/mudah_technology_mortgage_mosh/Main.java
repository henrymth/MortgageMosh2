package com.mudah_technology_mortgage_mosh;

import java.sql.SQLOutput;
import java.text.NumberFormat;
import java.util.Scanner;

public class Main {
    final static byte MONTH_IN_YEAR = 12;
    final static byte PERCENT = 100;

    public static void main(String[] args) {
	// write your code here
        int principal = (int) readNumber("Principal / Jumlah pinjaman (1000-1jt) : ", 1000, 500_000_000);
        float annualInterest = (float) readNumber("Annual Interest Rate: ", 1, 50);
        byte years = (byte) readNumber("Period (Years): ",1,20);

        double mortgage = calculateMortgage(principal, annualInterest, years);

        //String mortgageFormatted = NumberFormat.getCurrencyInstance().format(mortgage);
        String mortgageFormatted = NumberFormat.getCurrencyInstance().format(mortgage);
        System.out.println();
        System.out.println("MORTGAGE/PINJAMAN");
        System.out.println("------------------");
        System.out.println("Monthly Payments: " + mortgageFormatted);

        System.out.println();
        System.out.println("PAYMENT SCHEDULE");
        System.out.println("-----------------");
        for (short month = 1; month <=years * MONTH_IN_YEAR; month++ ) {
            double balance =  calculateBalance(principal,annualInterest,years,month);
            System.out.println(
                    "Payment ke " + month + ": "
                    + NumberFormat.getCurrencyInstance().format(balance));
        }
    }

    public static double readNumber (String prompt, double min, double max) {
        Scanner scanner = new Scanner(System.in);
        double value;
        while (true) {
            System.out.print(prompt);
            value = scanner.nextFloat();
            if (value >= min && value <= max) break;
            System.out.println("Enter a value between " + min +  " and " + max + "");
        }
        return value;
    }

    public static double calculateBalance (
            int principal,
            float annualInterest,
            byte years,
            short numberOfPaymentMade) {

        float monthlyInterest = annualInterest / PERCENT / MONTH_IN_YEAR;
        short numberOfPayments = (short)(years * MONTH_IN_YEAR);

        double balance = principal
                * (Math.pow(1 + monthlyInterest, numberOfPayments) - Math.pow(1 + monthlyInterest, numberOfPaymentMade))
                / (Math.pow(1 + monthlyInterest, numberOfPayments) - 1 );

        return balance;
    }

    public static double calculateMortgage(
            int principal,
            float annualInterest,
            byte years){

        float monthlyInterest = annualInterest / PERCENT / MONTH_IN_YEAR;
        short numberOfPayments = (short)(years * MONTH_IN_YEAR);

        double mortgage = principal
                * (monthlyInterest * Math.pow(1 + monthlyInterest,numberOfPayments)
                / (Math.pow(1 + monthlyInterest,numberOfPayments) - 1));

        return mortgage;
    }

}
