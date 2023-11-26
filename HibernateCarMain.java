package com.jspider.hibernateCarDekhoCaseStudy.Main;

import java.util.Scanner;

import com.jspider.hibernateCarDekhoCaseStudy.dao.CarDAO;
import com.jspider.hibernateCarDekhoCaseStudy.dto.CarClass;

public class CarMain {
	private static CarDAO carDAO = new CarDAO();
	public static void main(String[] args) {
		boolean flag = true;
		while (flag) {
			Scanner scanner = new Scanner(System.in);
			System.out.println("***** Car Dekho Application *****\n");
			System.out.println("Enter 1 To Add new car\nEnter 2 for View car By Id\nEnter 3 for View All Cars\nEnter 4 for Update car\nEnter 5 for Delete car\nEnter 6 for exit");
			System.out.println("Enter your choice");
			int choice = scanner.nextInt();
			switch (choice) {
			case 1:
				//Add New Car
				System.out.println("***** Add New Car.. *****");
				CarClass carClass = new CarClass();
				scanner.nextLine();
				System.out.println("Enter Car Name");
				carClass.setCarName(scanner.nextLine());
				System.out.println("Enter Car Brand");
				carClass.setCarBrand(scanner.nextLine());
				System.out.println("Enter car Price");
				carClass.setCarPrice(scanner.nextDouble());
				carDAO.addCar(carClass);
				System.out.println("Car added..");
				break;
			case 2:
				//View Car By Id
				System.out.println("View Car By Id..");
				System.out.println("Enter Car id");
				CarClass carClass2 = carDAO.viewCarById(scanner.nextInt());
				if (carClass2 != null) {
					System.out.println(carClass2);
					
				} else {
					System.out.println("Car Not Found");

				}
				break;
			case 3:
				//View All Cars
				System.out.println("***** View All Cars *****");
				carDAO.viewAllCars();
				break;
			
			case 4:
				//Update Car
				System.out.println("***** Update Car.. *****");
				System.out.println("Enter Car Id");
				carDAO.updateCar(scanner.nextInt(),scanner);
				System.out.println("Car Updated successfully..");
				break;
			case 5:
				//Delete Car
				System.out.println("***** Delete Car.. *****");
				System.out.println("Enter Car Id");
				carDAO.deleteCar(scanner.nextInt());
				System.out.println("Car Deleted successfully..");
				break;
			case 6:
				System.out.println("Thank You!!");
				flag = false;
				break;

			default:
				System.out.println("Invalid choice..");
			}
		
			
		}
		
	}
	
	

}
