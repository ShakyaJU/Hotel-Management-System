package BusinessLayer;

import Models.Booking;


import Models.Customer;
import FrontEndLayer.BookingPage;
import java.util.ArrayList;

import DatabaseLayer.DLBooking;
import DatabaseLayer.DLBooking;
import Helper.InputException;


public class BLBooking {
	Booking booking;

	public BLBooking() {
		this.booking = new Booking();
		
	}
	public Booking getBooking() {
		
		return booking;
	}
	
	public BLBooking(Booking bok) {
		this.booking=bok;
	}
	public void setBooking(Booking booking) throws InputException {
		try {
			if(this.validateBooking(booking)) {
				this.booking = booking;
			}
		}catch(InputException ex) {
			throw ex;
		}
	}

	private boolean validateBooking(Booking booking) throws InputException {
		if(booking.getGuestName() == null || booking.getGuestName().length() == 0) {
			throw new InputException("Guest name cannot be empty. ");
		}
		if(booking.getBookingDate() == null || booking.getBookingDate().length() == 0) {
			throw new InputException("Booking date cannot be empty. ");
		}
		if(booking.getCheckInDate() == null || booking.getCheckInDate().length() == 0) {
			throw new InputException("Check-in date cannot be empty. ");
		}
		if(booking.getCheckOutDate() == null || booking.getCheckOutDate().length() == 0) {
			throw new InputException("Check-out date cannot be empty. ");
		}
		  if(booking.getCheckInDate()==booking.getCheckOutDate()) {
	            throw  new InputException("Check_in_Date and Check_out_Date cannot be same");
	        }
		return true;
	}
	
	
	public Booking booking() throws Exception{ 
		try {
	        DLBooking dlBooking = new DLBooking(this.booking);
	        return dlBooking.booking();
	    } catch (Exception e) {
	        throw e;
	    }
	}
	public Booking update() throws Exception {
		try {
			DLBooking dl = new DLBooking(this.booking);
			return dl.update();			
		}catch(Exception e) {
			throw e;
		}
	}
	public Booking cancel() throws Exception {
		try {
			DLBooking dd = new DLBooking(this.booking);
			return dd.cancel();			
		}catch(Exception e) {
			throw e;
		}
	}
	public ArrayList<Booking> getAllBooking() throws Exception {
		try {
			DLBooking dlBooking = new DLBooking(this.booking);
			return dlBooking.getAllBooking();
		}catch(Exception e) {
			throw e;
		}
	}

	
}
