package com.skilldistillery.jobapp.services;

import java.util.List;

import com.skilldistillery.jobapp.entities.Question;

public interface QuestionService {
	List<Question> findAll();
	List<Question> findByKeyword(String keyword);
	List<Question> findByCategory(int catId);
	Question createQuestion(Question question);
	boolean deleteQuestion(int id);
	

}
