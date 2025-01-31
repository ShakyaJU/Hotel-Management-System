package Models;

public class Booking {
	
	private String bookingId;
	private String roomType;
	private String guestName;
	private String bookingDate;
	private String checkInDate;
	private String checkOutDate;
	private String bookingStatus;
	

	public Booking() {
		this.bookingId = "";
		this.roomType = "";
		this.guestName = "";
		this.bookingDate = "";
		this.checkInDate = "";
		this.checkOutDate = "";
		this.bookingStatus = "";
	}
	
	public Booking(String bookingId, String roomType, String guestName, String bookingDate, String checkInDate, String checkOutDate, String bookingStatus) {
		this.bookingId = bookingId;
		this.roomType = roomType;
		this.guestName = guestName;
		this.bookingDate = bookingDate;
		this.checkInDate = checkInDate;
		this.checkOutDate = checkOutDate;
		this.bookingStatus = bookingStatus;
		
	}

	public String getBookingStatus() {
		return bookingStatus;
	}

	public void setBookingStatus(String bookingStatus) {
		this.bookingStatus = bookingStatus;
	}

	public String getBookingId() {
		return bookingId;
	}

	public void setBookingId(String bookingId) {
		this.bookingId = bookingId;
	}

	public String getRoomType() {
		return roomType;
	}

	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}

	public String getGuestName() {
		return guestName;
	}

	public void setGuestName(String guestName) {
		this.guestName = guestName;
	}

	public String getBookingDate() {
		return bookingDate;
	}

	public void setBookingDate(String contactNo) {
		this.bookingDate = contactNo;
	}

	public String getCheckInDate() {
		return checkInDate;
	}

	public void setCheckInDate(String checkInDate) {
		this.checkInDate = checkInDate;
	}

	public String getCheckOutDate() {
		return checkOutDate;
	}

	public void setCheckOutDate(String checkOutDate) {
		this.checkOutDate = checkOutDate;
	}

	@Override
	public String toString() {
		return "Booking [bookingId=" + bookingId + ", roomType=" + roomType + ", guestName=" + guestName
				+ ", bookingDate=" + bookingDate + ", checkInDate=" + checkInDate + ", checkOutDate=" + checkOutDate
				+ ", bookingStatus=" + bookingStatus + "]";
	}

	
}
