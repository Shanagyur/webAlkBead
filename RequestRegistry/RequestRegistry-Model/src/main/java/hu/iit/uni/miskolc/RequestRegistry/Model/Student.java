package hu.iit.uni.miskolc.RequestRegistry.Model;

import java.util.Date;

public class Student extends User {

	private String neptunID;
	private Date teachingStart;
	
	public Student() {
		super();
	}

	public String getNeptunID() {
		return neptunID;
	}

	public void setNeptunID(String neptunID) {
		this.neptunID = neptunID;
	}

	public Date getTeachingStart() {
		return teachingStart;
	}

	public void setTeachingStart(Date teachingStart) {
		this.teachingStart = teachingStart;
	}
}
