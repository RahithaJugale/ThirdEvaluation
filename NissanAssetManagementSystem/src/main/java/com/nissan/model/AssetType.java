package com.nissan.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PostPersist;
import javax.persistence.PrePersist;

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

@Entity
public class AssetType {
	
	//instance variables
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer atId;
	
	@Column(nullable=false)
	private String atName;
	
	private Boolean isActive;
	
	@Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
	private DateTime createdAt;
	
	@Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
	private DateTime updatedAt;

	//default constructor
	public AssetType() {

	}

	//parameterized constructor
	public AssetType(Integer atId, String atName, Boolean isActive, DateTime createdAt, DateTime updatedAt) {
		super();
		this.atId = atId;
		this.atName = atName;
		this.isActive = isActive;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

	//getters and setters
	public Integer getAtId() {
		return atId;
	}

	public void setAtId(Integer atId) {
		this.atId = atId;
	}

	public String getAtName() {
		return atName;
	}

	public void setAtName(String atName) {
		this.atName = atName;
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
		return "AssetType [atId=" + atId + ", atName=" + atName + ", isActive=" + isActive + ", createdAt=" + createdAt
				+ ", updatedAt=" + updatedAt + "]";
	}

}
