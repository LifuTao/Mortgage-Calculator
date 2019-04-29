package application;
import java.lang.Math;

public class CalculationClass {
	// monthly payment = L[c(1 + c)^n]/[(1 + c)^n - 1]

	private double monthlyPayment;
	private double totalAmount;
	public void calculate(double purchasePrice, double downPaymentAmount, double interestRate,
			double numberOfYears)
	{
		//L = loan
		//c = per payment interest = interestRate/numOfPayments
		//n = payment number = numberOfYears * 12
		purchasePrice -= downPaymentAmount;
		interestRate/=100;
		double numOfPayments = numberOfYears *12;
		double perPaymentInterest = interestRate/12;

		monthlyPayment =  purchasePrice*(perPaymentInterest*Math.pow(1+perPaymentInterest,numOfPayments))
				/(Math.pow(1+perPaymentInterest, numOfPayments)-1);
		totalAmount = monthlyPayment * (numOfPayments);
		//round to 2 decimals
		monthlyPayment = Math.round(monthlyPayment * 100.0) / 100.0;
		totalAmount = Math.round(totalAmount * 100.0) / 100.0;
	}
	public double getMonthlyPayment(){

		return monthlyPayment;
	}
	public double getTotalAmount(){
	return totalAmount;
	}


	//10 years, 20 years, 30 years. only differnce is years. must calculate again



}
