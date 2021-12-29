package com.projectZeroPractice;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.projectZeroPractice.dao.ProjectZeroDAO;
import com.projectZeroPractice.dao.ProjectZeroDAOInteface;
import com.projectZeroPractice.entity.ProjectZeroUser;

public class DAOTesting {
	
	private ProjectZeroDAOInteface pzdi;

	@Before
	public void setUp() throws Exception {
		pzdi = new ProjectZeroDAO();
	}

	@After
	public void tearDown() throws Exception {
		pzdi=null;
	}

	@Test
	public void testCreateProfileDAO() {
		ProjectZeroUser pzu = new ProjectZeroUser();
		pzu.setName("Amar");
		pzu.setEmail("amar@gmail.com");
		pzu.setPassword("amar");
		pzu.setAddress("ptl");
		int i = pzdi.createProfileDAO(pzu);
		
		assert i>0:"Profile creation failed";
	}

	@Test
	public void testViewProfileDAO() {
		ProjectZeroUser pzu = new ProjectZeroUser();
		
		pzu.setEmail("amar@gmail.com");
		
		ProjectZeroUser i = pzdi.viewProfileDAO(pzu);
		
		assert i!=null:"Profile not found";
	}

}
