package com.pas.testuser.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pas.testuser.model.User;
import com.pas.testuser.repository.UserRepository;

@Service
public class UserServicesImpl implements UserServices {
	
	@Autowired
	UserRepository userrepo;
	
	@Override
	public void saveUser(User user) {
		// TODO Auto-generated method stub
		userrepo.save(user);
	}

	@Override
	public User GetUserDetails(int id) {
		// TODO Auto-generated method stub
		return userrepo.findById(id).get();
		
	}

	@Override
	public User GetUserDetailsByUsername(String username) {
		// TODO Auto-generated method stub
		return userrepo.findByUsername(username).get(0);
	}

	@Override
	public List<User> GetUserByDepartment(String department) {
		// TODO Auto-generated method stub
		List<User> users=new ArrayList<User>();
		users=userrepo.findByDepartment(department);
		return users;
	}

	@Override
	public List<User> getAllUsersSortedByDepartment() {
		// TODO Auto-generated method stub
		List<User> users=new ArrayList<User>();
		userrepo.findAllByOrderByDepartment().forEach(users1->users.add(users1));;
		return users;
	}

	@Override
	public void deleteUser(int id) {
		// TODO Auto-generated method stub
		userrepo.deleteById(id);
	}

	@Override
	public void updateUser(User user) {
		// TODO Auto-generated method stub
		userrepo.save(user);
	}

	@Override
	public List<User> getAllUsersGreaterThan(int id) {
		// TODO Auto-generated method stub
		List<User> users=new ArrayList<User>();
		users=userrepo.findByIdGreaterThan(id);
		return users;
	}

	@Override
	public List<User> getAllUsersSortedById() {
		// TODO Auto-generated method stub
		List<User> users=new ArrayList<User>();
		userrepo.findAllByOrderById().forEach(users1->users.add(users1));;
		return users;
	}
	
}
