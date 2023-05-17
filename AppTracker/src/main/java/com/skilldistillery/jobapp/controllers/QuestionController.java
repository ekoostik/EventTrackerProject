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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.jobapp.entities.Question;
import com.skilldistillery.jobapp.services.QuestionService;

@RestController
@RequestMapping("api")
@CrossOrigin({"*", "http://localhost/"})
public class QuestionController {
	
	@Autowired
	private QuestionService questSrvc;
	
	
	@GetMapping("questions")
	public List<Question> findAllQuestions(){
		return questSrvc.findAll();
	}
	@GetMapping("questions/category/{id}")
	public List<Question> findAllQuestionsByCat(@PathVariable Integer id){
		return questSrvc.findByCategory(id);
	}
	@DeleteMapping("delete/question/{id}")
	public void deleteQuestion(Principal principal,@PathVariable Integer id, HttpServletResponse resp) {
		try {
			if (questSrvc.deleteQuestion(id)) {
				resp.setStatus(200);
			} else {
				resp.setStatus(204);
			}
		} catch (Exception e) {
			e.printStackTrace();
			resp.setStatus(400);

		}
	}
	@PostMapping("add/question")
	public Question createQuestion(Principal principal,@RequestBody Question question, HttpServletResponse resp) {
		try {
			questSrvc.createQuestion(question);
			if (question == null) {
				resp.setStatus(404);
			} else {
				resp.setStatus(201);
			}
		} catch (Exception e) {
			e.printStackTrace();
			resp.setStatus(400);
			question = null;
		}
		return question;
	}
	

}
