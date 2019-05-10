
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

public class PhotoLibrary extends PhotographContainer {
	/**
	 * integer containing the ID of the PhotoLibrary
	 */
	private int id;
	/**
	 * HashSet of Albums containing the Photos that have been organized into Albums
	 */
	private HashSet<Album> albums;

	/**
	 * Calls the super constructor (PhotographContainer) with the name as the parameter
	 * @param n a String containing the name of the PhotoLibrary
	 * @param i an integer containing the ID of the PhotoLibrary
	 */
	public PhotoLibrary(String n, int i) {
		super(n);
		this.id = i;
		this.albums = new HashSet<Album>();
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
	 * @return returns a HashSet of Albums containing the PhotoLibrary's Albums
	 */
	public HashSet<Album> getAlbums() {
		return albums;
	}

	/**
	 * sets the String name to a new String n
	 * 
	 * @param n reference to a String containing the new name
	 */
	public void setName(String n) {
		name = n;
	}

	/**
	 * checks if Photograph p is in the ArrayList of photos; if it is, it gets
	 * removed and returns true. If not, returns false.
	 * 
	 * @param p reference to the Photograph being removed
	 * @return true if successfully erased (i.e. if it's been taken), false if not
	 */
	public boolean removePhoto(Photograph p) {
		if (photos.contains(p)) {
			photos.remove(p);
			for (Album a : albums) {
				if (a.hasPhoto(p)) {
					a.getPhotos().remove(p);
				}
			}
			return true;
		}
		return false;
	}

	/**
	 * Checks if an album with the name albumName has been created already, if it
	 * has returns false. If not, creates a new Album with the name albumName and
	 * returns true.
	 * 
	 * @param albumName a String containing the name of the Album being created
	 * @return true if the album was successfully created, false if not
	 */
	public boolean createAlbum(String albumName) {
		Album a = getAlbumByName(albumName);
		if (a != null) {
			return false;
		}
		albums.add(new Album(albumName));
		return true;
	}

	/**
	 * Checks if an album with the name albumName exists, if it does it removes the
	 * album and returns true. If not, returns false.
	 * 
	 * @param albumName a String containing the name of the Album being removed
	 * @return true if an Album with the name albumName was removed, false if not
	 */
	public boolean removeAlbum(String albumName) {
		return albums.remove(new Album(albumName));
	}

	/**
	 * Checks if Photograph p has already been taken (i.e. in photos), if it has
	 * then checks if an Album with the name albumName exists. If it does, then it
	 * checks if p is in that Album. If it isn't, the Photograph gets added to the
	 * Album and the method returns true. If all those conditions aren't met,
	 * returns false.
	 * 
	 * @param p         the Photograph being added to the Album
	 * @param albumName a String containing the name of the Album the Photograph is
	 *                  being added to
	 * @return true if the Photograph is successfully added to the given Album, if
	 *         not returns false.
	 */
	public boolean addPhotoToAlbum(Photograph p, String albumName) {
		if (photos.contains(p)) {
			Album a = getAlbumByName(albumName);
			if (a != null) {
				if (!a.hasPhoto(p)) {
					a.addPhoto(p);
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * Checks if Photograph p has already been taken (i.e. in photos), if it has
	 * then checks if an Album with the name albumName exists. If it does, then it
	 * checks if p is in that Album. If it is, the Photograph gets removed from the
	 * Album and the method returns true. If all those conditions aren't met,
	 * returns false.
	 * 
	 * @param p         the Photograph being removed from the Album
	 * @param albumName a String containing the name of the Album the Photograph is
	 *                  being removed from
	 * @return true if the Photograph is successfully removed from the given Album,
	 *         if not returns false.
	 */
	public boolean removePhotoFromAlbum(Photograph p, String albumName) {
		if (photos.contains(p)) {
			Album a = getAlbumByName(albumName);
			if (a != null) {
				if (a.hasPhoto(p)) {
					a.getPhotos().remove(p);
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * Helper method that returns the Album with the name albumName if it exists. If
	 * it doesn't, returns null.
	 * 
	 * @param albumName a String containing the name of the Album being searched
	 *                  for.
	 * @return returns the Album with the name albumName if it exists, if not
	 *         returns null
	 */
	private Album getAlbumByName(String albumName) {
		for (Album a : albums) {
			if (a.getName().equals(albumName)) {
				return a;
			}
		}
		return null;
	}

	/**
	 * checks if Object o is null or if it's not a PhotoLibrary first and returns
	 * false if it is. If not, o is converted to type PhotoLibrary and returns true
	 * if their attributes are the same.
	 * 
	 * @param o reference to the Object being compared to
	 */
	public boolean equals(Object o) {
		if (o == null) {
			return false;
		}
		if (!(o instanceof PhotoLibrary)) {
			return false;
		}
		PhotoLibrary p = (PhotoLibrary) o;
		if (p.id != this.id) {
			return false;
		}
		return true;
	}

	/**
	 * returns a String containing the name, ID, and photos of the PhotoLibrary.
	 * Calls class Photograph's toString method.
	 */
	@Override
	public String toString() {
		String fnl = "Name: " + this.name + ", ID: " + this.id + ", Photos: ";
		for (Photograph p : this.photos) {
			fnl += p.toString() + "\n";
		}
		for (Album a : albums) {
			fnl += a.getName() + "\n";
		}
		return fnl;
	}

	/**
	 * returns an ArrayList of type Photograph containing all photos that
	 * PhotoLibrary a and b have in common
	 * 
	 * @param a the first PhotoLibrary being compared
	 * @param b the second PhotoLibrary being compared
	 * @return returns an ArrayList of Photographs containing all the photos a and b
	 *         have in common
	 */
	public static ArrayList<Photograph> commonPhotos(PhotoLibrary a, PhotoLibrary b) {
		ArrayList<Photograph> fnl = new ArrayList<Photograph>();
		for (Photograph x : a.getPhotos()) {
			if (b.hasPhoto(x)) {
				fnl.add(x);
			}
		}
		return fnl;
	}

	/**
	 * calls commonPhotos and returns the similarity factor, a double containing the
	 * number of common photos divided by the number of photographs the PhotoLibrary
	 * with lesser photos has taken
	 * 
	 * @param a the first PhotoLibrary being compared
	 * @param b the second PhotoLibrary being compared
	 * @return returns a double containing the similarity factor
	 */
	public static double similarity(PhotoLibrary a, PhotoLibrary b) {
		if (a.getPhotos().size() == 0 || b.getPhotos().size() == 0) {
			return 0.0;
		}
		return (double) commonPhotos(a, b).size()
				/ Math.min((double) (a.numPhotographs()), (double) b.numPhotographs());
	}
}
