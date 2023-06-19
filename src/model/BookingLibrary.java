package model;

public class BookingLibrary {
	int BookingID;
	String CheckInDate;
	String CheckOutDate;
	String RoomType;
	String BookingStatus;
	int CustomerID;
	int RoomNo;

	public BookingLibrary() {
		this.BookingID = 0;
		this.CheckInDate = "";
		this.CheckOutDate = "";
		this.RoomType = "";
		this.BookingStatus = "";
		this.CustomerID = 0;
		this.RoomNo = 0;
	}

	public BookingLibrary(int bookingid, String checkindate, String checkoutdate, String roomtype,	String bookingstatus, int customerid, int roomno) {
		this.BookingID = bookingid;
		this.CheckInDate = checkindate;
		this.CheckOutDate = checkoutdate;
		this.RoomType = roomtype;
		this.BookingStatus = bookingstatus;
		this.CustomerID= customerid;
		this.RoomNo = roomno;
	}

	public int getBookingID() {
		return BookingID;
	}

	public void setBookingID(int bookingid) {
		BookingID = bookingid;
	}

	public String getCheckInDate() {
		return CheckInDate;
	}

	public void setCheckInDate(String checkindate) {
		CheckInDate = checkindate;
	}

	public String getCheckOutDate() {
		return CheckOutDate;
	}

	public void setCheckOutDate(String checkoutdate) {
		CheckOutDate = checkoutdate;
	}

	public String getRoomType() {
		return RoomType;
	}

	public void setRoomType(String roomtype) {
		this.RoomType = roomtype;
	}

	public String getBookingStatus() {
		return BookingStatus;
	}

	public void setBookingStatus(String bookingstatus) {
		this.BookingStatus = bookingstatus;
	}

	public int getCustomerID() {
		return CustomerID;
	}

	public void setCustomerID(int customerid) {
		CustomerID = customerid;
	}

	public int getRoomNo() {
		return RoomNo;
	}

	public void setRoomNo(int roomno) {
		this.RoomNo = roomno;
	}

	@Override
	public String toString() {
		return "BookingLibrary [BookingID=" + BookingID + ", CheckInDate=" + CheckInDate + ", CheckOutDate="
				+ CheckOutDate + ", RoomType=" + RoomType + ", BookingStatus=" + BookingStatus + ", CustomerID="
				+ CustomerID + ", RoomNo=" + RoomNo + "]";
	}
	
	
	
	
	




}
	

	