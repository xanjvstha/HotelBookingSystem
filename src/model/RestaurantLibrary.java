package model;

public class RestaurantLibrary {
	int FoodID;
	String FoodMenu;
	int FoodPrice;
	int BookingID;
	int EmployeeID;
	
	public RestaurantLibrary() {
		this.FoodID = 0;
		this.FoodMenu = "";
		this.FoodPrice = 0;
		this.BookingID = 0;
		this.EmployeeID = 0;
	}

	public RestaurantLibrary(int foodid, String foodmenu, int foodprice, int bookingid, int employeeid) {
		this.FoodID = foodid;
		this.FoodMenu = foodmenu;
		this.FoodPrice = foodprice;
		this.BookingID = bookingid;
		this.EmployeeID = employeeid;
	}

	public int getFoodID() {
		return FoodID;
	}

	public void setFoodID(int foodid) {
		this.FoodID = foodid;
	}

	public String getFoodMenu() {
		return FoodMenu;
	}

	public void setFoodMenu(String foodmenu) {
		this.FoodMenu = foodmenu;
	}

	public int getFoodPrice() {
		return FoodPrice;
	}
	
	public void setFoodPrice(int foodprice) {
		this.FoodPrice = foodprice;
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
		return "RestaurentLibrary [FoodID=" + FoodID + ", FoodMenu=" + FoodMenu + ", FoodPrice=" + FoodPrice + ", BookingID="
				+ BookingID + ", EmployeeID=" + EmployeeID+ "]";
	}
}