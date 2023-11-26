package com.jspider.hibernateCarDekhoCaseStudy.dao;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.jspider.hibernateCarDekhoCaseStudy.dto.CarClass;

public class CarDAO {
	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager entityManager;
	private static EntityTransaction entityTransaction;
	
	private static void openConnection() {
		entityManagerFactory = Persistence.createEntityManagerFactory("car");
		entityManager = entityManagerFactory.createEntityManager();
		entityTransaction = entityManager.getTransaction();	
	}
//	Add Car
	public void addCar(CarClass carClass) {
		openConnection();
		entityTransaction.begin();
		entityManager.persist(carClass);
		entityTransaction.commit();
		closeConnection();	
	}
	
//	View Car By Id
	public CarClass viewCarById(int id) {
		openConnection();
		entityTransaction.begin();
		CarClass carClass =  entityManager.find(CarClass.class,id );
		entityTransaction.commit();
		closeConnection();
		return carClass;
	
	}
	
//	View All Cars
	public void viewAllCars() {
		openConnection();
		entityTransaction.begin();
		Query query = entityManager.createQuery("select carclass From CarClass carclass");
		List<CarClass> car = query.getResultList();
		for (CarClass carClass : car) {
			System.out.println(carClass);	
		}
		entityTransaction.commit();
		closeConnection();	
		
		
	}
	
//	Update car 
	public void updateCar(int id,Scanner scanner) {
		openConnection();
		entityTransaction.begin();
		CarClass carClass =  entityManager.find(CarClass.class,id );
		System.out.println(scanner.nextLine());
		System.out.println("Enter New Car Name");
		carClass.setCarName(scanner.nextLine());
		System.out.println("Enter New Car Brand");
		carClass.setCarBrand(scanner.nextLine());
		System.out.println("Enter New Car Price");
		carClass.setCarPrice(scanner.nextDouble());
		System.out.println(carClass);
		entityTransaction.commit();
		closeConnection();	
	}
	
//	Delete Car
	public void deleteCar(int id) {
		openConnection();
		entityTransaction.begin();
		CarClass carClass =  entityManager.find(CarClass.class,id );
		entityManager.remove(carClass);
		System.out.println(carClass);
		entityTransaction.commit();
		closeConnection();	
	
	}
	
	private static void closeConnection() {
		if (entityManagerFactory != null) {
			entityManagerFactory.close();	
		}
		if (entityManager != null) {
			entityManager.close();
			
		}
		if (entityTransaction != null) {
			if(entityTransaction.isActive()) {
				entityTransaction.rollback();
			}
			
		}
		
		
	}

}
