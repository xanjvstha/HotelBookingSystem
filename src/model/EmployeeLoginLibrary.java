package model;

public class EmployeeLoginLibrary {
	int EmployeeID;
	String Emp_FullName;
	String Emp_Username;
	String Emp_Password;
	String Emp_Role;
	String Emp_NewPassword;

	public EmployeeLoginLibrary() {

		this.EmployeeID = 0;
		this.Emp_FullName = "";
		this.Emp_Username = "";
		this.Emp_Password = "";
		this.Emp_Role = "";
		this.Emp_NewPassword = "a";
	}

	public EmployeeLoginLibrary(int employeeid, String emp_fullname, String emp_username, String emp_password, String emp_role, String emp_newpassword) {

		this.EmployeeID = employeeid;
		this.Emp_FullName = emp_fullname;
		this.Emp_Username = emp_username;
		this.Emp_Password = emp_password;
		this.Emp_Role = emp_role;
		this.Emp_NewPassword = emp_newpassword;
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
	

	public String getEmp_NewPassword() {
		return Emp_NewPassword;
	}

	public void setEmp_NewPassword(String emp_newpassword) {
		Emp_NewPassword = emp_newpassword;
	}

	@Override
	public String toString() {
		return "LoginLibrary [EmoloyeeID=" + EmployeeID + ", Emp_FullName=" + Emp_FullName + ", Emp_Username=" + Emp_Username + ", Emp_Password=" + Emp_Password + ", Emp_Role=" + Emp_Role + ", Emp_NewPassword=" + Emp_NewPassword + "]";
	}
}