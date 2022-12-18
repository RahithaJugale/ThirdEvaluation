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
public class PurchaseOrder {

	// instance variables
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer pdId;
	private String pdOrderNo;

	@Column(nullable = false)
	private Integer adId;

	@Column(nullable = false)
	private Integer atId;
	private Integer pdQty;

	@Column(nullable = false)
	private Integer vdId;
	private String pdDate;
	private String pdDeliveryDate;
	private String status;

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

	// default constructor
	public PurchaseOrder() {

	}

	//parameterized constructor
	public PurchaseOrder(Integer pdId, String pdOrderNo, Integer adId, Integer atId, Integer pdQty, Integer vdId,
			String pdDate, String pdDeliveryDate, String status, Boolean isActive, DateTime createdAt,
			DateTime updatedAt) {
		super();
		this.pdId = pdId;
		this.pdOrderNo = pdOrderNo;
		this.adId = adId;
		this.atId = atId;
		this.pdQty = pdQty;
		this.vdId = vdId;
		this.pdDate = pdDate;
		this.pdDeliveryDate = pdDeliveryDate;
		this.status = status;
		this.isActive = isActive;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

	public PurchaseOrder(Integer pdId, String pdOrderNo, Integer adId, Integer atId, Integer pdQty, Integer vdId,
			String pdDate, String pdDeliveryDate, String status, AssetType assetType, AssetDefinition assetDefinition,
			Vendor vendor, Boolean isActive, DateTime createdAt, DateTime updatedAt) {
		super();
		this.pdId = pdId;
		this.pdOrderNo = pdOrderNo;
		this.adId = adId;
		this.atId = atId;
		this.pdQty = pdQty;
		this.vdId = vdId;
		this.pdDate = pdDate;
		this.pdDeliveryDate = pdDeliveryDate;
		this.status = status;
		this.assetType = assetType;
		this.assetDefinition = assetDefinition;
		this.vendor = vendor;
		this.isActive = isActive;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

	//getters and setters
	public Integer getPdId() {
		return pdId;
	}

	public void setPdId(Integer pdId) {
		this.pdId = pdId;
	}

	public String getPdOrderNo() {
		return pdOrderNo;
	}

	public void setPdOrderNo(String pdOrderNo) {
		this.pdOrderNo = pdOrderNo;
	}

	public Integer getAdId() {
		return adId;
	}

	public void setAdId(Integer adId) {
		this.adId = adId;
	}

	public Integer getAtId() {
		return atId;
	}

	public void setAtId(Integer atId) {
		this.atId = atId;
	}

	public Integer getPdQty() {
		return pdQty;
	}

	public void setPdQty(Integer pdQty) {
		this.pdQty = pdQty;
	}

	public Integer getVdId() {
		return vdId;
	}

	public void setVdId(Integer vdId) {
		this.vdId = vdId;
	}

	public String getPdDate() {
		return pdDate;
	}

	public void setPdDate(String pdDate) {
		this.pdDate = pdDate;
	}

	public String getPdDeliveryDate() {
		return pdDeliveryDate;
	}

	public void setPdDeliveryDate(String pdDeliveryDate) {
		this.pdDeliveryDate = pdDeliveryDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
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
		return "PurchaseOrder [pdId=" + pdId + ", pdOrderNo=" + pdOrderNo + ", adId=" + adId + ", atId=" + atId
				+ ", pdQty=" + pdQty + ", vdId=" + vdId + ", pdDate=" + pdDate + ", pdDeliveryDate=" + pdDeliveryDate
				+ ", status=" + status + ", assetType=" + assetType + ", assetDefinition=" + assetDefinition
				+ ", vendor=" + vendor + ", isActive=" + isActive + ", createdAt=" + createdAt + ", updatedAt="
				+ updatedAt + "]";
	}
}
