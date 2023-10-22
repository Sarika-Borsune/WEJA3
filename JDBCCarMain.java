package com.jspider.cardekho.main;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.jspider.cardekho.carclass.CarClass;
import com.jspider.cardekho.carclass.JDBCCarClass;
import com.jspider.cardekho.operations.JDBCCarOperations;

public class JDBCCarMain {	
	
	public static void main(String[] args) throws InterruptedException {
		Scanner scanner = new Scanner(System.in);
		JDBCCarOperations jdbcCarOperations = new JDBCCarOperations();
		boolean flag = true;
		while(flag) {
		System.out.println("***** Main Menu *****");
		System.out.println("1.Add New Car\n2.Car Details\n3.Get Car By Id\n4.Update Car\n5.Delete Car\n6.Exit");
		System.out.println("Enter Your Choice");
		int choice = scanner.nextInt();
		switch (choice) {
		case 1:
			
			jdbcCarOperations.addCarDetails();
			
			break;
		case 2:
			System.out.println("***** Get All car Details *****");
			List<CarClass> carClass = jdbcCarOperations.getAllCar();
			for(CarClass s : carClass) {
				System.out.println(s);	
			}
			break;
		case 3:
			System.out.println("Enter Car Id");
			List <CarClass> carClass1 = jdbcCarOperations.getCarById(scanner.nextInt());
			for(CarClass car : carClass1) {
				System.out.println(car);
				
			}
			
			
			break;
		case 4:
			System.out.println("***** Update Car Details *****");
			System.out.println("Enter car Id");
			jdbcCarOperations.updateCar(scanner.nextInt(),scanner);
			break;
		case 5:
			System.out.println("***** Delete Car Details *****");
			System.out.println("Enter Car Id");
			jdbcCarOperations.deleteCar(scanner.nextInt());
			break;			
		case 6:
			flag=false;
			System.out.println("Thank you!!");
			break;
		default:
			System.out.println("Invalid Chioce!!Please enter Valid Chioce..");
		}
		}
		scanner.close();
	}
}
		
		
		
	




















