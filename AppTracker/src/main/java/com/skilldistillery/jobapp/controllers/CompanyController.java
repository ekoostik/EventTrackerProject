package com.skilldistillery.jobapp.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
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

import com.skilldistillery.jobapp.entities.Company;
import com.skilldistillery.jobapp.entities.Question;
import com.skilldistillery.jobapp.services.CompanyService;

@RestController
@RequestMapping("api")
@CrossOrigin({"*", "http://localhost/"})
public class CompanyController {
	@Autowired
	private CompanyService compSrvc;

	@GetMapping("company")
	public List<Company> findAllCompanies() {

		return compSrvc.findAll();
	}

	@GetMapping("company/{id}")
	public Company findCompanyById(@PathVariable Integer id) {

		return compSrvc.findById(id);
	}
	@GetMapping("company/{active}")
	public List<Company> findCompanyByActive(@PathVariable Boolean active) {
		
		return compSrvc.findAllActive(active);
	}
	@GetMapping("company/remote/{remote}")
	public List<Company> findCompanyByRemote(@PathVariable Boolean remote) {
		
		return compSrvc.findAllRemote(remote);
	}

	@PostMapping("company")
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

	@DeleteMapping("company/{id}")
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
	
	
	@PutMapping("company")
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
	@GetMapping("company/{id}/questions")
	public List<Question> findAllQuestionsForCompany(@PathVariable Integer id){
		
		return compSrvc.findAllQuestionsForCompany(id);
	}
	

}
