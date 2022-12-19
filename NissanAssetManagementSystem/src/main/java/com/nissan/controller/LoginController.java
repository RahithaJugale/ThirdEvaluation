package com.nissan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.nissan.common.APIResponse;
import com.nissan.dto.LoginAfterRegistrationDTO;
import com.nissan.dto.LoginDTO;
import com.nissan.model.Login;
import com.nissan.model.UserRegistration;
import com.nissan.service.ILoginService;
import com.nissan.service.IUserRegistrationService;

@RestController
@RequestMapping("api/")
public class LoginController {
	
	@Autowired
	ILoginService loginService;
	
	@Autowired
	IUserRegistrationService userRegistrationService;
	
	//add new login
	@PostMapping("logins")
	public Login addNewLoginDetails(@RequestBody Login login) {
		return loginService.addNewLoginDetails(login);
	}
	
	//update login details by login ID
	@PutMapping("logins/{_lId}")
	public Login updateByLoginId(@PathVariable Integer _lId, @RequestBody Login _login) {
		return loginService.updateByLoginId(_lId, _login);
	}
	
	//delete login
	@DeleteMapping("logins/{_lId}")
	public Login deleteByLoginId(@PathVariable Integer _lId) {
		return loginService.deleteByLoginId(_lId);
	}
	
	//list all logins
	@GetMapping("logins")
	public List<Login> viewAllLogins() {
		return loginService.viewAllLogins();
	}
	
	//search login
	@GetMapping("logins/{_lId}")
	public Login searchByLoginId(Integer _lId) {
		return loginService.searchByLoginId(_lId);
	}
	
	
	//------------------------------------------------------------------------------------------------------------------
	
	//add new user
	@PostMapping("userRegistrations")
	public LoginDTO addNewUser(@RequestBody LoginDTO loginDTO) {
		return userRegistrationService.addNewUser(loginDTO);
	}
	
	//update an existing user by ID
	@PutMapping("userRegistrations/{_uId}")
	public UserRegistration updateUser(@PathVariable Integer _uId, @RequestBody UserRegistration userRegistration) {
		return userRegistrationService.updateUser(_uId, userRegistration);
	}
	
	//list all users
	@GetMapping("userRegistrations")
	public List<UserRegistration> listAllUsers() {
		return userRegistrationService.listAllUsers();
	}
	
	//delete user by ID
	@DeleteMapping("userRegistrations/{_uId}")
	public UserRegistration deleteUser(@PathVariable Integer _uId) {
		return userRegistrationService.deleteUser(_uId);
	}
	
	//search user by ID
	@GetMapping("userRegistrations/{_uId}")
	public UserRegistration searchUserById(@PathVariable Integer _uId) {
		return userRegistrationService.searchUserById(_uId);
	}
	
	//------------------------------------------------------------------------------------------------------------------
	
	@GetMapping("login")
	@ResponseBody
	public APIResponse login (@RequestBody LoginAfterRegistrationDTO _loginAfterRegistrationDTO){
		return loginService.login(_loginAfterRegistrationDTO);
	}

	
}
