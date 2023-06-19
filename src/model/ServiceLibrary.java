package model;

public class ServiceLibrary {
	int ServiceID;
	String ServiceType;
	int ServicePrice;
	int BookingID;
	int EmployeeID;

	public ServiceLibrary() {
		
		this.ServiceID = 0;
		this.ServiceType = "";
		this.ServicePrice = 0;
		this.BookingID = 0;
		this.EmployeeID = 0;
	}

	public ServiceLibrary(int serviceid, String servicetype, int serviceprice, int bookingid, int employeeid) {

		this.ServiceID = serviceid;
		this.ServiceType = servicetype;
		this.ServicePrice = serviceprice;
		this.BookingID = bookingid;
		this.EmployeeID = employeeid;
	}

	public int getServiceID() {
		return ServiceID;
	}

	public void setServiceID(int serviceid) {
		this.ServiceID = serviceid;
	}

	public String getServiceType() {
		return ServiceType;
	}

	public void setServiceType(String servicetype) {
		this.ServiceType = servicetype;
	}

	public int getServicePrice() {
		return ServicePrice;
	}

	public void setServicePrice(int serviceprice) {
		this.ServicePrice = serviceprice;
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
		return "ServiceLibrary [ServiceID=" + ServiceID + ", ServiceType=" + ServiceType + ", ServicePrice=" + ServicePrice
				+ ", BookingID=" + BookingID + ", EmployeeID=" + EmployeeID + "]";
	}
}