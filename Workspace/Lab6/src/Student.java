
public class Student extends Person {
	public String campusAddress;
	public double gpa;
	
	public Student() {
		super("JC", "12345 Street, Streetville");
		campusAddress = "";
		gpa = 0.0;
	}
	public Student(String ca, double gp) {
		super("JC", "12345 Street, Streetville");
		campusAddress = ca;
		gpa = gp;
	}
}
