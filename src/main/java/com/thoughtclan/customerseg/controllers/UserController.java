package com.thoughtclan.customerseg.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.thoughtclan.customerseg.model.Login;
import com.thoughtclan.customerseg.services.UserService;


@RestController
public class UserController{
	
	@Autowired
	private UserService userService;

		// method for login Screen
	
		@GetMapping("/login")
		public ModelAndView loginScreen(Model model) {
			model.addAttribute("loginObject",new Login());
			model.addAttribute("signinObject",new Login());
			return new ModelAndView("login");
		}
		
		@RequestMapping("/verify")
		public ModelAndView postLogin(@ModelAttribute("loginObject") Login loginUser) {
			String modelString = userService.verifyUser(loginUser);
			return new ModelAndView(modelString);
		}
		
		@RequestMapping("/signup")
		public ModelAndView signInOperation(@ModelAttribute("signinObject") Login signinUser) {
			System.out.println(signinUser.getName());
			userService.signInUser(signinUser);
			return new ModelAndView("signup-success");
		}
}
