package com.thoughtclan.customerseg.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.thoughtclan.customerseg.model.Country;

@Repository
public interface CountryRepository extends CrudRepository<Country, Integer>{

}
