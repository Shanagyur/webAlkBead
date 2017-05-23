package hu.iit.uni.miskolc.RequestRegistry.Model;

public class Details {
	
	private String firstName;
	private String lastName;
	private String neptunID;
	private String email;
	
	public Details() {
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getNeptunID() {
		return neptunID;
	}

	public void setNeptunID(String neptunID) {
		this.neptunID = neptunID;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
