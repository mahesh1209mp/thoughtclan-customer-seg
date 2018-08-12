package com.thoughtclan.customerseg.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thoughtclan.customerseg.model.Connection;
import com.thoughtclan.customerseg.model.Customer;
import com.thoughtclan.customerseg.model.Filter;
import com.thoughtclan.customerseg.model.FilterHelper;
import com.thoughtclan.customerseg.repository.ConnectionRepository;
import com.thoughtclan.customerseg.repository.GroupRepository;

@Service
public class GroupServices {
	
	@Autowired
	private GroupRepository groupRepository;
	
	@Autowired
	private ConnectionService connectionService;
	
	@Autowired
	private ConnectionRepository connectionRepository;
	
	public FilterHelper fHelperValue;
	
	// method to add a group value
	
	public String addGroup(Filter newGroup , List<Customer> filterList) {
		groupRepository.save(newGroup);
		Filter fGroup = groupRepository.findAllByGroupName(newGroup.getGroupName());
		connectionService.makeConnection(fGroup, filterList);
		
		String path = fGroup.getId().toString();
		return path;
	}	
	
	// method to return all group values
	public List<Filter> getAllGroup(){
		List<Filter> allList = new ArrayList<Filter>();
		groupRepository.findAll().forEach(allList::add);
		return allList;
	}
	
	// method to get particular group value field
	public List<Customer> getGroupCustomers(int id){
		List<Customer> customerList = new ArrayList<>();
		List<Connection> connectionList = new ArrayList<Connection>();
		connectionList=connectionRepository.findByGroupsId(id);
		
		for (Connection connection : connectionList) {
			customerList.add(connection.getCustomerId());
			System.out.println(connection.getCustomerId().getName());
		}
		
		return customerList;
	}
	
	
	public Filter getGroupDetails(int id) {
		return groupRepository.findById(id).get();
	}

	/* give helper and get helper 
	 * methods used for passing helper values to different methods.
	 */
	public void giveHelper(FilterHelper helper) {
		fHelperValue = helper;
	}
	
	public FilterHelper getHelper() {
		return fHelperValue;
	}
	
}
