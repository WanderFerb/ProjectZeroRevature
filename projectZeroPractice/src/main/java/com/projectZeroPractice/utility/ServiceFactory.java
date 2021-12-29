package com.projectZeroPractice.utility;

import com.projectZeroPractice.service.ProjectZeroService;
import com.projectZeroPractice.service.ProjectZeroServiceInterface;

public class ServiceFactory {
	
	private ServiceFactory() {}

	public static ProjectZeroServiceInterface createObject() {
		
		return new ProjectZeroService();
	}

}
