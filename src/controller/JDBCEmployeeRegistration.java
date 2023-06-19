package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import model.EmployeeRegistrationLibrary;

public class JDBCEmployeeRegistration {

	public boolean insert(EmployeeRegistrationLibrary registration) {

		Connection conn;
		PreparedStatement pstat;
		boolean result = false;
		String SQL = "INSERT INTO employee VALUES (?,?,?,?,?,?,?,?)";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/lutonhotel", "root", "");

			pstat = conn.prepareStatement(SQL);

			pstat.setInt(1, registration.getEmployeeID());
			pstat.setString(2, registration.getEmp_FullName());
			pstat.setString(3, registration.getEmp_EmailID());
			pstat.setString(4, registration.getEmp_MobileNo());
			pstat.setString(5, registration.getEmp_Address());
			pstat.setString(6, registration.getEmp_Username());
			pstat.setString(7, registration.getEmp_Password());
			pstat.setString(8, registration.getEmp_Role());

			pstat.executeUpdate();

			conn.close();
			pstat.close();
			result = true;

		} catch (Exception ex) {
			System.out.println("Error" + ex.getMessage());
		}
		return result;
	}
}