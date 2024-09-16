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
	private Long pmId;

	@Column(name = "dpp_id")
	private Long dppId;

	@Column(name = "material_cd")
	private String materialCd;

	@Column(name = "quantity_to_use")
	private Long quantityToUse;

	@Column(name = "material_list_id")
	private Long materialListId;

	@ManyToOne
	@JoinColumn(name = "material_cd", insertable = false, updatable = false)
	private MaterialCodeEntity materialCode;

	@ManyToOne
	@JoinColumn(name = "material_list_id", insertable = false, updatable = false)
	private RawMaterialListEntity materialList;

	@ManyToOne
	@JoinColumn(name = "dpp_id", insertable = false, updatable = false)
	private DailyPlanEntity dailyPlannedProduction;
    
	public ProductionMaterialEntity() {
		super();
	}

	public ProductionMaterialEntity(Long pmId, Long dppId, String materialCd, Long materialListId, Long quantityToUse) {
		super();
		this.pmId = pmId;
		this.dppId = dppId;
		this.materialCd = materialCd;
		this.quantityToUse = quantityToUse;
		this.materialListId = materialListId;
	}

	// Getters and Setters

	public Long getMaterialListId() {
		return materialListId;
	}

	public void setMaterialListId(Long materialListId) {
		this.materialListId = materialListId;
	}

	public RawMaterialListEntity getMaterialList() {
		return materialList;
	}

	public void setMaterialList(RawMaterialListEntity materialList) {
		this.materialList = materialList;
	}

	public Long getPmId() {
		return pmId;
	}

	public void setPmId(Long pmId) {
		this.pmId = pmId;
	}

	public Long getDppId() {
		return dppId;
	}

	public void setDppId(Long dppId) {
		this.dppId = dppId;
	}

	public String getMaterialCd() {
		return materialCd;
	}

	public void setMaterialCd(String materialCd) {
		this.materialCd = materialCd;
	}

	public Long getQuantityToUse() {
		return quantityToUse;
	}

	public void setQuantityToUse(Long quantityToUse) {
		this.quantityToUse = quantityToUse;
	}

	public MaterialCodeEntity getMaterialCode() {
		return materialCode;
	}

	public void setMaterialCode(MaterialCodeEntity materialCode) {
		this.materialCode = materialCode;
	}

	public DailyPlanEntity getDailyPlannedProduction() {
		return dailyPlannedProduction;
	}

	public void setDailyPlannedProduction(DailyPlanEntity dailyPlannedProduction) {
		this.dailyPlannedProduction = dailyPlannedProduction;
	}

	@Override
	public String toString() {
		return "ProductionMaterialEntity [pmId=" + pmId + ", dppId=" + dppId + ", materialCd=" + materialCd
				+ ", quantityToUse=" + quantityToUse + ", materialListId=" + materialListId + "]";
	}

}