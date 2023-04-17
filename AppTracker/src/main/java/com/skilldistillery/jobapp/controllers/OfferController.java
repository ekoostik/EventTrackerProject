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

import com.skilldistillery.jobapp.entities.Offer;
import com.skilldistillery.jobapp.services.OfferService;

@RestController
@RequestMapping("api")
@CrossOrigin({"*", "http://localhost/"})
public class OfferController {
	@Autowired
	private OfferService offSrvc;
	
	
	
	@GetMapping("offers")
	public List<Offer> findAll(){
		return offSrvc.findAll();
	}
	
	@GetMapping("offer/company/{id}")
	public Offer findCompanyOffer(@PathVariable Integer id) {
		return offSrvc.findByCompanyOfferId(id);
	}
	
	@PostMapping("company/{id}/offer")
	public Offer addOffer(@PathVariable Integer id, @RequestBody Offer offer, HttpServletResponse resp, HttpServletRequest req ) {
		try {
			offer = offSrvc.createOffer(id, offer);
			if (offer == null) {
				resp.setStatus(404);
			} else {
				resp.setStatus(201);
				resp.setHeader("Location", req.getRequestURL().append("/").append(offer.getId()).toString());
			}
		} catch (Exception e) {
			e.printStackTrace();
			resp.setStatus(400);
			offer = null;
		}

		return offer;
	}
	
	
	
	@DeleteMapping("delete/offer/{id}")
	public void deleteCompany(@PathVariable Integer id, HttpServletResponse resp) {
		try {
			if (offSrvc.deleteOffer(id)) {
				resp.setStatus(200);
			} else {
				resp.setStatus(204);
			}
		} catch (Exception e) {
			e.printStackTrace();
			resp.setStatus(400);

		}
	}
	@PutMapping("update/offer/{id}")
	public Offer updateOffer(@PathVariable Integer id, @RequestBody Offer offer, HttpServletResponse resp) {
		
		try {
			 offer = offSrvc.updateOffer(id, offer);
			if(offer ==null) {
				resp.setStatus(404);
			}
			}catch(Exception e){
				e.printStackTrace();
				resp.setStatus(400);
				offer = null;
			}
			return offer;
	}
	


	
	
	
	
	
	
	

}
