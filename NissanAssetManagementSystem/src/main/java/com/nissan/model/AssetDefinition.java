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
public class AssetDefinition {
	
	//instance variables
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer adId;
	
	@Column(nullable=false)
	private String adName;
	private Integer adTypeId;
	private String adClass;
	
	@JoinColumn(name="atId", insertable=false, updatable=false)
	@ManyToOne
	private AssetType assetType;

	private Boolean isActive;

	@Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
	private DateTime createdAt;

	@Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
	private DateTime updatedAt;

	//default constructor
	public AssetDefinition() {

	}

	//parameterized constructor
	public AssetDefinition(Integer adId, String adName, Integer adTypeId, String adClass, AssetType assetType,
			Boolean isActive, DateTime createdAt, DateTime updatedAt) {
		super();
		this.adId = adId;
		this.adName = adName;
		this.adTypeId = adTypeId;
		this.adClass = adClass;
		this.assetType = assetType;
		this.isActive = isActive;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

	public AssetDefinition(Integer adId, String adName, Integer adTypeId, String adClass, Boolean isActive,
			DateTime createdAt, DateTime updatedAt) {
		super();
		this.adId = adId;
		this.adName = adName;
		this.adTypeId = adTypeId;
		this.adClass = adClass;
		this.isActive = isActive;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

	//getters and setters
	public Integer getAdId() {
		return adId;
	}

	public void setAdId(Integer adId) {
		this.adId = adId;
	}

	public String getAdName() {
		return adName;
	}

	public void setAdName(String adName) {
		this.adName = adName;
	}

	public Integer getAdTypeId() {
		return adTypeId;
	}

	public void setAdTypeId(Integer adTypeId) {
		this.adTypeId = adTypeId;
	}

	public String getAdClass() {
		return adClass;
	}

	public void setAdClass(String adClass) {
		this.adClass = adClass;
	}

	public AssetType getAssetType() {
		return assetType;
	}

	public void setAssetType(AssetType assetType) {
		this.assetType = assetType;
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
		return "AssetDefinition [adId=" + adId + ", adName=" + adName + ", adTypeId=" + adTypeId + ", adClass="
				+ adClass + ", assetType=" + assetType + ", isActive=" + isActive + ", createdAt=" + createdAt
				+ ", updatedAt=" + updatedAt + "]";
	}
}
