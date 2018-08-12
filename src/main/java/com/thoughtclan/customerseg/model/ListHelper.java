package com.thoughtclan.customerseg.model;

import java.util.ArrayList;

public class ListHelper {
	
	private ArrayList<Customer> customerList;

	public ArrayList<Customer> getCustomerList() {
		return customerList;
	}

	public void setCustomerList(ArrayList<Customer> customerList) {
		this.customerList = customerList;
	}

	public ListHelper(ArrayList<Customer> customerList) {
		super();
		this.customerList = customerList;
	}

	public ListHelper() {
		super();
	}
	
	

}
