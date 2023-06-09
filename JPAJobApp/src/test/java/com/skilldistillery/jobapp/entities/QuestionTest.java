package com.skilldistillery.jobapp.entities;

import static org.junit.jupiter.api.Assertions.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class QuestionTest {
	private static EntityManagerFactory emf; 
	private EntityManager em;
	private Question question;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		emf = Persistence.createEntityManagerFactory("JPAJobApp");
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	emf.close();
	}

	@BeforeEach
	void setUp() throws Exception {
		em = emf.createEntityManager();
		question = em.find(Question.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
	em.close();
	question = null;
	}
	
	@Test
	void test_Question() {
		assertNotNull(question);
		assertEquals('W', question.getQuestionAsked().charAt(0));
	}
	@Test
	void test_company_map() {
		assertNotNull(question.getCompanies());
		assertFalse(question.getCompanies().isEmpty());
	
	}
	@Test
	void test_category_map() {
		assertNotNull(question.getCategory());
		assertEquals("General", question.getCategory().getName());
	}
}
