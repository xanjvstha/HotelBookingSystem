package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.RestaurantLibrary;

public class JDBCRestaurant {
	
	public boolean insert(RestaurantLibrary foodservice) {
		Connection conn;
		PreparedStatement pstat;
		boolean result = false;
		String SQL = "INSERT INTO foodservice (FoodID,FoodMenu,FoodPrice,BookingID,EmployeeID) VALUES (?,?,?,?,?)";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/lutonhotel", "root", "");

			pstat = conn.prepareStatement(SQL);
			
			pstat.setInt(1, foodservice.getFoodID());
			pstat.setString(2, foodservice.getFoodMenu());
			pstat.setInt(3, foodservice.getFoodPrice());
			pstat.setInt(4,foodservice.getBookingID());
			pstat.setInt(5, foodservice.getEmployeeID());
			
			pstat.executeUpdate();
			pstat.close();
			conn.close();
			result = true;
		} catch (Exception ex) {
			System.out.println("Error" + ex.getMessage());
		}
		return result;
	}
	
	public ArrayList<RestaurantLibrary> selectall() {
		String sql = "SELECT * FROM foodservice ";
		ArrayList<RestaurantLibrary> a1 = new ArrayList<RestaurantLibrary>();
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/lutonhotel", "root", "");

			PreparedStatement pstat = con.prepareStatement(sql);
			ResultSet rs = pstat.executeQuery();
			while (rs.next()) {
				RestaurantLibrary res = new RestaurantLibrary
						(rs.getInt("FoodID"),
						 rs.getString("FoodMenu"),
						 rs.getInt("FoodPrice"),
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