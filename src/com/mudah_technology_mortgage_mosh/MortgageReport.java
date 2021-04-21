package com.mudah_technology_mortgage_mosh;

import java.text.NumberFormat;

public class MortgageReport {

    private final NumberFormat currency;
    private MortgageCalculator calculator;

    public MortgageReport(MortgageCalculator calculator) {
        this.calculator = calculator;
        currency = NumberFormat.getCurrencyInstance();
    }

    public void printPaymentSchedule() {
        System.out.println();
        System.out.println("PAYMENT SCHEDULE");
        System.out.println("-----------------");

        for (double balance: calculator.getRemainingBalances())
            System.out.println(
                    "Payment ke  month : "
                            + currency.format(balance));

/*        for (short month = 1; month <= calculator.getYears() * MortgageCalculator.MONTH_IN_YEAR; month++) {
            double balance = calculator.calculateBalance(month);
            System.out.println(
                    "Payment ke " + month + ": "
                            + NumberFormat.getCurrencyInstance().format(balance));
        }*/
    }

    public void printMortgage() {
        double mortgage = calculator.calculateMortgage();
        String mortgageFormatted = currency.format(mortgage);
        System.out.println();
        System.out.println("MORTGAGE/PINJAMAN");
        System.out.println("------------------");
        System.out.println("Monthly Payments: " + mortgageFormatted);
    }
}
