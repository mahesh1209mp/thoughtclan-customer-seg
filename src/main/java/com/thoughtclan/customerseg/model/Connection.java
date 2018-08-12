package com.thoughtclan.customerseg.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "connection")
public class Connection {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int srNo;
	
	@ManyToOne
	@JoinColumn(name="group_id")
	private Filter groups;
	
	
	@ManyToOne
	@JoinColumn(name="c_id")
	private Customer customer;


	public Filter getGroups() {
		return groups;
	}


	public void setGroups(Filter groups) {
		this.groups = groups;
	}


	public Customer getCustomerId() {
		return customer;
	}


	public void setCustomerId(Customer customerId) {
		this.customer = customerId;
	}


	public Connection(Filter groups, Customer customerId) {
		super();
		this.groups = groups;
		this.customer = customerId;
	}


	public Connection() {
		super();
	}	
	
}
