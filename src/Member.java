
public class Member {
	private String memberCardId;
	private String name;
	private String email;
	private String phoneNumber;
	private String Address;

	//Constructor
	public Member(String memberCardId, String name, String email, String phoneNumber, String Address) {
		this.memberCardId = memberCardId;
		this.name = name;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.Address = Address;
		
	}
	
	//get methods
	public String getMemberCardId() {
		return memberCardId;
	}
	
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
	public void setMemberCardId(String memberCardId) {
		this.memberCardId = memberCardId;
	}	

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
