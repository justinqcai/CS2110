package pointsinaplane;
//Justin Cai, jc5pz
public class pointsinaplane {
	public static void main(String[] args) {
		System.out.println(points(2.0, 3.0));
		System.out.println(points(-1.0, -.5));
		System.out.println(points(-1.0, 3.0));
		System.out.println(points(2.0, -1.0));
		
	}
	public static double points(double x, double y) {
		if(x >= 0 && y >= 0) {
			return x*y;
		}
		if(x<0 && y>=0) {
			return x-y;
		}
		if(x<0 && y<0) {
			return x/y;
		}
		return x+y;
	}
}