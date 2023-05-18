package com.skilldistillery.jobapp.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import com.skilldistillery.jobapp.entities.UserCompanies;
import com.skilldistillery.jobapp.entities.UserCompaniesId;

public interface UserCompaniesRepository extends JpaRepository<UserCompanies, UserCompaniesId>  {
	
	List<UserCompanies> findByIdUserId(Integer id);

}
