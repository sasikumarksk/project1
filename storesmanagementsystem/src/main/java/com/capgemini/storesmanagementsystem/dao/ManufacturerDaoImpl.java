package com.capgemini.storesmanagementsystem.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.capgemini.storesmanagementsystem.dto.ProductDetailsInfo;
import com.capgemini.storesmanagementsystem.dto.UserDetailsInfo;

public class ManufacturerDaoImpl implements ManufacturerDao {
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	Statement stmt = null;

	public List<String> loginManufacturer(String userId, String password) {

		List<String> users = new ArrayList<String>();

		try {
			Class.forName("com.mysql.jdbc.Driver");
			String dburl = "jdbc:mysql://localhost:3306/stores_management_db?user=root&password=root";
			con = DriverManager.getConnection(dburl);
			String qry = "select * from userdetailinfo where userId ='" + userId + "' and password='" + password + "'";
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

	public boolean addDealer(UserDetailsInfo dealer) {
		boolean isAdded = false;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String dburl = "jdbc:mysql://localhost:3306/stores_management_db?user=root&password=root";
			con = DriverManager.getConnection(dburl);
			String qry = " insert into  userdetailinfo  values (?,?,?,?,?,?)";
			pstmt = con.prepareStatement(qry);
			pstmt.setString(1, dealer.getUserId());
			pstmt.setString(2, dealer.getEmail());
			pstmt.setString(3, dealer.getAddress());
			pstmt.setString(4, dealer.getPassword());
			pstmt.setString(5, dealer.getUserRole());
			pstmt.setString(6, dealer.getUserName());
			int r = pstmt.executeUpdate();
			System.out.println(r);

			if (r != 0) {
				isAdded = true;
			}

		} catch (Exception e) {

			e.printStackTrace();
		}

		return isAdded;
	}
	

	public boolean modifyDealer(String user) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String dburl = "jdbc:mysql://localhost:3306/stores_management_db?user=root&password=root";
			Connection con = DriverManager.getConnection(dburl);

			String qry = "update userdetailinfo set role='Admin' where userId='" + user + "' ";
			pstmt = con.prepareStatement(qry);
			int i = pstmt.executeUpdate();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return false;
	}

	public boolean removeDealer(String dealerId) {

		try {
			Class.forName("com.mysql.jdbc.Driver");
			String dburl = "jdbc:mysql://localhost:3306/stores_management_db?user=root&password=root";
			con = DriverManager.getConnection(dburl);
			String qry = "delete from userdetailinfo where role='dealer' and userId='" + dealerId + "' ";
			pstmt = con.prepareStatement(qry);
			pstmt.setString(1, dealerId);
			int n = pstmt.executeUpdate();
			System.out.println(n);
		} catch (Exception e) {

			e.getMessage();
		}
		return true;
	}

	public List<String> viewAllDealers(String role) {
		List<String> manufactures = new ArrayList<String>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String dburl = "jdbc:mysql://localhost:3306/stores_management_db?user=root&password=root";
			Connection con = DriverManager.getConnection(dburl);
			String qry = "select * from userdetailinfo where role='" + role + "' ";
			pstmt = con.prepareStatement(qry);

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				manufactures.add(rs.getString("userName"));

			}
		} catch (Exception e) {

			e.getMessage();
		}

		return manufactures;

	}

	public boolean addProduct(ProductDetailsInfo product) {
		boolean isAdded = false;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String dburl = "jdbc:mysql://localhost:3306/stores_management_db?user=root&password=root";
			con = DriverManager.getConnection(dburl);
			String qry = " insert into  productdetailsinfo  values (?,?,?,?,?)";
			pstmt = con.prepareStatement(qry);
			pstmt.setInt(1, product.getProduct());
			pstmt.setString(2, product.getProductName());
			pstmt.setDouble(3, product.getPrice());
			pstmt.setInt(4, product.getStocks());
			pstmt.setString(5, product.getWarranty());

			int r = pstmt.executeUpdate();
			System.out.println(r);

			if (r != 0) {
				isAdded = true;
			}

		} catch (Exception e) {

			e.printStackTrace();
		}

		return isAdded;

	}

	public boolean modifyProduct(String productId) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String dburl = "jdbc:mysql://localhost:3306/stores_management_db?user=root&password=root";
			Connection con = DriverManager.getConnection(dburl);

			String qry = "update  productdetailsinfo set productName='sparx' where productId='" + productId + "' ";
			pstmt = con.prepareStatement(qry);
			pstmt.executeUpdate();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return true;
	}

	public boolean removeProduct(Integer productId) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String dburl = "jdbc:mysql://localhost:3306/stores_management_db?user=root&password=root";
			con = DriverManager.getConnection(dburl);
			String qry = "delete from productdetailsinfo  and productId=? ";
			pstmt = con.prepareStatement(qry);
			pstmt.setInt(1, productId);
			pstmt.executeUpdate();
		} catch (Exception e) {

			e.getMessage();
		}
		return true;

	}

	public List<String> viewAllProducts() {
		List<String> productlist = new ArrayList<String>();

		try {
			Class.forName("com.mysql.jdbc.Driver");
			String dburl = "jdbc:mysql://localhost:3306/stores_management_db?user=root&password=root";
			Connection con = DriverManager.getConnection(dburl);

			String qry = "select * from productdetailsinfo";
			Statement stmt = con.createStatement();

			ResultSet rs = stmt.executeQuery(qry);

			while (rs.next()) {
				productlist.add(rs.getString("brand"));
			}
		} catch (Exception e) {

			e.getMessage();
		}
		return productlist;

	}

	public List<String> viewAllOrders() {
		List<String> productlist = new ArrayList<String>();

		try {
			Class.forName("com.mysql.jdbc.Driver");
			String dburl = "jdbc:mysql://localhost:3306/stores_management_db?user=root&password=root";
			Connection con = DriverManager.getConnection(dburl);

			String qry = "select * from productdetailsinfo";
			Statement stmt = con.createStatement();

			ResultSet rs = stmt.executeQuery(qry);

			while (rs.next()) {
				productlist.add(rs.getString("userId"));
				productlist.add(rs.getString("referenceId"));
				productlist.add(rs.getString("location"));

			}
		} catch (Exception e) {

			e.getMessage();
		}
		return productlist;

	}

	public List<String> viewStore() {

		List<String> productlist = new ArrayList<String>();

		try {
			Class.forName("com.mysql.jdbc.Driver");
			String dburl = "jdbc:mysql://localhost:3306/stores_management_db?user=root&password=root";
			Connection con = DriverManager.getConnection(dburl);

			String qry = "select * from storesinfo";
			Statement stmt = con.createStatement();

			ResultSet rs = stmt.executeQuery(qry);

			while (rs.next()) {
				productlist.add(rs.getString("productId"));
				productlist.add(rs.getString("storesId"));
				productlist.add(rs.getString("minStocksPresent"));
				productlist.add(rs.getString("numOfItems"));
				
			}
		} catch (Exception e) {

			e.getMessage();
		}
		return productlist;

	}



}

	
			




