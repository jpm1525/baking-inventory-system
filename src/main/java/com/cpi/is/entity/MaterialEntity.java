package com.cpi.is.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "qkc_raw_material")
public class MaterialEntity {

    @Id
    @Column(name = "material_cd")
    private String materialCd;

    @Column(name = "material_name")
    private String materialName;

    @Column(name = "unit_of_measurement")
    private String unitOfMeasurement;
    
    

	public MaterialEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	public MaterialEntity(String materialCd, String materialName, String unitOfMeasurement) {
		super();
		this.materialCd = materialCd;
		this.materialName = materialName;
		this.unitOfMeasurement = unitOfMeasurement;
	}


	public String getMaterialCd() {
		return materialCd;
	}

	public void setMaterialCd(String materialCd) {
		this.materialCd = materialCd;
	}

	public String getMaterialName() {
		return materialName;
	}

	public void setMaterialName(String materialName) {
		this.materialName = materialName;
	}

	public String getUnitOfMeasurement() {
		return unitOfMeasurement;
	}

	public void setUnitOfMeasurement(String unitOfMeasurement) {
		this.unitOfMeasurement = unitOfMeasurement;
	}


	@Override
	public String toString() {
		return "MaterialEntity [materialCd=" + materialCd + ", materialName=" + materialName + ", unitOfMeasurement="
				+ unitOfMeasurement + "]";
	}
	
    
}