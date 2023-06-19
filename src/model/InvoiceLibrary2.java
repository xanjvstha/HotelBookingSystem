package model;

public class InvoiceLibrary2 {
	int BookingID;
	int BillingID;
	String FullName;
	String CheckInDate;
	String CheckOutDate;
	String StayedDays;
	int DrinkAmount;
	int ServiceAmount;
	int FoodAmount;
	int RoomAmount;
	double SubTotalAmount;
	double Discount;
	double GrandTotal;
	String BillingStatus;
	int EmployeeID;
	
	public InvoiceLibrary2() {
		this.BookingID =0;
		this.BillingID = 0;
		this.FullName = "";
		this.CheckInDate = "";
		this.CheckOutDate = "";
		this.StayedDays = "";
		this.DrinkAmount = 0;
		this.ServiceAmount = 0;
		this.FoodAmount = 0;
		this.RoomAmount = 0;
		this.SubTotalAmount = 0.0;
		this.Discount = 0.0;
		this.GrandTotal = 0.0;
		this.BillingStatus = "";
		this.EmployeeID = 0;
	}
	
	public InvoiceLibrary2(int billingid, String fullname, String checkInDate, String checkOutDate, String stayedDays, int drinkamount, int serviceamount, int foodamount,
			int roomamount, double subTotalAmount, double discount, double grandTotal, String billingstatus, int employeeid) {
		
		this.BillingID = billingid;
		this.FullName = fullname;
		this.CheckInDate = checkInDate;
		this.CheckOutDate = checkOutDate;
		this.StayedDays = stayedDays;
		this.DrinkAmount = drinkamount;
		this.ServiceAmount = serviceamount;
		this.FoodAmount = foodamount;
		this.RoomAmount = roomamount;
		this.SubTotalAmount = subTotalAmount;
		this.Discount = discount;
		this.GrandTotal = grandTotal;
		this.BillingStatus = billingstatus;
		this.EmployeeID = employeeid;
	}
	
	public int getBookingID() {
		return BookingID;
	}

	public void setBookingID(int bookingID) {
		BookingID = bookingID;
	}

	public int getBillingID() {
		return BillingID;
	}

	public void setBillingID(int billingid) {
		BillingID = billingid;
	}

	public String getFullName() {
		return FullName;
	}

	public void setFullName(String fullname) {
		FullName = fullname;
	}
	
	public String getCheckInDate() {
		return CheckInDate;
	}

	public void setCheckInDate(String checkInDate) {
		CheckInDate = checkInDate;
	}

	public String getCheckOutDate() {
		return CheckOutDate;
	}

	public void setCheckOutDate(String checkOutDate) {
		CheckOutDate = checkOutDate;
	}

	public String getStayedDays() {
		return StayedDays;
	}

	public void setStayedDays(String stayedDays) {
		StayedDays = stayedDays;
	}

	public int getDrinkAmount() {
		return DrinkAmount;
	}

	public void setDrinkAmount(int drinkamount) {
		DrinkAmount = drinkamount;
	}

	public int getServiceAmount() {
		return ServiceAmount;
	}

	public void setServiceAmount(int serviceamount) {
		ServiceAmount = serviceamount;
	}

	public int getFoodAmount() {
		return FoodAmount;
	}

	public void setFoodAmount(int foodamount) {
		FoodAmount = foodamount;
	}

	public int getRoomAmount() {
		return RoomAmount;
	}

	public void setRoomAmount(int roomamount) {
		RoomAmount = roomamount;
	}

	public double getSubTotalAmount() {
		return SubTotalAmount;
	}

	public void setSubTotalAmount(double subTotalAmount) {
		SubTotalAmount = subTotalAmount;
	}

	public double getDiscount() {
		return Discount;
	}

	public void setDiscount(double discount) {
		Discount = discount;
	}
	
	public double getGrandTotal() {
		return GrandTotal;
	}

	public void setGrandTotal(double grandTotal) {
		GrandTotal = grandTotal;
	}

	public String getBillingStatus() {
		return BillingStatus;
	}

	public void setBillingStatus(String billingstatus) {
		BillingStatus = billingstatus;
	}
	
	public int getEmployeeID() {
		return EmployeeID;
	}

	public void setEmployeeID(int employeeID) {
		EmployeeID = employeeID;
	}

	@Override
	public String toString() {
		return "InvoiceLibrary2 [BookingID=" + BookingID + ",BillingID=" + BillingID + ", FullName=" + FullName
				+ ", CheckInDate=" + CheckInDate + ", CheckOutDate=" + CheckOutDate + ", StayedDays=" + StayedDays
				+ ", DrinkAmount=" + DrinkAmount + ", ServiceAmount=" + ServiceAmount + ", FoodAmount=" + FoodAmount + ", RoomAmount=" + RoomAmount
				+ ", SubTotalAmount=" + SubTotalAmount + ", Discount=" + Discount + ", GrandTotal=" + GrandTotal 
				+ ", BillingStatus=" + BillingStatus + ", EmployeeID=" + EmployeeID + "]";
	}
}