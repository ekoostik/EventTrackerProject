package com.skilldistillery.jobapp.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.jobapp.entities.Contact;

public interface ContactRepository extends JpaRepository<Contact, Integer>  {

	
		Contact findContactById(int id);
		
		List<Contact> findByCompany_Id(int id);
		List<Contact> findByLastNameLike(String lastName);
		
}
