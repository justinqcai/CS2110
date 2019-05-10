package rectangle;

public class Rectangle {
	
	private double length, width;
	
	public Rectangle() {
		length = 1;
		width = 1;
	}
	
	public Rectangle(double length, double width) {
		this.length = length;
		this.width = width;
	}
	public double getWidth() {
		return this.width;
	}
	public double getLength() {
		return this.length;
	}
	public void setWidth(double width) {
		this.width = width;
	}
	public void setLength(double length) {
		this.length = length;
	}
	public String toString() {
		return "Length: " + this.length + ", Width: " + this.width;
	}
	
	//write an appropriate toString method, getters and setters
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Rectangle a = new Rectangle(1.0, 2.0);
		System.out.println(a.toString());
		a.setLength(2.0);
		a.setWidth(3.0);
		System.out.println(a.toString());
	}

}
