package com.pas.testuser.service;

import java.util.List;
import java.util.Optional;

import com.pas.testuser.model.User;

public interface UserServices {

	public void saveUser(User user);
	
	public User GetUserDetails(int id);
	
	public User GetUserDetailsByUsername(String username);
	
	public List<User> GetUserByDepartment(String department);

	public List<User> getAllUsersSortedByDepartment();
	
	public void deleteUser(int id);
	
	public void updateUser(User user);
	
	public List<User> getAllUsersGreaterThan(int id);
}
