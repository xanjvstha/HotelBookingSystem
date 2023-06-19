package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.RoomLibrary;

public class JDBCRoomService {
	public boolean insert(RoomLibrary roomservice) {
		Connection conn;
		PreparedStatement pstat;
		boolean result = false;
		String SQL = "INSERT INTO roomservice(RoomNo,RoomType,RoomPrice,RoomStatus) VALUES (?,?,?,?)";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/lutonhotel", "root", "");

			pstat = conn.prepareStatement(SQL);
			
			pstat.setInt(1, roomservice.getRoomNo());
			pstat.setString(2, roomservice.getRoomType());
			pstat.setDouble(3, roomservice.getRoomPrice());
			pstat.setString(4, roomservice.getRoomStatus());

			pstat.executeUpdate();
			pstat.close();
			conn.close();
			result = true;
		} catch (Exception ex) {
			System.out.println("Error" + ex.getMessage());
		}
		return result;
	}
		
	public ArrayList<RoomLibrary> selectall() {
		String sql = "SELECT * FROM roomservice";
		ArrayList<RoomLibrary> a1 = new ArrayList<RoomLibrary>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/lutonhotel", "root", "");
			
			PreparedStatement pstat = conn.prepareStatement(sql);
			ResultSet rs = pstat.executeQuery();
			while (rs.next()) {
				RoomLibrary roomservice = new RoomLibrary
						(rs.getInt("RoomNo"),
						rs.getString("RoomType"),
						rs.getDouble("RoomPrice"),
						rs.getString("RoomStatus"));
									
				a1.add(roomservice);
			}
			
			rs.close();
			pstat.close();
			conn.close();

		} catch (Exception ex) {
			System.out.println("Error : " + ex.getMessage());
		}
		return a1;
	}
		
	public boolean receptionupdate(RoomLibrary roomservice) {
		Connection conn;
		PreparedStatement pstat;
		boolean result2 = false;
		String SQL = "UPDATE roomservice SET RoomStatus=? WHERE RoomNo=?;";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/lutonhotel", "root", "");

			pstat = conn.prepareStatement(SQL);

			pstat.setString(1, roomservice.getRoomStatus());
			pstat.setInt(2, roomservice.getRoomNo());

			pstat.executeUpdate();
			pstat.close();
			conn.close();
			result2 = true;
		} catch (Exception ex) {
			System.out.println("Error" + ex.getMessage());
		}
		return result2;
	}
		
	//Available room
	public ArrayList<RoomLibrary> searchAvailableRoom() {
		Connection conn;
		PreparedStatement pstat;
		ResultSet rs;
		String sql = "SELECT * FROM roomservice WHERE RoomStatus = 'Available'";
		ArrayList<RoomLibrary>tmpPerson = new ArrayList<RoomLibrary>();

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/lutonhotel", "root", "");
			pstat = conn.prepareStatement(sql);
			
			rs = pstat.executeQuery();
			while (rs.next()) {
				RoomLibrary roomservice = new RoomLibrary
						(rs.getInt("RoomNo"),
						rs.getString("RoomType"), 
						rs.getDouble("RoomPrice"),
						rs.getString("RoomStatus"));
				
				tmpPerson.add(roomservice);
			}
			
			rs.close();
			pstat.close();
			conn.close();

		} catch (Exception ex) {
			System.out.println("Error : " + ex.getMessage());
			
		}
		return tmpPerson;
		}
	}