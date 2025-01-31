package BusinessLayer;
//This class uses the user model to receive and send data to the database layer
import Models.Customer;



import FrontEndLayer.RegistrationPage;
import FrontEndLayer.FPage;
import java.util.ArrayList;
import DatabaseLayer.DLUser;
import Helper.InputException;

public class BLuser {
 Customer customer;

	public BLuser() {
		this.customer = new Customer();
		
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) throws InputException {
		try {
			if(this.validateCustomer(customer)) {
				this.customer = customer;
			}
		}catch(InputException ex) {
			throw ex;
		}
	}
	
	
private boolean validateCustomer(Customer customer) throws InputException {
	if(customer.getEmail() == null || customer.getEmail().length() == 0) {
		throw new InputException("The details are empty. ");
	}
	if(customer.getPassword() == null || customer.getPassword().length() == 0) {
		throw new InputException("Customer password cannot be empty. ");
	}
	if(customer.getFullName().length() == 0 || customer.getAddress().length() == 0 || customer.getContactNo().length() == 0 ) {
		throw new InputException("The details are invalid.");
	}
	if(customer.getCustomerType()=="Corporate Customer" && customer.getCompanyName().length()==0) {
		throw new InputException("Corporate Name cannot be empty. ");
	}
	return true;
}

private boolean validateLogin(Customer customer) throws InputException {
	if(customer.getEmail() == null || customer.getEmail().length() == 0) {
		throw new InputException("Customer email cannot be empty. ");
	}
	if(customer.getPassword() == null || customer.getPassword().length() == 0) {
		throw new InputException("Customer password cannot be empty. ");
	}
	return true;
}

public void setLogin(Customer customer) throws InputException {
	try {
		if(this.validateLogin(customer)) {
			this.customer = customer;
		}
	}catch(InputException ex) {
		throw ex;
	}
}

public Customer loginCustomer() throws Exception{
    try {
        DLUser dlCustomer = new DLUser(this.customer);
        return dlCustomer.loginCustomer();
    } catch (Exception e) {
        throw e;
    }
}

public Customer register() throws Exception{ 
	try {
        DLUser dlCustomer = new DLUser(this.customer);
        return dlCustomer.register();
    } catch (Exception e) {
        throw e;
    }
}
// save the user, update the user, delete the user, getUserList
/*public Customer save() throws Exception {
	// this function saves the user detail to database and returns the user object after saving
	try {
		DLUser dlUser = new DLUser(this.customer);
		return dlUser.save();
	}catch (Exception e) {
		throw e;
	}
}
public User update() throws Exception {
	// this function updates the user detail to database and returns the user object after saving
	try {
		DLUser dlUser = new DLUser(this.user);
		return dlUser.UpdateUser();
	}catch (Exception e) {
		throw e;
	}
}
public void delete() throws Exception {
	// this function deletes the user detail to database and returns the user object after saving
	try {
		DLUser dlUser = new DLUser(this.user);
		 dlUser.DeleteUser();
	}catch (Exception e) {
		throw e;
	}
}

public ArrayList<User> getAllUser() throws Exception {
	try {
		DLUser dlUser = new DLUser(this.user);
		return dlUser.getAllUser();
	}catch(Exception e) {
		throw e;
	}
}

public ArrayList<User> searchUser(String[] keys, String[] values) throws Exception{
	try {
		DLUser dlUser = new DLUser(this.user);
		return dlUser.searchUser(keys, values);
	}catch(Exception e) {
		throw e;
		
	}
}*/
}

