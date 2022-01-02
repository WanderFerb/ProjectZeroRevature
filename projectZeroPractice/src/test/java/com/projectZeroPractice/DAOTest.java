package com.projectZeroPractice;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.projectZeroPractice.dao.ProjectZeroDAOInteface;
import com.projectZeroPractice.entity.ProjectZeroUser;
import com.projectZeroPractice.entity.TimelineEntity;
import com.projectZeroPractice.utility.ControllerFactory;
import com.projectZeroPractice.utility.DAOFactory;

public class DAOTest {

	private ProjectZeroDAOInteface pzdi;

	@Before
	public void setUp() throws Exception {
		pzdi = DAOFactory.createObject();
	}

	@After
	public void tearDown() throws Exception {
		pzdi = null;
	}

	@Test
	public void testCreateProfileDAO() {
		ProjectZeroUser pzu = new ProjectZeroUser();
		pzu.setName("b");
		pzu.setEmail("b");
		pzu.setPassword("b");
		pzu.setAddress("b");

		int i = pzdi.createProfileDAO(pzu);
		assert i > 0 : "Profile Creation Failed";
	}

	@Test
	public void testViewProfileDAO() {
		ProjectZeroUser pzu = new ProjectZeroUser();

		pzu.setEmail("a");
		pzu.setPassword("a");

		int i = pzdi.createProfileDAO(pzu);
		assert i > 0 : "Profile View Failed";
	}

	@Test
	public void testViewAllProfileDAO() {
		List<ProjectZeroUser> pzl1 = pzdi.viewAllProfileDAO();
		assert pzl1 != null : "View All Profile Failed";
	}

	@Test
	public void testDeleteProfileDAO() {
		ProjectZeroUser pzu = new ProjectZeroUser();

		pzu.setEmail("b");
		pzu.setPassword("b");

		int i = pzdi.deleteProfileDAO(pzu);
		assert i > 0 : "Profile deletion Failed";
	}

	@Test
	public void testLoginProfileDAO() {
		ProjectZeroUser pzu = new ProjectZeroUser();

		pzu.setEmail("a");
		pzu.setPassword("a");

		int i = pzdi.deleteProfileDAO(pzu);
		assert i > 0 : "Profile View Failed";
	}



}
