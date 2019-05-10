package circle;

public class Point {
	
	private double x, y;
	
	public Point() {
		x = 0;
		y = 0;
	}
	
	public Point(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	public Point(Point p) {
		this.x = p.x;
		this.y = p.y;
	}
	
	public double distance(Point p) {
		double xdiff = this.x - p.x;
		double ydiff = this.y - p.y;
		return Math.sqrt(xdiff*xdiff + ydiff*ydiff);
	}
	
	public String toString() {
		return "(" + x +", " + y + ")";
	}
	
	public static void main(String[] args) {
		Point p1 = new Point(3, 2);
		Point p2 = new Point(-4, 2);
		System.out.println(p1);
		System.out.println(p2);
		System.out.println(p1.distance(p2));
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}
	
	public boolean equals(Object o) {
		// Java checks "o != null" first. If false, it will just fail 
		// and drop to the "return false."  If true (o is not null), 
		// then it will check that o is an instance of class Point.
		// If that is true, then it will check the individual
		// x and y coordinates.
		if (o != null && o instanceof Point) {
			Point otherPoint = (Point) o;
			
			if (this.x == otherPoint.getX() &&
					this.y == otherPoint.getY()) {
				return true;
			}
		}
		
		return false;
	}
}