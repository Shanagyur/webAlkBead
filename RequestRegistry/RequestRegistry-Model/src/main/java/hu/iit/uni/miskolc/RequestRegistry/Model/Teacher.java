package hu.iit.uni.miskolc.RequestRegistry.Model;

public class Teacher extends User {

	private String neptunID;
	private String faculty;
	
	public Teacher() {
		super();
	}

	public String getNeptunID() {
		return neptunID;
	}

	public void setNeptunID(String neptunID) {
		this.neptunID = neptunID;
	}

	public String getFaculty() {
		return faculty;
	}

	public void setFaculty(String faculty) {
		this.faculty = faculty;
	}
}
