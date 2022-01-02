package com.projectZeroPractice.controller;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.List;
import java.util.Scanner;

import com.projectZeroPractice.entity.ProjectZeroUser;
import com.projectZeroPractice.entity.TimelineEntity;
import com.projectZeroPractice.service.ProjectZeroServiceInterface;
import com.projectZeroPractice.utility.ServiceFactory;
import com.projectZeroPractice.view.MainView;


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

		if (pzu2 != null) {
			System.out.println("Welcome " + pzu2.getName());
			
				System.out.println("Press 1 to View Timeline");
//				System.out.println("Press 2 to Add message to Timeline (Feature in making)");
//				System.out.println("Press 3 to Upload Photo");
				System.out.println("Press 2 to exit");
			

			System.out.println("Enter your choice");
			int choice1 = sc.nextInt();

			switch (choice1) {
			case 1:
				List<TimelineEntity> tresult1 = pzsi.timelineShowService(pzu);
				for (TimelineEntity ti1 : tresult1) {
					System.out.println("Sender of Message is :" + ti1.getSender());
					System.out.print("	Time of Message is :" + ti1.getTimeOfMessage());
					System.out.print("		Message :" + ti1.getMessage());
					System.out.println();
					System.out.println("	Reciever of Message is :" + ti1.getReciever());
					System.out.println();
				}
				break;

//			case 2:
//				System.out.println("Enter Details of Message to be sent");
//				Scanner sc1 = new Scanner(System.in);
//
//				System.out.println("Enter Sender Name : ");
//				String sender = sc1.next();
//
//				System.out.println("Enter Time of Message : ");
//				String timeOfMessage = sc1.next();
//
//				System.out.println("Enter Message : ");
//				String message = sc1.next();
//
//				System.out.println("Enter Reciever Name : ");
//				String reciever = sc1.next();
//
//				TimelineEntity tme = new TimelineEntity();
//				tme.setSender(sender);
//				tme.setTimeOfMessage(timeOfMessage);
//				tme.setMessage(message);
//				tme.setReciever(reciever);;
//				break;

//			case 3:
//				System.out.println("To Upload picture, Enter its Path");
//				String picPath = sc.next();
//				try{  
//					Class.forName("oracle.jdbc.driver.OracleDriver");  
//					Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","Abhinav");  
//					              
//					PreparedStatement ps=con.prepareStatement("insert into imgtable values(?,?)");  
//					ps.setString(1,"image");  
//					  
//					FileInputStream fin=new FileInputStream(picPath);  
//					ps.setBinaryStream(2,fin,fin.available());  
//					int i=ps.executeUpdate();  
//					System.out.println(i+" records affected");  
//					          
//					con.close();  
//					}catch (Exception e) {e.printStackTrace();}  			
//				break;
				
			case 2:
				System.out.println("You have exited Profile");
				break;

			default:
				System.out.println("WRONG CHOICE!");
				break;
			}

		}
		return 0;
	}
}
