package FrontEndLayer;

import java.awt.EventQueue;



import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JDesktopPane;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JSplitPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.JCheckBox;
import javax.swing.Box;
import javax.swing.ImageIcon;

import java.awt.Component;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;
import Models.Customer;
import Models.Receptionist;
import BusinessLayer.BLReceptionist;
import BusinessLayer.BLuser;
import Helper.DatabaseConnector;
import Helper.InputException;
public class FPage {

	private JFrame frame;
	private JTextField tfEmail;
	private JPasswordField tfPassword;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the application.
	 *
	/**
	 * Initialize the contents of the frame.
	 */
	public FPage() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.LIGHT_GRAY);
		frame.setBounds(100, 100, 399, 438);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnLogin = new JButton("LOGIN");
		btnLogin.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnLogin.setBounds(104, 252, 185, 36);
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loginUser();
			}
		});
		frame.getContentPane().add(btnLogin);
		
		tfEmail = new JTextField();
		tfEmail.setBounds(104, 168, 185, 31);
		frame.getContentPane().add(tfEmail);
		tfEmail.setColumns(10);
		
		JLabel lblEmail = new JLabel("Email Address:");
		lblEmail.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		lblEmail.setBounds(10, 168, 115, 31);
		frame.getContentPane().add(lblEmail);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		lblPassword.setBounds(30, 213, 72, 25);
		frame.getContentPane().add(lblPassword);
		
		JLabel lblWelcome = new JLabel("WELCOME TO HOTEL  LUTON");
		lblWelcome.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblWelcome.setBounds(75, 99, 280, 36);
		frame.getContentPane().add(lblWelcome);
		
		Box horizontalBox = Box.createHorizontalBox();
		horizontalBox.setBackground(new Color(0, 0, 0));
		horizontalBox.setBounds(0, 79, 460, -26);
		frame.getContentPane().add(horizontalBox);
		
		JLabel lblLogo = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("/Logo.png")).getImage();
		lblLogo.setIcon(new ImageIcon(img));
		lblLogo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblLogo.setBounds(155, 11, 77, 77);
		frame.getContentPane().add(lblLogo);
		
		JLabel lblLutonUk = new JLabel("Luton,UK");
		lblLutonUk.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblLutonUk.setBounds(162, 130, 70, 14);
		frame.getContentPane().add(lblLutonUk);
		
		JButton btnRegister = new JButton("REGISTER");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				RegistrationPage regPage = new RegistrationPage();
				regPage.setVisible(true);
			}
		});
		btnRegister.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnRegister.setBounds(104, 299, 185, 36);
		frame.getContentPane().add(btnRegister);
		
		
		tfPassword = new JPasswordField();
		tfPassword.setBounds(104, 210, 185, 31);
		frame.getContentPane().add(tfPassword);
		
		JButton btnStaffLog = new JButton("STAFF LOGIN");
		btnStaffLog.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loginReceptionist();
			}
		});
		btnStaffLog.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnStaffLog.setBounds(104, 346, 185, 36);
		frame.getContentPane().add(btnStaffLog);
		frame.setResizable(false);
		
	}
	private void loginUser() {
        try {
            Customer customer = new Customer();
            customer.setEmail(tfEmail.getText());
            customer.setPassword(String.valueOf(tfPassword.getPassword()));

            BLuser blUser = new BLuser();
            blUser.setLogin(customer);
            
            customer = blUser.loginCustomer();
            frame.dispose();
        }catch(InputException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        catch(Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }
	private void loginReceptionist() {
		try {
            Receptionist receptionist = new Receptionist();
            receptionist.setEmail(tfEmail.getText());
            receptionist.setPassword(String.valueOf(tfPassword.getPassword()));

            BLReceptionist blReceptionist = new BLReceptionist();
            blReceptionist.setReceptionist(receptionist);
            
            receptionist = blReceptionist.loginReceptionist();
            frame.dispose();
        }catch(InputException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        catch(Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
	}
	
	public void setVisible(boolean s) {
		frame.setVisible(s);
	}
}

