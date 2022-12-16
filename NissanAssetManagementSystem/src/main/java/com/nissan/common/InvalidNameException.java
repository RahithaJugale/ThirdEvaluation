package com.nissan.common;

public class InvalidNameException extends Exception{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InvalidNameException(String message) {
		
		super(message);
		//System.out.println(message);
	}

}
