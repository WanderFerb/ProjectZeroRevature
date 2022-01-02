package com.projectZeroPractice.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import com.projectZeroPractice.entity.ProjectZeroUser;
import com.projectZeroPractice.entity.TimelineEntity;

public class ProjectZeroDAO implements ProjectZeroDAOInteface {

	public int createProfileDAO(ProjectZeroUser pzu) {
		int i = 0;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "Abhinav");
			PreparedStatement ps = con.prepareStatement("insert into projectzeropractice values(?,?,?,?)");
			ps.setNString(1, pzu.getName());
			ps.setNString(2, pzu.getEmail());
			ps.setNString(3, pzu.getPassword());
			ps.setNString(4, pzu.getAddress());
			i = ps.executeUpdate();

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return i;
	}

	@Override
	public ProjectZeroUser viewProfileDAO(ProjectZeroUser pzu) {

		ProjectZeroUser pzl = null;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "Abhinav");
			PreparedStatement ps = con.prepareStatement("select * from projectzeropractice where email=?");

			ps.setNString(1, pzu.getEmail());

			ResultSet res = ps.executeQuery();

			if (res.next()) {
				pzl = new ProjectZeroUser();
				pzl.setName(res.getString(1));
				pzl.setEmail(res.getString(2));
				pzl.setPassword(res.getString(3));
				pzl.setAddress(res.getString(4));
			}

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return pzl;
	}

	@Override
	public List<ProjectZeroUser> viewAllProfileDAO() {

		List<ProjectZeroUser> pzl1 = new ArrayList<ProjectZeroUser>();

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "Abhinav");
			PreparedStatement ps = con.prepareStatement("select * from projectzeropractice");

			ResultSet res = ps.executeQuery();

			while (res.next()) {
				ProjectZeroUser pzul = new ProjectZeroUser();
				pzul.setName(res.getString(1));
				pzul.setEmail(res.getString(2));
				pzul.setPassword(res.getString(3));
				pzul.setAddress(res.getString(4));

				pzl1.add(pzul);
			}

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return pzl1;
	}

	@Override
	public int deleteProfileDAO(ProjectZeroUser pzu) {
		int i = 0;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "Abhinav");
			PreparedStatement ps = con.prepareStatement("delete from projectzeropractice where email=?");
			ps.setNString(1, pzu.getEmail());
			i = ps.executeUpdate();

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return i;
	}

	@Override
	public ProjectZeroUser loginProfileDAO(ProjectZeroUser pzu) {
		
		ProjectZeroUser pzl = null;
		
		int i = 0;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "Abhinav");
			PreparedStatement ps = con.prepareStatement("select * from projectzeropractice where email=? and password=?");

			
			ps.setString(2, pzu.getEmail());
			ps.setString(1, pzu.getPassword());
			
			
			ResultSet res = ps.executeQuery();

			if (res.next()) {
				pzl = new ProjectZeroUser();
				pzl.setName(res.getString(1));
				pzl.setEmail(res.getString(2));
				pzl.setPassword(res.getString(3));
				pzl.setAddress(res.getString(4));
			}

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return pzl;
	}

	@Override
	public List<TimelineEntity> viewTimelineDAO() {
		List<TimelineEntity> pzl1 = new ArrayList<TimelineEntity>();
	
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "Abhinav");
				PreparedStatement ps = con.prepareStatement("select * from timeline");
	
				ResultSet res = ps.executeQuery();
	
				while (res.next()) {
					TimelineEntity tme = new TimelineEntity();
					tme.setSender(res.getString(1));
					tme.setTimeOfMessage(res.getString(2));
					tme.setMessage(res.getString(3));
					tme.setReciever(res.getString(4));
				

				pzl1.add(tme);
			}
			

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return pzl1;
	}

	@Override
	public List<TimelineEntity> addTimelineDAO() {
		List<TimelineEntity> pzl2 = new ArrayList<TimelineEntity>();

		int i = 0;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "Abhinav");
			PreparedStatement ps = con.prepareStatement("insert into timeline values(?,?,?,?)");

			TimelineEntity tme = new TimelineEntity();
			ps.setNString(1, tme.getSender());
			ps.setNString(2, tme.getTimeOfMessage());
			ps.setNString(3, tme.getMessage());
			ps.setNString(4, tme.getReciever());
			
			i = ps.executeUpdate();

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return pzl2;
	}

}
