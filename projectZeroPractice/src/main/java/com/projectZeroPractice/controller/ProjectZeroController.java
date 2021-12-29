package com.projectZeroPractice.controller;

import java.util.List;
import java.util.Scanner;

import com.projectZeroPractice.entity.ProjectZeroUser;
import com.projectZeroPractice.entity.TimelineEntity;
import com.projectZeroPractice.service.ProjectZeroServiceInterface;
import com.projectZeroPractice.utility.ServiceFactory;

public class ProjectZeroController implements ProjectZeroControllerInterface {

	public int createProfileController() {

		Scanner sc = new Scanner(System.in);

		System.out.println("Enter Name : ");
		String name = sc.next();

		System.out.println("Enter Email : ");
		String email = sc.next();

		System.out.println("Enter Password : ");
		String password = sc.next();

		System.out.println("Enter Address : ");
		String address = sc.next();

		ProjectZeroUser pzu = new ProjectZeroUser();
		pzu.setName(name);
		pzu.setEmail(email);
		pzu.setPassword(password);
		pzu.setAddress(address);

		ProjectZeroServiceInterface pzsi = ServiceFactory.createObject();

		return pzsi.createProfileService(pzu);
	}

	@Override
	public int viewProfileController() {
		int i = 0;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Email");
		String email = sc.next();

		ProjectZeroUser pzu = new ProjectZeroUser();
		pzu.setEmail(email);

		ProjectZeroServiceInterface pzsi = ServiceFactory.createObject();
		ProjectZeroUser pzu1 = pzsi.viewProfileService(pzu);

		if (pzu1 != null) {
			System.out.println("Name is : " + pzu1.getName());
			System.out.println("Email is : " + pzu1.getEmail());
			System.out.println("Password is : " + pzu1.getPassword());
			System.out.println("Address is : " + pzu1.getAddress());
			i = 1;
		} else {

		}

		return i;
	}

	@Override
	public int viewAllProfileController() {
		ProjectZeroServiceInterface pzsi = ServiceFactory.createObject();
		List<ProjectZeroUser> pzu1 = pzsi.viewAllProfileService();

		for (ProjectZeroUser pzu2 : pzu1) {
			System.out.println("********Displaying All Profiles***************");
			System.out.println("Name is : " + pzu2.getName());
			System.out.println("Email is : " + pzu2.getEmail());
			System.out.println("Password is : " + pzu2.getPassword());
			System.out.println("Address is : " + pzu2.getAddress());

		}

		return pzu1.size();
	}

	@Override
	public int deleteProfileController() {

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Email");
		String email = sc.next();

		ProjectZeroUser pzu = new ProjectZeroUser();
		pzu.setEmail(email);

		ProjectZeroServiceInterface pzsi = ServiceFactory.createObject();
		int pzu1 = pzsi.deleteProfileService(pzu);

		return pzu1;
	}

	@Override
	public int loginProfileController() {
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter Email : ");
		String email = sc.next();

		System.out.println("Enter Password : ");
		String password = sc.next();

		ProjectZeroUser pzu = new ProjectZeroUser();
		pzu.setEmail(email);
		pzu.setPassword(password);
		
		ProjectZeroServiceInterface pzsi = ServiceFactory.createObject();
		ProjectZeroUser pzu2 = pzsi.loginProfileService(pzu);
		
		if (pzu2!=null) {
			System.out.println("Welcome "+pzu2.getName());
			
			System.out.println("Press 1 to View Timeline");
			System.out.println("Press 2 to Upload Photo");
			
			System.out.println("Enter your choice");
			int choice1= sc.nextInt();
			
			switch (choice1) {
			case 1: List<TimelineEntity> tresult=pzsi.timelineService(pzu);
				for (TimelineEntity ti: tresult) {
					System.out.println("Sender of Message is :" +ti.getSender());
					System.out.println("Sender of Message is :" +ti.getTimeOfMessage());
					System.out.println("Sender of Message is :" +ti.getMessage());
					System.out.println("Sender of Message is :" +ti.getReciever());
				}
			}
		}

	return 0;
}

}
