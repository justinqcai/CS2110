
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

public class Album extends PhotographContainer {
	/**
	 * Calls the super constructor (PhotographContainer constructor) with the name as the parameter
	 * @param n The name of the Album
	 */
	public Album(String n) {
		super(n);
		this.name = n;
		this.photos = new ArrayList<Photograph>();
	}
}
