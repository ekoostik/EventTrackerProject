package com.skilldistillery.jobapp.services;

import java.util.List;

import com.skilldistillery.jobapp.entities.Contact;

public interface ContactService {
	List <Contact> findAll();
	Contact findById(int id);
	Contact createContact(Contact contact);
	Contact updateContact(int id, Contact contact);
	boolean deleteContact(int id);
	List<Contact> findContactByCompany(int id);
	List<Contact> findByLastName(String lastname);
	List<Contact> findByUsername(String username);
}
