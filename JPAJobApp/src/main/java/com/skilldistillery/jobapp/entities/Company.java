package com.skilldistillery.jobapp.entities;


import java.util.List;
import java.util.Objects;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;




import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Company {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String name;


	private String website;

	private boolean active;
	
	

	
	//@JsonIgnore
	@OneToMany(mappedBy="company")
	private List<Contact>contacts;
	
	
	@JsonIgnore
	@ManyToMany(mappedBy="companies")
	private List<Question> questions;
	
	@JsonIgnore
	@OneToMany(mappedBy="company")
	private List<Offer> offers;
	
//	@JsonIgnore
//	@ManyToMany
//	@JoinTable(name="User_has_Company",
//	joinColumns=@JoinColumn(name="Company_id"),
//	inverseJoinColumns=@JoinColumn(name="User_id"))
//	private List<User> users;
//	
	public Company() {

	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}



	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}



	public List<Contact> getContacts() {
		return contacts;
	}


	public void setContacts(List<Contact> contacts) {
		this.contacts = contacts;
	}


	public List<Question> getQuestions() {
		return questions;
	}


	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}





	public List<Offer> getOffers() {
		return offers;
	}



	public void setOffers(List<Offer> offers) {
		this.offers = offers;
	}





//
//	public List<User> getUsers() {
//		return users;
//	}
//
//
//
//	public void setUsers(List<User> users) {
//		this.users = users;
//	}



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
		Company other = (Company) obj;
		return id == other.id;
	}

	@Override
	public String toString() {
		return "Company [id=" + id + ", name=" + name + "]";
	}

}
