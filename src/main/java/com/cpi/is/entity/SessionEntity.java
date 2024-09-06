package com.cpi.is.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="qkc_sessions")
public class SessionEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="session_id")
	private String sessionId;
	private String username;
	@Column(name="user_id")
	private String userId;
	@Column(name="branch_id")
	private String branchId;
	
	public SessionEntity() {
		super();
	}
	
	public SessionEntity(String sessionId, String username, String userId, String branchId) {
		super();
		this.sessionId = sessionId;
		this.username = username;
		this.userId = userId;
		this.branchId = branchId;
	}

	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getBranchId() {
		return branchId;
	}

	public void setBranchId(String branchId) {
		this.branchId = branchId;
	}

	@Override
	public String toString() {
		return "SessionEntity [sessionId=" + sessionId + ", username=" + username + ", userId=" + userId + ", branchId="
				+ branchId + "]";
	}
	
}