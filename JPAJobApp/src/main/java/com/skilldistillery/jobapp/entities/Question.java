package com.skilldistillery.jobapp.entities;

import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Question {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="question_asked")
	private String questionAsked;
	
	@ManyToMany
	@JoinTable(name="Company_has_Question",
	joinColumns=@JoinColumn(name="Question_id"),
	inverseJoinColumns=@JoinColumn(name="Company_id"))
	private List<Company>companies;
	
	
	@ManyToOne
	@JoinColumn(name="category_id")
	private Category category;

	public Question(int id, String questionAsked) {
		super();
		this.id = id;
		this.questionAsked = questionAsked;
	}

	public Question() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getQuestionAsked() {
		return questionAsked;
	}

	public void setQuestionAsked(String questionAsked) {
		this.questionAsked = questionAsked;
	}



	public List<Company> getCompanies() {
		return companies;
	}

	public void setCompanies(List<Company> companies) {
		this.companies = companies;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
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
		Question other = (Question) obj;
		return id == other.id;
	}

	@Override
	public String toString() {
		return "Questions [id=" + id + ", questionAsked=" + questionAsked + "]";
	}
	
	
	
	
	
}
