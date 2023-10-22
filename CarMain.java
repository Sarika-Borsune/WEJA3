package com.jspider.cardekho.main;
import java.util.*;

import com.jspider.cardekho.carclass.CarClass;
import com.jspider.cardekho.operations.CarOperations;

public class CarMain {	
	
	public static void main(String[] args) throws InterruptedException {
		Scanner scanner = new Scanner(System.in);
		CarOperations carOperations = new CarOperations();
		boolean flag = true;
		while(flag) {
		System.out.println("***** Main Menu *****");
		System.out.println("1.Add Car");
		System.out.println("2.Remove Car");
		System.out.println("3.Update Car");
		System.out.println("4.View Car");
		System.out.println("5.Exit");
		
		System.out.println("Enter Your Choice");
		int choice = scanner.nextInt();
		switch (choice) {
		case 1:
			carOperations.addCarDetails(scanner);
			break;
		case 2:
			carOperations.RemoveCarDetails(scanner);
			break;
		case 3:
			carOperations.updateCarDetails(scanner);
			break;
		case 4:
			carOperations.retriveCarDetails(scanner);
			
			break;
		case 5:
			flag=false;
			break;
	
		default:
			
			System.out.println("Invalid Choice");
		}	
		
	}
	}

}


















