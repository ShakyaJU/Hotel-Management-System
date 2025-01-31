package FrontEndLayer;

import java.awt.BorderLayout;


import java.awt.EventQueue;

import Models.Booking;
import Models.Customer;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.JSpinner;
import javax.swing.JComboBox;
import java.awt.Panel;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;

import com.toedter.calendar.JDateChooser;

import BusinessLayer.BLBooking;
import BusinessLayer.BLuser;
import Helper.InputException;

import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;

public class BookingPage extends JFrame {

	private JPanel contentPane;
	private JTextField txtGuestName;
	JComboBox comboBoxRoomType = new JComboBox();
	private JDateChooser dateCheckin;
	private JDateChooser dateCheckout;
	private JDateChooser dateBooking;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BookingPage frame = new BookingPage();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public BookingPage() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 602, 418);
		contentPane = new JPanel();
		contentPane.setBackground(Color.GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTitle = new JLabel("LUTON HOTEL");
		lblTitle.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblTitle.setBounds(208, 21, 169, 42);
		contentPane.add(lblTitle);
		
		JLabel lblRoom = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("/Room.jpg")).getImage();
		lblRoom.setIcon(new ImageIcon(img));
		lblRoom.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblRoom.setBounds(10, 90, 255, 257);
		contentPane.add(lblRoom);
		
		JLabel lblBaRoom = new JLabel("Book a Room");
		lblBaRoom.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblBaRoom.setBounds(356, 90, 154, 24);
		contentPane.add(lblBaRoom);
		
		JLabel lblCheckin = new JLabel("Check-In Date:");
		lblCheckin.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblCheckin.setBounds(285, 233, 76, 14);
		contentPane.add(lblCheckin);
		
		JLabel lblCheckout = new JLabel("Check-Out Date:");
		lblCheckout.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblCheckout.setBounds(285, 258, 92, 14);
		contentPane.add(lblCheckout);
		
		JButton btnRequest = new JButton("Request Booking");
		btnRequest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				booking();
				}
		});
		btnRequest.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnRequest.setBounds(275, 314, 140, 33);
		contentPane.add(btnRequest);
		
		JLabel lblGuestName = new JLabel("Guest Name:");
		lblGuestName.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblGuestName.setBounds(300, 172, 76, 14);
		contentPane.add(lblGuestName);
		
		txtGuestName = new JTextField();
		txtGuestName.setColumns(10);
		txtGuestName.setBounds(370, 169, 140, 20);
		contentPane.add(txtGuestName);
		
		JButton btnCancel = new JButton("Close");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				HomePage hp = new HomePage();
				hp.setVisible(true);
			}
		});
		btnCancel.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnCancel.setBounds(425, 314, 140, 33);
		contentPane.add(btnCancel);
		
		JLabel lblRoomType = new JLabel("Room Type:");
		lblRoomType.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblRoomType.setBounds(295, 140, 70, 14);
		contentPane.add(lblRoomType);
		
		
		comboBoxRoomType.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		comboBoxRoomType.setModel(new DefaultComboBoxModel(new String[] {"Single", "Double", "Twin"}));
		comboBoxRoomType.setBounds(370, 136, 140, 22);
		contentPane.add(comboBoxRoomType);
		
		JLabel lblBookingDate = new JLabel("Booking Date:");
		lblBookingDate.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblBookingDate.setBounds(285, 197, 76, 14);
		contentPane.add(lblBookingDate);
		
		 dateCheckin = new JDateChooser();
		dateCheckin.setDateFormatString("yyyy-MM-dd");
		dateCheckin.setBounds(370, 227, 140, 20);
		contentPane.add(dateCheckin);
		
		 dateCheckout = new JDateChooser();
		dateCheckout.setDateFormatString("yyyy-MM-dd");
		dateCheckout.setBounds(370, 258, 140, 20);
		contentPane.add(dateCheckout);
		
		 dateBooking = new JDateChooser();
		dateBooking.setDateFormatString("yyyy-MM-dd");
		dateBooking.setBounds(370, 197, 140, 20);
		contentPane.add(dateBooking);
		
		
	}
	public void booking() {
		try {
            Booking booking = new Booking();
            //SimpleDateFormat dateformat =new SimpleDateFormat("yyyy-MM-dd");
            booking.setRoomType(comboBoxRoomType.getSelectedItem().toString());
            booking.setGuestName(txtGuestName.getText());
            booking.setBookingDate(dateBooking.getDate().toString());
            booking.setCheckInDate(dateCheckin.getDate().toString());
            booking.setCheckOutDate(dateCheckout.getDate().toString());
          
            BLBooking blBooking = new BLBooking();
            blBooking.setBooking(booking);
            booking = blBooking.booking();
			HomePage hp = new HomePage();
			hp.setVisible(true);
			dispose();
        }catch(InputException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        catch(Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
	}
}
