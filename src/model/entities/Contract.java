package model.entities;

import model.services.TaxService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Contract {

    private Integer contractNumber;
    private Date contractDate;
    private Double totalPrice;
    private List<Installment> installments = new ArrayList<Installment>();

    public Contract(Integer id, Date contractDate, Double totalPrice) {
        this.contractNumber = id;
        this.contractDate = contractDate;
        this.totalPrice = totalPrice;
    }

    public Integer getContractNumber() {
        return contractNumber;
    }

    public Date getContractDate() {
        return contractDate;
    }

    public void setContractDate(Date contractDate) {
        this.contractDate = contractDate;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public List<Installment> getInstallments() {
        return installments;
    }

    public void addInstallments(Installment installment) {
        installments.add(installment);
    }

    public void removeInstallments(Installment installment) {
        installments.remove(installment);
    }
}
