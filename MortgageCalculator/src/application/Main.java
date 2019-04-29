package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;


//Mortgage Calculator
public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("Sample.fxml"));

			CalculationClass calc = new CalculationClass();
			calc.calculate(500000,0,5,30);
			System.out.println("Monthly Payment: " + calc.getMonthlyPayment());
			System.out.println("Total Amount: " + calc.getTotalAmount());
			primaryStage.setTitle("Mortgage Calculator");
			primaryStage.setScene(new Scene(root,550,700));
			primaryStage.show();


		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
