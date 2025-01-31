package FrontEndLayer;

import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JInternalFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JDesktopPane;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import com.toedter.calendar.JDateChooser;

import BusinessLayer.BLBooking;
import Helper.InputException;
import Models.Booking;

public class RoomPage extends JFrame {

	private JPanel contentPane;
	private DefaultTableModel model;
	private JTextField txtBookingId;
	private JTextField txtGuestName;
	private JTable table;
	JComboBox comboBoxRoomType = new JComboBox();
	private JDateChooser dateCheckIn;
	private JDateChooser dateCheckOut;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RoomPage frame = new RoomPage();
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
	public RoomPage() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1013, 625);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBackground(Color.GRAY);
		contentPane.add(desktopPane, BorderLayout.CENTER);
		
		JLabel lblNewLabel = new JLabel("LUTON HOTEL");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel.setBounds(429, 11, 154, 42);
		desktopPane.add(lblNewLabel);
		
		JLabel lblBookingId = new JLabel("Booking ID:");
		lblBookingId.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblBookingId.setBounds(674, 162, 71, 14);
		desktopPane.add(lblBookingId);
		
		JButton btnUpdate = new JButton("Update Booking");
		btnUpdate.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				update();
			}
		});
		btnUpdate.setBounds(726, 341, 146, 36);
		desktopPane.add(btnUpdate);
        
        JLabel lblGuestName = new JLabel("Guest Name:");
        lblGuestName.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        lblGuestName.setBounds(663, 193, 82, 14);
        desktopPane.add(lblGuestName);
        
        JLabel lblCheckInDate = new JLabel("Check-In Date:");
        lblCheckInDate.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        lblCheckInDate.setBounds(657, 230, 99, 14);
        desktopPane.add(lblCheckInDate);
        
        JLabel lblCheckOutDate = new JLabel("Check-Out Date:");
        lblCheckOutDate.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        lblCheckOutDate.setBounds(642, 262, 114, 14);
        desktopPane.add(lblCheckOutDate);
        
        JLabel lblRoomType = new JLabel("Room Type:");
        lblRoomType.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        lblRoomType.setBounds(674, 287, 82, 14);
        desktopPane.add(lblRoomType);
        
        comboBoxRoomType = new JComboBox();
        comboBoxRoomType.setModel(new DefaultComboBoxModel(new String[] {"Single", "Double", "Twin"}));
        comboBoxRoomType.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        comboBoxRoomType.setBounds(755, 284, 140, 22);
        desktopPane.add(comboBoxRoomType);
        
        txtBookingId = new JTextField();
        txtBookingId.setColumns(10);
        txtBookingId.setBounds(755, 160, 140, 20);
        desktopPane.add(txtBookingId);
        
        txtGuestName = new JTextField();
        txtGuestName.setColumns(10);
        txtGuestName.setBounds(755, 191, 140, 20);
        desktopPane.add(txtGuestName);
        
        JButton btnCancel = new JButton("Close");
        btnCancel.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		HomePage hp = new HomePage();
    			hp.setVisible(true);
    			dispose();
        		
        	}
        });
        btnCancel.setFont(new Font("Times New Roman", Font.BOLD, 14));
        btnCancel.setBounds(726, 435, 146, 36);
        desktopPane.add(btnCancel);
        
        dateCheckIn = new JDateChooser();
        dateCheckIn.setDateFormatString("yyyy-MM-dd");
        dateCheckIn.setBounds(755, 224, 140, 20);
        desktopPane.add(dateCheckIn);
        
        dateCheckOut = new JDateChooser();
        dateCheckOut.setDateFormatString("yyyy-MM-dd");
        dateCheckOut.setBounds(755, 255, 140, 20);
        desktopPane.add(dateCheckOut);
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 130, 622, 352);
        desktopPane.add(scrollPane);
        
        table = new JTable();
        scrollPane.setViewportView(table);

        // Set column for the default table model;
        model = new DefaultTableModel();
        Object[] columnName = new Object[6];
        columnName[0] = "BookingId";
        columnName[1] = "Guest Name";
        columnName[2] = "Room Type ";
        columnName[3]= "Booking Status";
        //columnName[4]= "Booking Date";
        columnName[4]= "Check-In";
        columnName[5]= "Check-Out";
        model.setColumnIdentifiers(columnName);
        table.setModel(model);
        scrollPane.setViewportView(table);
        
        JButton btnCancelBooking = new JButton("Cancel Booking");
        btnCancelBooking.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		cancel();
        	}
        });
        btnCancelBooking.setFont(new Font("Times New Roman", Font.BOLD, 14));
        btnCancelBooking.setBounds(726, 388, 146, 36);
        desktopPane.add(btnCancelBooking);
        
        JLabel lblView = new JLabel("View Booking");
        lblView.setFont(new Font("Times New Roman", Font.BOLD, 22));
        lblView.setBounds(231, 93, 140, 26);
        desktopPane.add(lblView);
        
	}
	public void loadBooking () { 
		try {

			BLBooking bb = new BLBooking (); 
			ArrayList<Booking> book = bb.getAllBooking(); 
			setTableData (book);

			} catch (Exception ex) {

			JOptionPane.showMessageDialog(null, ex.getMessage());
			}
	}
		
	private void setTableData(ArrayList<Booking> booking) {
		// 
		Object[] rowData = new Object[6];
		model.setRowCount(0);
		for(int i=0; i<booking.size(); i++) {
			rowData[0] = booking.get(i).getBookingId();
			rowData[1] = booking.get(i).getGuestName();
			rowData[2] = booking.get(i).getRoomType();
			rowData[3] = booking.get(i).getBookingStatus();
			//rowData[4] = booking.get(i).getBookingDate();
			rowData[4] = booking.get(i).getCheckInDate();
			rowData[5] = booking.get(i).getCheckOutDate();
			model.addRow(rowData);
		}
	table.setModel(model);
	}
	public void update() {
		try {
            Booking update = new Booking();
            //SimpleDateFormat dateformat =new SimpleDateFormat("yyyy-MM-dd");
           // update.setBookingId(txtBookingId.getText());
            update.setGuestName(txtGuestName.getText());
            update.setCheckInDate(dateCheckIn.getDate().toString());
            update.setCheckOutDate(dateCheckOut.getDate().toString());
            update.setRoomType(comboBoxRoomType.getSelectedItem().toString());
            update.setBookingId(txtBookingId.getText());
            BLBooking blBooking = new BLBooking(update);
      
            blBooking.update();
            loadBooking();
			
        }catch(InputException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        catch(Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
	}
	
	public void cancel() {
		try {
            Booking cancel= new Booking();
            //SimpleDateFormat dateformat =new SimpleDateFormat("yyyy-MM-dd");
           // update.setBookingId(txtBookingId.getText());
            
            cancel.setBookingId(txtBookingId.getText());
            BLBooking blBooking = new BLBooking(cancel);
      
            blBooking.cancel();
            loadBooking();
			
        }catch(InputException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        catch(Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
	}
}
