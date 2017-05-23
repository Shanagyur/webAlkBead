package hu.iit.uni.miskolc.RequestRegistry.Model;

public class Admin extends User {

	private String neptunID;
	private String department;
	
	public Admin() {
		super();
	}

	public String getNeptunID() {
		return neptunID;
	}

	public void setNeptunID(String neptunID) {
		this.neptunID = neptunID;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}
}
