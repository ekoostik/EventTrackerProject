package com.skilldistillery.jobapp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.jobapp.entities.Company;
import com.skilldistillery.jobapp.entities.Offer;
import com.skilldistillery.jobapp.repositories.CompanyRepository;
import com.skilldistillery.jobapp.repositories.OfferRepository;
@Service
public class OfferServiceImpl implements OfferService {
	
	@Autowired
	private OfferRepository offRepo;
	
	@Autowired 
	private CompanyRepository compRepo;

	@Override
	public List<Offer> findAll() {
		return offRepo.findAll();
	}

	@Override
	public Offer findByCompanyOfferId(int id) {
		return offRepo.findById(id);
	}

	@Override
	public List<Offer> findAllBySalary(double low, double high) {
		return offRepo.findBySalaryBetween(low, high);
	}

	@Override
	public Offer createOffer(int id, Offer offer) {
		Company comp = compRepo.findById(id);
		offer.setId(id);
		comp.setOffer(offer);
		offRepo.saveAndFlush(offer);
		return offer;
	}

	@Override
	public Offer updateOffer(int id, Offer offer) {
		Offer toUpdate = offRepo.findById(id);
		if(toUpdate!=null) {
			if(offer.getSalary()!= 0) {
				toUpdate.setSalary(offer.getSalary());
			}
			if(offer.getHealth()!= null) {
				toUpdate.setHealth(offer.getHealth());
			}
			if(offer.getDental()!= null) {
				toUpdate.setDental(offer.getDental());
			}
			if(offer.getOvertime()!= null) {
				toUpdate.setOvertime(null);
			}
			if(offer.getHolidays()!= null) {
				toUpdate.setHolidays(null);
			}
			offRepo.saveAndFlush(toUpdate);
		}
		return toUpdate;
	}

	@Override
	public boolean deleteOffer(int id) {
		boolean didDelete = false;
		Company comp = compRepo.findById(id);
		Offer toDelete=comp.getOffer();
		if (toDelete != null) {
			comp.setOffer(null);
			offRepo.delete(toDelete);
			didDelete = true;
		}

		return didDelete;
	}
}
