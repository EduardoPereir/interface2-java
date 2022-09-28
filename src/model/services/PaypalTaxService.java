package model.services;

public class PaypalTaxService implements TaxService{

    private double monthInterest = 0.01;
    private double paymentFee = 0.02;

    @Override
    public double paymentFee(double amount) {
        return amount * paymentFee;
    }

    @Override
    public double interest(double amount, int months) {
        return amount * monthInterest * months;
    }
}

