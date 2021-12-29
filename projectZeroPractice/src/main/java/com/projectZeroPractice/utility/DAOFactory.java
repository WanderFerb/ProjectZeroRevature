package com.projectZeroPractice.utility;

import com.projectZeroPractice.dao.ProjectZeroDAO;
import com.projectZeroPractice.dao.ProjectZeroDAOInteface;

public class DAOFactory {

	private DAOFactory() {}
	
	public static ProjectZeroDAOInteface createObject() {
		
		return new ProjectZeroDAO();
	}

}
