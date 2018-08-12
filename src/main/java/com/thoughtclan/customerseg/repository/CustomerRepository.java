package com.thoughtclan.customerseg.repository;

import java.util.List;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.thoughtclan.customerseg.model.Customer;


@Repository
public interface CustomerRepository extends CrudRepository<Customer, Integer>,
												JpaSpecificationExecutor<Customer> {
	
	
	List<Customer> findAll(Specification<Customer> spec);
	
	
}
