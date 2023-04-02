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
		if (toUpdate != null) {
			if (comp.getName() != null) {
				toUpdate.setName(comp.getName());
			}
			if (comp.getApplyDate() != null) {
				toUpdate.setApplyDate(comp.getApplyDate());
			}
			if (comp.getWebsite() != null) {
				toUpdate.setWebsite(comp.getWebsite());
			}

			toUpdate.setActive(comp.isActive());
			if (comp.getOffer() != null) {
				toUpdate.setOffer(comp.getOffer());
			}

			compRepo.saveAndFlush(toUpdate);
		}
		return toUpdate;
	}

	@Override
	public boolean deleteCompany(int id) {
		boolean didDelete = false;
		Company toDelete = compRepo.findById(id);
		if (toDelete != null) {
			compRepo.delete(toDelete);
			didDelete = true;
		}

		return didDelete;
	}

}
