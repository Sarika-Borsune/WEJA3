package com.jspider.cardekho.operations;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.Scanner;

import com.jspider.cardekho.carclass.CarClass;
public class CarOperations {	
	Scanner scanner = new Scanner(System.in);
	
	ArrayList <CarClass> arrayList = new ArrayList<CarClass> ();
	//Add Car
	public void addCarDetails(Scanner scanner) {
		System.out.println("*****Add Car Details*****\n");
		
		
		
		CarClass carClass = new CarClass();
		
		
		System.out.println("Enter New Car Id:");
		carClass.setcarId(scanner.nextInt());
		
		
		System.out.println("Enter New Car Name:");
		carClass.setcarName(scanner.next());
		
		
		System.out.println("Enter New Car Brand:");
		carClass.setcarBrand(scanner.next());
		
		
		System.out.println("Enter New Car Price:");
		carClass.setcarPrice(scanner.nextDouble());
		
		arrayList.add(carClass);
		System.out.println("Car Added Succesfully..\n");
		
	}
	
	//Remove Car
    public  void RemoveCarDetails(Scanner scanner) {
    	System.out.println("***** Remove Car From List *****\n");
		CarClass found = null;
		System.out.println("Enter Car ID");
		int newId =scanner.nextInt();	
		for (int i = 0; i < arrayList.size(); i++) {
			int id = arrayList.get(i).getcarId();
			if (id==newId) {
				found = arrayList.get(i);	
				break;
			}
		}
		if (found!= null) {
			//System.out.println(found);
			arrayList.remove(found);
			System.out.println("Car Removed from the List Successfully..");
			
		}
   
    	}
    
	//Update Car
	public void updateCarDetails(Scanner scanner) {
		System.out.println("***** Update Car Details *****\n");
		CarClass found = null;
		System.out.println("Enter Car ID");
		int newId =scanner.nextInt();	
		for (int i = 0; i < arrayList.size(); i++) {
			int id = arrayList.get(i).getcarId();
			if (id==newId) {
				found = arrayList.get(i);	
				break;
			}
	
		}
		if (found != null) {
			
			System.out.println("Enter New Car Name");
			String name = scanner.next();
			found.setcarName(name);
			
			System.out.println("Enter New Car Brand");
			String brand = scanner.next();
			found.setcarBrand(brand);
			
			System.out.println("Enter New Car Price");
			double price = scanner.nextDouble();
			found.setcarPrice(price);
			
			System.out.println("Car Updated Successfuly..");

		}
		else {
			System.out.println("Car Not Found");
		}	
			
		}
	
    //View Car
	public  void retriveCarDetails(Scanner scanner) {
		System.out.println("***** View Car Details  *****\n");
		
		for (CarClass carClass : arrayList) {
			System.out.println(carClass);			
		}
		System.out.println();

}
}
