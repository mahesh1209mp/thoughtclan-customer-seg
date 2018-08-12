package com.thoughtclan.customerseg.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thoughtclan.customerseg.model.Connection;
import com.thoughtclan.customerseg.model.Customer;
import com.thoughtclan.customerseg.model.Filter;
import com.thoughtclan.customerseg.repository.ConnectionRepository;

@Service
public class ConnectionService {

	@Autowired
	private ConnectionRepository connectionRepository;
	
	
	public void makeConnection(Filter group, List<Customer> customerList ) {
	
		for (Customer customer : customerList) {
			Connection con = new Connection(group,customer);
			connectionRepository.save(con);
		}
	}
}