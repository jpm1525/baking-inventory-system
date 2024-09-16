package com.cpi.is.entity.maintenance;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "QKC_SKU")
public class SkuCodeEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "sku_cd")
	private String skuCd;
	@Column(name = "sku_name")
	private String skuCodeName;
	@Column(name = "unit_of_measurement")
	private String unitOfMeasurement;
	@Column(name = "create_date", insertable = false, updatable = false)
	private Date createDate;
	@Column(name = "update_date", insertable = false, updatable = false)
	private Date updateDate;

	public SkuCodeEntity() {
		super();
	}

	public SkuCodeEntity(String skuCd, String skuCodeName, String unitOfMeasurement) {
		super();
		this.skuCd = skuCd;
		this.skuCodeName = skuCodeName;
		this.unitOfMeasurement = unitOfMeasurement;
	}

	public String getSkuCd() {
		return skuCd;
	}

	public void setSkuCd(String skuCd) {
		this.skuCd = skuCd;
	}

	public String getSkuCodeName() {
		return skuCodeName;
	}

	public void setSkuCodeName(String skuCodeName) {
		this.skuCodeName = skuCodeName;
	}

	public String getUnitOfMeasurement() {
		return unitOfMeasurement;
	}

	public void setUnitOfMeasurement(String unitOfMeasurement) {
		this.unitOfMeasurement = unitOfMeasurement;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	@Override
	public String toString() {
		return "SkuCodeEntity [skuCd=" + skuCd + ", skuCodeName=" + skuCodeName + ", unitOfMeasurement="
				+ unitOfMeasurement + ", createDate=" + createDate + ", updateDate=" + updateDate + "]";
	}

}
