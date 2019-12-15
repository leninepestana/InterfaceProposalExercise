package services;

import java.util.Calendar;
import java.util.Date;

import entities.Contract;
import entities.Installment;

public class ContractService {
	
	//private PaypalService paypalService;
	private OnlinePaymentService onlinePaymentService;
	
	public ContractService() {
	}
	
	public ContractService(OnlinePaymentService onlinePaymentService) {
		this.onlinePaymentService = onlinePaymentService;
	}
	
	public void ProcessContract(Contract contract, int months) {
		double basicQuota = contract.getTotalValue() / months;
		for (int i=1; i<= months; i++) {
			Date date = addMonths(contract.getDate(), i);
			double updateQuota = basicQuota + onlinePaymentService.getMonthlyPercentage(basicQuota, i);
			double fullQuota = updateQuota + onlinePaymentService.getFeePercentage(updateQuota);
			contract.addtInstallment(new Installment(date, fullQuota));
		}
		
	}
	
	private Date addMonths(Date date, int n) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.MONTH, n);
		return cal.getTime();
	}

}
