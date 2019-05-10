/**
 * Justin Cai, jc5pz
 * Homework 5
 * 
 */
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public abstract class PhotographContainer {
	/**
	 * String containing the name of the album
	 */
	protected String name;
	/**
	 * ArrayList of Photographs containing the photos in the album
	 */
	protected ArrayList<Photograph> photos;

	public PhotographContainer(String n) {
		name = n;
		photos = new ArrayList<Photograph>();
	}

	/**
	 * gets the name of the album
	 * 
	 * @return a String containing the name of the album
	 */
	public String getName() {
		return name;
	}

	/**
	 * gets the photos in the album
	 * 
	 * @return an ArrayList of Photographs containing the photos in the album
	 */
	public ArrayList<Photograph> getPhotos() {
		return photos;
	}

	/**
	 * Changes the current name to a new name
	 * 
	 * @param n a String containing the new name to be set
	 */
	public void setName(String n) {
		name = n;
	}

	/**
	 * Checks if p is null or if p is already in the Album, if either of these are
	 * true the method doesn't add p to the Album and returns false. Otherwise, the
	 * method adds p to photos and returns true.
	 * 
	 * @param p the Photograph being added to the album
	 * @return boolean true if the Photograph was successfully added, false if not
	 */
	public boolean addPhoto(Photograph p) {
		if (p == null || hasPhoto(p)) {
			return false;
		}
		photos.add(p);
		return true;
	}

	/**
	 * Checks if p is null or if p is not in the Album, if either of these are true
	 * the method doesn't remove p from the Album and returns false. Otherwise, the
	 * method removes p from photos and returns true.
	 * 
	 * @param p the Photograph being removed to the album
	 * @return boolean true if the Photograph was successfully removed, false if not
	 */
	public boolean removePhoto(Photograph p) {
		if (p == null || !hasPhoto(p)) {
			return false;
		}
		photos.remove(p);
		return true;
	}

	/**
	 * Checks if p is already in the Album
	 * 
	 * @param p the Photograph being searched for
	 * @return true if p is in the album, false if not
	 */
	public boolean hasPhoto(Photograph p) {
		if (photos.contains(p)) {
			return true;
		}
		return false;
	}

	/**
	 * 
	 * @return an integer containing the number of Photographs in the album, aka the
	 *         size of photos
	 */
	public int numPhotographs() {
		return photos.size();
	}

	/**
	 * This method first checks if o is null or if it isn't of class Album, if
	 * either of these are true, returns false. If not, it changes o an Album and
	 * compares their names; if their names are the same, returns true. Otherwise,
	 * returns false.
	 * 
	 * @param o the Object being compared to
	 * @return a boolean true if o is an Album and has the same name as the current
	 *         Album.
	 */
	public boolean equals(Object o) {
		if (o == null) {
			return false;
		}
		if (!(o instanceof PhotographContainer)) {
			return false;
		}
		PhotographContainer ao = (PhotographContainer) o;
		if (name == ao.getName()) {
			return true;
		}
		return false;
	}

	/**
	 * @return a String containing the name of the album and the filenames of all
	 *         Photographs in the Album
	 */
	public String toString() {
		return name + "\n" + photos.toString();
	}

	@Override
	public int hashCode() {
		return this.name.hashCode();
	}

	/**
	 * Loops through the photos and compares the ratings to the rating given in the
	 * parameter, returns an ArrayList containing all photos where the photo's
	 * rating is >= the rating parameter
	 * 
	 * @param rating an integer containing a rating that must be matched
	 * @return an ArrayList containing all the photos that match the given rating
	 */
	public ArrayList<Photograph> getPhotos(int rating) {
		if (rating < 0 || rating > 5) {
			return null;
		}
		ArrayList<Photograph> fnl = new ArrayList<Photograph>();
		for (Photograph p : photos) {
			if (p.getRating() >= rating) {
				fnl.add(p);
			}
		}
		return fnl;
	}

	/**
	 * Looks for all Photographs taken in the year given in parameter and returns an
	 * ArrayList containing those Photographs. Returns null if the year is not
	 * formatted properly.
	 * 
	 * @param year an integer containing the year of the Photos wanted
	 * @return an ArrayList of Photographs taken in year, null if year isn't correct
	 */
	public ArrayList<Photograph> getPhotosInYear(int year) {
		if (year < 1000 || year > 9999) {
			return null;
		}
		ArrayList<Photograph> fnl = new ArrayList<Photograph>();
		for (Photograph p : photos) {
			String yr = p.getDateTaken().substring(0, 4);
			if (yr.equals("" + year)) {
				fnl.add(p);
			}
		}
		return fnl;
	}

	/**
	 * Looks for all Photographs taken in the year and month given in parameter and
	 * returns an ArrayList containing those Photographs. Returns null if the year
	 * or month are not formatted properly.
	 * 
	 * @param month an integer containing the month of Photographs wanted
	 * @param year  an integer containing the year of Photographs wanted
	 * @return returns an ArrayList containing all Photographs that were taken in
	 *         the year and month given, null if year or month isn't correct
	 */
	public ArrayList<Photograph> getPhotosInMonth(int month, int year) {
		if (month > 12 || month < 1 || year < 1000 || year > 9999) {
			return null;
		}
		ArrayList<Photograph> fnl = new ArrayList<Photograph>();
		for (Photograph p : photos) {
			String yr = p.getDateTaken().substring(0, 4);
			String mo = p.getDateTaken().substring(5, 7);
			String m = "";
			if (month < 10) {
				m = "0" + month;
			} else {
				m = "" + month;
			}
			if (yr.equals("" + year) && mo.equals(m)) {
				fnl.add(p);
			}
		}
		return fnl;
	}

	/**
	 * Looks for all Photographs taken between the beginDate and endDate, inclusive,
	 * and returns an ArrayList containing those Photos. Returns null if either of
	 * the dates are not formatted properly. Returns null if the beginDate is after
	 * the endDate.
	 * 
	 * @param beginDate a String containing the start date being searched for
	 * @param endDate   a String containing the end date being searched for
	 * @return an ArrayList of Photographs containing all Photos taken in between
	 *         the two dates. Null if the dates aren't formatted/done incorrectly
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
			if (begin.equals(beginDate) && end.equals(endDate)) {
				if (begin.compareTo(end) > 0) {
					return null;
				}
				if (begin.length() == 10 && end.length() == 10) {
					if (begin.substring(5, 7).compareTo("0") >= 0 || begin.substring(5, 7).compareTo("12") <= 0) {
						ArrayList<Photograph> fnl = new ArrayList<Photograph>();
						for (Photograph p : photos) {
							if (p.getDateTaken().compareTo(beginDate) >= 0
									&& p.getDateTaken().compareTo(endDate) <= 0) {
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
}
