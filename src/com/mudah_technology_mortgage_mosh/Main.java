package com.mudah_technology_mortgage_mosh;

public class Main {

    public static void main(String[] args) {
	// write your code here
        int principal = (int) Console.readNumber("Principal / Jumlah pinjaman (1000-1jt) : ", 1000, 500_000_000);
        float annualInterest = (float) Console.readNumber("Annual Interest Rate: ", 1, 50);
        byte years = (byte) Console.readNumber("Period (Years): ",1,20);

        var calculator = new MortgageCalculator(principal,annualInterest,years);
        var report = new MortgageReport(calculator);
        report.printMortgage();
        report.printPaymentSchedule();
    }

}
