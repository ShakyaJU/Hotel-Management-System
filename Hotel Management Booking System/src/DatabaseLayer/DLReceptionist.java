package DatabaseLayer;

import Models.Customer;
import Models.Receptionist;
import FrontEndLayer.FPage;
import FrontEndLayer.HomePage;

import Helper.DatabaseConnector;
import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;
public class DLReceptionist {

	private Receptionist receptionist;
	private DatabaseConnector db;
	private Connection connection;

	public DLReceptionist() throws Exception {
		this.receptionist = new Receptionist();
		try {
			this.db = DatabaseConnector.getInstance();
			this.connection = this.db.getConnection();
		} catch (Exception ex) {
			throw ex;
		}

	}

	public DLReceptionist(Receptionist receptionist) throws Exception {
		this.receptionist = receptionist;
		try {
			this.db = DatabaseConnector.getInstance();
			this.connection = this.db.getConnection();
		} catch (Exception ex) {
			throw ex;
		}

	}

	public Receptionist getReceptionist() {
		return receptionist;
	}

	public void setUser(Receptionist receptionist) {
		this.receptionist = receptionist;
	}
	
	public Receptionist loginReceptionist() throws Exception{
        try {
            String sql = "SELECT * FROM receptionist WHERE email='" + this.receptionist.getEmail() + "' AND password='" + this.receptionist.getPassword() + "'";
            Statement statement = this.connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            if (rs.next()) {
                HomePage hp = new HomePage();
                hp.setVisible(true);
                hp.pack();
                hp.setBounds(100, 100, 600, 600);
               // hp.setExtendedState(JFrame.MAXIMIZED_BOTH);
            }else {
                JOptionPane.showMessageDialog(null, "Incorrect Email or Password.", "Login error", 2);
            }
            return receptionist;
        }catch(Exception ex){
            throw ex;
        }
	}
}
	
