/**
 * Homework 3
 * Justin Cai, jc5pz
 *
 * Sources : CS2110 Lecture, Java API, StackOverflow
 * https://stackoverflow.com/questions/20231539/java-check-the-date-format-of-current-string-is-according-to-required-format-or
 * 
 * DO THE COMMENTS
 */
import java.util.*;

public class Album {
	/**
	 * String containing the name of the album
	 */
	private String name;
	/**
	 * ArrayList of Photographs containing the photos in the album
	 */
	private ArrayList<Photograph> photos;

	public Album(String n) {
		name = n;
		photos = new ArrayList<Photograph>();
	}
	/**
	 * gets the name of the album
	 * @return a String containing the name of the album
	 */
	public String getName() {
		return name;
	}
	/**
	 * gets the photos in the album
	 * @return an ArrayList of Photographs containing the photos in the album
	 */
	public ArrayList<Photograph> getPhotos() {
		return photos;
	}
	/**
	 * Changes the current name to a new name
	 * @param n a String containing the new name to be set
	 */
	public void setName(String n) {
		name = n;
	}
	/**
	 * Checks if p is null or if p is already in the Album, if either of these are true the method doesn't add
	 * p to the Album and returns false. Otherwise, the method adds p to photos and returns true.
	 * @param p the Photograph being added to the album
	 * @return boolean true if the Photograph was successfully added, false if not
	 */
	public boolean addPhoto(Photograph p) {
		if(p == null ||hasPhoto(p)) {
			return false;
		}
		photos.add(p);
		return true;
	}
	/**
	 * Checks if p is null or if p is not in the Album, if either of these are true the method doesn't remove
	 * p from the Album and returns false. Otherwise, the method removes p from photos and returns true.
	 * @param p the Photograph being removed to the album
	 * @return boolean true if the Photograph was successfully removed, false if not
	 */
	public boolean removePhoto(Photograph p) {
		if(p == null ||!hasPhoto(p)) {
			return false;
		}
		photos.remove(p);
		return true;
	}
	/**
	 * Checks if p is already in the Album
	 * @param p the Photograph being searched for
	 * @return true if p is in the album, false if not
	 */
	public boolean hasPhoto(Photograph p) {
		if(photos.contains(p)) {
			return true;
		}
		return false;
	}
	/**
	 * 
	 * @return an integer containing the number of Photographs in the album, aka the size of photos
	 */
	public int numPhotographs() {
		return photos.size();
	}
	/**
	 * This method first checks if o is null or if it isn't of class Album, if either of these are true,
	 * returns false. If not, it changes o an Album and compares their names; if their names are the same,
	 * returns true. Otherwise, returns false.
	 * @param o the Object being compared to
	 * @return a boolean true if o is an Album and has the same name as the current Album.
	 */
	public boolean equals(Object o) {
		if(o==null) {
			return false;
		}
		if(!(o instanceof Album)) {
			return false;
		}
		Album ao = (Album) o;
		if(name == ao.getName()) {
			return true;
		}
		return false;
	}
	/**
	 * @return a String containing the name of the album and the filenames of all Photographs in the
	 * Album
	 */
	public String toString() {
		return name + "\n" + photos.toString();
	}
	@Override
	public int hashCode() {
		return this.name.hashCode();
	}
}
