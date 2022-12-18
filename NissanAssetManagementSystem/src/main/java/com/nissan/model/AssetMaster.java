package com.nissan.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PostPersist;
import javax.persistence.PrePersist;

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

@Entity
public class AssetMaster {

	//instance variables
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer amId;
	
	@Column(nullable=false)
	private Integer atId;
	
	@Column(nullable=false)
	private Integer adId;
	
	@Column(nullable=false)
	private Integer vdId;
	private String amModel;
	private String amSnumber;
	private String amMyyear;
	private String amPdate;
	private Boolean amWarranty;
	private String amFrom;
	private String amTo;
	
	@OneToOne
	private AssetType assetType;

	@OneToOne
	private AssetDefinition assetDefinition;

	@OneToOne
	private Vendor vendor;

	private Boolean isActive;

	@Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
	private DateTime createdAt;

	@Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
	private DateTime updatedAt;

	//default constructor
	public AssetMaster() {

	}

	//parameterized constructor
	public AssetMaster(Integer amId, Integer atId, Integer adId, Integer vdId, String amModel, String amSnumber,
			String amMyyear, String amPdate, Boolean amWarranty, String amFrom, String amTo, Boolean isActive,
			DateTime createdAt, DateTime updatedAt) {
		super();
		this.amId = amId;
		this.atId = atId;
		this.adId = adId;
		this.vdId = vdId;
		this.amModel = amModel;
		this.amSnumber = amSnumber;
		this.amMyyear = amMyyear;
		this.amPdate = amPdate;
		this.amWarranty = amWarranty;
		this.amFrom = amFrom;
		this.amTo = amTo;
		this.isActive = isActive;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

	public AssetMaster(Integer amId, Integer atId, Integer adId, Integer vdId, String amModel, String amSnumber,
			String amMyyear, String amPdate, Boolean amWarranty, String amFrom, String amTo, AssetType assetType,
			AssetDefinition assetDefinition, Vendor vendor, Boolean isActive, DateTime createdAt, DateTime updatedAt) {
		super();
		this.amId = amId;
		this.atId = atId;
		this.adId = adId;
		this.vdId = vdId;
		this.amModel = amModel;
		this.amSnumber = amSnumber;
		this.amMyyear = amMyyear;
		this.amPdate = amPdate;
		this.amWarranty = amWarranty;
		this.amFrom = amFrom;
		this.amTo = amTo;
		this.assetType = assetType;
		this.assetDefinition = assetDefinition;
		this.vendor = vendor;
		this.isActive = isActive;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

	//getters and setters
	public Integer getAmId() {
		return amId;
	}

	public void setAmId(Integer amId) {
		this.amId = amId;
	}

	public Integer getAtId() {
		return atId;
	}

	public void setAtId(Integer atId) {
		this.atId = atId;
	}

	public Integer getAdId() {
		return adId;
	}

	public void setAdId(Integer adId) {
		this.adId = adId;
	}

	public Integer getVdId() {
		return vdId;
	}

	public void setVdId(Integer vdId) {
		this.vdId = vdId;
	}

	public String getAmModel() {
		return amModel;
	}

	public void setAmModel(String amModel) {
		this.amModel = amModel;
	}

	public String getAmSnumber() {
		return amSnumber;
	}

	public void setAmSnumber(String amSnumber) {
		this.amSnumber = amSnumber;
	}

	public String getAmMyyear() {
		return amMyyear;
	}

	public void setAmMyyear(String amMyyear) {
		this.amMyyear = amMyyear;
	}

	public String getAmPdate() {
		return amPdate;
	}

	public void setAmPdate(String amPdate) {
		this.amPdate = amPdate;
	}

	public Boolean getAmWarranty() {
		return amWarranty;
	}

	public void setAmWarranty(Boolean amWarranty) {
		this.amWarranty = amWarranty;
	}

	public String getAmFrom() {
		return amFrom;
	}

	public void setAmFrom(String amFrom) {
		this.amFrom = amFrom;
	}

	public String getAmTo() {
		return amTo;
	}

	public void setAmTo(String amTo) {
		this.amTo = amTo;
	}

	public AssetType getAssetType() {
		return assetType;
	}

	public void setAssetType(AssetType assetType) {
		this.assetType = assetType;
	}

	public AssetDefinition getAssetDefinition() {
		return assetDefinition;
	}

	public void setAssetDefinition(AssetDefinition assetDefinition) {
		this.assetDefinition = assetDefinition;
	}

	public Vendor getVendor() {
		return vendor;
	}

	public void setVendor(Vendor vendor) {
		this.vendor = vendor;
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
		return "AssetMaster [amId=" + amId + ", atId=" + atId + ", adId=" + adId + ", vdId=" + vdId + ", amModel="
				+ amModel + ", amSnumber=" + amSnumber + ", amMyyear=" + amMyyear + ", amPdate=" + amPdate
				+ ", amWarranty=" + amWarranty + ", amFrom=" + amFrom + ", amTo=" + amTo + ", assetType=" + assetType
				+ ", assetDefinition=" + assetDefinition + ", vendor=" + vendor + ", isActive=" + isActive
				+ ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + "]";
	}
}
