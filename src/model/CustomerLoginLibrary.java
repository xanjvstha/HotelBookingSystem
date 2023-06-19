package model;

public class CustomerLoginLibrary {
	int CustomerID;
	String FullName;
	String Username;
	String Password;
	String AccountType;
	String NewPassword;

	public CustomerLoginLibrary() {

		this.CustomerID = 0;
		this.FullName = "";
		this.Username = "";
		this.Password = "";
		this.AccountType = "";
		this.NewPassword = "a";
	}

	public CustomerLoginLibrary(int customerid, String fullname, String username, String password, String accounttype, String newpassword) {

		this.CustomerID = customerid;
		this.FullName = fullname;
		this.Username = username;
		this.Password = password;
		this.AccountType = accounttype;
		this.NewPassword = newpassword;
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
	
	public String getNewPassword() {
		return NewPassword;
	}

	public void setNewPassword(String newpassword) {
		NewPassword = newpassword;
	}

	@Override
	public String toString() {
		return "LoginLibrary [CustomerID=" + CustomerID + ", FullName=" + FullName + ", Username=" + Username + ", Password=" + Password + ", AccountType=" + AccountType + ", NewPassword=" + NewPassword + "]";
	}
}