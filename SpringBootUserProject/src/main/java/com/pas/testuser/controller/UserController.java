package com.pas.testuser.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pas.testuser.model.User;
import com.pas.testuser.service.UserServices;

@Controller
public class UserController {

	@Autowired
	UserServices userServices;
	
	@RequestMapping("/showCreate")
	public String showCreate() {
		return "createUser";
	}
	
	@RequestMapping("/insertUser")
	public String SaveUser(@ModelAttribute ("user") User user) {
		userServices.saveUser(user);
		return "createUser";
	}
	
}
