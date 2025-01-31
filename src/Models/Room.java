package Models;

public class Room {
	
	private int roomNo;
	private String roomType;
	private String roomStatus;
	private int roomPrice;
	

	public Room() {
		this.roomNo = 0;
		this.roomType = "";
		this.roomStatus = "";
		this.roomPrice = 0;
	}
	
	public Room(int roomNo, String roomType, String roomStatus, int roomPrice) {
		this.roomNo = roomNo;
		this.roomType = roomType;
		this.roomStatus = roomStatus;
		this.roomPrice = roomPrice;
		
	}

	public int getRoomNo() {
		return roomNo;
	}

	public void setRoomNo(int roomNo) {
		this.roomNo = roomNo;
	}

	public String getRoomType() {
		return roomType;
	}

	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}

	public String getRoomStatus() {
		return roomStatus;
	}

	public void setRoomStatus(String roomStatus) {
		this.roomStatus = roomStatus;
	}

	public int getRoomPrice() {
		return roomPrice;
	}

	public void setRoomPrice(int roomPrice) {
		this.roomPrice = roomPrice;
	}

	@Override
	public String toString() {
		return "Room [roomNo=" + roomNo + ", roomType=" + roomType + ", roomStatus=" + roomStatus + ", roomPrice="
				+ roomPrice + "]";
	}
	
	

}

