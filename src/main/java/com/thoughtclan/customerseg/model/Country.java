package com.thoughtclan.customerseg.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "country")
public class Country {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "country_id")
	private int id;
	
	@Column(name = "country_name")
	private String cName;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getcName() {
		return cName;
	}

	public void setcName(String cName) {
		this.cName = cName;
	}

	public Country(int id, String cName) {
		super();
		this.id = id;
		this.cName = cName;
	}
	
	public Country(String cName) {
		super();
		this.cName = cName;
	}
	
	public Country() {
	}
	
	
}
