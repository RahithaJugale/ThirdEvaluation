package com.nissan.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.PostPersist;
import javax.persistence.PrePersist;

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

@Entity
public class Vendor {

	//instance variable
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer vdId;
	
	@Column(nullable=false)
	private String vdName;
	private String vdType;
	private Integer vdAtypeId;
	private String vdFrom;
	private String vdTo;
	private String vdAddress;
	
	@JoinColumn(name="adId", insertable=false, updatable=false)
	@OneToMany
	private List<AssetType> assetType;
	
	private Boolean isActive;

	@Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
	private DateTime createdAt;

	@Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
	private DateTime updatedAt;

	//default constructor
	public Vendor() {

	}

	//parameterized constructor
	public Vendor(Integer vdId, String vdName, String vdType, Integer vdAtypeId, String vdFrom, String vdTo,
			String vdAddress, List<AssetType> assetType, Boolean isActive, DateTime createdAt, DateTime updatedAt) {
		super();
		this.vdId = vdId;
		this.vdName = vdName;
		this.vdType = vdType;
		this.vdAtypeId = vdAtypeId;
		this.vdFrom = vdFrom;
		this.vdTo = vdTo;
		this.vdAddress = vdAddress;
		this.assetType = assetType;
		this.isActive = isActive;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

	public Vendor(Integer vdId, String vdName, String vdType, Integer vdAtypeId, String vdFrom, String vdTo,
			String vdAddress, Boolean isActive, DateTime createdAt, DateTime updatedAt) {
		super();
		this.vdId = vdId;
		this.vdName = vdName;
		this.vdType = vdType;
		this.vdAtypeId = vdAtypeId;
		this.vdFrom = vdFrom;
		this.vdTo = vdTo;
		this.vdAddress = vdAddress;
		this.isActive = isActive;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

	//getters and setters
	public Integer getVdId() {
		return vdId;
	}

	public void setVdId(Integer vdId) {
		this.vdId = vdId;
	}

	public String getVdName() {
		return vdName;
	}

	public void setVdName(String vdName) {
		this.vdName = vdName;
	}

	public String getVdType() {
		return vdType;
	}

	public void setVdType(String vdType) {
		this.vdType = vdType;
	}

	public Integer getVdAtypeId() {
		return vdAtypeId;
	}

	public void setVdAtypeId(Integer vdAtypeId) {
		this.vdAtypeId = vdAtypeId;
	}

	public String getVdFrom() {
		return vdFrom;
	}

	public void setVdFrom(String vdFrom) {
		this.vdFrom = vdFrom;
	}

	public String getVdTo() {
		return vdTo;
	}

	public void setVdTo(String vdTo) {
		this.vdTo = vdTo;
	}

	public String getVdAddress() {
		return vdAddress;
	}

	public void setVdAddress(String vdAddress) {
		this.vdAddress = vdAddress;
	}

	public List<AssetType> getAssetType() {
		return assetType;
	}

	public void setAssetType(List<AssetType> assetType) {
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
		return "Vendor [vdId=" + vdId + ", vdName=" + vdName + ", vdType=" + vdType + ", vdAtypeId=" + vdAtypeId
				+ ", vdFrom=" + vdFrom + ", vdTo=" + vdTo + ", vdAddress=" + vdAddress + ", assetType=" + assetType
				+ ", isActive=" + isActive + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + "]";
	}

}
