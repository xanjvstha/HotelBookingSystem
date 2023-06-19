package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.BookingLibrary;
import model.BookingLibrary1;

public class JDBCBooking {
	public boolean insert(BookingLibrary booking) {
		Connection conn;
		PreparedStatement pstat;
		boolean result = false;
		String SQL = "INSERT INTO booking VALUES (?,?,?,?,?,?,?)";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/lutonhotel", "root", "");

			pstat = conn.prepareStatement(SQL);
			
			pstat.setInt(1, booking.getBookingID());
			pstat.setString(2, booking.getCheckInDate());
			pstat.setString(3, booking.getCheckOutDate());
			pstat.setString(4, booking.getRoomType());
			pstat.setString(5, booking.getBookingStatus());
			pstat.setInt(6, booking.getCustomerID());
			pstat.setInt(7, booking.getRoomNo());

			pstat.executeUpdate();
			pstat.close();
			conn.close();
			result = true;
		} catch (Exception ex) {
			System.out.println("Error" + ex.getMessage());
		}
		return result;
	}

	public boolean update(BookingLibrary booking) {

		Connection con;
		boolean res = false;
		String sql = "UPDATE booking SET  CheckInDate = ?, CheckOutDate = ?, RoomType = ? WHERE BookingID = ?";
		PreparedStatement pstat; 
		try {

			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/lutonhotel", "root", "");
			pstat = con.prepareStatement(sql);
			pstat.setString(1, booking.getCheckInDate());
			pstat.setString(2, booking.getCheckOutDate());
			pstat.setString(3, booking.getRoomType());
			pstat.setInt(4, booking.getBookingID());
			pstat.executeUpdate();
			con.close();
			res = true;
		} catch (Exception ex) {
			res = false;
			
			System.out.println("Error : " + ex.getMessage());
		}

		return res;
	}
	
	public boolean checkin(BookingLibrary booking) {

		Connection con;
		boolean res = false;
		String sql = "UPDATE booking SET  BookingStatus = ? WHERE BookingID = ?";
		PreparedStatement pstat; 
		try {

			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/lutonhotel", "root", "");
			pstat = con.prepareStatement(sql);
			pstat.setString(1, booking.getBookingStatus());
			pstat.setInt(2, booking.getBookingID());
			pstat.executeUpdate();
			con.close();
			res = true;
		} catch (Exception ex) {
			res = false;
			
			System.out.println("Error : " + ex.getMessage());
		}

		return res;
	}
	
	public boolean deleteBooking(int id) {
		
		Connection con;
		boolean res = false;
		String sql = "DELETE FROM booking WHERE BookingID = ?";
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
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public ArrayList customerselectall(int id) {
		Connection conn;
		PreparedStatement pstat;
		ResultSet rs;
		ArrayList<BookingLibrary1>a1=new ArrayList();
		String sql="SELECT customer.CustomerID, customer.FullName, booking.BookingID, "
				+ "booking.CheckInDate, booking.CheckOutDate, "
				+ "booking.RoomType, booking.BookingStatus, "
				+ "booking.RoomNo  FROM booking LEFT JOIN customer"
				+ " ON booking.CustomerID = customer.CustomerID WHERE customer.CustomerID=?;";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/lutonhotel","root","");
			
			pstat=conn.prepareStatement(sql);
			pstat.setInt(1, id);
//			pstat.setInt(1,Global.currentLoginLibrary.getCustomerID());
		
			rs=pstat.executeQuery();
			
			while(rs.next()) {
				BookingLibrary1 booking=new BookingLibrary1
						(rs.getInt("CustomerID"),
						rs.getString("FullName"),
						rs.getInt("BookingID"),
						rs.getString("CheckInDate"),
						rs.getString("CheckOutDate"),
						rs.getString("RoomType"),
						rs.getString("BookingStatus"),
						rs.getInt("RoomNo")
						);
				
				a1.add(booking);
				
			}
		}
		catch(Exception ex) {
			System.out.println("Error"+ex.getMessage());
		}
		return a1;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public ArrayList receptionselect() {
		Connection conn;
		PreparedStatement pstat;
		ResultSet rs;
		ArrayList<BookingLibrary1>a2=new ArrayList();
		String sql = "SELECT customer.CustomerID, customer.FullName, booking.BookingID, booking.CheckInDate, booking.CheckOutDate, booking.RoomType, booking.BookingStatus, booking.RoomNo FROM booking"
				+ " LEFT JOIN customer ON booking.CustomerID = customer.CustomerID"
				+ " WHERE booking.BookingStatus <> 'Inactive'";
//		String sql="SELECT customer.CustomerID, customer.FullName, booking.BookingID, booking.CheckInDate, booking.CheckOutDate, booking.RoomType, booking.BookingStatus, booking.RoomNo FROM booking LEFT JOIN customer ON booking.CustomerID = customer.CustomerID";
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/lutonhotel","root","");
			
			pstat=conn.prepareStatement(sql);
		
			rs=pstat.executeQuery();
			
			while(rs.next()) {
				BookingLibrary1 booking=new BookingLibrary1
						(rs.getInt("CustomerID"),
						rs.getString("FullName"),
						rs.getInt("BookingID"),
						rs.getString("CheckInDate"),
						rs.getString("CheckOutDate"),
						rs.getString("RoomType"),
						rs.getString("BookingStatus"),
						rs.getInt("RoomNo")
						);
				
				a2.add(booking);
				
			}
		}
		catch(Exception ex) {
			System.out.println("Error"+ex.getMessage());
		}
		return a2;
		
	}
	
	public boolean receptionUpdate (BookingLibrary1 booking) {
		
		Connection con;
		boolean res = false;
		String sql = "UPDATE booking SET BookingStatus = ?, RoomNo = ? WHERE BookingID=?";
		PreparedStatement pstat; 
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/lutonhotel", "root", "");
			pstat = con.prepareStatement(sql);
			
			pstat.setString(1, booking.getBookingStatus());
			pstat.setInt(2,booking.getRoomNo());
			pstat.setInt(3, booking.getBookingID());
			
			pstat.executeUpdate();
			con.close();
			res = true;
		} catch (Exception ex) {			
			System.out.println("Error : " + ex.getMessage());
		}

		return res;
	}
}