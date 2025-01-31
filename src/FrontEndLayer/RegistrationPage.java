package FrontEndLayer;

import java.awt.BorderLayout;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import BusinessLayer.BLuser;
import Helper.InputException;
import Models.Customer;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class RegistrationPage extends JFrame {
	private JComboBox comboBox;
	private JTextField txtFullName;
	private JTextField txtCompanyName;
	private JTextField txtAddress;
	private JTextField txtContactNo;
	private JTextField txtEmailAddress;
	private JPasswordField txtPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegistrationPage frame = new RegistrationPage();
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
	public RegistrationPage() {
		setResizable(false);
		getContentPane().setBackground(Color.GRAY);
		getContentPane().setForeground(Color.BLACK);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 503, 472);
		getContentPane().setLayout(null);
		
		JLabel lblTitleLutonHotel = new JLabel("LUTON HOTEL");
		lblTitleLutonHotel.setFont(new Font("Times New Roman", Font.BOLD, 17));
		lblTitleLutonHotel.setBounds(194, 11, 133, 14);
		getContentPane().add(lblTitleLutonHotel);
		
		JLabel lblRegisterAcciunt = new JLabel("Register your account.");
		lblRegisterAcciunt.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblRegisterAcciunt.setBounds(177, 52, 166, 14);
		getContentPane().add(lblRegisterAcciunt);
		
		JLabel lblFullName = new JLabel("Full Name:");
		lblFullName.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblFullName.setBounds(117, 106, 60, 14);
		getContentPane().add(lblFullName);
		
		JLabel lblCompanyName = new JLabel("Company Name:");
		lblCompanyName.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblCompanyName.setBounds(83, 131, 94, 14);
		getContentPane().add(lblCompanyName);
		
		JLabel lblAddress = new JLabel("Address:");
		lblAddress.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblAddress.setBounds(127, 156, 50, 14);
		getContentPane().add(lblAddress);
		
		JLabel lblContactNo = new JLabel("Contact No:");
		lblContactNo.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblContactNo.setBounds(108, 181, 75, 14);
		getContentPane().add(lblContactNo);
		
		JLabel lblEmailAddress = new JLabel("Email Address:");
		lblEmailAddress.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblEmailAddress.setBounds(100, 206, 83, 14);
		getContentPane().add(lblEmailAddress);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblPassword.setBounds(117, 231, 60, 14);
		getContentPane().add(lblPassword);
		
		txtFullName = new JTextField();
		txtFullName.setBounds(177, 103, 166, 20);
		getContentPane().add(txtFullName);
		txtFullName.setColumns(10);
		
		txtCompanyName = new JTextField();
		txtCompanyName.setColumns(10);
		txtCompanyName.setBounds(177, 128, 166, 20);
		getContentPane().add(txtCompanyName);
		
		txtAddress = new JTextField();
		txtAddress.setColumns(10);
		txtAddress.setBounds(177, 153, 166, 20);
		getContentPane().add(txtAddress);
		
		txtContactNo = new JTextField();
		txtContactNo.setColumns(10);
		txtContactNo.setBounds(177, 178, 166, 20);
		getContentPane().add(txtContactNo);
		
		txtEmailAddress = new JTextField();
		txtEmailAddress.setColumns(10);
		txtEmailAddress.setBounds(177, 203, 166, 20);
		getContentPane().add(txtEmailAddress);
		
		txtPassword = new JPasswordField();
		txtPassword.setBounds(177, 228, 166, 20);
		getContentPane().add(txtPassword);
		
		JButton btnRegister = new JButton("Register");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				register();
				
			}
		});
		btnRegister.setBounds(150, 358, 89, 23);
		getContentPane().add(btnRegister);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				FPage fp = new FPage();
				fp.setVisible(true);
				
			}
		});
		btnCancel.setBounds(254, 358, 89, 23);
		getContentPane().add(btnCancel);
		
		comboBox = new JComboBox();
		comboBox.setBackground(new Color(255, 255, 255));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Customer", "Corporate Customer"}));
		comboBox.setBounds(209, 286, 134, 22);
		getContentPane().add(comboBox);
		
		JLabel lblNewLabel = new JLabel("Customer Type:");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblNewLabel.setBounds(83, 290, 113, 14);
		getContentPane().add(lblNewLabel);
		
	}
	
	public void register() {
		try {
            Customer customer = new Customer();
            customer.setFullName(txtFullName.getText());
            customer.setCompanyName(txtCompanyName.getText());
            customer.setAddress(txtAddress.getText());
            customer.setContactNo(txtContactNo.getText());
            customer.setCustomerType(comboBox.getSelectedItem().toString());
            customer.setEmail(txtEmailAddress.getText());
           
            customer.setPassword(String.valueOf(txtPassword.getPassword()));

            BLuser blUser = new BLuser();
            blUser.setCustomer(customer);
            customer = blUser.register();
            dispose();
			HomePage hp = new HomePage();
			hp.setVisible(true);
        }catch(InputException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        catch(Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
		
	}
}
