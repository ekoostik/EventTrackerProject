package com.skilldistillery.jobapp.entities;

import java.time.LocalDateTime;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name="User_has_Company")
public class UserCompanies {

@EmbeddedId
private UserCompaniesId id;

@CreationTimestamp
@Column(name="apply_date")
private LocalDateTime applyDate;

private Boolean active;

@ManyToOne
@JoinColumn(name="User_id")
@MapsId(value="userId")
private User user;

@ManyToOne
@JoinColumn(name="Company_id")
@MapsId(value="companyId")
private Company company;

public UserCompanies() {
	
}

public UserCompaniesId getId() {
	return id;
}

public void setId(UserCompaniesId id) {
	this.id = id;
}

public LocalDateTime getApplyDate() {
	return applyDate;
}

public void setApplyDate(LocalDateTime applyDate) {
	this.applyDate = applyDate;
}

public Boolean getActive() {
	return active;
}

public void setActive(Boolean active) {
	this.active = active;
}

public User getUser() {
	return user;
}

public void setUser(User user) {
	this.user = user;
}

public Company getCompany() {
	return company;
}

public void setCompany(Company company) {
	this.company = company;
}

@Override
public int hashCode() {
	return Objects.hash(id);
}

@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	UserCompanies other = (UserCompanies) obj;
	return Objects.equals(id, other.id);
}


	
}
