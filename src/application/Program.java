package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Contract;
import entities.Installment;
import services.ContractService;
import services.PaypalService;

public class Program {
	
	public static void main (String[] args) throws ParseException {
		
		
		Locale.setDefault(Locale.US);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter contract data ");
		System.out.print("Number: ");
		int number = sc.nextInt();
		System.out.print("Date (dd/MM/yyyy): ");
		Date date = sdf.parse(sc.next());
		System.out.print("Contract value: ");
		double totalValue = sc.nextDouble();
		
		Contract contract = new Contract(number, date, totalValue);
		
		System.out.print("Enter number of installments: ");
		int months = sc.nextInt();
		
		
		
		System.out.println("INSTALLMENTS:");
		
		ContractService contractService = new ContractService(new PaypalService());
		
		contractService.ProcessContract(contract, months);
		
		for (Installment x : contract.getInstallment()) {
			System.out.println(x);
		}
		
		sc.close();
	}

}
