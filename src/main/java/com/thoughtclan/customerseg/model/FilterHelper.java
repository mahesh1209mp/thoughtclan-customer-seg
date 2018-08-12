package com.thoughtclan.customerseg.model;


public class FilterHelper {
	
	private int minAge;
	private int maxAge;
	private String name;
	private String gender;
	private String state;
	private String country;
	private String city;
	
	
	
	public int getMinAge() {
		return minAge;
	}
	public void setMinAge(int minAge) {
		this.minAge = minAge;
	}
	public int getMaxAge() {
		return maxAge;
	}
	public void setMaxAge(int maxAge) {
		this.maxAge = maxAge;
	}
	
	
	
	
	public FilterHelper(int minAge, int maxAge, String name, String gender, String state, String country, String city) {
		super();
		this.minAge = minAge;
		this.maxAge = maxAge;
		this.name = name;
		this.gender = gender;
		this.state = state;
		this.country = country;
		this.city = city;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public FilterHelper() {
	}
	
}
