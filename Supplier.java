
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

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNumber() {
		return PhoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		PhoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	 
}
