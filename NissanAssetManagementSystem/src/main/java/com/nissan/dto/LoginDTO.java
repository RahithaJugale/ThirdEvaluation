package com.nissan.dto;

public class LoginDTO {
	
	private String username;
	private String password;
	private String userType;
	private String firstName;
	private String lastName;
	private Integer age;
	private String gender;
	private String address;
	private Long phoneNumber;
	
	
	public LoginDTO() {

	}
	public LoginDTO(String username, String password, String userType, String firstName, String lastName, Integer age,
			String gender, String address, Long phoneNumber) {
		super();
		this.username = username;
		this.password = password;
		this.userType = userType;
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.gender = gender;
		this.address = address;
		this.phoneNumber = phoneNumber;
	}
	//getters and setters
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Long getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(Long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	@Override
	public String toString() {
		return "LoginDTO [username=" + username + ", password=" + password + ", userType=" + userType + ", firstName="
				+ firstName + ", lastName=" + lastName + ", age=" + age + ", gender=" + gender + ", address=" + address
				+ ", phoneNumber=" + phoneNumber + "]";
	}
	
	
}
