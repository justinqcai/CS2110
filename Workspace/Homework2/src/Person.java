/**
 * Homework 2
 * Justin Cai, jc5pz
 *
 * Sources : CS2110 Lecture, Java API
 */
import java.util.ArrayList;

public class Person {
	/** 
	 * String containing the name of the Person
	 */
	private String name; 
	/** 
	 * integer containing the ID of the Person
	 */
	private int id; 
	/**
	 * ArrayList of Photographs containing the photos that have been taken
	 */
	private ArrayList<Photograph> photos;
	
	public static void main(String[] args) {
		//Instantiates three Persons
		Person justin = new Person("Justin", 1);
		Person a = justin;
		Person b = new Person("Cai", 2);
		//Instantiates four Photographs
		Photograph beach = new Photograph("Beach", "beach.jpg");
		Photograph sun = new Photograph("Sun", "sun.jpg");
		Photograph sunset = new Photograph("Sunset", "sunset.jpg");
		Photograph sunrise = new Photograph("Sunrise", "sunrise.jpg");
		//Persons call method takePhoto. Justin takes Photos sun and sunset, b takes Photos beach, sun, and sunrise
		justin.takePhoto(sun);
		justin.takePhoto(sunset);
		b.takePhoto(beach);
		b.takePhoto(sun);
		b.takePhoto(sunrise);
		//Prints out the number of Photographs justin has and if Person a equals justin, if Person b equals justin
		System.out.println(justin.getName() + " has: " + justin.numPhotographs() + " Photographs");
		System.out.println("Is " + a.getName() + " equal to " + justin.getName() +"?: " + a.equals(justin));
		System.out.println("Is " + b.getName() + " equal to " + justin.getName() +"?: " + b.equals(justin));
		//Justin takes Photo beach
		justin.takePhoto(beach);
		System.out.println(justin.getName() + " has: " + justin.numPhotographs() + " Photographs");
		System.out.println("Has " + justin.getName() + " taken the Photo " + beach.getFilename()+"?: " + justin.hasPhoto(beach));
		System.out.println("Has " + b.getName() + " taken the Photo " + beach.getFilename()+"?: " + b.hasPhoto(beach));
		System.out.println("The similarity between " + b.getName() + " and " + justin.getName() + " is " + similarity(b, justin));
		System.out.println("Common photos between " + b.getName() + " and " +justin.getName() + " are: " + commonPhotos(b, justin));
		//Person b erases Photo beach and justin erases Photo sunset
		b.erasePhoto(beach);
		justin.erasePhoto(sunset);
		//Prints similarity, common photos between justin and b, calls hasPhoto to check if b has taken Photo beach
		System.out.println("The similarity between " + b.getName() + " and " + justin.getName() + " is " + similarity(b, justin));
		System.out.println("Common photos between " + b.getName() + " and " +justin.getName() + " are: " + commonPhotos(b, justin));
		System.out.println("Has " + b.getName() + " taken the Photo " + beach.getFilename()+"?: " + b.hasPhoto(beach));
		//Calls Person b and justin's toString method
		System.out.println(b.toString());
		System.out.println(justin.toString());


	}

	public Person(String n, int i) {
		this.name = n;
		this.id = i;
		photos = new ArrayList<Photograph>();
	}
	/**
	 * 
	 * @return returns a String containing the Person's name
	 */
	public String getName() {
		return this.name;
	}
	/**
	 * 
	 * @return returns an integer containing the Person's ID
	 */
	public int getId() {
		return this.id;
	}
	/**
	 * 
	 * @return returns an ArrayList of Photographs containing the Person's photos
	 */
	public ArrayList<Photograph> getPhotos() {
		return this.photos;
	}
	/**
	 * sets the String name to a new String n
	 * @param n reference to a String containing the new name
	 */
	public void setName(String n) {
		this.name = n;
	}
	/**
	 * checks if the photo being taken has already been taken (checks if the ArrayList contains it), if not the method adds it to photos and returns true. If it's been taken already, returns false
	 * @param p reference to a Photograph containing the photo being taken
	 * @return true if photo is successfully taken (i.e. not taken before), false if not
	 */
	public boolean takePhoto(Photograph p) {
		if(!getPhotos().contains(p)) {
			photos.add(p);
			return true;
		}
		return false;
	}
	/**
	 * checks if Photograph p is already in the ArrayList photos
	 * @param p reference to the Photograph being checked
	 * @return true if it is in the ArrayList, false if not
	 */
	public boolean hasPhoto(Photograph p) {
		if(photos.contains(p)) {
			return true;
		}
		return false;
	}
	/**
	 * checks if Photograph p is in the ArrayList of photos; if it is, it gets removed and returns true. If not, returns false.
	 * @param p reference to the Photograph being removed
	 * @return true if successfully erased (i.e. if it's been taken), false if not
	 */
	public boolean erasePhoto(Photograph p) {
		if(photos.contains(p)) {
			photos.remove(p);
			return true;
		}
		return false;
	}
	/**
	 * 
	 * @return returns an integer containing the number of photos taken
	 */
	public int numPhotographs() {
		return photos.size();
	}
	/**
	 * checks if Object o is null or if it's not a Person first and returns false if it is. If not, o is converted to type Person and returns true if their attributes are the same.
	 * @param o reference to the Object being compared to
	 */
	public boolean equals(Object o) {
		if(o == null) {
			return false;
		}
		if(!(o instanceof Person)) {
			return false;
		}
		Person p = (Person) o;
		if(p.id != this.id) {
			return false;
		}
		return true;
	}
	/**
	 * returns a String containing the name, ID, and photos of the Person. Calls class Photograph's toString method.
	 */
	@Override
	public String toString() {
		String fnl = "Name: " + this.name + ", ID: " + this.id + ", Photos: ";
		for(Photograph p: this.photos) {
			fnl += p.toString() + "\n";
		}
		return fnl;
	}
	/**
	 * returns an ArrayList of type Photograph containing all photos that Person a and b have in common
	 * @param a the first Person being compared
	 * @param b the second Person being compared
	 * @return returns an ArrayList of Photographs containing all the photos a and b have in common
	 */
	public static ArrayList<Photograph> commonPhotos(Person a, Person b) {
		ArrayList<Photograph> ap = a.getPhotos();
		ArrayList<Photograph> bp = b.getPhotos();
		ArrayList<Photograph> fnl = new ArrayList<Photograph>();
		for(Photograph x: ap) {
			if(bp.contains(x)) {
				fnl.add(x);
			}
		}
		return fnl;
	}
	/**
	 * calls commonPhotos and returns the similarity factor, a double containing the number of common photos divided by the number of photographs the Person with lesser photos has taken
	 * @param a the first Person being compared
	 * @param b the second Person being compared
	 * @return returns a double containing the similarity factor
	 */
	public static double similarity(Person a, Person b) {
		if(a.getPhotos().size() == 0 || b.getPhotos().size() == 0) {
			return 0.0;
		}
		return (double)commonPhotos(a, b).size() / Math.min((double)(a.numPhotographs()), (double)b.numPhotographs());
	}
}
