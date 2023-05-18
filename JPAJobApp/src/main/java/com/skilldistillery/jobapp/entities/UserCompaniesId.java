package com.skilldistillery.jobapp.entities;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;

@Embeddable
public class UserCompaniesId implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Column(name="User_id")
	private int userId;
	
	@Column(name="Company_id")
	private int companyId;

	public UserCompaniesId() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserCompaniesId(int userId, int companyId) {
		super();
		this.userId = userId;
		this.companyId = companyId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getCompanyId() {
		return companyId;
	}

	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		return Objects.hash(companyId, userId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserCompaniesId other = (UserCompaniesId) obj;
		return companyId == other.companyId && userId == other.userId;
	}

	@Override
	public String toString() {
		return "UserCompaniesId [userId=" + userId + ", companyId=" + companyId + "]";
	}

	
	
	
}
