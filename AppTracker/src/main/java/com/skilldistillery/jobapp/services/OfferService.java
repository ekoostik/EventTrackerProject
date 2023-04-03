package com.skilldistillery.jobapp.services;

import java.util.List;

import com.skilldistillery.jobapp.entities.Offer;

public interface OfferService {
	List<Offer> findAll();
	Offer findByCompanyOfferId(int id);
	List<Offer> findAllBySalary(double low, double high);
	Offer createOffer(int id, Offer offer);
	Offer updateOffer(int id, Offer offer);
	boolean deleteOffer(int id);
}
