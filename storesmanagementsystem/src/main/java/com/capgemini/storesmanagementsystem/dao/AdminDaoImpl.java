package com.capgemini.storesmanagementsystem.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.capgemini.storesmanagementsystem.dto.UserDetailsInfo;

public class AdminDaoImpl implements AdminDao {
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	Statement stmt = null;

	public List<String> loginAdmin(String userId, String password) {
		List<String> users = new ArrayList<String>();

		try {
			Class.forName("com.mysql.jdbc.Driver");
			String dburl = "jdbc:mysql://localhost:3306/storemanagement?user=root&password=root";
			con = DriverManager.getConnection(dburl);
			String qry = "select * from users_info where userId ='" + userId + "' and password='" + password + "'";
			pstmt = con.prepareStatement(qry);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				users.add(rs.getString("userId"));
				users.add(rs.getString("password"));

			}
		} catch (Exception e) {
			e.getMessage();
		}

		return users;
	}

	public boolean addManufacturer(UserDetailsInfo user) {
		boolean isAdded = false;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String dburl = "jdbc:mysql://localhost:3306/stores_management_db?user=root&password=root";
			con = DriverManager.getConnection(dburl);
			String qry = " insert into  users_info  values (?,?,?,?,?,?)";
			pstmt = con.prepareStatement(qry);
			pstmt.setString(1, user.getUserId());
			pstmt.setString(2,user.getEmail());
			pstmt.setString(3,user.getAddress());
			pstmt.setString(4, user.getPassword());
			pstmt.setString(5, user.getUserRole());
			pstmt.setString(6, user.getUserName());
			int r = pstmt.executeUpdate();
			

			if (r != 0) {
				isAdded = true;
			}

		} catch (Exception e) {

			e.printStackTrace();
		}

		return isAdded;
	}

	public boolean updateManufacturer(String userId,UserDetailsInfo user) {
		boolean isUpdated = false;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String dburl = "jdbc:mysql://localhost:3306/stores_management_db?user=root&password=root";
			Connection con = DriverManager.getConnection(dburl);

			String qry = "update users_info set userName=?,email=?,password=? where userId='" + userId + "' ";
			pstmt = con.prepareStatement(qry);
			pstmt.setString(1, user.getUserName());
			pstmt.setString(2, user.getEmail());
			pstmt.setString(3, user.getPassword());
			 int n=pstmt.executeUpdate();
			 if (n != 0) {
					isUpdated = true;
				}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return isUpdated;
	}

	public boolean deleteManufacturer(String userId) {
		boolean isDeleted = false;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String dburl = "jdbc:mysql://localhost:3306/stores_management_db?user=root&password=root";
			con = DriverManager.getConnection(dburl);
			String qry = "delete from users_info where userId=?";
			pstmt = con.prepareStatement(qry);
			pstmt.setString(1, userId);
			int r=pstmt.executeUpdate();
			if (r != 0) {
				isDeleted = true;
			}
		} catch (Exception e) {

			e.getMessage();
		}
		return isDeleted;
	}

	public List<String> viewAllManufacturer() {

		List<String> manufactures = new ArrayList<>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String dburl = "jdbc:mysql://localhost:3306/stores_management_db?user=root&password=root";
			Connection con = DriverManager.getConnection(dburl);
			String qry = "select * from userdetailinfo ";
			pstmt=con.prepareStatement(qry);

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				manufactures.add(rs.getString("userName"));
				manufactures.add(rs.getString("userId"));
				manufactures.add(rs.getString("email"));
				manufactures.add(rs.getString("location"));
				
			}
		} catch (Exception e) {

			e.getMessage();
		}

		return manufactures;

	}
	
}