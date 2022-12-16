package com.nissan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nissan.dto.LoginDTO;
import com.nissan.model.Login;
import com.nissan.service.ILoginService;

@RestController
@RequestMapping("api/")
public class LoginController {
	
	@Autowired
	ILoginService loginService;
	
	//add new login
	@PostMapping("logins")
	public Login addNewLoginDetails(@PathVariable Login login) {
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
	
	//public ResponseEntity<String> login (@RequestBody LoginDTO _loginDTO)

}
