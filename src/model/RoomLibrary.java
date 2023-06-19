package model;

public class RoomLibrary {
	int RoomNo;
	String RoomType;
	double RoomPrice;
	String RoomStatus;
	
	public RoomLibrary() {
		this.RoomNo = 0;
		this.RoomType = "";
		this.RoomPrice = 0;
		this.RoomStatus = "";
	}
	
	public RoomLibrary(int roomno, String roomtype, Double roomprice, String roomstatus) {
		super();
		this.RoomNo = roomno;
		this.RoomType = roomtype;
		this.RoomPrice = roomprice;
		this.RoomStatus = roomstatus;
	}

	public int getRoomNo() {
		return RoomNo;
	}

	public void setRoomNo(int roomno) {
		RoomNo = roomno;
	}

	public String getRoomType() {
		return RoomType;
	}

	public void setRoomType(String roomtype) {
		RoomType = roomtype;
	}

	public double getRoomPrice() {
		return RoomPrice;
	}

	public void setRoomPrice(double roomprice) {
		this.RoomPrice = roomprice;
	}
	

	public String getRoomStatus() {
		return RoomStatus;
	}

	public void setRoomStatus(String roomstatus) {
		RoomStatus = roomstatus;
	}

	@Override
	public String toString() {
		return "RoomLibrary [RoomNo=" + RoomNo + ", RoomType=" + RoomType + ", RoomPrice="
				+ RoomPrice + ", RoomStatus=" + RoomStatus + "]";
	}
}