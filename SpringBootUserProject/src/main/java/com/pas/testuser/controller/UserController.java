package com.pas.testuser.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.pas.testuser.model.User;
import com.pas.testuser.service.UserServices;

@Controller
public class UserController {

	@Autowired
	CacheManager cachemanager;
	
	@Autowired
	UserServices userServices;
	
	@RequestMapping("/showCreate")
	public String showCreate(Model model) {
		/* return "createUser"; */
		User user= new User();
		model.addAttribute(user);
		return "createUser";
	}
	
	@RequestMapping("/insertUser")
	public String SaveUser(@ModelAttribute ("user") User user) {
		userServices.saveUser(user);
		return "redirect:/";
	}
	
	@RequestMapping("/")
	public String viewHomePage(Model model) {
		List<User> listusers=userServices.getAllUsersSortedById();
		model.addAttribute("listusers", listusers);
		return "index";
	}
	
	@RequestMapping(value = "/deleteuser/{id}", method = RequestMethod.GET)
	public String deleteUser(@PathVariable int id) {
		userServices.deleteUser(id);
		return "redirect:/";
	}
	
	@RequestMapping(value = "/edituser/{id}")
	public String editUser(@PathVariable int id, Model model) {
		User user=userServices.GetUserDetails(id);
		model.addAttribute("command",user);
		return "userEditForm";
	}
	
	@RequestMapping(value = "/edituser/editSave", method = RequestMethod.POST)
	public String updateUser(@ModelAttribute ("user") User user) {
		userServices.saveUser(user);
		return "redirect:/";
	}
	
	/* Clear Cache Data by calling below method */
	@RequestMapping("/clearCache")
	public String clearCache(Model model) {
		System.out.println("Cleaning System Cache...");
		for(String name:cachemanager.getCacheNames()) {
			cachemanager.getCache(name).clear();
		}
		System.out.println("Sucessfully Cleared System Cache...");
		String msg="Sucessfully Cleared System Cache...";
		model.addAttribute("msg",msg);
		return ("redirect:/");
	}
}
