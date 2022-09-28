package application;

import model.entities.Contract;
import model.entities.Installment;
import model.services.ContractService;
import model.services.PaypalTaxService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) throws ParseException {

        Locale.setDefault(Locale.US);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Scanner s = new Scanner(System.in);

        System.out.println("Enter contract data:");
        System.out.print("Number of contract: ");
        int contractNumber = s.nextInt();
        System.out.print("Date (dd/mm/yyyy): ");
        Date contractDate = sdf.parse(s.next());
        System.out.print("Contract Value: ");
        double contractValue = s.nextDouble();

        Contract contract = new Contract(contractNumber, contractDate, contractValue);

        System.out.print("Enter number of installments: ");
        int installmentNumber = s.nextInt();

        ContractService contractService = new ContractService(new PaypalTaxService());
        contractService.processContract(contract, installmentNumber);

        System.out.println("\nInstallments: ");
        for ( Installment i: contract.getInstallments()){
            System.out.println(i);
        }

        s.close();
    }
}
