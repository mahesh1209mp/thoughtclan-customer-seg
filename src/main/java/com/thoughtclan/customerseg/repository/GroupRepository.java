package com.thoughtclan.customerseg.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.thoughtclan.customerseg.model.Filter;

@Repository
public interface GroupRepository extends CrudRepository<Filter, Integer>{

	public Filter findAllByGroupName(String groupName);
	
	
	

}
