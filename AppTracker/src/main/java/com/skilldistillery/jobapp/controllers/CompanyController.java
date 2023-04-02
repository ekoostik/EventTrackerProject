package com.skilldistillery.jobapp.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
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

import com.skilldistillery.jobapp.entities.Company;
import com.skilldistillery.jobapp.services.CompanyService;

@RestController
@RequestMapping("api")
public class CompanyController {
	@Autowired
	private CompanyService compSrvc;

	@GetMapping("companies")
	public List<Company> findAllCompanies() {

		return compSrvc.findAll();
	}

	@GetMapping("company/{id}")
	public Company findCompanyById(@PathVariable Integer id) {

		return compSrvc.findById(id);
	}

	@PostMapping("add/company")
	public Company addCompany(@RequestBody Company company, HttpServletRequest req, HttpServletResponse resp) {
		try {
			compSrvc.createCompany(company);
			if (company == null) {
				resp.setStatus(404);
			} else {
				resp.setStatus(201);
			}
		} catch (Exception e) {
			e.printStackTrace();
			resp.setStatus(400);
			company = null;
		}
		return company;
	}

	@DeleteMapping("delete/company/{id}")
	public void deleteCompany(@PathVariable Integer id, HttpServletResponse resp) {
		try {
			if (compSrvc.deleteCompany(id)) {
				resp.setStatus(200);
			} else {
				resp.setStatus(204);
			}
		} catch (Exception e) {
			e.printStackTrace();
			resp.setStatus(400);

		}
	}
	
	
	@PutMapping("update/company/{id}")
	public Company updateCompany(@PathVariable Integer id, @RequestBody Company company, HttpServletResponse resp) {
		
		try {
			 company = compSrvc.updateCompany(id, company);
			if(company ==null) {
				resp.setStatus(404);
			}
			}catch(Exception e){
				e.printStackTrace();
				resp.setStatus(400);
				company = null;
			}
			return company;
	}
	

}
