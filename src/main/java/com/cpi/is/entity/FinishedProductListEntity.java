package com.cpi.is.entity;

import java.io.Serializable;

import java.util.Date; // Import Date

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
@Table(name = "QKC_FINISHED_PRODUCT_LIST")
public class FinishedProductListEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "FPL_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long fplId;

	@Column(name = "SKU_Cd")
	private String skuCd;

	@Column(name = "QUANTITY")
	private Long quantity;

	@Column(name = "BRANCH_ID")
	private Long branchId;

	@Column(name = "DATE_FINISHED")
	@Temporal(TemporalType.DATE)
	private Date dateFinished;

	@ManyToOne
	@JoinColumn(name = "SKU_Cd", insertable = false, updatable = false)
	private SkuCodeEntity sku;

	@ManyToOne
	@JoinColumn(name = "BRANCH_ID", insertable = false, updatable = false)
	private BranchEntity branch;

	public FinishedProductListEntity() {
		super();
	}

	public FinishedProductListEntity(Long fplId, String skuCd, Long quantity, Long branchId, Date dateFinished) {
		super();
		this.fplId = fplId;
		this.skuCd = skuCd;
		this.quantity = quantity;
		this.branchId = branchId;
		this.dateFinished = dateFinished;
	}

	public Long getFplId() {
		return fplId;
	}

	public void setFplId(Long fplId) {
		this.fplId = fplId;
	}

	public String getSkuCd() {
		return skuCd;
	}

	public void setSkuCd(String skuCd) {
		this.skuCd = skuCd;
	}

	public Long getQuantity() {
		return quantity;
	}

	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}

	public Long getBranchId() {
		return branchId;
	}

	public void setBranchId(Long branchId) {
		this.branchId = branchId;
	}

	public Date getDateFinished() {
		return dateFinished;
	}

	public void setDateFinished(Date dateFinished) {
		this.dateFinished = dateFinished;
	}

	public SkuCodeEntity getSku() {
		return sku;
	}

	public void setSku(SkuCodeEntity sku) {
		this.sku = sku;
	}

	public BranchEntity getBranch() {
		return branch;
	}

	public void setBranch(BranchEntity branch) {
		this.branch = branch;
	}

	@Override
	public String toString() {
		return "FinishedProductListEntity{" + "fplId=" + fplId + ", skuCd='" + skuCd + '\'' + ", quantity=" + quantity
				+ ", branchId=" + branchId + ", dateFinished=" + dateFinished + '}';
	}
}