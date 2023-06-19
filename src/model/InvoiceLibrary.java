package model;

public class InvoiceLibrary {
	
	int BookingID;
	String CheckInDate;
	String CheckOutDate;
	String FullName;
	int RoomNo;
	int RoomPrice;
	int FoodPrice;
	int DrinkPrice;
	int ServicePrice;
	
	public InvoiceLibrary() {
		
		this.BookingID = 0;
		this.CheckInDate = "";
		this.CheckOutDate = "";
		this.FullName = "";
		this.RoomNo = 0;
		this.RoomPrice = 0;
		this.FoodPrice = 0;
		this.DrinkPrice = 0;
		this.ServicePrice = 0;
	}
	
	public InvoiceLibrary(int bookingid, String checkindate, String checkoutdate, String fullname, int roomno, int roomprice,
			int foodprice, int drinkprice, int serviceprice) {
		
		this.BookingID = bookingid;
		this.CheckInDate = checkindate;
		this.CheckOutDate = checkoutdate;
		this.FullName = fullname;
		this.RoomNo = roomno;
		this.RoomPrice = roomprice;
		this.FoodPrice = foodprice;
		this.DrinkPrice = drinkprice;
		this.ServicePrice = serviceprice;
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

	public String getFullName() {
		return FullName;
	}

	public void setFullName(String fullname) {
		FullName = fullname;
	}

	public int getRoomNo() {
		return RoomNo;
	}

	public void setRoomNo(int roomno) {
		RoomNo = roomno;
	}

	public int getRoomPrice() {
		return RoomPrice;
	}

	public void setRoomPrice(int roomprice) {
		RoomPrice = roomprice;
	}

	public int getFoodPrice() {
		return FoodPrice;
	}

	public void setRes_Price(int foodprice) {
		FoodPrice = foodprice;
	}

	public int getDrinkPrice() {
		return DrinkPrice;
	}

	public void setDrinkPrice(int drinkprice) {
		DrinkPrice = drinkprice;
	}

	public int getServicePrice() {
		return ServicePrice;
	}

	public void setServicePrice(int serviceprice) {
		ServicePrice = serviceprice;
	}

	@Override
	public String toString() {
		return "InvoiceLibrary [BookingID=" + BookingID + ", CheckInDate=" + CheckInDate + ", CheckOutDate=" + CheckOutDate
				+ ", FullName=" + FullName + ", RoomNo=" + RoomNo + ", RoomPrice=" + RoomPrice + ", FoodPrice=" + FoodPrice
				+ ", DrinkPrice=" + DrinkPrice + ", ServicePrice=" + ServicePrice + "]";
	}	
}