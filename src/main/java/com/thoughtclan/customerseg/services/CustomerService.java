package com.thoughtclan.customerseg.services;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.thoughtclan.customerseg.model.Customer;
import com.thoughtclan.customerseg.model.FilterHelper;
import com.thoughtclan.customerseg.model.Login;
import com.thoughtclan.customerseg.repository.CustomerRepository;
import com.thoughtclan.customerseg.specification.CustomerSpecification;


// Customer service class to provide values to the controller class

@Service
public class CustomerService {
	
	@Autowired
	private CustomerRepository customerRepository;
	
	// get all entries in our database
	public List<Customer> getAllEntries(){
		
		List<Customer> customers = new ArrayList<Customer>();
		customerRepository.findAll().forEach(customers::add);
		return customers;
		
	}
	
	// filter the records
	
	public List<Customer> getFilterEntries(FilterHelper fCustomer){
		
		FilterHelper fhelper = new FilterHelper(fCustomer.getMinAge(),fCustomer.getMaxAge(),fCustomer.getName(),
				fCustomer.getGender(),fCustomer.getState(),fCustomer.getCountry(),fCustomer.getCity());		
		if(fhelper.getGender().equals("Select your Gender")) {
			fhelper.setGender(null);
		}
		Iterable<Customer> customers = customerRepository.findAll(CustomerSpecification.hasData(fhelper));
		
		List<Customer> filterList = new ArrayList<>();
		for( Customer cs : customers) {
			filterList.add(cs);
		}
		
		
		return filterList;
	}
	
	// add customer to database
	
	public void addCustomer(Customer cs1) {

		customerRepository.save(cs1);
	}
	

	
	// method to verify the password for the user
	public String sendPassword(Login user) {
		return null;
	}
}
