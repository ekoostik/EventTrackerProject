package com.skilldistillery.jobapp.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.jobapp.entities.Company;
import com.skilldistillery.jobapp.entities.Question;

public interface CompanyRepository extends JpaRepository<Company, Integer> {

	
	Company findById(int id);

//	List<Company> findByOrderByApplyDateAsc();
	
}
