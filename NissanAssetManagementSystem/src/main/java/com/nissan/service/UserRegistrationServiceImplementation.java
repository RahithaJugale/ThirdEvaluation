package com.nissan.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nissan.common.InvalidEntryException;
import com.nissan.common.Validation;
import com.nissan.dto.LoginDTO;
import com.nissan.model.Login;
import com.nissan.model.UserRegistration;
import com.nissan.repo.ILoginRepository;
import com.nissan.repo.IUserRegistrationRepository;

@Service
public class UserRegistrationServiceImplementation implements IUserRegistrationService {

	@Autowired
	IUserRegistrationRepository userRegistrationRepository;

	@Autowired
	ILoginRepository loginRepository;

	public Validation validation = new Validation();

	// add new user
	@Override
	@Transactional
	public LoginDTO addNewUser(LoginDTO loginDTO) {
		System.out.println(loginDTO.getUsername());
		Login login = new Login();
		login.setUsername(loginDTO.getUsername());
		login.setPassword(loginDTO.getPassword());
		login.setIsActive(true);
		login.setUserType(loginDTO.getUserType());
		loginRepository.save(login);
		Integer flag = 1;
		// while(flag != 0) {
		if (!validation.isNameValid(loginDTO.getFirstName())) {
			flag = 0;
			// break;
		}
		if (!validation.isNameValid(loginDTO.getLastName())) {
			flag = 0;
			// break;
		}
		if (!validation.isAgeValid(loginDTO.getAge())) {
			flag = 0;
			// break;
		}
		if (!validation.isPhoneValid(loginDTO.getPhoneNumber())) {
			flag = 0;
			// break;
		}
		// }

		if (flag == 0) {
			System.out.println("khsdbfs");
			throw new InvalidEntryException("Invalid entry");
		} else {
			UserRegistration userRegistration = new UserRegistration();
			userRegistration.setFirstName(loginDTO.getFirstName());
			userRegistration.setLastName(loginDTO.getLastName());
			userRegistration.setAge(loginDTO.getAge());
			userRegistration.setPhoneNumber(loginDTO.getPhoneNumber());
			userRegistration.setGender(loginDTO.getGender());
			userRegistration.setAddress(loginDTO.getAddress());
			userRegistration.setIsActive(true);
			userRegistration.setlId(login.getlId());
			userRegistrationRepository.save(userRegistration);
		}
		return loginDTO;
	}

	// update an existing user by ID
	@Override
	@Transactional
	public UserRegistration updateUser(Integer _uId, UserRegistration userRegistration) {
		UserRegistration user = userRegistrationRepository.findById(_uId).get();
		Integer flag = 1;
		//while (flag != 0) {
			if (validation.isNameValid(userRegistration.getFirstName())) {
				user.setFirstName(userRegistration.getFirstName());
			} else {
				flag = 0;
				//break;
			}
			if (!validation.isNameValid(userRegistration.getLastName())) {
				flag = 0;
				//break;
			} else {
				user.setLastName(userRegistration.getLastName());
			}
			if (!validation.isAgeValid(userRegistration.getAge())) {
				flag = 0;
				//break;
			} else {
				user.setAge(userRegistration.getAge());
			}
			if (!validation.isPhoneValid(userRegistration.getPhoneNumber())) {
				flag = 0;
				//break;
			} else {
				user.setPhoneNumber(userRegistration.getPhoneNumber());
			}
		//}
		if (flag == 0) {
			throw new InvalidEntryException("Invalid entry");
		} else
			return userRegistrationRepository.save(userRegistration);
	}

	// list all users
	@Override
	public List<UserRegistration> listAllUsers() {
		return userRegistrationRepository.findAll();
	}

	// delete user by ID
	@Override
	@Transactional
	public UserRegistration deleteUser(Integer _uId) {
		UserRegistration user = userRegistrationRepository.findById(_uId).get();
		user.setIsActive(false);
		return userRegistrationRepository.save(user);
	}

	// search user by ID
	@Override
	public UserRegistration searchUserById(Integer _uId) {
		return userRegistrationRepository.findById(_uId).get();
	}

}
