package model.services;

import java.util.Date;

public interface TaxService {

    double paymentFee(double amount);
    double interest(double amount, int months);
}
