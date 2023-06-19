package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import model.CustomerLoginLibrary;

public class JDBCCustomerLogin {
	
	public boolean customerlogin(CustomerLoginLibrary customeruser) {
		boolean login = false;
		Connection conn;
		PreparedStatement pstat;
		ResultSet rs;
		String sql="SELECT * FROM customer WHERE Username=? AND Password=?";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/lutonhotel","root","");
			
			pstat=conn.prepareStatement(sql);
			
			pstat.setString(1, customeruser.getUsername());
			pstat.setString(2, customeruser.getPassword());
			
			rs=pstat.executeQuery();
			while(rs.next()) {
				login = true;
				
				int id = rs.getInt("CustomerID");
				String fullname = rs.getString("FullName");
				String password = rs.getString("Password");
				
				customeruser.setCustomerID(id);
				customeruser.setFullName(fullname);
				customeruser.setAccountType(rs.getString("AccountType"));
				customeruser.setNewPassword(password);
			}
		}
		catch(Exception ex) {
			System.out.println("Error"+ex.getMessage());
			login = false;
		}
		return login;
	}
}