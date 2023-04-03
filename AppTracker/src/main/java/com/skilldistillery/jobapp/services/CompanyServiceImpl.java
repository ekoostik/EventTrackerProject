package com.skilldistillery.jobapp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.jobapp.entities.Company;
import com.skilldistillery.jobapp.entities.Contact;
import com.skilldistillery.jobapp.entities.Offer;
import com.skilldistillery.jobapp.entities.Question;
import com.skilldistillery.jobapp.repositories.CompanyRepository;
import com.skilldistillery.jobapp.repositories.ContactRepository;
import com.skilldistillery.jobapp.repositories.OfferRepository;

@Service
public class CompanyServiceImpl implements CompanyService {
	@Autowired
	private CompanyRepository compRepo;

	@Autowired
	private OfferRepository offRepo;

	@Autowired
	private ContactRepository contRepo;

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

			compRepo.saveAndFlush(toUpdate);
		}
		return toUpdate;
	}

	@Override
	public boolean deleteCompany(int id) {
		boolean didDelete = false;
		Company toDelete = compRepo.findById(id);
		if (toDelete != null) {
			if (toDelete.getOffer() != null) {
				Offer off = offRepo.findById(toDelete.getOffer().getId());
				toDelete.setOffer(null);
				offRepo.delete(off);
			}
			if (!toDelete.getContacts().isEmpty()) {
				List<Contact> contacts = contRepo.findByCompany_Id(toDelete.getId());

				toDelete.setContacts(null);
				for (Contact contact : contacts) {
					contRepo.delete(contact);
				}
			}
			compRepo.delete(toDelete);
			didDelete = true;

		}

		return didDelete;
	}

	@Override
	public List<Company> findAllActive(boolean active) {

		return compRepo.findByActive(active);
	}

	@Override
	public List<Company> findAllRemote(boolean remote) {

		return compRepo.findByRemote(remote);
	}

	@Override
	public List<Question> findAllQuestionsForCompany(int id) {
		Company comp = compRepo.findById(id);

		return comp.getQuestions();
	}

}
