import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Homework 5 Justin Cai, jc5pz
 *
 * Sources : CS2110 Lecture, Java API, StackOverflow
 * https://stackoverflow.com/questions/20231539/java-check-the-date-format-of-current-string-is-according-to-required-format-or
 *  
 */
public class Photograph implements Comparable<Photograph> {
	/**
	 * String containing the caption
	 */
	private String caption;
	/**
	 * String containing the filename
	 */
	private String filename;
	/**
	 * String containing the date taken in YYYY-MM-DD format
	 */
	private String dateTaken;
	/**
	 * Integer containing the rating of the Photo from 0-5
	 */
	private int rating;
	/**
	 * File containing the image file
	 */
	private File imageFile;

	public Photograph(String c, String f) {
		this.caption = c;
		this.filename = f;
		this.imageFile = new File(f);
		this.rating = 0;
		this.dateTaken = "2019-02-28";
	}

	public Photograph(String f, String c, String d, int r) {
		this.caption = c;
		this.filename = f;
		this.imageFile = new File(f);
		this.dateTaken = d;
		this.rating = r;
	}

	/**
	 * 
	 * @return a String containing the caption of the Photograph
	 */
	public String getCaption() {
		return this.caption;
	}

	/**
	 * 
	 * @return a String containing the filename of the Photograph
	 */
	public String getFilename() {
		return this.filename;
	}

	/**
	 * 
	 * @return a String containing the date taken of the Photograph
	 */
	public String getDateTaken() {
		return this.dateTaken;
	}

	/**
	 * 
	 * @return an integer containing the rating of the Photograph
	 */
	public int getRating() {
		return this.rating;
	}

	/**
	 * First checks if the new date is properly formatted, if it is the method sets
	 * dateTaken to the new date
	 * 
	 * @param d a String containing the new date being set
	 */
	public void setDateTaken(String d) {
		Date begin1 = null;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			begin1 = sdf.parse(d);
			String begin = sdf.format(begin1);
			if (begin.equals(d)) {
				if (d.length() == 10) {
					this.dateTaken = d;
				}
			}
		} catch (ParseException e) {

		}
	}

	/**
	 * First checks if the new rating is between 0 and 5, if it is the method sets
	 * rating to the new rating
	 * 
	 * @param r An integer containing the new rating being set
	 */
	public void setRating(int r) {
		if (r >= 0 && r <= 5) {
			this.rating = r;
		}
	}

	/**
	 * @param o the Object being compared to
	 * @return boolean true if the object being compared is the same Photograph,
	 *         false if not
	 */
	public boolean equals(Object o) {
		if (o == null) {
			return false;
		}
		if (!(o instanceof Photograph)) {
			return false;
		}
		Photograph op = (Photograph) o;
		if (op.caption != this.caption) {
			return false;
		}
		if (op.filename != this.filename) {
			return false;
		}
		return true;
	}

	/**
	 * @return a String containing the caption and filename
	 */
	@Override
	public String toString() {
		return "Caption: " + this.caption + ", Filename: " + this.filename;
	}

	@Override
	public int hashCode() {
		return (this.caption + "---" + this.filename).hashCode();
	}
	/**
	 * Compares the Photograph to another Photograph p; first compares by their date taken. If the dates taken are the same, then compares
	 * by the captions
	 */
	public int compareTo(Photograph p) {
		if (dateTaken.compareTo(p.getDateTaken()) < 0) {
			return -1;
		} else if (dateTaken.compareTo(p.getDateTaken()) > 0) {
			return 1;
		}
		return caption.compareTo(p.getCaption());
	}

	public File getImageFile() {
		return imageFile;
	}

	public void setImageFile(File imageFile) {
		this.imageFile = imageFile;
	}
}
