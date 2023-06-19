package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import model.InvoiceLibrary;
import model.InvoiceLibrary2;
import model.BookingLibrary1;

public class JDBCBilling extends Database {

	SimpleDateFormat dateformate = new SimpleDateFormat("yyyy-MM-dd");
	Date date = new Date();
	String currentDate = dateformate.format(date);

	@SuppressWarnings("rawtypes")
	public ArrayList selectinvoice(InvoiceLibrary billing1) {

		Connection conn;
		PreparedStatement pstat;
		ResultSet rs;
		@SuppressWarnings("unchecked")
		ArrayList<InvoiceLibrary> Billing = new ArrayList();
		
		String sql = "SELECT booking.BookingID, booking.CheckInDate, booking.CheckOutDate, customer.FullName, roomservice.RoomNo, roomservice.RoomPrice,"    
			    + " (SELECT SUM(foodservice.FoodPrice) FROM foodservice WHERE foodservice.BookingID =booking.BookingID) AS FoodPrice,"
			    + " (SELECT SUM(barservice.DrinkPrice) FROM barservice WHERE barservice.BookingID = booking.BookingID) AS DrinkPrice,"
			    + " (SELECT SUM(extraservice.ServicePrice)FROM extraservice WHERE extraservice.BookingID = booking.BookingID) AS ServicePrice"
			    + " FROM booking LEFT JOIN customer ON booking.CustomerID = customer.CustomerID"
			    + " LEFT JOIN roomservice ON booking.RoomNo = roomservice.RoomNo"
			    + " LEFT JOIN foodservice ON foodservice.BookingID = booking.BookingID"
			    + " LEFT JOIN extraservice ON extraservice.BookingID = booking.BookingID"
			    + " LEFT JOIN barservice ON barservice.BookingID = booking.BookingID"
			    + " WHERE booking.BookingStatus='Active'"
			    + " GROUP BY booking.BookingID";
		try {
			conn = connect();
			
			pstat = conn.prepareStatement(sql);			

			rs = pstat.executeQuery();

			while (rs.next()) {
				
				InvoiceLibrary billing = new InvoiceLibrary(rs.getInt("BookingID"), rs.getString("CheckInDate"),
						rs.getString("CheckOutDate"), rs.getString("FullName"), rs.getInt("RoomNo"),
						rs.getInt("RoomPrice"), rs.getInt("FoodPrice"), rs.getInt("DrinkPrice"), rs.getInt("ServicePrice"));

				Billing.add(billing);
			}

		} catch (Exception ex) {
			System.out.println("Error" + ex.getMessage());
		}
		return Billing;
	}

	public boolean insertbilling(InvoiceLibrary2 billing) {

		Connection conn;
		PreparedStatement pstat;
		boolean result = false;
		String sql = "INSERT INTO checkout (BookingID,BillingID,FullName,CheckInDate,CheckOutDate,StayedDays,DrinkAmount,ServiceAmount,FoodAmount,RoomAmount,SubTotalAmount,Discount,GrandTotal,BillingStatus,EmployeeID)VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";
		try {

			conn = connect();

			pstat = conn.prepareStatement(sql);
			pstat.setInt(1, billing.getBookingID());
			pstat.setInt(2, billing.getBillingID());
			pstat.setString(3, billing.getFullName());
			pstat.setString(4, billing.getCheckInDate());
			pstat.setString(5, billing.getCheckOutDate());
			pstat.setString(6, billing.getStayedDays());
			pstat.setInt(7, billing.getDrinkAmount());
			pstat.setInt(8, billing.getServiceAmount());
			pstat.setInt(9, billing.getFoodAmount());
			pstat.setInt(10, billing.getRoomAmount());
			pstat.setDouble(11, billing.getSubTotalAmount());
			pstat.setDouble(12, billing.getDiscount());
			pstat.setDouble(13, billing.getGrandTotal());
			pstat.setString(14, billing.getBillingStatus());
			pstat.setInt(15, billing.getEmployeeID());

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

	public boolean update(BookingLibrary1 booking) {

		Connection conn;
		PreparedStatement pstat;
		boolean result5 = false;
		String sql = "UPDATE booking SET BookingStatus = ? WHERE BookingID=?";
		try {

			conn = connect();

			pstat = conn.prepareStatement(sql);

			pstat.setString(1, booking.getBookingStatus());
			pstat.setInt(2, booking.getBookingID());

			pstat.executeUpdate();
			conn.close();
			pstat.close();
			result5 = true;

		} catch (Exception ex) {
			System.out.println("Error" + ex.getMessage());
		}
		return result5;
	}
}