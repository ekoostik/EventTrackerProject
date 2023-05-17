package com.skilldistillery.jobapp.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CompanyTest {
	
	private static EntityManagerFactory emf; 
	private EntityManager em;
	private Company comp;

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
		comp = em.find(Company.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
	em.close();
	comp = null;
	}

	@Test
	void test_company_map() {
		assertNotNull(comp);
		assertEquals("McDonalds", comp.getName());
	}
	@Test
	void test_contactList() {
		assertNotNull(comp.getContacts());
		assertFalse(comp.getContacts().isEmpty());
	}
	@Test
	void test_questionList() {
		assertNotNull(comp.getQuestions());
		assertFalse(comp.getQuestions().isEmpty());
	}



}
