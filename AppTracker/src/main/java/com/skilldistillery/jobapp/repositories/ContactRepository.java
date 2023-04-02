package com.skilldistillery.jobapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.jobapp.entities.Contact;

public interface ContactRepository extends JpaRepository<Contact, Integer>  {

	
		Contact findContactById(int id);
}
