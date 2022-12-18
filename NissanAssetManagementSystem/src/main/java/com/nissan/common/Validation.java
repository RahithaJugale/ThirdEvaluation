package com.nissan.common;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validation {
	
	
	//name validations - > asset name, asset type name, vendor name, first name, last name
	public Boolean isNameValid(String name) {
		
		Boolean bool = false;
		try {
			Pattern namePattern = Pattern.compile("[^A-Za-z ]");
			Matcher nameMatcher = namePattern.matcher(name);
			
			if(nameMatcher.find()) {
				throw new InvalidNameException("Invalid name");
			}
			else
				bool = true;
			
			
		}catch(InvalidNameException e) {
			e.getMessage();
		}
		
		return bool;
	}
	
	//age validation
	public Boolean isAgeValid(Integer _age) {
		
		String age = _age.toString();
		Boolean bool = false;
		try {
			Pattern agePattern = Pattern.compile("[^0-9]");
			Matcher ageMatcher = agePattern.matcher(age);
			
			if(ageMatcher.find()) {
				throw new InvalidEntryException("Invalid entry");
			}
			else if(_age<18){
				bool = false;
			}else
				bool = true;
			
			
		}catch(InvalidEntryException e) {
			e.getMessage();
		}
		
		return bool;
	}
	
	//phone number validation
	public Boolean isPhoneValid(Long _phone) {
		
		String phone = _phone.toString();
		Boolean bool = false;
		try {
			Pattern phonePattern = Pattern.compile("[^0-9]");
			Matcher phoneMatcher = phonePattern.matcher(phone);
			
			if(phoneMatcher.find()) {
				throw new InvalidEntryException("Invalid entry");
			}else if(phone.length() > 10) {
				bool = false;
			}else if(phone.length() < 10) {
				bool = false;
			}else
				bool = true;
			
			
		}catch(InvalidEntryException e) {
			e.getMessage();
		}
		
		return bool;
	}

}
