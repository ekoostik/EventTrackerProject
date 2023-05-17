package com.skilldistillery.jobapp.controllers;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.jobapp.entities.Contact;
import com.skilldistillery.jobapp.services.ContactService;

@RestController
@RequestMapping("api")
@CrossOrigin({"*", "http://localhost/"})
public class ContactController {

	@Autowired
	private ContactService contSrvc;

	@GetMapping("contacts")
	public List<Contact> findAllContacts() {
		return contSrvc.findAll();
	}

	@GetMapping("contact/{id}")
	public Contact findById(Principal principal, @PathVariable Integer id) {
		return contSrvc.findById(id);
	}
	
	@GetMapping("contacts/{username}")
	public List<Contact> findUsersContacts(Principal principal, @PathVariable String username, HttpServletResponse resp  ){
		return contSrvc.findByUsername(username);
	}

	@PostMapping("contact")
	public Contact addContact(Principal principal, @RequestBody Contact contact, HttpServletResponse resp) {
		try {
			contSrvc.createContact(contact);
			if (contact == null) {
				resp.setStatus(404);
			} else {
				resp.setStatus(201);
			}
		} catch (Exception e) {
			e.printStackTrace();
			resp.setStatus(400);
			contact = null;
		}
		return contact;
	}

	@DeleteMapping("contact/{id}")
	public void deleteContact(Principal principal, @PathVariable Integer id, HttpServletResponse resp) {
		try {
			if (contSrvc.deleteContact(id)) {
				resp.setStatus(200);
			} else {
				resp.setStatus(204);
			}
		} catch (Exception e) {
			e.printStackTrace();
			resp.setStatus(400);

		}
	}

	@PutMapping("contact")
	public Contact updateContact(Principal principal, @PathVariable Integer id, @RequestBody Contact contact, HttpServletResponse resp) {

		try {
			contact = contSrvc.updateContact(id, contact);
			if (contact == null) {
				resp.setStatus(404);
			}
		} catch (Exception e) {
			e.printStackTrace();
			resp.setStatus(400);
			contact = null;
		}
		return contact;
	}
	
	@GetMapping("contact/company/{id}")
	public List<Contact> findContactByCompanyId(Principal principal, @PathVariable Integer id) {
		
		return contSrvc.findContactByCompany(id);
		
	}
	@GetMapping("contact/name")
	public List<Contact> findContactByLastName(Principal principal, @PathVariable String lastName){
		return contSrvc.findByLastName(lastName);
	}

}
