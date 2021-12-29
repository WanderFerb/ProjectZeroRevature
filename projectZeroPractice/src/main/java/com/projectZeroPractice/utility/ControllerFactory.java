package com.projectZeroPractice.utility;

import com.projectZeroPractice.controller.ProjectZeroController;
import com.projectZeroPractice.controller.ProjectZeroControllerInterface;

public class ControllerFactory {
	
	private ControllerFactory() {}
	

	public static ProjectZeroControllerInterface creatObject() {
		// TODO Auto-generated method stub
		return new ProjectZeroController();
	}

}
