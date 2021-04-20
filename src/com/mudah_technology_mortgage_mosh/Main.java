package com.mudah_technology_mortgage_mosh;

import java.text.NumberFormat;

public class Main {
    final static byte MONTH_IN_YEAR = 12;
    final static byte PERCENT = 100;

    public static void main(String[] args) {
	// write your code here
        int principal = (int) Console.readNumber("Principal / Jumlah pinjaman (1000-1jt) : ", 1000, 500_000_000);
        float annualInterest = (float) Console.readNumber("Annual Interest Rate: ", 1, 50);
        byte years = (byte) Console.readNumber("Period (Years): ",1,20);

        printMortgage(principal, annualInterest, years);
        printPaymentSchedule(principal, annualInterest, years);
    }

    private static void printMortgage(int principal, float annualInterest, byte years) {
        double mortgage = calculateMortgage(principal, annualInterest, years);
        String mortgageFormatted = NumberFormat.getCurrencyInstance().format(mortgage);
        System.out.println();
        System.out.println("MORTGAGE/PINJAMAN");
        System.out.println("------------------");
        System.out.println("Monthly Payments: " + mortgageFormatted);
    }

    private static void printPaymentSchedule(int principal, float annualInterest, byte years) {
        System.out.println();
        System.out.println("PAYMENT SCHEDULE");
        System.out.println("-----------------");
        for (short month = 1; month <= years * MONTH_IN_YEAR; month++ ) {
            double balance =  calculateBalance(principal, annualInterest, years,month);
            System.out.println(
                    "Payment ke " + month + ": "
                    + NumberFormat.getCurrencyInstance().format(balance));
        }
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
