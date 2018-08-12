package com.thoughtclan.customerseg.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.thoughtclan.customerseg.model.Filter;
import com.thoughtclan.customerseg.repository.GroupRepository;
import com.thoughtclan.customerseg.services.GroupServices;

@Controller
@RequestMapping
public class GroupController {

	@Autowired
	private GroupServices groupService;
	
	@RequestMapping("/all-groups")
	public ModelAndView allGroups(Model model) {
		model.addAttribute("group_list",groupService.getAllGroup());
		return new ModelAndView("all-groups");
	}
	
	@RequestMapping("/{id}")
	public ModelAndView showMyGroup(@PathVariable int id,Model model) {
		System.out.println(id);
		
		model.addAttribute("customers_model",groupService.getGroupCustomers(id));
		model.addAttribute("group_info",groupService.getGroupDetails(id));
		return new ModelAndView("single_group");
	}
	
}
