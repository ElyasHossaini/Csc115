package Labs.LabWeek1;

/*
* Student.java
* A Student class
*/
public class Student {

	private String sID;
	private int grade;

	public Student() {
		sID = "";
		grade = -1;
	}

	public Student(String sID, int grade) {
		this.sID = sID;
		this.grade = grade;
	}
	
	public String getSID() {
		return this.sID; // so it compiles
	}
	
	public int getGrade() {
		return this.grade; // so it compiles
	}
	
	public void setSID(String other) {
		this.sID = other;
	}
	
	public void setGrade(int other) {
		this.grade = other;
	}
	
	
	public String toString() {
		return this.sID + " " + this.grade + " loves monkey";
	}

}
