/**
 * Homework 2
 * Justin Cai, jc5pz
 *
 * Sources : CS2110 Lecture, Java API
 */
public class Photograph {
	private String caption; //String containing the caption
	private String filename; //String containing the filename
	public Photograph(String c, String f) {
		this.caption = c;
		this.filename = f;
	}
	//returns a String containing the caption of the Photograph
	public String getCaption() {
		return this.caption;
	}
	//returns a String containing the filename of the Photograph
	public String getFilename() {
		return this.filename;
	}
	//returns boolean true if the object being compared is the same Photograph, false if not
	public boolean equals(Object o) {
		if(o == null) {
			return false;
		}
		if(!(o instanceof Photograph)) {
			return false;
		}
		Photograph op = (Photograph) o;
		if(op.caption != this.caption) {
			return false;
		}
		if(op.filename != this.filename) {
			return false;
		}
		return true;
	}
	//returns a String containing the caption and filename
	@Override
	public String toString() {
		return "Caption: " + this.caption + ", Filename: " + this.filename;
	}
}
