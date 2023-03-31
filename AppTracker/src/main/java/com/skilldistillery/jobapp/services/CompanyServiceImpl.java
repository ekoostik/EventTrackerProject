package com.skilldistillery.jobapp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.jobapp.entities.Company;
import com.skilldistillery.jobapp.repositories.CompanyRepository;
@Service
public class CompanyServiceImpl implements CompanyService {
	@Autowired
	private CompanyRepository compRepo;

	@Override
	public List<Company> findAll() {
	
		return compRepo.findAll();
	}

	@Override
	public Company findById() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Company createCompany(Company comp) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Company updateCompany(int id, Company comp) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteCompany(int id) {
		// TODO Auto-generated method stub
		return false;
	}

}
