package com.mudah_technology_mortgage_mosh;

public class MortgageCalculator {
    public final static byte MONTH_IN_YEAR = 12;
    public final static byte PERCENT = 100;

    private int principal;
    private float annualInterest;
    private byte years;

    public MortgageCalculator(int principal, float annualInterest, byte years) {
        this.principal = principal;
        this.annualInterest = annualInterest;
        this.years = years;
    }

    public double calculateBalance(short numberOfPaymentMade) {

        float monthlyInterest = getMonthlyInterest();
        short numberOfPayments = getNumberOfPayments();

        double balance = principal
                * (Math.pow(1 + monthlyInterest, numberOfPayments) - Math.pow(1 + monthlyInterest, numberOfPaymentMade))
                / (Math.pow(1 + monthlyInterest, numberOfPayments) - 1);

        return balance;
    }

    public double calculateMortgage() {

        float monthlyInterest = getMonthlyInterest();
        short numberOfPayments = getNumberOfPayments();

        double mortgage = principal
                * (monthlyInterest * Math.pow(1 + monthlyInterest, numberOfPayments)
                / (Math.pow(1 + monthlyInterest, numberOfPayments) - 1));

        return mortgage;
    }

    public double[] getRemainingBalances(){
        for (short month = 1; month <= getNumberOfPayments; month++) {
            double balance = calculator.calculateBalance(month);
        }

    private float getMonthlyInterest() {
        return annualInterest / PERCENT / MONTH_IN_YEAR;
    }

    private short getNumberOfPayments() {
        return (short) (years * MONTH_IN_YEAR);
    }

    public short getYears() {
        return years;
    }
}
