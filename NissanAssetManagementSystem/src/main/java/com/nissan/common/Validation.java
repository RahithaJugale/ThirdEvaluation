package com.nissan.common;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validation {
	
	
	//name validations - > asset name, asset type name, vendor name
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

}
