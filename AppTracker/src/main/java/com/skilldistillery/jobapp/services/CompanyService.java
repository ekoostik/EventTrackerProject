package com.skilldistillery.jobapp.services;

import java.util.List;

import com.skilldistillery.jobapp.entities.Company;

public interface CompanyService {

	
	List<Company> findAll();
	Company findById(int id);
	Company createCompany(Company comp);
	Company updateCompany(int id, Company comp);
	boolean deleteCompany(int id);
	List<Company> findAllActive(boolean active);
	List<Company> findAllRemote(boolean remote);
}
