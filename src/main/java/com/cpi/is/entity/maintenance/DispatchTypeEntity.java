package com.cpi.is.entity.maintenance;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "QKC_DISPATCH_TYPE")
public class DispatchTypeEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "dispatch_type_cd")
	private String dispatchTypeCd;
	@Column(name = "dispatch_type_name")
	private String dispatchTypeName;
	@Column(name = "create_date", insertable = false, updatable = false)
	private Date createDate;
	@Column(name = "update_date", insertable = false, updatable = false)
	private Date updateDate;

	public DispatchTypeEntity() {
		super();
	}

	public DispatchTypeEntity(String dispatchTypeCd, String dispatchTypeName) {
		super();
		this.dispatchTypeCd = dispatchTypeCd;
		this.dispatchTypeName = dispatchTypeName;
	}

	public String getDispatchTypeCd() {
		return dispatchTypeCd;
	}

	public void setDispatchTypeCd(String dispatchTypeCd) {
		this.dispatchTypeCd = dispatchTypeCd;
	}

	public String getDispatchTypeName() {
		return dispatchTypeName;
	}

	public void setDispatchTypeName(String dispatchTypeName) {
		this.dispatchTypeName = dispatchTypeName;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	@Override
	public String toString() {
		return "DispatchTypeEntity [dispatchTypeCd=" + dispatchTypeCd + ", dispatchTypeName=" + dispatchTypeName
				+ ", createDate=" + createDate + ", updateDate=" + updateDate + "]";
	}

}
