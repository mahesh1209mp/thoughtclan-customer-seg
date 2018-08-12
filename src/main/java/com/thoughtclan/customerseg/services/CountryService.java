package com.thoughtclan.customerseg.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thoughtclan.customerseg.model.Country;
import com.thoughtclan.customerseg.repository.CountryRepository;


@Service
public class CountryService {
	
	@Autowired
	private CountryRepository countryRepository;
	
	public List<Country> getCountries(){
		
		List<Country> countries = new ArrayList<Country>();
		countryRepository.findAll().forEach(countries::add);
		
		return countries;
	}

}
