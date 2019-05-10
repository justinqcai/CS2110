package circle;

public class Circle {
	
	private double radius;
	private Point center;
	
	public Circle() {
		radius = 1;
		center = new Point(0,0);
	}
	
	public Circle(double radius, Point center) {
		this.radius = radius;
		//this.center = center;
		this.center = new Point(center);
	}
	
	@Override
	public String toString() {
		return "Center: " + center + " Radius: " + radius;
	}
	
	public boolean contains(Point p) {
		double distance = center.distance(p);
		if(distance <= radius) {
			return true;
		}
		else {
			return false;
		}
	}

	public static void main(String[] args) {
		Point p = new Point(3,3);
		Circle c = new Circle(3, p);
		System.out.println(c);
		p.setX(15);
		System.out.println(c);
		Circle d = c;
		System.out.println(c.equals(d));
		Circle e = new Circle(3, new Point(3,3));
		System.out.println(c.equals(e));
		Circle f = new Circle(4, new Point(2,2));
		System.out.println(c.equals(f));
		
		
		

	}

	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		if(radius > 0) {
			this.radius = radius;
		}
	}

	public Point getCenter() {
		return center;
	}

	public void setCenter(Point center) {
		this.center = center;
	}
	public boolean equals(Object o) {
		if(o == null) {
			return false;
		}
		if(!(o instanceof Circle)) {
			return false;
		}
		Circle oc = (Circle) o;
		if(this.radius!=oc.getRadius()) {
			return false;
		}
		if(this.center.getX() != oc.center.getX()) {
			return false;
		}
		if(this.center.getY() != oc.center.getY()) {
			return false;
		}
		return true;
	}
	
	

}