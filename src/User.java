
public class User {
	private String username;
	private String password;
	
	//Constructor
	public User(String username, String password)
	{
		this.username = username;
		this.password = password;
	}

	//get methods
	public String getUsername() {
		return username;
	}
	
	public String getPassword() {
		return password;
	}
	
	//set methods
	public void setUsername(String username) {
		this.username = username;
	}
	

	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
