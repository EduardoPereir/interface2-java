package model.services;

import model.entities.Contract;
import model.entities.Installment;

import java.util.Calendar;
import java.util.Date;

public class ContractService {

    private TaxService taxService;

    public ContractService(TaxService taxService) {
        this.taxService = taxService;
    }

    public void processContract(Contract contract, int months) {
        double basicQuota = contract.getTotalPrice() / months;
        for (int i = 1; i <= months; i++) {
            Date date = addMonths(contract.getContractDate(), i);
            double updateQuota = basicQuota + taxService.interest(basicQuota, i);
            double fullQuota = updateQuota + taxService.paymentFee(updateQuota);
            contract.addInstallments(new Installment(date, fullQuota));
        }
    }

    private Date addMonths(Date date, int n) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.MONTH, n);
        return cal.getTime();
    }
}
