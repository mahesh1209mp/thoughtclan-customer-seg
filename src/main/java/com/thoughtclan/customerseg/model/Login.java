package com.thoughtclan.customerseg.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Login {
	
	// take the values from the database and verify it
	
	@Id
	@Column(name = "username")
	private String username;
	
	@Column(name = "password", nullable=false)
	private String password;
	
	@Column(name = "name" , nullable=false)
	private String name;
	
	public Login() {
		
	}
    
	
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public Login(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	
	public Login(String username, String password, String name) {
		super();
		this.username = username;
		this.password = password;
		this.name = name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
	

}
