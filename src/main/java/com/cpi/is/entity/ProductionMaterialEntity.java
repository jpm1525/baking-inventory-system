package com.cpi.is.entity;

import com.cpi.is.entity.maintenance.MaterialCodeEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "qkc_production_materials")
public class ProductionMaterialEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pm_id")
    private Integer pmId;

    @Column(name = "dpp_id")
    private Integer dailyPlan;

    @Column(name = "material_cd")
    private String material;

    @Column(name = "quantity_to_use")
    private Integer quantityToUse;
    
	@ManyToOne
	@JoinColumn(name = "material_cd", insertable = false, updatable = false)
	private MaterialCodeEntity materialCode;
    
	public ProductionMaterialEntity() {
		super();
	}

	public Integer getPmId() {
		return pmId;
	}

	public void setPmId(Integer pmId) {
		this.pmId = pmId;
	}

	public Integer getDailyPlan() {
		return dailyPlan;
	}

	public void setDailyPlan(Integer dailyPlan) {
		this.dailyPlan = dailyPlan;
	}

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}



	public Integer getQuantityToUse() {
		return quantityToUse;
	}



	public void setQuantityToUse(Integer quantityToUse) {
		this.quantityToUse = quantityToUse;
	}
	
	public MaterialCodeEntity getMaterialCode() {
		return materialCode;
	}

	public void setMaterialCode(MaterialCodeEntity materialCode) {
		this.materialCode = materialCode;
	}

	@Override
	public String toString() {
		return "ProductionMaterialEntity [pmId=" + pmId + ", dailyPlan=" + dailyPlan + ", material=" + material
				+ ", quantityToUse=" + quantityToUse + "]";
	}

}