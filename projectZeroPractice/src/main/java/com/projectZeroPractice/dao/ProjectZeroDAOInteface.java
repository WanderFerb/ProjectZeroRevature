package com.projectZeroPractice.dao;

import java.util.List;

import com.projectZeroPractice.entity.ProjectZeroUser;
import com.projectZeroPractice.entity.TimelineEntity;

public interface ProjectZeroDAOInteface {

	int createProfileDAO(ProjectZeroUser pzu);

	ProjectZeroUser viewProfileDAO(ProjectZeroUser pzu);

	List<ProjectZeroUser> viewAllProfileDAO();

	
	int deleteProfileDAO(ProjectZeroUser pzu);

	ProjectZeroUser loginProfileDAO(ProjectZeroUser pzu);

	List<TimelineEntity> viewTimelineDAO(ProjectZeroUser pzu);

	

	


}
