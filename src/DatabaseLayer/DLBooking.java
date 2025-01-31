package DatabaseLayer;

import Models.Customer;

import Models.Booking;


import FrontEndLayer.FPage;
import FrontEndLayer.HomePage;
import FrontEndLayer.RegistrationPage;
import FrontEndLayer.BookingPage;
import FrontEndLayer.RoomPage;
import Helper.DatabaseConnector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class DLBooking {
	
	private Booking booking;
	private DatabaseConnector db;
	private Connection connection;
	
	public DLBooking() throws Exception {
		this.booking = new Booking();
		try {
			this.db = DatabaseConnector.getInstance();
			this.connection = this.db.getConnection();
		} catch (Exception ex) {
			throw ex;
		}

	}

	public DLBooking(Booking booking ) throws Exception {
		this.booking = booking;
		try {
			this.db = DatabaseConnector.getInstance();
			this.connection = this.db.getConnection();
		} catch (Exception ex) {
			throw ex;
		}

	
	}

	public Booking getBooking() {
		return booking;
	}

	public void setBooking(Booking booking) {
		this.booking = booking;
	}
	
	public Booking booking() throws Exception{
		  try {
	            String sql = "INSERT INTO booking(roomType, guestName, bookingDate, checkInDate, checkOutDate) VALUES (?,?,?,?,?)";
	            PreparedStatement statement = this.connection.prepareStatement(sql);
	            statement.setString(1, this.booking.getRoomType());
	            statement.setString(2, this.booking.getGuestName());
	            statement.setString(3, this.booking.getBookingDate());
	            statement.setString(4, this.booking.getCheckInDate()); 
	            statement.setString(5, this.booking.getCheckOutDate());
	            statement.executeUpdate();

	            JOptionPane.showMessageDialog(null, "Your booking has been requested. ");
	            return this.booking;
	        }catch (Exception ex) {
	            JOptionPane.showMessageDialog(null, ex.getMessage());
	        }
	        return booking;
	    }
	
	public ArrayList<Booking> getAllBooking() throws Exception {
		try {
			ArrayList<Booking> bookings = new ArrayList<Booking>();
			String query = "SELECT * FROM booking ORDER BY bookingId";
			Statement statement = this.connection.createStatement();
			ResultSet rs = statement.executeQuery(query);
			while (rs.next()) {
				Booking b = new Booking();
				b.setBookingId(rs.getString("bookingId"));
				b.setGuestName(rs.getString("guestName"));
				b.setRoomType(rs.getString("roomType"));
				b.setBookingStatus(rs.getString("bookingStatus"));
				b.setBookingDate(rs.getString("bookingDate"));
				b.setCheckInDate(rs.getString("checkInDate"));
				b.setCheckOutDate(rs.getString("checkOutDate"));
				bookings.add(b);
			}
			return bookings;
		} catch (Exception ex) {
			throw ex;
		}
	}
	
	public Booking update() throws Exception{
		 try {
	            // create the statement
	            String query = "UPDATE booking  SET guestName=? , checkInDate=?, checkOutDate =?,roomType=? WHERE bookingId=?";
	            PreparedStatement statement = this.connection.prepareStatement(query);
	            
	            statement.setString(1, this.booking.getGuestName());
	            statement.setString(2,this.booking.getCheckInDate());
	            statement.setString(3,this.booking.getCheckOutDate());
	            statement.setString(4, this.booking.getRoomType());
	            statement.setString(5,this.booking.getBookingId());
	                    
	            // execute the query
	            statement.executeUpdate();
	            JOptionPane.showMessageDialog(null, "Your data Has been updated. ");
	            return this.booking;
	        }catch (Exception ex) {
	            JOptionPane.showMessageDialog(null, ex.getMessage());
	        }
	        return booking;
	    }
	public Booking cancel() throws Exception{
        DLBooking dd = new DLBooking();
        try {
            // create the statement
            String query = "UPDATE booking  SET bookingStatus='Cancelled' WHERE bookingId=?";
            PreparedStatement statement = this.connection.prepareStatement(query);

            statement.setString(1, this.booking.getBookingId()) ;

            // execute the query
            statement.executeUpdate();
            JOptionPane.showMessageDialog(null, "Your data Has been canceled. ");
            return this.booking;
        }catch(Exception ex) {
        	 JOptionPane.showMessageDialog(null, ex.getMessage());
           }
        return booking;
        
    }

}
