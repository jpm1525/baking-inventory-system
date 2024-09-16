package com.cpi.is.entity;

import java.util.Date;

import com.cpi.is.entity.maintenance.BranchEntity;
import com.cpi.is.entity.maintenance.SkuCodeEntity;

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

@Entity
@Table(name = "QKC_DAILY_PLANNED_PRODUCTION")

public class DailyPlanEntity {

	@Id
	@Column(name = "DPP_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer dppId;
	@Column(name = "PRODUCTION_DATE")
	@Temporal(TemporalType.DATE)
	private Date productionDate;
	@Column(name = "BRANCH_ID")
	private Integer branchId;
	@Column(name = "SKU_CD")
	private String skuCd;
	private Integer quantity;
	private String status;

	@ManyToOne
	@JoinColumn(name = "SKU_CD", insertable = false, updatable = false)
	private SkuCodeEntity skuName;

	@ManyToOne
	@JoinColumn(name = "BRANCH_ID", insertable = false, updatable = false)
	private BranchEntity branch;

	public DailyPlanEntity() {
		super();
	}

	public DailyPlanEntity(Integer dppId, Date productionDate, Integer branchId, String skuCd, Integer quantity,
			String status) {
		super();
		this.dppId = dppId;
		this.productionDate = productionDate;
		this.branchId = branchId;
		this.skuCd = skuCd;
		this.quantity = quantity;
		this.status = status;
	}

	public Integer getDppId() {
		return dppId;
	}

	public void setDppId(Integer dppId) {
		this.dppId = dppId;
	}

	public Date getProductionDate() {
		return productionDate;
	}

	public void setProductionDate(Date productionDate) {
		this.productionDate = productionDate;
	}

	public Integer getBranchId() {
		return branchId;
	}

	public void setBranchId(Integer branchId) {
		this.branchId = branchId;
	}

	public String getSkuCd() {
		return skuCd;
	}

	public void setSkuCd(String skuCd) {
		this.skuCd = skuCd;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public SkuCodeEntity getSkuName() {
		return skuName;
	}

	public void setSkuName(SkuCodeEntity skuName) {
		this.skuName = skuName;
	}

	public BranchEntity getBranch() {
		return branch;
	}

	public void setBranch(BranchEntity branch) {
		this.branch = branch;
	}

	@Override
	public String toString() {
		return "DailyPlanEntity [dppId=" + dppId + ", productionDate=" + productionDate + ", branchId=" + branchId
				+ ", skuCd=" + skuCd + ", quantity=" + quantity + ", status=" + status + "]";
	}

}
