/**
 * Homework 3
 * Justin Cai, jc5pz
 *
 * Sources : CS2110 Lecture, Java API, StackOverflow
 * https://stackoverflow.com/questions/20231539/java-check-the-date-format-of-current-string-is-according-to-required-format-or
 * 
 * DO THE COMMENTS
 */
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class PhotoLibrary {
	/** 
	 * String containing the name of the PhotoLibrary
	 */
	private String name; 
	/** 
	 * integer containing the ID of the PhotoLibrary
	 */
	private int id; 
	/**
	 * ArrayList of Photographs containing the photos that have been taken
	 */
	private ArrayList<Photograph> photos;
	/**
	 * HashSet of Albums containing the Photos that have been organized into Albums
	 */
	private HashSet<Album> albums;

	public static void main(String[] args) {
		//Instantiates three PhotoLibrarys
		PhotoLibrary justin = new PhotoLibrary("Justin", 1);
		PhotoLibrary a = justin;
		PhotoLibrary b = new PhotoLibrary("Cai", 2);
		//Instantiates four Photographs
		Photograph beach = new Photograph("Beach", "beach.jpg");
		Photograph sun = new Photograph("Sun", "sun.jpg");
		Photograph sunset = new Photograph("Sunset", "sunset.jpg");
		Photograph sunrise = new Photograph("Sunrise", "sunrise.jpg");
		//PhotoLibrarys call method takePhoto. Justin takes Photos sun and sunset, b takes Photos beach, sun, and sunrise
		justin.takePhoto(sun);
		justin.takePhoto(sunset);
		b.takePhoto(beach);
		b.takePhoto(sun);
		b.takePhoto(sunrise);
		//Prints out the number of Photographs justin has and if PhotoLibrary a equals justin, if PhotoLibrary b equals justin
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
		//PhotoLibrary b erases Photo beach and justin erases Photo sunset
		b.erasePhoto(beach);
		justin.erasePhoto(sunset);
		//Prints similarity, common photos between justin and b, calls hasPhoto to check if b has taken Photo beach
		System.out.println("The similarity between " + b.getName() + " and " + justin.getName() + " is " + similarity(b, justin));
		System.out.println("Common photos between " + b.getName() + " and " +justin.getName() + " are: " + commonPhotos(b, justin));
		System.out.println("Has " + b.getName() + " taken the Photo " + beach.getFilename()+"?: " + b.hasPhoto(beach));
		//Calls PhotoLibrary b and justin's toString method
		System.out.println(b.toString());
		System.out.println(justin.toString());
	}
	public PhotoLibrary(String n, int i) {
		this.name = n;
		this.id = i;
		this.albums = new HashSet<Album>();
		photos = new ArrayList<Photograph>();
	}
	/**
	 * 
	 * @return returns a String containing the PhotoLibrary's name
	 */
	public String getName() {
		return this.name;
	}
	/**
	 * 
	 * @return returns an integer containing the PhotoLibrary's ID
	 */
	public int getId() {
		return this.id;
	}
	/**
	 * 
	 * @return returns an ArrayList of Photographs containing the PhotoLibrary's photos
	 */
	public ArrayList<Photograph> getPhotos() {
		return this.photos;
	}
	/**
	 * Loops through the photos and compares the ratings to the rating given in the parameter, returns
	 * an ArrayList containing all photos where the photo's rating is >= the rating parameter 
	 * @param rating an integer containing a rating that must be matched
	 * @return an ArrayList containing all the photos that match the given rating
	 */
	public ArrayList<Photograph> getPhotos(int rating) {
		if(rating<0||rating>5) {
			return null;
		}
		ArrayList<Photograph> fnl = new ArrayList<Photograph>();
		for(Photograph p: photos) {
			if(p.getRating() >= rating) {
				fnl.add(p);
			}
		}
		return fnl;
	}
	/**
	 * Looks for all Photographs taken in the year given in parameter and returns an ArrayList 
	 * containing those Photographs. Returns null if the year is not formatted properly.
	 * @param year an integer containing the year of the Photos wanted
	 * @return an ArrayList of Photographs taken in year, null if year isn't correct
	 */
	public ArrayList<Photograph> getPhotosInYear(int year) {
		if(year < 1000 || year >9999) {
			return null;
		}
		ArrayList<Photograph> fnl = new ArrayList<Photograph>();
		for(Photograph p: photos) {
			String yr = p.getDateTaken().substring(0,4);
			if(yr.equals(""+year)) {
				fnl.add(p);
			}
		}
		return fnl;
	}
	/**
	 * Looks for all Photographs taken in the year and month given in parameter and returns an ArrayList 
	 * containing those Photographs. Returns null if the year or month are not formatted properly.
	 * @param month an integer containing the month of Photographs wanted
	 * @param year an integer containing the year of Photographs wanted
	 * @return returns an ArrayList containing all Photographs that were taken in the year and month given,
	 * null if year or month isn't correct
	 */
	public ArrayList<Photograph> getPhotosInMonth(int month, int year) {
		if(month>12||month<1||year<1000 || year>9999) {
			return null;
		}
		ArrayList<Photograph> fnl = new ArrayList<Photograph>();
		for(Photograph p: photos) {
			String yr = p.getDateTaken().substring(0,4);
			String mo = p.getDateTaken().substring(5,7);
			String m = "";
			if(month <10) {
				m = "0"+month;
			}
			else {
				m = ""+month;
			}
			if(yr.equals(""+year) && mo.equals(m)) {
				fnl.add(p);
			}
		}
		return fnl;
	}
	/**
	 * Looks for all Photographs taken between the beginDate and endDate, inclusive, and returns an ArrayList containing those Photos.
	 * Returns null if either of the dates are not formatted properly. Returns null if the beginDate is after the endDate.
	 * @param beginDate a String containing the start date being searched for
	 * @param endDate a String containing the end date being searched for
	 * @return an ArrayList of Photographs containing all Photos taken in between the two dates. Null if the dates aren't formatted/done
	 * incorrectly
	 */
	public ArrayList<Photograph> getPhotosBetween(String beginDate, String endDate) {
		Date begin1 = null;
		Date end1 = null;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			begin1 = sdf.parse(beginDate);
			end1 = sdf.parse(endDate);
			String begin = sdf.format(begin1);
			String end = sdf.format(end1);
			if(begin.equals(beginDate) && end.equals(endDate)) {
				if(begin.compareTo(end) > 0) {
					return null;
				}
				if(begin.length() == 10 && end.length() ==10) {
					if(begin.substring(5,7).compareTo("0") >= 0 || begin.substring(5,7).compareTo("12") <= 0) {
						ArrayList<Photograph> fnl = new ArrayList<Photograph>();
						for(Photograph p: photos) {
							if(p.getDateTaken().compareTo(beginDate) >=0 && p.getDateTaken().compareTo(endDate) <= 0) {
								fnl.add(p);
							}
						}
						return fnl;
					}
				}
			}	
		} catch (ParseException e) {
			return null;
		}
		return null;
	}
	/**
	 * 
	 * @return returns a HashSet of Albums containing the PhotoLibrary's Albums
	 */
	public HashSet<Album> getAlbums() {
		return albums;
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
			if(p.getRating() < 0 || p.getRating() > 5) {
				return false;
			}
			Date begin1 = null;
			try {
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				begin1 = sdf.parse(p.getDateTaken());
				String begin = sdf.format(begin1);
				if(begin.equals(p.getDateTaken())) {
					if(p.getDateTaken().length() ==10) {
						if(begin.substring(5,7).compareTo("0") >= 0 || begin.substring(5,7).compareTo("12") <= 0) {
							photos.add(p);
							return true;
						}
					}
				}
			} catch(ParseException e) {
				return false;
			}
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
			for(Album a: albums) {
				if(a.hasPhoto(p)) {
					a.getPhotos().remove(p);
				}
			}
			return true;
		}
		return false;
	}
	/**
	 * Checks if an album with the name albumName has been created already, if it has returns false. If not, creates a new Album
	 * with the name albumName and returns true. 
	 * @param albumName a String containing the name of the Album being created
	 * @return true if the album was successfully created, false if not
	 */
	public boolean createAlbum(String albumName) {
		Album a = getAlbumByName(albumName);
		if(a != null) {
			return false;
		}
		albums.add(new Album(albumName));
		return true;
	}
	/**
	 * Checks if an album with the name albumName exists, if it does it removes the album and returns true. If not, returns false.
	 * @param albumName a String containing the name of the Album being removed
	 * @return true if an Album with the name albumName was removed, false if not
	 */
	public boolean removeAlbum(String albumName) {
		return albums.remove(new Album(albumName));
	}
	/**
	 * Checks if Photograph p has already been taken (i.e. in photos), if it has then checks if an Album with the name albumName exists.
	 * If it does, then it checks if p is in that Album. If it isn't, the Photograph gets added to the Album and the method returns true.
	 * If all those conditions aren't met, returns false.
	 * @param p the Photograph being added to the Album
	 * @param albumName a String containing the name of the Album the Photograph is being added to
	 * @return true if the Photograph is successfully added to the given Album, if not returns false.
	 */
	public boolean addPhotoToAlbum(Photograph p, String albumName) {
		if(photos.contains(p)) {
			Album a = getAlbumByName(albumName);
			if(a != null) {
				if(!a.hasPhoto(p)) {
					a.addPhoto(p);
					return true;
				}
			}
		}
		return false;
	}
	/**
	 * Checks if Photograph p has already been taken (i.e. in photos), if it has then checks if an Album with the name albumName exists.
	 * If it does, then it checks if p is in that Album. If it is, the Photograph gets removed from the Album and the method returns true.
	 * If all those conditions aren't met, returns false.
	 * @param p the Photograph being removed from the Album
	 * @param albumName a String containing the name of the Album the Photograph is being removed from
	 * @return true if the Photograph is successfully removed from the given Album, if not returns false.
	 */
	public boolean removePhotoFromAlbum(Photograph p, String albumName) {
		if(photos.contains(p)) {
			Album a = getAlbumByName(albumName);
			if(a != null) {
				if(a.hasPhoto(p)) {
					a.getPhotos().remove(p);
					return true;
				}
			}
		}
		return false;
	}
	/**
	 * Helper method that returns the Album with the name albumName if it exists. If it doesn't, returns null.
	 * @param albumName a String containing the name of the Album being searched for.
	 * @return returns the Album with the name albumName if it exists, if not returns null
	 */
	private Album getAlbumByName(String albumName) {
		for(Album a: albums) {
			if(a.getName().equals(albumName)) {
				return a;
			}
		}
		return null;
	}
	/**
	 * 
	 * @return returns an integer containing the number of photos taken
	 */
	public int numPhotographs() {
		return photos.size();
	}
	/**
	 * checks if Object o is null or if it's not a PhotoLibrary first and returns false if it is. If not, o is converted to type PhotoLibrary and returns true if their attributes are the same.
	 * @param o reference to the Object being compared to
	 */
	public boolean equals(Object o) {
		if(o == null) {
			return false;
		}
		if(!(o instanceof PhotoLibrary)) {
			return false;
		}
		PhotoLibrary p = (PhotoLibrary) o;
		if(p.id != this.id) {
			return false;
		}
		return true;
	}
	/**
	 * returns a String containing the name, ID, and photos of the PhotoLibrary. Calls class Photograph's toString method.
	 */
	@Override
	public String toString() {
		String fnl = "Name: " + this.name + ", ID: " + this.id + ", Photos: ";
		for(Photograph p: this.photos) {
			fnl += p.toString() + "\n";
		}
		for(Album a: albums) {
			fnl += a.getName() + "\n";
		}
		return fnl;
	}
	/**
	 * returns an ArrayList of type Photograph containing all photos that PhotoLibrary a and b have in common
	 * @param a the first PhotoLibrary being compared
	 * @param b the second PhotoLibrary being compared
	 * @return returns an ArrayList of Photographs containing all the photos a and b have in common
	 */
	public static ArrayList<Photograph> commonPhotos(PhotoLibrary a, PhotoLibrary b) {
		ArrayList<Photograph> fnl = new ArrayList<Photograph>();
		for(Photograph x: a.getPhotos()) {
			if(b.hasPhoto(x)) {
				fnl.add(x);
			}
		}
		return fnl;
	}
	/**
	 * calls commonPhotos and returns the similarity factor, a double containing the number of common photos divided by the number of photographs the PhotoLibrary with lesser photos has taken
	 * @param a the first PhotoLibrary being compared
	 * @param b the second PhotoLibrary being compared
	 * @return returns a double containing the similarity factor
	 */
	public static double similarity(PhotoLibrary a, PhotoLibrary b) {
		if(a.getPhotos().size() == 0 || b.getPhotos().size() == 0) {
			return 0.0;
		}
		return (double)commonPhotos(a, b).size() / Math.min((double)(a.numPhotographs()), (double)b.numPhotographs());
	}
}
