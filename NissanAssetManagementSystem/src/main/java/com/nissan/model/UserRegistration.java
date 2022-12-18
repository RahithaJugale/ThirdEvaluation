package com.nissan.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PostPersist;
import javax.persistence.PrePersist;

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

@Entity
public class UserRegistration {

	//instance variables
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer uId;
	
	@Column(nullable=false)
	private String firstName;
	private String lastName;
	
	@Column(nullable=false)
	private Integer age;
	private String gender;
	private String address;
	
	@Column(nullable=false)
	private Long phoneNumber;
	private Integer lId;
	
	private Boolean isActive;
	
	@Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
	private DateTime createdAt;
	
	@Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
	private DateTime updatedAt;
	
	@JoinColumn(name="lId", insertable=false, updatable=false)
	@ManyToOne
	private Login login;

	//default constructor
	public UserRegistration() {

	}

	//parameterized constructor
	public UserRegistration(String firstName, String lastName, Integer age, String gender, String address,
			Long phoneNumber, Integer lId, Boolean isActive) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.gender = gender;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.lId = lId;
		this.isActive = isActive;
	}
	public UserRegistration(Integer uId, String firstName, String lastName, Integer age, String gender, String address,
			Long phoneNumber, Integer lId, Boolean isActive, DateTime createdAt, DateTime updatedAt, Login login) {
		super();
		this.uId = uId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.gender = gender;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.lId = lId;
		this.isActive = isActive;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.login = login;
	}

	public UserRegistration(Integer uId, String firstName, String lastName, Integer age, String gender, String address,
			Long phoneNumber, Integer lId, Boolean isActive, DateTime createdAt, DateTime updatedAt) {
		super();
		this.uId = uId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.gender = gender;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.lId = lId;
		this.isActive = isActive;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}
	


	//getters and setters
	public Integer getuId() {
		return uId;
	}

	public void setuId(Integer uId) {
		this.uId = uId;
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

	public Integer getlId() {
		return lId;
	}

	public void setlId(Integer lId) {
		this.lId = lId;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public DateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(DateTime createdAt) {
		this.createdAt = createdAt;
	}

	public DateTime getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(DateTime updatedAt) {
		this.updatedAt = updatedAt;
	}

	public Login getLogin() {
		return login;
	}

	public void setLogin(Login login) {
		this.login = login;
	}
	
	@PrePersist
	public void onSave() {
		DateTime dateTime = new DateTime();
		this.createdAt = dateTime;
		this.updatedAt = dateTime;
	}
	
	@PostPersist
	public void onUpdate() {
		DateTime dateTime = new DateTime();
		this.updatedAt = dateTime;
	}

	//toString()
	@Override
	public String toString() {
		return "UserRegistration [uId=" + uId + ", firstName=" + firstName + ", lastName=" + lastName + ", age=" + age
				+ ", gender=" + gender + ", address=" + address + ", phoneNumber=" + phoneNumber + ", lId=" + lId
				+ ", isActive=" + isActive + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + ", login="
				+ login + "]";
	}

}
