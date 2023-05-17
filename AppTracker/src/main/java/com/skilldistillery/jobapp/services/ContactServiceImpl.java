package com.skilldistillery.jobapp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.jobapp.entities.Contact;
import com.skilldistillery.jobapp.entities.User;
import com.skilldistillery.jobapp.repositories.ContactRepository;
import com.skilldistillery.jobapp.repositories.UserRepository;

@Service
public class ContactServiceImpl implements ContactService {

	@Autowired
	private ContactRepository contRepo;
	
	@Autowired
	private UserRepository userRepo;

	@Override
	public List<Contact> findAll() {

		return contRepo.findAll();
	}

	@Override
	public Contact findById(int id) {

		return contRepo.findContactById(id);
	}

	@Override
	public Contact createContact(Contact contact) {
		contRepo.saveAndFlush(contact);
		return contact;
	}

	@Override
	public Contact updateContact(int id, Contact contact) {
		Contact toUpdate = contRepo.findContactById(id);
		if (toUpdate != null) {
			if (contact.getFirstName() != null) {
				toUpdate.setFirstName(contact.getFirstName());
			}
			if (contact.getLastName() != null) {
				toUpdate.setLastName(contact.getLastName());
			}
			if (contact.getPhone() != null) {
				toUpdate.setPhone(contact.getPhone());
			}
			if (contact.getEmail() != null) {
				toUpdate.setEmail(contact.getEmail());
			}
			if (contact.getTitle() != null) {
				toUpdate.setTitle(contact.getTitle());
			}
			contRepo.saveAndFlush(toUpdate);
		}
		return toUpdate;
	}

	@Override
	public boolean deleteContact(int id) {
		boolean didDelete = false;
		Contact toDelete = contRepo.findContactById(id);
		if (toDelete != null) {
			contRepo.delete(toDelete);
			didDelete = true;
		}

		return didDelete;
	}

	@Override
	public List <Contact> findContactByCompany(int id) {
		return contRepo.findByCompany_Id(id);
	}

	@Override
	public List<Contact> findByLastName(String lastname) {
		lastname= "%" + lastname + "%";
		return contRepo.findByLastNameLike(lastname);
	}

	@Override
	public List<Contact> findByUsername(String username) {
		User user = userRepo.findByUsername(username);
		// TODO Auto-generated method stub
		return contRepo.findByUsers(user);
	}

}
