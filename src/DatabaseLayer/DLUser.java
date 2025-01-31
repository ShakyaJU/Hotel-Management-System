package DatabaseLayer;

import Models.Customer;


import Models.Booking;


import FrontEndLayer.FPage;
import FrontEndLayer.HomePage;
import FrontEndLayer.RegistrationPage;
import Helper.DatabaseConnector;
import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;



public class DLUser {
	private Customer customer;
	private DatabaseConnector db;
	private Connection connection;

	public DLUser() throws Exception {
		this.customer = new Customer();
		try {
			this.db = DatabaseConnector.getInstance();
			this.connection = this.db.getConnection();
		} catch (Exception ex) {
			throw ex;
		}

	}

	public DLUser(Customer customer) throws Exception {
		this.customer = customer;
		try {
			this.db = DatabaseConnector.getInstance();
			this.connection = this.db.getConnection();
		} catch (Exception ex) {
			throw ex;
		}

	}

	public Customer getCustomer() {
		return customer;
	}

	public void setUser(Customer customer) {
		this.customer = customer;
	}
	
	public Customer loginCustomer() throws Exception{
        try {
            String sql = "SELECT * FROM customer WHERE Email='" + this.customer.getEmail() + "' AND Password='" + this.customer.getPassword() + "'";
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
            return customer;
        }catch(Exception ex){
            throw ex;
        }
    }
	
	public Customer register() throws Exception{
		  try {
	            String sql = "INSERT INTO customer(fullName, companyName, address, contactNo, email, password, customerType) VALUES (?,?,?,?,?,?,?)";
	            PreparedStatement statement = this.connection.prepareStatement(sql);
	            statement.setString(1, this.customer.getFullName());
	            statement.setString(2, this.customer.getCompanyName());
	            statement.setString(3, this.customer.getAddress());
	            statement.setString(4, this.customer.getContactNo()); 
	            statement.setString(5, this.customer.getEmail());
	            statement.setString(6, this.customer.getPassword());
	            statement.setString(7, this.customer.getCustomerType());
	            statement.executeUpdate();

	            JOptionPane.showMessageDialog(null, "Account Registered Successfully.");
	            return this.customer;
	        }catch (Exception ex) {
	            JOptionPane.showMessageDialog(null, ex.getMessage());
	        }
	        return customer;
	    }
	
	
	
	

	/*public User save() throws Exception {
		try {
			// prepare for the data to be returned in case of insert
			String generatedColumns[] = { "id" };
			// create the statement
			String query = "INSERT INTO user(name, address) VALUES(?,?)";
			PreparedStatement statement = this.connection.prepareStatement(query, generatedColumns);
			statement.setString(1, this.user.getName());
			statement.setString(2, this.user.getAddress());
			// execute the query
			int noOfUpdate = statement.executeUpdate();
			if (noOfUpdate > 0) {
				ResultSet rs = statement.getGeneratedKeys();
				if (rs.next()) {
					int id = rs.getInt(1);
					this.user.setUserId(id);
				}
			}
			return this.user;

		} catch (Exception ex) {
			throw ex;
		}
	}

	public User UpdateUser() throws Exception {
		try {

			// update the statement
			String query = "UPDATE user SET name=?, address=? WHERE id=?";
			PreparedStatement statement = this.connection.prepareStatement(query);
			statement.setString(1, this.user.getName());
			statement.setString(2, this.user.getAddress());
			statement.setInt(3, this.user.getUserId());
			// execute the query
			statement.executeUpdate();
			return this.user;

		} catch (Exception ex) {
			throw ex;
		}
	}

	public User DeleteUser() throws Exception {
		try {

			// delete the statement
			String query = "DELETE FROM user WHERE id=?";
			PreparedStatement statement = this.connection.prepareStatement(query);
			statement.setString(1, this.user.getName());
			statement.setString(2, this.user.getAddress());
			statement.setInt(3, this.user.getUserId());
			// execute the query
			statement.executeUpdate();
			return this.user;

		} catch (Exception ex) {
			throw ex;
		}
	}

	public ArrayList<User> getAllUser() throws Exception {
		try {
			ArrayList<User> users = new ArrayList<User>();
			String query = "SELECT * FROM user ORDER BY name";
			Statement statement = this.connection.createStatement();
			ResultSet rs = statement.executeQuery(query);
			while (rs.next()) {
				User u = new User();
				u.setUserId(rs.getInt("id"));
				u.setName(rs.getString("name"));
				u.setAddress(rs.getString("address"));
				users.add(u);
			}
			return users;
		} catch (Exception ex) {
			throw ex;
		}
	}

	public ArrayList<User> searchUser(String[] keys, String[] values) throws Exception {
		// SELECT * FROM USER WHERE name LIKE '%Hari%' AND address LIKE '&PCPS%';
		ArrayList<User> users = new ArrayList<User>();
		try {
			int keyLength = keys.length;
			String where = "";
			for (int i = 0; i < keyLength; ++i) {
				if (i == 0) {
					where = where + " WHERE " + keys[i] + " LIKE '%" + values[i] + "%' ";
				} else {
					where = where + " AND " + keys[i] + " LIKE '%" + values[i] + "%' ";
				}
			}
			String query = "SELECT * FROM user" + where + " ORDER BY name";
			Statement statement = this.connection.createStatement();
			ResultSet rs = statement.executeQuery(query);
			while (rs.next()) {
				User u = new User();
				u.setUserId(rs.getInt("id"));
				u.setName(rs.getString("name"));
				u.setAddress(rs.getString("address"));
				users.add(u);

			}
		} catch (SQLException e) {
			throw new Exception(e.getMessage());
		}
		return users;
	}*/
}

