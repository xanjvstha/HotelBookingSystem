package model;

public class RegistrationLibrary {
	
	int CustomerID;
	String FullName;
	String Address;
	String District;
	String State;
	String Postcode;
	String Country;
	String EmailID;
	String MobileNo;
	String Username;
	String Password;
	String AccountType;
	
public RegistrationLibrary() {
		
		this.CustomerID = 0;
		this.FullName = "";
		this.Address = "";
		this.District = "";
		this.State = "";
		this.Postcode = "";
		this.Country = "";
		this.EmailID = "";
		this.MobileNo = "";
		this.Username = "";
		this.Password = "";
		this.AccountType = "";

	}
	
	public RegistrationLibrary(int id, String fullname, String address, String district, String state, String postcode, String country, String emailid, String mobileno, String username,
			String password, String accountype) {
		
		this.CustomerID = id;
		this.FullName = fullname;
		this.Address = address;
		this.District = district;
		this.State = state;
		this.Postcode = postcode;
		this.Country = country;
		this.EmailID = emailid;
		this.MobileNo = mobileno;
		this.Username = username;
		this.Password = password;
		this.AccountType = accountype;
	}

	public int getCustomerID() {
		return CustomerID;
	}

	public void setCustomerID(int id) {
		CustomerID = id;
	}

	public String getFullName() {
		return FullName;
	}

	public void setFullName(String fullname) {
		FullName = fullname;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}
	
	public String getDistrict() {
		return District;
	}

	public void setDistrict(String district) {
		District = district;
	}
	
	public String getState() {
		return State;
	}

	public void setState(String state) {
		State = state;
	}
	
	public String getPostcode() {
		return Postcode;
	}

	public void setPostcode(String postcode) {
		Postcode = postcode;
	}
	
	public String getCountry() {
		return Country;
	}

	public void setCountry(String country) {
		Country = country;
	}
	
	public String getEmailID() {
		return EmailID;
	}

	public void setEmailID(String emailid) {
		EmailID = emailid;
	}

	public String getMobileNo() {
		return MobileNo;
	}

	public void setMobileNo(String mobileno) {
		MobileNo = mobileno;
	}

	public String getUsername() {
		return Username;
	}

	public void setUsername(String username) {
		Username = username;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public String getAccountType() {
		return AccountType;
	}

	public void setAccountType(String accounttype) {
		AccountType = accounttype;
	}

	@Override
	public String toString() {
		return "RegistrationLibrary [CustomerID=" + CustomerID + ", FullName=" + FullName + ", Address=" + Address + ", District=" + District + ", State=" + State + ", Postcode=" + Postcode + ", Country=" + Country + ",  EmailID=" + EmailID + ", MobileNo=" + MobileNo
				+ ", Username=" + Username + ", Password=" + Password + ", AccountType=" + AccountType + "]";
	}
}