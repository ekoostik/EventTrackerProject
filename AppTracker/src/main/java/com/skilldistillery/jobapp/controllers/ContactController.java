package com.skilldistillery.jobapp.controllers;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
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
public class ContactController {

	@Autowired
	private ContactService contSrvc;

	@GetMapping("contacts")
	public List<Contact> findAllContacts() {
		return contSrvc.findAll();
	}

	@GetMapping("contact/{id}")
	public Contact findById(@PathVariable Integer id) {
		return contSrvc.findById(id);
	}

	@PostMapping("add/contact")
	public Contact addContact(@RequestBody Contact contact, HttpServletResponse resp) {
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

	@DeleteMapping("delete/contact/{id}")
	public void deleteContact(@PathVariable Integer id, HttpServletResponse resp) {
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

	@PutMapping("update/contact/{id}")
	public Contact updateContact(@PathVariable Integer id, @RequestBody Contact contact, HttpServletResponse resp) {

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
	
	@GetMapping("contact/search/company/{companyId}")
	public List<Contact> findContactByCompanyId(@PathVariable Integer companyId) {
		
		return contSrvc.findContactByCompany(companyId);
		
	}
	@GetMapping("contact/search/name/{lastName}")
	public List<Contact> findContactByLastName(@PathVariable String lastName){
		return contSrvc.findByLastName(lastName);
	}

}
