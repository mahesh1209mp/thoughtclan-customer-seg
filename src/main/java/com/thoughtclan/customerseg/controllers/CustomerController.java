package com.thoughtclan.customerseg.controllers;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.mysql.jdbc.log.Log;
import com.thoughtclan.customerseg.model.Customer;
import com.thoughtclan.customerseg.model.Filter;
import com.thoughtclan.customerseg.model.FilterHelper;
import com.thoughtclan.customerseg.model.ListHelper;
import com.thoughtclan.customerseg.services.CountryService;
import com.thoughtclan.customerseg.services.CustomerService;
import com.thoughtclan.customerseg.services.GroupServices;


@RestController
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private CountryService countryService;
	
	@Autowired
	private GroupServices groupService;

	
	// get all entries method	
	@RequestMapping("/customer")
	public ModelAndView getAllCustomers(Model model) {
	
		// passing value to the model
		model.addAttribute("customers_model", customerService.getAllEntries());
	
		return new ModelAndView("display-page");
	}
	
	// filter record method
	@GetMapping("/filter")
	public ModelAndView filterCustomers(Model model) {
		model.addAttribute("helperFilter",new FilterHelper());
		return new ModelAndView("search-entries");
	}
	
	// post filter method
	@PostMapping("/filter")
	public ModelAndView postFilter(@ModelAttribute("helperFilter") FilterHelper helper,
			Model model) {
		groupService.giveHelper(helper);
		
		List<Customer> myCustomerList = customerService.getFilterEntries(helper);
		if(myCustomerList.isEmpty()) {
			return new ModelAndView("noresult");
		}
		else {
			model.addAttribute("customers_model", myCustomerList);
			model.addAttribute("group", new Filter());
			return new ModelAndView("search-result");
		}
	}
	
	
	// add extra customer
	@GetMapping("/add")
	public ModelAndView addCustomer(Model model) {
		model.addAttribute("adCustomer", new Customer());
		model.addAttribute("countries",countryService.getCountries());
		return new ModelAndView("add-page");
	}
	
	
	// add customer and go back to main page
	@PostMapping("/add")
	public ModelAndView postAddCustomer(@ModelAttribute Customer adCustomer, Model model) {
		System.out.println(adCustomer.getCountry());
		customerService.addCustomer(adCustomer);
		model.addAttribute("customers_model", customerService.getAllEntries());
		return new ModelAndView("redirect:/customer");
	}
	
	
	// insert id of the view also
	@PostMapping("/view-group")
	public ModelAndView viewNewGroup(@ModelAttribute("group") Filter group) {
		List<Customer> filteredList = new ArrayList<Customer>();
		// filtered customers
		filteredList= customerService.getFilterEntries(groupService.getHelper());
		
		String path=groupService.addGroup(group,filteredList);
		
		return new ModelAndView("redirect:/"+path);
	}

	
}
