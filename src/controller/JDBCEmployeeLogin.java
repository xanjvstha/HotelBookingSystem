package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import model.EmployeeLoginLibrary;

public class JDBCEmployeeLogin {
	
	
	public boolean employeelogin(EmployeeLoginLibrary employeeuser) {
		boolean login = false;
		Connection conn;
		PreparedStatement pstat;
		ResultSet rs;
		String sql="SELECT * FROM employee WHERE Emp_Username=? AND Emp_Password=?";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/lutonhotel","root","");
			
			pstat=conn.prepareStatement(sql);
			
			pstat.setString(1, employeeuser.getEmp_Username());
			pstat.setString(2, employeeuser.getEmp_Password());
			
			rs=pstat.executeQuery();
			
			while(rs.next()) {
				login = true;
				
				int id1 = rs.getInt("EmployeeID");
				String fullname = rs.getString("Emp_FullName");
				String password = rs.getString("Emp_Password");
				
				employeeuser.setEmployeeID(id1);
				employeeuser.setEmp_FullName(fullname);
				employeeuser.setEmp_Role(rs.getString("Emp_Role"));
				employeeuser.setEmp_NewPassword(password);
			}
		}
		catch(Exception ex) {
			System.out.println("Error"+ex.getMessage());
			login = false;
		}
		return login;
	}
}