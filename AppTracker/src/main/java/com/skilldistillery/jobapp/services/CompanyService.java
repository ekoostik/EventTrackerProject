package com.skilldistillery.jobapp.services;

import java.util.List;

import com.skilldistillery.jobapp.entities.Company;
import com.skilldistillery.jobapp.entities.Question;
import com.skilldistillery.jobapp.entities.UserCompanies;

public interface CompanyService {

	
	List<Company> findAll();
	Company findById(int id);
	Company createCompany(Company comp);
	Company updateCompany(int id, Company comp);
	boolean deleteCompany(int id);

	
	List<Question> findAllQuestionsForCompany(int id);
	List<UserCompanies> findAllForUser(Integer id);
}
