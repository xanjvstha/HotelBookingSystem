package model;

public class BarLibrary {
	int BarID;
	String BarMenu;
	int DrinkPrice;
	int BookingID;
	int EmployeeID;
	
	public BarLibrary() {

		this.BarID = 0;
		this.BarMenu ="";
		this.DrinkPrice = 0;
		this.BookingID = 0;
		this.EmployeeID = 0;
	}

	public BarLibrary(int barid, String barmenu, int drinkprice, int bookingid, int employeeid) {
		this.BarID = barid;
		this.BarMenu = barmenu;
		this.DrinkPrice = drinkprice;
		this.BookingID = bookingid;
		this.EmployeeID = employeeid;
	}

	public int getBarID() {
		return BarID;
	}

	public void setBarID(int barid) {
		this.BarID = barid;
	}

	public String getBarMenu() {
		return BarMenu;
	}

	public void setBarMenu(String barmenu) {
		this.BarMenu = barmenu;
	}

	public int getDrinkPrice() {
		return DrinkPrice;
	}

	public void setDrinkPrice(int drinkprice) {
		this.DrinkPrice = drinkprice;
	}

	public int getBookingID() {
		return BookingID;
	}

	public void setBookingID(int bookingid) {
		this.BookingID = bookingid;
	}
	
	public int getEmployeeID() {
		return EmployeeID;
	}

	public void setEmployeeID(int employeeID) {
		EmployeeID = employeeID;
	}

	@Override
	public String toString() {
		return "BarLibrary [BarID=" + BarID + ", BarMenu=" + BarMenu + ", DrinkPrice=" + DrinkPrice + ", BookingID=" + BookingID+ ", EmployeeID=" + EmployeeID+ "]";
	}
}