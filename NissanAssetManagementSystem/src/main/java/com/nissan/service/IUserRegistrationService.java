package com.nissan.service;

import java.util.List;

import com.nissan.model.UserRegistration;

public interface IUserRegistrationService {
	
	//add new user
	UserRegistration addNewUser(UserRegistration userRegistration);
	
	//update an existing user by ID
	UserRegistration updateUser(Integer _uId, UserRegistration userRegistration);
	
	//list all users
	List<UserRegistration> listAllUsers();
	
	//delete user by ID
	UserRegistration deleteUser(Integer _uId);
	
	//search user by ID
	UserRegistration searchUserById(Integer _uId);

}
