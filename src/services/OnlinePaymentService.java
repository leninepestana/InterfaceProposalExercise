package services;

public interface OnlinePaymentService {
	
	public double getFeePercentage(double amount);
	public double getMonthlyPercentage(double amount, int months);

}
