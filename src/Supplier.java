
public class Supplier {
	
	private String id;
	private String name;
	private String PhoneNumber;
	private String email;
	
	public Supplier(String text1,String text2,String text3,String text4) {
		  id = text1;
		  name = text2;
		  PhoneNumber = text3;
		  email = text4;	
	}

	//get methods
	public String getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public String getPhoneNumber() {
		return PhoneNumber;
	}
	
	public String getEmail() {
		return email;
	}

	//set methods
	public void setId(String id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPhoneNumber(String phoneNumber) {
		PhoneNumber = phoneNumber;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	 
}
