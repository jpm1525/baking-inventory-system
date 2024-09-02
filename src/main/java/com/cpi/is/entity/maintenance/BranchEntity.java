package com.cpi.is.entity.maintenance;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="QKC_BRANCH")
public class BranchEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id 
	@Column(name="branch_id") 
	private Long branchId;
	@Column(name="branch_name")
	private String branchName;
	@Column(name="create_date", insertable = false, updatable = false)
	private Date createDate;
	@Column(name="update_date", insertable = false, updatable = false)
	private Date updateDate;

	public BranchEntity() {
		super();
	}

	public BranchEntity(Long branchId, String branchName) {
		super();
		this.branchId = branchId;
		this.branchName = branchName;
	}

	public Long getBranchId() {
		return branchId;
	}

	public void setBranchId(Long branchId) {
		this.branchId = branchId;
	}

	public String getBranchName() {
		return branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public Date getUpdateDate() {
		return updateDate;
	}
	
}