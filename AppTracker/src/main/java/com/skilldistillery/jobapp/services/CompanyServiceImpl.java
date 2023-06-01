package com.skilldistillery.jobapp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.jobapp.entities.Company;
import com.skilldistillery.jobapp.entities.Question;
import com.skilldistillery.jobapp.entities.UserCompanies;
import com.skilldistillery.jobapp.repositories.CompanyRepository;
import com.skilldistillery.jobapp.repositories.UserCompaniesRepository;

@Service
public class CompanyServiceImpl implements CompanyService {
	

	
	@Autowired
	private CompanyRepository compRepo;

	@Autowired
	private UserCompaniesRepository userComp;

	

	@Override
	public Company findById(int id) {
		return compRepo.findById(id);
	}

	@Override
	public Company createCompany(Company comp) {
		compRepo.saveAndFlush(comp);
		return comp;
	}

	@Override
	public Company updateCompany(int id, Company comp) {
		Company toUpdate = compRepo.findById(id);
		System.out.println(toUpdate);
		if (toUpdate != null) {
			if (comp.getName() != null) {
				toUpdate.setName(comp.getName());
			}
		
			if (comp.getWebsite() != null) {
				toUpdate.setWebsite(comp.getWebsite());
			}
			

			toUpdate.setActive(comp.isActive());

			compRepo.saveAndFlush(toUpdate);
		}
		return toUpdate;
	}




	@Override
	public List<Question> findAllQuestionsForCompany(int id) {
		Company comp = compRepo.findById(id);

		return comp.getQuestions();
	}

	@Override
	public boolean deleteCompany(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<UserCompanies> findAllForUser(Integer id) {
		// TODO Auto-generated method stub
		return userComp.findByIdUserId(id);
	}

	@Override
	public List<Company> findAll() {
		// TODO Auto-generated method stub
		return compRepo.findAll();
	}

}
