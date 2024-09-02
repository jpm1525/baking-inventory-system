package com.cpi.is.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "qkc_sku")
public class SkuEntity {

    @Id
    @Column(name = "sku_cd")
    private String skuCd;

    @Column(name = "sku_name")
    private String skuName;

    @Column(name = "unit_of_measurement")
    private String unitOfMeasurement;

    @Column(name = "batch_number")
    private Integer batchNumber;
    
    

	public SkuEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	public SkuEntity(String skuCd, String skuName, String unitOfMeasurement, Integer batchNumber) {
		super();
		this.skuCd = skuCd;
		this.skuName = skuName;
		this.unitOfMeasurement = unitOfMeasurement;
		this.batchNumber = batchNumber;
	}



	public String getSkuCd() {
		return skuCd;
	}

	public void setSkuCd(String skuCd) {
		this.skuCd = skuCd;
	}

	public String getSkuName() {
		return skuName;
	}

	public void setSkuName(String skuName) {
		this.skuName = skuName;
	}

	public String getUnitOfMeasurement() {
		return unitOfMeasurement;
	}

	public void setUnitOfMeasurement(String unitOfMeasurement) {
		this.unitOfMeasurement = unitOfMeasurement;
	}

	public Integer getBatchNumber() {
		return batchNumber;
	}

	public void setBatchNumber(Integer batchNumber) {
		this.batchNumber = batchNumber;
	}

	@Override
	public String toString() {
		return "SkuEntity [skuCd=" + skuCd + ", skuName=" + skuName + ", unitOfMeasurement=" + unitOfMeasurement
				+ ", batchNumber=" + batchNumber + "]";
	}
    
}
