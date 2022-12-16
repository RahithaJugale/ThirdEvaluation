package com.nissan.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nissan.common.Validation;
import com.nissan.dto.LoginDTO;
import com.nissan.model.Login;
import com.nissan.repo.ILoginRepository;

@Service
public class LoginServiceImplementation implements ILoginService {

	@Autowired
	ILoginRepository loginRepository;
	

//	LoginDTO loginDTO;
	
	Validation validation = new Validation();
	
	//add new login
	@Override
	@Transactional
	public Login addNewLoginDetails(Login login) {
		if(validation.isNameValid(login.getUsername())) {
			return loginRepository.save(login);
		}
		return login;
	}

	//update login details by login ID
	@Override
	@Transactional
	public Login updateByLoginId(Integer _lId, Login _login) {
		try {
			Login login = loginRepository.findById(_lId).get();
			if(validation.isNameValid(login.getUsername())) {
				login.setUsername(_login.getUsername());
				login.setPassword(_login.getPassword());
				login.setIsActive(_login.getIsActive());
				return loginRepository.save(login);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return _login;
	}

	//delete login
	@Override
	@Transactional
	public Login deleteByLoginId(Integer _lId) {
		Login login = loginRepository.findById(_lId).get();
		login.setIsActive(false);
		return loginRepository.save(login);
	}

	//list all logins
	@Override
	public List<Login> viewAllLogins() {
		return loginRepository.findAll();
	}

	//search login
	@Override
	public Login searchByLoginId(Integer _lId) {
		return loginRepository.findById(_lId).get();
	}
	
	//public String login(LoginDTO _loginDTO) {
		//LoginDTO e
	//}

}
