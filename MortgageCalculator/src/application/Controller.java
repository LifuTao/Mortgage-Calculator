package application;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.scene.control.Slider;


public class Controller {

	@FXML
	private TextField purchasePriceField;
	@FXML
	private TextField downPaymentAmountField;
	@FXML
	private TextField interestRateField;
	@FXML
	private Button defaultCalculateButton;
	@FXML
	private TextField tenYearsLoanAmountField;
	@FXML
	private TextField tenYearsMonthlyPaymentField;
	@FXML
	private TextField twentyYearsLoanAmountField;
	@FXML
	private TextField twentyYearsMonthlyPaymentField;
	@FXML
	private TextField thirtyYearsLoanAmountField;
	@FXML
	private TextField thirtyYearsMonthlyPaymentField;
	//Slider code
	@FXML
	private Slider yearSlider;
	@FXML
	private Button customCalculateButton;
	@FXML
	private Text customNumberOfYearsField;
	@FXML
	private TextField customYearsLoanAmountField;
	@FXML
	private TextField customYearsMonthlyPaymentField;

	private CalculationClass calcClass = new CalculationClass();

	@FXML
    public void onDefaultButtonClicked(ActionEvent e) {
        //default button clicked
		System.out.println("on default button clicked");
		/*public void calculate(double purchasePrice, double downPaymentAmount, double interestRate,
				int numberOfYears) */
		double purchasePrice = Double.parseDouble(purchasePriceField.getText());
		double downPaymentAmount = Double.parseDouble(downPaymentAmountField.getText());
		double interestRate = Double.parseDouble(interestRateField.getText());
		//10 Year Mortgage
		calcClass.calculate(purchasePrice,downPaymentAmount,interestRate,10);
		double tenYearLoanAmount = calcClass.getTotalAmount();
		double tenYearMonthlyPayment = calcClass.getMonthlyPayment();
		//20 Year Mortgage
		calcClass.calculate(purchasePrice,downPaymentAmount,interestRate,20);
		double twentyYearLoanAmount = calcClass.getTotalAmount();
		double twentyYearMonthlyPayment = calcClass.getMonthlyPayment();
		//30 Year Mortgage
		calcClass.calculate(purchasePrice,downPaymentAmount,interestRate,30);
		double thirtyYearLoanAmount = calcClass.getTotalAmount();
		double thirtyYearMonthlyPayment = calcClass.getMonthlyPayment();
		//Fill in the fields
		//10 Year Fields
		tenYearsLoanAmountField.setText(Double.toString(tenYearLoanAmount));
		tenYearsMonthlyPaymentField.setText(Double.toString(tenYearMonthlyPayment));
		//20 Year Fields
		twentyYearsLoanAmountField.setText(Double.toString(twentyYearLoanAmount));
		twentyYearsMonthlyPaymentField.setText(Double.toString(twentyYearMonthlyPayment));
		//30 Year Fields
		thirtyYearsLoanAmountField.setText(Double.toString(thirtyYearLoanAmount));
		thirtyYearsMonthlyPaymentField.setText(Double.toString(thirtyYearMonthlyPayment));
    }
	@FXML
	public void onCustomCalculateButtonClicked(ActionEvent e)
	{
		//slider calculate button clicked
		double purchasePrice = Double.parseDouble(purchasePriceField.getText());
		double downPaymentAmount = Double.parseDouble(downPaymentAmountField.getText());
		double interestRate = Double.parseDouble(interestRateField.getText());
		//get years variable also
		double numOfYears = yearSlider.getValue();
		calcClass.calculate(purchasePrice, downPaymentAmount, interestRate, numOfYears);
		double customYearLoanAmount = calcClass.getTotalAmount();
		double customYearMonthlyPayment = calcClass.getMonthlyPayment();
		customNumberOfYearsField.setText(Double.toString(numOfYears) + " years");
		customYearsLoanAmountField.setText(Double.toString(customYearLoanAmount));
		customYearsMonthlyPaymentField.setText(Double.toString(customYearMonthlyPayment));

	}




}
