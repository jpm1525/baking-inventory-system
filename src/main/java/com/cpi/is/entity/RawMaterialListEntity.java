package com.cpi.is.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

import java.util.Date;

import com.cpi.is.entity.maintenance.BranchEntity;
import com.cpi.is.entity.maintenance.MaterialCodeEntity;

@Entity
@Table(name = "qkc_raw_material_list")
public class RawMaterialListEntity {

	@Id
	@Column(name = "MATERIAL_LIST_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long materialListId;
	@Column(name = "MATERIAL_CD")
	private String materialCd;
	private Long quantity;
	@Column(name = "USER_ID")
	private Long userId;
	@Column(name = "DATE_RECEIVE")
	@Temporal(TemporalType.DATE)
	private Date dateReceive;
	@Column(name = "BRANCH_ID")
	private Long branchId;

	@ManyToOne
	@JoinColumn(name = "MATERIAL_CD", insertable = false, updatable = false)
	private MaterialCodeEntity materialName;

	@ManyToOne
	@JoinColumn(name = "BRANCH_ID", insertable = false, updatable = false)
	private BranchEntity branch;

	public RawMaterialListEntity() {
		super();
	}

	public RawMaterialListEntity(Long materialListId, String materialCd, Long quantity, Long userId, Date dateReceive,
			Long branchId) {
		super();
		this.materialListId = materialListId;
		this.materialCd = materialCd;
		this.quantity = quantity;
		this.userId = userId;
		this.dateReceive = dateReceive;
		this.branchId = branchId;
	}

	// Getters and Setters

	public Long getMaterialListId() {
		return materialListId;
	}

	public void setMaterialListId(Long materialListId) {
		this.materialListId = materialListId;
	}

	public String getMaterialCd() {
		return materialCd;
	}

	public void setMaterialCd(String materialCd) {
		this.materialCd = materialCd;
	}

	public Long getQuantity() {
		return quantity;
	}

	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Date getDateReceive() {
		return dateReceive;
	}

	public void setDateReceive(Date dateReceive) {
		this.dateReceive = dateReceive;
	}

	public Long getBranchId() {
		return branchId;
	}

	public void setBranchId(Long branchId) {
		this.branchId = branchId;
	}

	public MaterialCodeEntity getMaterialName() {
		return materialName;
	}

	public void setMaterialName(MaterialCodeEntity materialName) {
		this.materialName = materialName;
	}

	public BranchEntity getBranch() {
		return branch;
	}

	public void setBranch(BranchEntity branch) {
		this.branch = branch;
	}

	@Override
	public String toString() {
		return "RawMaterialListEntity [materialListId=" + materialListId + ", materialCd=" + materialCd + ", quantity="
				+ quantity + ", userId=" + userId + ", dateReceive=" + dateReceive + ", branchId=" + branchId + "]";
	}

}
