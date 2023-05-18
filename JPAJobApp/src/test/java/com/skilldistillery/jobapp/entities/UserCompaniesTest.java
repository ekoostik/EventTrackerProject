package com.skilldistillery.jobapp.entities;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class UserCompaniesTest {
	
	private static EntityManagerFactory emf;
	private EntityManager em;
	private UserCompanies userComp;
	private UserCompaniesId userId;


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
	
		userId = em.find(UserCompaniesId.class, 1);
		userComp = em.find(UserCompanies.class, userId);
		System.out.println(userComp);
	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
		userComp = null;

	}
	

	@Test
	void test() {
		assertNotNull(userComp);;
	}

}
