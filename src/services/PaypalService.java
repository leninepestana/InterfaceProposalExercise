package services;

public class PaypalService implements OnlinePaymentService {
	
	private static final double FEE_PERCENTAGE = 0.02;
	private static final double MONTHLY_PERCENTAGE = 0.01;
	
	public double getFeePercentage(double amount) {
		return FEE_PERCENTAGE;
	}
	
	public double getMonthlyPercentage(double amount, int months) {
		return MONTHLY_PERCENTAGE;
	}

}
