package com.jspider.cardekho.carclass;

public class JDBCCarClass {
	 private int carId;
	 private String carName;
	 private String carBrand;
	 private double carPrice;
	 
	 public  int getcarId() {
		 return carId;
	 }
	 public void setcarId(int carId) {
		 this.carId = carId;
	 }
	 
	 public String getcarName() {
		 return carName;
	 }
	 public void setcarName(String carName) {
		 this.carName = carName;
	 }
	 
	 public String getcarBrand() {
		 return carBrand;
	 }
	 public void setcarBrand(String carBrand) {
		 this.carBrand = carBrand;
	 }
	 
	 public double getcarPrice() {
		 return carPrice;
	 }
	 public void setcarPrice(double carPrice) {
		 this.carPrice = carPrice;
	 }
	 
	@Override
	public String toString() {
		return "CarClass [carId=" + carId + ", carName=" + carName + ", carBrand=" + carBrand + ", carPrice=" + carPrice
				+ "]";
	}
	
	 
	 
}

