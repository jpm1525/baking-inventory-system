package com.cpi.is.entity;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name="qkc_dispatch_tracking")
public class DispatchingEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="dispatch_track_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long dispatchTrackId;
	@Column(name="dispatch_type_cd")
	private String dispatchTypeCd;
	@Column(name="fpl_id")
	private String fplId;
	private Long quantity;
	@Column(name="branch_id")
	private Long branchId;
	private String destination;
	@Column(name="dispatch_date")
	@Temporal(TemporalType.DATE)
	private Date dispatchDate;
	
	public DispatchingEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DispatchingEntity(Long dispatchTrackId, String dispatchTypeCd, String fplId, Long quantity, Long branchId,
			String destination, Date dispatchDate) {
		super();
		this.dispatchTrackId = dispatchTrackId;
		this.dispatchTypeCd = dispatchTypeCd;
		this.fplId = fplId;
		this.quantity = quantity;
		this.branchId = branchId;
		this.destination = destination;
		this.dispatchDate = dispatchDate;
	}

	public Long getDispatchTrackId() {
		return dispatchTrackId;
	}

	public void setDispatchTrackId(Long dispatchTrackId) {
		this.dispatchTrackId = dispatchTrackId;
	}

	public String getDispatchTypeCd() {
		return dispatchTypeCd;
	}

	public void setDispatchTypeCd(String dispatchTypeCd) {
		this.dispatchTypeCd = dispatchTypeCd;
	}

	public String getFplId() {
		return fplId;
	}

	public void setFplId(String fplId) {
		this.fplId = fplId;
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

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public Date getDispatchDate() {
		return dispatchDate;
	}

	public void setDispatchDate(Date dispatchDate) {
		this.dispatchDate = dispatchDate;
	}

	@Override
	public String toString() {
		return "DispatchingEntity [dispatchTrackId=" + dispatchTrackId + ", dispatchTypeCd=" + dispatchTypeCd
				+ ", fplId=" + fplId + ", quantity=" + quantity + ", branchId=" + branchId + ", destination="
				+ destination + ", dispatchDate=" + dispatchDate + "]";
	}

}
