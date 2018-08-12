package com.thoughtclan.customerseg.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Customer")
public class Customer {
	
	// values declaration
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "c_id")
	private int id;
	
	@Column(name = "c_name")
	private String name;
	
	@Column(name = "c_age")
	private int age;
	
	@Column(name = "c_gender")
	private String gender;
	
	@Column(name = "c_city")
	private String city;
	
	@Column(name = "c_state")
	private String state;
	
	@Column(name = "c_country")
	private String country;
	
	// blank constructor
	public Customer() {
		super();
	}
	
	// constructor using fields
	public Customer( String name, int age, String gender, String city, String state, String country) {
		super();
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.city = city;
		this.state = state;
		this.country = country;
	}
	
	
	// getters and setters for all properties
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
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
}
