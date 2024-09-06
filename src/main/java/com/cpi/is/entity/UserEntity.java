package com.cpi.is.entity;

import java.io.Serializable;

import com.cpi.is.entity.maintenance.BranchEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="QKC_USER")
public class UserEntity implements Serializable{

	private static final long serialVersionUID = 1L;
		
		@Id
		@Column(name="USER_ID")
		private Integer userId;
		private String username;
		private String password;
		@Column(name="BRANCH_ID")
		private Integer branchId;
		
		@ManyToOne
		@JoinColumn(name="BRANCH_ID", insertable=false, updatable=false)
		private BranchEntity branch;
		
		public Integer getBranchId() {
			return branchId;
		}

		public void setBranchId(Integer branchId) {
			this.branchId = branchId;
		}

		public BranchEntity getBranch() {
			return branch;
		}

		public void setBranch(BranchEntity branch) {
			this.branch = branch;
		}

		public UserEntity() {
			super();
			// TODO Auto-generated constructor stub
		}

		public UserEntity(Integer userId, String username, String password) {
			super();
			this.userId = userId;
			this.username = username;
			this.password = password;
		}

		public Integer getUserId() {
			return userId;
		}

		public void setUserId(Integer userId) {
			this.userId = userId;
		}

		public String getUsername() {
			return username;
		}

		public void setUsername(String username) {
			this.username = username;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		@Override
		public String toString() {
			return "UserEntity [userId=" + userId + ", username=" + username + ", password=" + password + ", branchId="
					+ branchId + "]";
		}
		
//		@Override
//		public String toString() {
//			return "{userId=" + userId 
//				 + ", username=" + username 
//				 + ", password=" + password + "}";
//		}
		
}
