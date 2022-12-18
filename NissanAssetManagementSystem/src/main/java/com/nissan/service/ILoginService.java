package com.nissan.service;

import java.util.List;

import com.nissan.common.APIResponse;
import com.nissan.dto.LoginDTO;
import com.nissan.model.Login;

public interface ILoginService {
	
	//add new login
	Login addNewLoginDetails(Login login);
	
	//update login details by login ID
	Login updateByLoginId(Integer _lId, Login _login);

	//delete login
	Login deleteByLoginId(Integer _lId);
	
	//list all logins
	List<Login> viewAllLogins();
	
	//search login
	Login searchByLoginId(Integer _lId);
	
	//check if username and password is correct
	public APIResponse login(LoginDTO _loginDTO);
}
