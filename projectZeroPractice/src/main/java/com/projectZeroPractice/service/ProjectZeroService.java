package com.projectZeroPractice.service;

import java.util.List;

import com.projectZeroPractice.dao.ProjectZeroDAOInteface;
import com.projectZeroPractice.entity.ProjectZeroUser;
import com.projectZeroPractice.entity.TimelineEntity;
import com.projectZeroPractice.utility.DAOFactory;

public class ProjectZeroService implements ProjectZeroServiceInterface {

	public int createProfileService(ProjectZeroUser pzu) {
		ProjectZeroDAOInteface pzdi= DAOFactory.createObject();
		return pzdi.createProfileDAO(pzu);
	}

	@Override
	public ProjectZeroUser viewProfileService(ProjectZeroUser pzu) {
		ProjectZeroDAOInteface pzdi= DAOFactory.createObject();
		return pzdi.viewProfileDAO(pzu);
	}

	@Override
	public List<ProjectZeroUser> viewAllProfileService() {
		ProjectZeroDAOInteface pzdi= DAOFactory.createObject();
		return pzdi.viewAllProfileDAO();
	}

	@Override
	public int deleteProfileService(ProjectZeroUser pzu) {
		ProjectZeroDAOInteface pzdi= DAOFactory.createObject();
		return pzdi.deleteProfileDAO(pzu);
	}

	@Override
	public ProjectZeroUser loginProfileService(ProjectZeroUser pzu) {
		ProjectZeroDAOInteface pzdi= DAOFactory.createObject();
		return pzdi.loginProfileDAO(pzu);
	}

	@Override
	public List<TimelineEntity> timelineShowService(ProjectZeroUser pzu) {
		ProjectZeroDAOInteface pzdi= DAOFactory.createObject();
		return pzdi.viewTimelineDAO();
	}

	@Override
	public List<TimelineEntity> timelineAddService(ProjectZeroUser pzu) {
		ProjectZeroDAOInteface pzdi= DAOFactory.createObject();
		return pzdi.addTimelineDAO();
	}

	
	

}
