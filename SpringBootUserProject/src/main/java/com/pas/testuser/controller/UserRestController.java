package com.pas.testuser.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pas.testuser.model.User;
import com.pas.testuser.service.UserServices;

@RestController
public class UserRestController {

	@Autowired
	CacheManager cachemanager;
	
	@Autowired
	UserServices userServices;
	
	@PostMapping("/postUser")
	private int saveUserByService(@RequestBody User user) {
		userServices.saveUser(user);
		return user.getId();
	}
	
	@GetMapping("/getUserById/{id}")
	private User getUserByService(@PathVariable ("id") int id) {
		return userServices.GetUserDetails(id);
	}
	
	@GetMapping("/getUserByUsername/{username}")
	private User getUserByUsernameService(@PathVariable ("username") String username) {
		return userServices.GetUserDetailsByUsername(username);
	}
	
	@GetMapping("/getUserByDepartment/{department}") 
	private Optional<List<User>> getUserByDepartmentService(@PathVariable ("department") String department){
		return Optional.ofNullable(userServices.GetUserByDepartment(department));
	}
	
	@GetMapping("/getAllUsersSortedByDept")
	private List<User> getAllUsersSortedByDeptService(){
		return userServices.getAllUsersSortedByDepartment();
	}
	
	@DeleteMapping("/deleteUserDetails/{id}")
	private void deleteUserDetails(@PathVariable ("id") int id) {
		userServices.deleteUser(id);
	}
	
	@PutMapping("/updateUserDetails")
	private void updateUserDetails(@RequestBody User user) {
		userServices.saveUser(user);
	}
	
	@GetMapping("/getAllUserIdGreaterThan/{id}")
	private List<User> getAllUserIdGreaterThan(@PathVariable ("id") int id){
		return userServices.getAllUsersGreaterThan(id);
	}
	
	/* Clear Cache Data by calling below method */
	@GetMapping("/clearCache")
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
