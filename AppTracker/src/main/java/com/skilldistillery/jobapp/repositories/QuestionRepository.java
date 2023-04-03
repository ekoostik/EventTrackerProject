package com.skilldistillery.jobapp.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.jobapp.entities.Company;
import com.skilldistillery.jobapp.entities.Question;

public interface QuestionRepository extends JpaRepository<Question, Integer> {
	Question findById(int id);
	List<Question> findByQuestionAskedLike(String keyword);
	List<Question> findByCategory_Id(int id);
	
}
