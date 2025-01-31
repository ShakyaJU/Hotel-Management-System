package FrontEndLayer;

import java.awt.BorderLayout;
import java.awt.EventQueue;



import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class HomePage extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HomePage frame = new HomePage();
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
	public HomePage() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 569, 422);
		contentPane = new JPanel();
		contentPane.setBackground(Color.PINK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Welcome To Luton Hotel");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel.setBounds(179, 11, 225, 24);
		contentPane.add(lblNewLabel);
		
		JButton btnViewBooking = new JButton("View Booking");
		btnViewBooking.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				RoomPage rp = new RoomPage();
				rp.loadBooking();
				rp.setVisible(true);
				dispose();
				
			}
		});
		btnViewBooking.setFont(new Font("Times New Roman", Font.BOLD, 12));
		btnViewBooking.setBounds(210, 162, 126, 39);
		contentPane.add(btnViewBooking);
		
		JButton btnRoomBooking = new JButton("Room Booking");
		btnRoomBooking.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				BookingPage bp = new BookingPage();
				bp.setVisible(true);
			}
		});
		btnRoomBooking.setFont(new Font("Times New Roman", Font.BOLD, 12));
		btnRoomBooking.setBounds(210, 95, 126, 39);
		contentPane.add(btnRoomBooking);
		
		JButton btnBillingDetails = new JButton("Billing Details");
		btnBillingDetails.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				BillingPage blp = new BillingPage();
				blp.setVisible(true);
			}
		});
		btnBillingDetails.setFont(new Font("Times New Roman", Font.BOLD, 12));
		btnBillingDetails.setBounds(210, 221, 126, 39);
		contentPane.add(btnBillingDetails);
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				FPage fp = new FPage();
				fp.setVisible(true);
				}
		});
		btnLogout.setFont(new Font("Times New Roman", Font.BOLD, 12));
		btnLogout.setBounds(210, 281, 126, 33);
		contentPane.add(btnLogout);
		
		JLabel lblBg = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("/Hotel.jpg")).getImage();
		lblBg.setIcon(new ImageIcon(img));
		lblBg.setBounds(10, 55, 530, 302);
		contentPane.add(lblBg);
	}
}
