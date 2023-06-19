package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.BarLibrary;

public class JDBCBarService {
	
	public boolean insert(BarLibrary bar) {
		Connection conn;
		PreparedStatement pstat;
		boolean result = false;
		String SQL = "INSERT INTO barservice (BarID,BarMenu,DrinkPrice,BookingID,EmployeeID) VALUES (?,?,?,?,?)";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/lutonhotel", "root", "");

			pstat = conn.prepareStatement(SQL);
			
			pstat.setInt(1, bar.getBarID());
			pstat.setString(2, bar.getBarMenu());
			pstat.setInt(3, bar.getDrinkPrice());
			pstat.setInt(4, bar.getBookingID());
			pstat.setInt(5, bar.getEmployeeID());
			
			pstat.executeUpdate();
			pstat.close();
			conn.close();
			result = true;
		} catch (Exception ex) {
			System.out.println("Error" + ex.getMessage());
		}
		return result;
	}
	
	public ArrayList<BarLibrary> selectall() {
		String sql = "SELECT * FROM barservice ";
		ArrayList<BarLibrary> a1 = new ArrayList<BarLibrary>();
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/lutonhotel", "root", "");
			
			PreparedStatement pstat = con.prepareStatement(sql);
			ResultSet rs = pstat.executeQuery();
			while (rs.next()) {
				BarLibrary res = new BarLibrary
						(rs.getInt("BarID"),
						 rs.getString("BarMenu"),
						 rs.getInt("DrinkPrice"),
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