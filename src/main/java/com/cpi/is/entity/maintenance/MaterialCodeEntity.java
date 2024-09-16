package com.cpi.is.entity.maintenance;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "QKC_RAW_MATERIAL")
public class MaterialCodeEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "material_cd")
	private String materialCd;
	@Column(name = "material_name")
	private String materialCodeName;
	@Column(name = "unit_of_measurement")
	private String unitOfMeasurement;
	@Column(name = "create_date", insertable = false, updatable = false)
	private Date createDate;
	@Column(name = "update_date", insertable = false, updatable = false)
	private Date updateDate;

	public MaterialCodeEntity() {
		super();
	}

	public MaterialCodeEntity(String materialCd, String materialCodeName, String unitOfMeasurement) {
		super();
		this.materialCd = materialCd;
		this.materialCodeName = materialCodeName;
		this.unitOfMeasurement = unitOfMeasurement;
	}

	public String getMaterialCd() {
		return materialCd;
	}

	public void setMaterialCd(String materialCd) {
		this.materialCd = materialCd;
	}

	public String getMaterialCodeName() {
		return materialCodeName;
	}

	public void setMaterialCodeName(String materialCodeName) {
		this.materialCodeName = materialCodeName;
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
		return "MaterialCodeEntity [materialCd=" + materialCd + ", materialCodeName=" + materialCodeName
				+ ", unitOfMeasurement=" + unitOfMeasurement + ", createDate=" + createDate + ", updateDate="
				+ updateDate + "]";
	}

}
