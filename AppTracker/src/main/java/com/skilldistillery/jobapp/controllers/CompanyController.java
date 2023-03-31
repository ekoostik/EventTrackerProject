package com.skilldistillery.jobapp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
	public List<Company> findAllCompanies(){
		
		
		return compSrvc.findAll();
	}

}
