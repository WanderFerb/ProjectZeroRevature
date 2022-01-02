package com.projectZeroPractice.service;

import java.util.List;

import com.projectZeroPractice.entity.ProjectZeroUser;
import com.projectZeroPractice.entity.TimelineEntity;

public interface ProjectZeroServiceInterface {

	int createProfileService(ProjectZeroUser pzu);

	ProjectZeroUser viewProfileService(ProjectZeroUser pzu);

	List<ProjectZeroUser> viewAllProfileService();

	int deleteProfileService(ProjectZeroUser pzu);

	ProjectZeroUser loginProfileService(ProjectZeroUser pzu);

	List<TimelineEntity> timelineShowService(ProjectZeroUser pzu);

	List<TimelineEntity> timelineAddService(ProjectZeroUser pzu);

}
