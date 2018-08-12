package com.thoughtclan.customerseg.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thoughtclan.customerseg.model.Login;
import com.thoughtclan.customerseg.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	// method to verify the user
	
	public String verifyUser(Login userLogin) {
		
		List<Login> userList = new ArrayList<Login>();
		userRepository.findAll().forEach(userList::add);
		
		int count=0;
		
		for (Login login : userList) {
			if(login.getUsername().equals(userLogin.getUsername())
					&&login.getPassword().equals(userLogin.getPassword())){
				count=1;
			}
		}
		
		if(count==0) {
			return "login_fail";
		}
		else {
			return "redirect:/customer";
	
		}
	}
	
	public void signInUser(Login userLogin) {
		userRepository.save(userLogin);
	}

}
