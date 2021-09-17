package com.percapincome.pojo;

public class WriterObj {
	private String country_city;
	private String gender;
	private double avgIncome;
	public String getCountry_city() {
		return country_city;
	}
	public void setCountry_city(String country_city) {
		this.country_city = country_city;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public double getAvgIncome() {
		return avgIncome;
	}
	public void setAvgIncome(double avgIncome) {
		this.avgIncome = avgIncome;
	}
	public WriterObj(String country_city, String gender, double avgIncome) {
		super();
		this.country_city = country_city;
		this.gender = gender;
		this.avgIncome = avgIncome;
	}
	
	
}
