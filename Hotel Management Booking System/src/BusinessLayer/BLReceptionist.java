package BusinessLayer;

import Models.Customer;
import Models.Receptionist;
import FrontEndLayer.FPage;
import java.util.ArrayList;

import DatabaseLayer.DLReceptionist;
import DatabaseLayer.DLUser;
import Helper.InputException;

public class BLReceptionist {
	Receptionist receptionist;

	public BLReceptionist() {
		this.receptionist = new Receptionist();
		
	}
	public Receptionist getReceptionist() {
		return receptionist;
	}
	public void setReceptionist(Receptionist receptionist) throws InputException {
		try {
			if(this.validateReceptionist(receptionist)) {
				this.receptionist = receptionist;
			}
		}catch(InputException ex) {
			throw ex;
		}
	}

private boolean validateReceptionist(Receptionist receptionist) throws InputException {
	if(receptionist.getEmail() == null || receptionist.getEmail().length() == 0) {
		throw new InputException("Receptionist detail cannot be empty. ");
	}
	if(receptionist.getPassword() == null || receptionist.getPassword().length() == 0) {
		throw new InputException("Receptionist detail cannot be empty. ");
	}
	return true;
	}

public Receptionist loginReceptionist() throws Exception{
    try {
        DLReceptionist dlReceptionist = new DLReceptionist(this.receptionist);
        return dlReceptionist.loginReceptionist();
    } catch (Exception e) {
        throw e;
    }
}
}

	
