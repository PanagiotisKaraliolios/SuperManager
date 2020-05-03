
public class Cashier extends User {
	private String name;
	private String email;
	private String phoneNumber;
	private String Address;
	
	//Constructor
	public Cashier(String username, String password, String name, String email, String phoneNumber, String Address) {
		super(username, password);
		this.name = name;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.Address = Address;
		
	}

	//get methods
	public String getName() {
		return name;
	}
	
	public String getEmail() {
		return email;
	}
	
	public String getPhoneNumber() {
		return phoneNumber;
	}
	
	public String getAddress() {
		return Address;
	}

	//set methods
	public void setName(String name) {
		this.name = name;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public void setAddress(String address) {
		Address = address;
	}
	

}
