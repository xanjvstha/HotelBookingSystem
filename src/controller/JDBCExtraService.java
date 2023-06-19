package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.ServiceLibrary;

public class JDBCExtraService {

	public boolean insert(ServiceLibrary extraservice) {

		Connection conn;
		PreparedStatement pstat;
		boolean result = false;
		String sql = "INSERT INTO extraservice (ServiceID, ServiceType, ServicePrice, BookingID, EmployeeID) VALUES (?, ?, ?, ?, ?)";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/lutonhotel", "root", "");

			pstat = conn.prepareStatement(sql);
			
			pstat.setInt(1, extraservice.getServiceID());
			pstat.setString(2,extraservice.getServiceType());
			pstat.setInt(3, extraservice.getServicePrice());
			pstat.setInt(4, extraservice.getBookingID());
			pstat.setInt(5, extraservice.getEmployeeID());
				
			pstat.executeUpdate();

			conn.close();
			pstat.close();
			result = true;
		}

		catch (Exception ex) {
			System.out.println("Error" + ex.getMessage());
		}
		return result;
	}
	
	public ArrayList<ServiceLibrary> select_all() {
		String sql = "SELECT * FROM extraservice ";
		ArrayList<ServiceLibrary> a1 = new ArrayList<ServiceLibrary>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/lutonhotel", "root", "");
			PreparedStatement pstat = con.prepareStatement(sql);
			ResultSet rs = pstat.executeQuery();
			while (rs.next()) {
				ServiceLibrary res = new ServiceLibrary
						(rs.getInt("ServiceID"),
						 rs.getString("ServiceType"),
						 rs.getInt("ServicePrice"),
						 rs.getInt("BookingID"),
						 rs.getInt("EmployeeID"));
				
				a1.add(res);		
			}
			rs.close();
			pstat.close();
			con.close();
		} catch (Exception ex) {
			System.out.println("Error : " + ex.getMessage());
		}
		return a1;
	}
}