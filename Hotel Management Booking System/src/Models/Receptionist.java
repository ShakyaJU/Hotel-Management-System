package Models;

public class Receptionist {
	private int receptionistId;
	private String fullName;
	private String email;
	private String password;
	private String contactNo;

	public Receptionist() {
		this.receptionistId = 0;
		this.fullName = "";
		this.email = "";
		this.password = "";
		this.contactNo = "";
		
	}
	
	public Receptionist(int receptionistId, String fullName, String email, String password, String contactNo) {
		this.receptionistId = receptionistId;
		this.fullName = fullName;
		this.email = email;
		this.password = password;
		this.contactNo = contactNo;
	}

	public int getReceptionistId() {
		return receptionistId;
	}

	public void setReceptionistId(int receptionistId) {
		this.receptionistId = receptionistId;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	@Override
	public String toString() {
		return "Receptionist [receptionistId=" + receptionistId + ", fullName=" + fullName + ", email=" + email
				+ ", password=" + password + ", contactNo=" + contactNo + "]";
	}

}

