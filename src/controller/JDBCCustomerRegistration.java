package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.RegistrationLibrary;

public class JDBCCustomerRegistration {

	public boolean insert(RegistrationLibrary registration) {

		Connection conn;
		PreparedStatement pstat;
		boolean result = false;
		String SQL = "INSERT INTO customer VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/lutonhotel", "root", "");

			pstat = conn.prepareStatement(SQL);

			pstat.setInt(1, registration.getCustomerID());
			pstat.setString(2, registration.getFullName());
			pstat.setString(3, registration.getAddress());
			pstat.setString(4, registration.getDistrict());
			pstat.setString(5, registration.getState());
			pstat.setString(6, registration.getPostcode());
			pstat.setString(7, registration.getCountry());
			pstat.setString(8, registration.getEmailID());
			pstat.setString(9, registration.getMobileNo());
			pstat.setString(10, registration.getUsername());
			pstat.setString(11, registration.getPassword());
			pstat.setString(12, registration.getAccountType());

			pstat.executeUpdate();

			conn.close();
			pstat.close();
			result = true;

		} catch (Exception ex) {
			System.out.println("Error" + ex.getMessage());
		}
		return result;
	}

	public ArrayList<RegistrationLibrary> select_all() {
		String sql = "SELECT * FROM customer";
		ArrayList<RegistrationLibrary> a1 = new ArrayList<RegistrationLibrary>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/lutonhotel", "root", "");
			PreparedStatement pstat = con.prepareStatement(sql);
			
			
			ResultSet rs = pstat.executeQuery();
			while (rs.next()) {
				RegistrationLibrary reg = new RegistrationLibrary
					    (rs.getInt("CustomerID"),
						rs.getString("FullName"),
						rs.getString("Address"),
						rs.getString("District"),
						rs.getString("State"),
						rs.getString("Postcode"),
						rs.getString("Country"),
						rs.getString("EmailID"), 
						rs.getString("MobileNo"),
						rs.getString("Username"),
						rs.getString("Password"),
						rs.getString("AccountType"));
				a1.add(reg);
			}
			rs.close();
			pstat.close();
			con.close();
		} catch (Exception ex) {
			System.out.println("Error : " + ex.getMessage());
		}
		return a1;
	}
	
	public boolean update(RegistrationLibrary registration) {
		
		Connection con;
		boolean res = false;
		String sql = "UPDATE customer SET FullName = ?, Address = ?, District = ?, State = ?, Postcode = ?, Country = ?, EmailID = ? , MobileNo = ?, Username = ?, Password = ?, AccountType = ? WHERE CustomerID = ?";
		PreparedStatement pstat;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/lutonhotel", "root", "");
			pstat = con.prepareStatement(sql);
			pstat.setString(1, registration.getFullName());
			pstat.setString(2, registration.getAddress());
			pstat.setString(3, registration.getDistrict());
			pstat.setString(4, registration.getState());
			pstat.setString(5, registration.getPostcode());
			pstat.setString(6, registration.getCountry());
			pstat.setString(7, registration.getEmailID());
			pstat.setString(8, registration.getMobileNo());
			pstat.setString(9, registration.getUsername());
			pstat.setString(10, registration.getPassword());
			pstat.setString(11, registration.getAccountType());
			pstat.setInt(12, registration.getCustomerID());

			pstat.executeUpdate();
			con.close();
			res = true;
		} catch (Exception ex) {
			res = false;
			System.out.println("Error : " + ex.getMessage());
		}
		return res;
	}
	
	public boolean delete(int id) {
		Connection con;
		boolean res = false;
		String sql = "DELETE FROM customer WHERE CustomerID = ?";
		PreparedStatement pstat;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/lutonhotel", "root", "");
			pstat = con.prepareStatement(sql);
			pstat.setInt(1, id);
			pstat.executeUpdate();
			con.close();
			res = true;
		} catch (Exception ex) {
			res = false;
			System.out.println("Error : " + ex.getMessage());
		}

		return res;
	}
}