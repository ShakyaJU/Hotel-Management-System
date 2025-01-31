package Models;

public class Customer {

	private int custId;
	private String fullName;
	private String contactNo;
	private String email;
	private String password;
	private String address;
	private String companyName;
	private String customerType;
	
	public Customer() {
		this.custId = 0;
		this.companyName = "";
		this.fullName = "";
		this.contactNo = "";
		this.email = "";
		this.password = "";
		this.address = "";
		this.customerType = "";
	}
	
	public Customer(int custId, String companyName, String fullName, String contactNo, String email, String password, String address, String custType) {
		this.custId = custId;
		this.companyName = companyName;
		this.fullName = fullName;
		this.contactNo = contactNo;
		this.email = email;
		this.password = password;
		this.address = address;
		this.customerType = custType;
	}

	public int getCustId() {
		return custId;
	}

	public void setCustId(int custId) {
		this.custId = custId;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getCustomerType() {
		return customerType;
	}

	public void setCustomerType(String customerType) {
		this.customerType = customerType;
	}

	@Override
	public String toString() {
		return "Customer [custId=" + custId + ", fullName=" + fullName + ", contactNo=" + contactNo + ", email=" + email
				+ ", password=" + password + ", address=" + address + ", companyName=" + companyName + ", customerType="
				+ customerType + "]";
	}


}

