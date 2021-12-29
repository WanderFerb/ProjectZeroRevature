package com.projectZeroPractice.view;

import java.util.Scanner;

import com.projectZeroPractice.controller.ProjectZeroControllerInterface;
import com.projectZeroPractice.entity.ProjectZeroUser;
import com.projectZeroPractice.utility.ControllerFactory;

public class MainView {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		String cont= "y";
		
		while(cont.equals("y")) {
			System.out.println("***********WELCOME TO MAIN MENU************");
			System.out.println("Press 1 to Create/Signup Profile");
			System.out.println("Press 2 to Login/Edit Profile");
			System.out.println("Press 3 to Delete Profile");
			System.out.println("Press 4 to View Profile");
			System.out.println("Press 5 to Search/View All Profile");
						
			int choice=sc.nextInt();
			
			ProjectZeroControllerInterface pzci = ControllerFactory.creatObject();
			
			switch (choice) {
			case 1:
				int i = pzci.createProfileController();
				
				if (i>0) {
					System.out.println("Profile created");
				}
				else {
					System.out.println("Couldn't create Profile");
				}
				break;
				
			case 2:
				int i2 = pzci.loginProfileController();
						
				if (i2>0) {
					System.out.println("Profile Logged In Successfully");
					
				}
				else {
					System.out.println("Couldn't Login into Profile");
				}
				break;
			
			case 3:
				int i3 = pzci.deleteProfileController();
				if (i3>0) {
					System.out.println("Profile deleted");
				}
				else {
					System.out.println("Couldn't delete Profile");
				}
				break;
				
			case 4:
				int i4 = pzci.viewProfileController();
				if (i4>0) {
					System.out.println("Profile Found");
				}
				else {
					System.out.println("Couldn't find Profile");
				}
				break;
				
			case 5:
				int i5 = pzci.viewAllProfileController();
				if (i5>0) {
					System.out.println(i5+"Profiles(s)Found");
				}
				else {
					System.out.println("Couldn't find any Profile");
				}
				break;


			default:
				System.out.println("WRONG CHOICE!!!");
				break;
			}
			System.out.println("Do you want to continue, Press y/n");
			cont = sc.next();
			
		}

	}

}
