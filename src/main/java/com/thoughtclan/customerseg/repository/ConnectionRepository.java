package com.thoughtclan.customerseg.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.thoughtclan.customerseg.model.Connection;

@Repository
public interface ConnectionRepository extends CrudRepository<Connection, Integer>{
	
	List<Connection> findByGroupsId(Integer id);
	
}
