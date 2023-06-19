package model;

public class EmployeeRegistrationLibrary {
	
	int EmployeeID;
	String Emp_FullName;
	String Emp_EmailID;
	String Emp_MobileNo;
	String Emp_Address;
	String Emp_Username;
	String Emp_Password;
	String Emp_Role;
	
public EmployeeRegistrationLibrary() {
		
		this.EmployeeID = 0;
		this.Emp_FullName = "";
		this.Emp_EmailID = "";
		this.Emp_MobileNo = "";
		this.Emp_Address = "";
		this.Emp_Username = "";
		this.Emp_Password = "";
		this.Emp_Role = "";

	}
	
	public EmployeeRegistrationLibrary(int employeeid, String emp_fullname, String emp_emailid, String emp_mobileno, String emp_address, String emp_username,
			String emp_password, String emp_role) {
		
		this.EmployeeID = employeeid;
		this.Emp_FullName = emp_fullname;
		this.Emp_EmailID = emp_emailid;
		this.Emp_MobileNo = emp_mobileno;
		this.Emp_Address = emp_address;
		this.Emp_Username = emp_username;
		this.Emp_Password = emp_password;
	}

	public int getEmployeeID() {
		return EmployeeID;
	}

	public void setEmployeeID(int employeeid) {
		EmployeeID = employeeid;
	}

	public String getEmp_FullName() {
		return Emp_FullName;
	}

	public void setEmp_FullName(String emp_fullname) {
		Emp_FullName = emp_fullname;
	}

	public String getEmp_EmailID() {
		return Emp_EmailID;
	}

	public void setEmp_EmailID(String emp_emailid) {
		Emp_EmailID = emp_emailid;
	}

	public String getEmp_MobileNo() {
		return Emp_MobileNo;
	}

	public void setMobileNo(String emp_mobileno) {
		Emp_MobileNo = emp_mobileno;
	}
	public String getEmp_Address() {
		return Emp_Address;
	}

	public void setEmp_Address(String emp_address) {
		Emp_Address = emp_address;
	}

	public String getEmp_Username() {
		return Emp_Username;
	}

	public void setEmp_Username(String emp_username) {
		Emp_Username = emp_username;
	}

	public String getEmp_Password() {
		return Emp_Password;
	}

	public void setEmp_Password(String emp_password) {
		Emp_Password = emp_password;
	}

	public String getEmp_Role() {
		return Emp_Role;
	}

	public void setEmp_Role(String emp_role) {
		Emp_Role = emp_role;
	}

	@Override
	public String toString() {
		return "EmployeeRegistrationLibrary [EmployeeID=" + EmployeeID + ", Emp_FullName=" + Emp_FullName + ", Emp_Address=" + Emp_Address + ", Emp_EmailID=" + Emp_EmailID + ", Emp_MobileNo=" + Emp_MobileNo
				+ ", Emp_Username=" + Emp_Username + ", Emp_Password=" + Emp_Password + ", Emp_Role=" + Emp_Role + "]";
	}
}