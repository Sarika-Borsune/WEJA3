package com.jspider.hibernateCarDekhoCaseStudy.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class CarClass {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	 private int carId;
	@Column(nullable = false)
	 private String carName;
	@Column(nullable = false)
	 private String carBrand;
	@Column(nullable = false)
	 private double carPrice;
	 
}
