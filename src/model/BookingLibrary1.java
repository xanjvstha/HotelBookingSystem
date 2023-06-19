package model;

public class BookingLibrary1 {
	int CustomerID;
	String FullName;
	int BookingID;
	String CheckInDate;
	String CheckOutDate;
	String RoomType;
	String BookingStatus;
	int RoomNo;
	
	public BookingLibrary1() {
		this.CustomerID = 0;
		this.FullName = "";
		this.BookingID = 0;
		this.CheckInDate = "";
		this.CheckOutDate = "";
		this.RoomType = "";
		this.BookingStatus = "";
		this.RoomNo = 0;
	}

	public BookingLibrary1(int customerid, String fullname, int bookingid, String checkindate, String checkoutdate,
			String roomtype, String bookingstatus, int roomno) {
		
		this.CustomerID = customerid;
		this.FullName = fullname;
		this.BookingID = bookingid;
		this.CheckInDate = checkindate;
		this.CheckOutDate = checkoutdate;
		this.RoomType = roomtype;
		this.BookingStatus = bookingstatus;
		this.RoomNo = roomno;
	}

	public int getCustomerID() {
		return CustomerID;
	}

	public void setCustomerID(int customerid) {
		CustomerID = customerid;
	}

	public String getFullName() {
		return FullName;
	}

	public void setFullName(String fullname) {
		FullName = fullname;
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

	public int getRoomNo() {
		return RoomNo;
	}

	public void setRoomNo(int roomno) {
		this.RoomNo = roomno;
	}

	@Override
	public String toString() {
		return "BookingLibrary3 [CustomerID=" + CustomerID + ", FullName=" + FullName + ", BookingID=" + BookingID
				+ ", CheckInDate=" + CheckInDate + ", CheckOutDate=" + CheckOutDate + ", RoomType=" + RoomType
				+ ", BookingStatus=" + BookingStatus + ", RoomNo=" + RoomNo + "]";
	}
}