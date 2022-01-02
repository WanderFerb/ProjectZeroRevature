package com.projectZeroPractice;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.projectZeroPractice.controller.ProjectZeroControllerInterface;
import com.projectZeroPractice.utility.ControllerFactory;

public class ControllerTest {
	
	private ProjectZeroControllerInterface pzci;

	@Before
	public void setUp() throws Exception {
		pzci= ControllerFactory.creatObject();
	}

	@After
	public void tearDown() throws Exception {
		pzci = null;
	}

	@Test
	public void testCreateProfileController() {
		int i =  pzci.createProfileController();
		assert i>0:"Profile creation failed";
	}

	@Test
	public void testViewProfileController() {
		int i =  pzci.viewProfileController();
		assert i>0:"Profile view failed";
	}

	@Test
	public void testViewAllProfileController() {
		int i =  pzci.viewAllProfileController();
		assert i>0:"Profile all view failed";
	}

	@Test
	public void testDeleteProfileController() {
		int i =  pzci.deleteProfileController();
		assert i>0:"Profile deletion failed";
	}

	@Test
	public void testLoginProfileController() {
		int i =  pzci.loginProfileController();
		assert i>0:"Profile login failed";
	}

}
