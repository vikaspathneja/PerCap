package com.percapincome.pojo;

import com.percapincome.util.PropReader;

public class People {
	private String City;
	private String Country;
	private String Gender;
	private String Currency;
	private double AverageIncome;
	
	public String getCity() {
		return City;
	}
	public void setCity(String city) {
		City = city;
	}
	public String getCountry() {
		return Country;
	}
	public void setCountry(String country) {
		Country = country;
	}
	public String getGender() {
		return Gender;
	}
	public void setGender(String gender) {
		Gender = gender;
	}
	public String getCurrency() {
		return Currency;
	}
	public void setCurrency(String currency) {
		Currency = currency;
	}
	public double getAverageIncome() {
		return AverageIncome;
	}
	public void setAverageIncome(double averageIncome) {
		AverageIncome = averageIncome;
	}
	public People(String city, String country, String gender, String currency, double averageIncome) {
		super();
		City = city;
		Country = country;
		Gender = gender;
		Currency = currency;
		AverageIncome = averageIncome;
	}
	@Override
	public String toString() {
		return "People [City=" + City + ", Country=" + Country + ", Gender=" + Gender + ", Currency=" + Currency
				+ ", AverageIncome=" + AverageIncome + "]";
	}
	
	
	

	
	
	
	
	
	
	

}
