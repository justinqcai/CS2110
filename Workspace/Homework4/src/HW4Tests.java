import static org.junit.Assert.*;

import java.util.*;
import org.junit.Test;

public class HW4Tests {
	/**
	 * Tests the removePhoto method of PhotoLibrary by adding a Photograph beach to a PhotoLibrary and asserting that calling removePhoto(beach)
	 * will return true (it should succeed)
	 */
	@Test(timeout = 100)
	public void testRemovePhoto() {
		PhotoLibrary justin = new PhotoLibrary("Justin", 1);
		Photograph beach = new Photograph("beach.jpg", "Beach", "2019-02-03", 4);
		// Photograph test = new Photograph("Test", "test.jpg", "201-020-03", 4);
		justin.addPhoto(beach);
		assertTrue(justin.removePhoto(beach));
	}

	/**
	 * Tests the compareTo method of Photograph, asserts that Photograph beach when compared to Photograph sun should return a value greater
	 * than 0 because beach was taken after sun (compareTo first compares date Taken)
	 */
	@Test(timeout = 100)
	public void testCompareTo() {
		Photograph beach = new Photograph("beach.jpg", "Beach", "2019-02-03", 4);
		Photograph sun = new Photograph("sun.jpg", "Sun", "2019-02-01", 3);
		assertTrue(beach.compareTo(sun) > 0);
	}

	/**
	 * Tests the CompareByCaption class. First creates an ArrayList of Photographs and fills it with Photographs, then sorts it using 
	 * CompareByCaption. Asserts that the newly sorted list should be in the order: beach, parade, sun, as that is the alphabetical order
	 * of the captions.
	 */
	@Test(timeout = 100)
	public void testCompare() {
		ArrayList<Photograph> list = new ArrayList<Photograph>();
		Photograph beach = new Photograph("beach.jpg", "Beach", "2019-02-03", 4);
		Photograph sun = new Photograph("sun.jpg", "Sun", "2019-02-01", 3);
		Photograph parade = new Photograph("parade.jpg", "Parade", "2019-01-23", 5);
		list.add(beach);
		list.add(sun);
		list.add(parade);
		Collections.sort(list, new CompareByCaption());
		ArrayList<Photograph> ans = new ArrayList<Photograph>();
		ans.add(beach);
		ans.add(parade);
		ans.add(sun);
		assertTrue(list.equals(ans));
	}

	/**
	 * Tests the CompareByRating class. First creates an ArrayList of Photographs and fills it with Photographs, then sorts it using 
	 * CompareByRating. Asserts that the newly sorted list should be in the order: parade, beach, sun as that is the descending order
	 * of the Photograph's by rating.
	 */
	@Test(timeout = 100)
	public void testCompare2() {
		ArrayList<Photograph> list = new ArrayList<Photograph>();
		Photograph beach = new Photograph("beach.jpg", "Beach", "2019-02-03", 4);
		Photograph sun = new Photograph("sun.jpg", "sun", "2019-02-01", 3);
		Photograph parade = new Photograph("Parade.jpg", "parade", "2019-01-23", 5);
		list.add(beach);
		list.add(sun);
		list.add(parade);
		Collections.sort(list, new CompareByRating());
		ArrayList<Photograph> ans = new ArrayList<Photograph>();
		ans.add(parade);
		ans.add(beach);
		ans.add(sun);
		assertTrue(list.equals(ans));
	}

	/**
	 * Second test for removePhoto in the Photograph test. Adds Photograph beach to a PhotoLibrary and asserts that calling removePhoto on
	 * another Photograph should return false because it hasn't been added to the PhotoLibrary and thus can't be removed.
	 */
	@Test(timeout = 100)
	public void testRemovePhoto2() {
		PhotoLibrary justin = new PhotoLibrary("Justin", 1);
		Photograph beach = new Photograph("Beach.jpg", "beach", "2019-02-03", 4);
		Photograph test = new Photograph("Test.jpg", "test", "201-020-03", 4);
		justin.addPhoto(beach);
		// justin.addPhoto(test);
		assertFalse(justin.removePhoto(test));
	}

	/**
	 * Second test for the compareTo method in Photograph, asserts that Photograph beach when compared to Photograph sun should return a
	 * negative value because their dates taken are the same, which then means their captions are to be compared, and beach's caption
	 * comes before sun's caption alphabetically
	 */
	@Test(timeout = 100)
	public void testCompareTo2() {
		Photograph beach = new Photograph("Beach.jpg", "beach", "2019-02-03", 4);
		Photograph sun = new Photograph("Sun.jpg", "sun", "2019-02-03", 3);
		assertTrue(beach.compareTo(sun) < 0);
	}

	/**
	 * Second test for the CompareByCaption class. First creates an ArrayList of Photographs and fills it with Photographs, then sorts it using 
	 * CompareByCaption. Asserts that the newly sorted list should be in the order: beach, parade, myself, sun, as that is the alphabetical order
	 * of the captions. Although sun and myself have the same caption, myself should come before sun as it has a higher rating.
	 */
	@Test(timeout = 100)
	public void testCompare3() {
		ArrayList<Photograph> list = new ArrayList<Photograph>();
		Photograph beach = new Photograph("Beach.jpg", "beach", "2019-02-03", 4);
		Photograph sun = new Photograph("Sun.jpg", "sun", "2019-02-01", 3);
		Photograph parade = new Photograph("Parade.jpg", "parade", "2019-01-23", 5);
		Photograph myself = new Photograph("Sun.jpg", "sun", "2019-01-29", 4);
		list.add(beach);
		list.add(sun);
		list.add(parade);
		list.add(myself);
		Collections.sort(list, new CompareByCaption());
		ArrayList<Photograph> ans = new ArrayList<Photograph>();
		ans.add(beach);
		ans.add(parade);
		ans.add(myself);
		ans.add(sun);
		System.out.print(list);
		assertTrue(list.equals(ans));
	}

	/**
	 * Second test for the CompareByRating class. First creates an ArrayList of Photographs and fills it with Photographs, then sorts it using 
	 * CompareByRating. Asserts that the newly sorted list should be in the order: parade, beach, myself, sun as that is the descending order
	 * of the Photograph's by rating. Although beach and myself have the same rating, beach should come before myself as its caption comes
	 * before myself's caption alphabetically.
	 */
	@Test(timeout = 100)
	public void testCompare4() {
		ArrayList<Photograph> list = new ArrayList<Photograph>();
		Photograph beach = new Photograph("beach.jpg", "Beach", "2019-02-03", 4);
		Photograph sun = new Photograph("sun.jpg", "sun", "2019-02-01", 3);
		Photograph parade = new Photograph("Parade.jpg", "parade", "2019-01-23", 5);
		Photograph myself = new Photograph("Sun.jpg", "sun", "2019-01-29", 4);
		list.add(beach);
		list.add(sun);
		list.add(parade);
		list.add(myself);
		Collections.sort(list, new CompareByRating());
		ArrayList<Photograph> ans = new ArrayList<Photograph>();
		ans.add(parade);
		ans.add(beach);
		ans.add(myself);
		ans.add(sun);
		assertTrue(list.equals(ans));
	}

}
