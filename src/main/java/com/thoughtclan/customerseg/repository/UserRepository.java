package com.thoughtclan.customerseg.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.thoughtclan.customerseg.model.Login;

@Repository
public interface UserRepository extends CrudRepository<Login,String>{

//
//	String findPasswordById(String username);

}
