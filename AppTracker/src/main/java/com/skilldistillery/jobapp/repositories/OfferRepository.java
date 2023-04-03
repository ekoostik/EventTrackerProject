package com.skilldistillery.jobapp.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.jobapp.entities.Offer;

public interface OfferRepository extends JpaRepository<Offer, Integer>{

	Offer findById(int id);
	List<Offer> findBySalaryBetween(double low, double high);
}
