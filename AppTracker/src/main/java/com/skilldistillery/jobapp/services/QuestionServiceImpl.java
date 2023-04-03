package com.skilldistillery.jobapp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.jobapp.entities.Question;

import com.skilldistillery.jobapp.repositories.QuestionRepository;

@Service
public class QuestionServiceImpl implements QuestionService {

	@Autowired
	private QuestionRepository questRepo;

	@Override
	public List<Question> findAll() {
		return questRepo.findAll();
	}

	@Override
	public List<Question> findByKeyword(String keyword) {
		return questRepo.findByQuestionAskedLike(keyword);
	}

	@Override
	public List<Question> findByCategory(int catId) {
		return questRepo.findByCategory_Id(catId);
	}

	@Override
	public Question createQuestion(Question question) {
		
		questRepo.saveAndFlush(question);
		return question;
	}

	@Override
	public boolean deleteQuestion(int id) {
		boolean didDelete = false;
		Question toDelete = questRepo.findById(id);
		if (toDelete != null) {
			questRepo.delete(toDelete);
			didDelete = true;
		}

		return didDelete;
	}

}
