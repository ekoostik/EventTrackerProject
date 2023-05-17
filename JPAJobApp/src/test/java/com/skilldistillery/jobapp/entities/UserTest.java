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

class UserTest {
	
	private static EntityManagerFactory emf; 
	private EntityManager em;
	private User user;

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
		user = em.find(User.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
		user = null;
	}

	@Test
	void testUser() {
		assertNotNull(user);
		assertEquals("David", user.getFirstName());
		
	}
	@Test
	void test_Question_Mapping() {
		assertNotNull(user.getQuestions());
		assertFalse(user.getQuestions().isEmpty());
	}
	@Test
	void test_Offer_Mapping() {
		assertNotNull(user.getOffers());
		assertFalse(user.getOffers().isEmpty());
	}
	
	@Test
	void test_Company_Map() {
		assertNotNull(user.getCompanies());
		assertFalse(user.getCompanies().isEmpty());
	}

}
