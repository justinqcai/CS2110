/**
 * Homework 3
 * Justin Cai, jc5pz
 *
 * Sources : CS2110 Lecture, Java API, StackOverflow
 * 
 * DO THE COMMENTS
 */
import static org.junit.Assert.*;
import java.util.*;

import org.junit.Test;

public class PhotoLibraryTests {
	/**
	 * Tests if method getPhotos works. First instantiates a PhotoLibrary and takes three photos, two with rating 4 and rating 3. 
	 * However, one of the 4-rated has an improperly formatted date, thus takePhoto shouldn't work and it shouldn't be in the
	 * answer set. Then calls getPhotos(4) and asserts that it should return an ArrayList of Photographs only containing the 4-rated
	 * Photograph that has the properly formatted date.
	 */
	@Test(timeout=100)
	public void testGetPhotos() {
		PhotoLibrary pl = new PhotoLibrary("Justin", 1);
		Photograph beach = new Photograph("Beach", "beach.jpg", "2019-02-03", 4);
		Photograph test = new Photograph("Test", "test.jpg", "201-020-03", 4);
		Photograph sun = new Photograph("Sun", "sun.jpg", "2019-02-01", 3);
		pl.takePhoto(test);
		pl.takePhoto(beach);
		pl.takePhoto(sun);
		ArrayList<Photograph> ans = new ArrayList<Photograph>();
		ans.add(beach);
		assertTrue(pl.getPhotos(4).equals(ans));
	}
	/**
	 * Tests if getPhotosInMonth works. First instantiates a PhotoLibrary and takes four photos, two of which are in January (01) and two
	 * of which in February (02). All four are in 2019, however one of the February photos has an improperly formatted date. Then calls 
	 * getPhotosInMonth(2, 2019), and asserts that it should return an ArrayList of Photographs only containing the properly formatted
	 * Photograph taken in February.
	 */
	@Test(timeout=100)
	public void testGetPhotosInMonth() {
		PhotoLibrary pl = new PhotoLibrary("Justin", 1);
		Photograph beach = new Photograph("Beach", "beach.jpg", "2019-02-03", 4);
		Photograph test = new Photograph("Test", "test.jpg", "2019-02-031", 3);
		Photograph sun = new Photograph("Sun", "sun.jpg", "2019-01-01", 3);
		Photograph parade = new Photograph("Parade", "parade.jpg", "2019-01-23", 5);
		pl.takePhoto(beach);
		pl.takePhoto(sun);
		pl.takePhoto(parade);
		pl.takePhoto(test);
		ArrayList<Photograph> ans = new ArrayList<Photograph>();
		ans.add(beach);
		assertTrue(pl.getPhotosInMonth(2, 2019).equals(ans));
	}
	/**
	 * Tests if getPhotosBetween works. First instantiates a PhotoLibrary and takes four photos, two of which are in between Jan. 2, 2019
	 * and Feb. 28, 2019. The other two have improperly formatted dates. Then calls getPhotosBetween("2019-01-02", "2019-02-28") and 
	 * asserts that it should return an ArrayList of Photographs only containing the two Photographs in between the two dates.
	 */
	@Test(timeout=100)
	public void testGetPhotosBetween() {
		PhotoLibrary pl = new PhotoLibrary("Justin", 1);
		Photograph beach = new Photograph("Beach", "beach.jpg", "201-02-28", 4);
		Photograph test = new Photograph("Test", "test.jpg", "20191-02-28", 4);
		Photograph sun = new Photograph("Sun", "sun.jpg", "2019-01-01", 3);
		Photograph myself = new Photograph("Me", "myself.jpg", "2019-01-29", 3);
		pl.takePhoto(beach);
		pl.takePhoto(sun);
		pl.takePhoto(myself);
		pl.takePhoto(test);
		ArrayList<Photograph> ans = new ArrayList<Photograph>();
		ans.add(myself);
		assertTrue(pl.getPhotosBetween("2019-01-02", "2019-02-27").equals(ans));
	}
	/**
	 * Tests if erasePhoto works. First instantiates a PhotoLibrary and takes one Photograph beach. Then calls erasePhoto(beach) and 
	 * asserts that it should return true, because the Photo has been taken and should be successfully erased.
	 */
	@Test(timeout=100)
	public void testErasePhoto() {
		PhotoLibrary pl = new PhotoLibrary("Justin", 1);
		Photograph beach = new Photograph("Beach", "beach.jpg", "2019-02-03", 4);
		pl.takePhoto(beach);
		assertTrue(pl.erasePhoto(beach));
	}
	/**
	 * Tests if similarity works. First, instantiates two PhotoLibraries and instantiates four Photographs. The first PhotoLibrary takes
	 * three of the Photos and the second takes two of the Photos, with one Photo being taken by both. Then calls similarity on the two
	 * PhotoLibraries and asserts that it should return .5, the similarity factor (1/2 =.5. 1 Photo similar, the smaller PhotoLibrary
	 * has 2 Photos, thus 1/2).
	 */
	@Test(timeout=100)
	public void testSimilarity() {
		PhotoLibrary pl = new PhotoLibrary("Justin", 1);
		PhotoLibrary pl2 = new PhotoLibrary("Evan", 2);
		Photograph beach = new Photograph("Beach", "beach.jpg", "2019-02-03", 4);
		Photograph sun = new Photograph("Sun", "sun.jpg", "2019-01-01", 3);
		Photograph myself = new Photograph("Me", "myself.jpg", "2019-01-29", 3);
		Photograph parade = new Photograph("Parade", "parade.jpg", "2019-01-23", 5);
		pl.takePhoto(beach);
		pl.takePhoto(sun);
		pl.takePhoto(myself);
		pl2.takePhoto(sun);
		pl2.takePhoto(parade);
		double ans = .5;
		assertTrue(PhotoLibrary.similarity(pl, pl2) == ans);
	}
	/**
	 * Tests if method getPhotos works. First instantiates a PhotoLibrary and takes three photos with ratings 5, 4, and 3. Then calls
	 * getPhotos(4) and asserts that it should not return an ArrayList of Photographs only containing the 4-rated Photograph.
	 */
	@Test(timeout=100)
	public void testGetPhotos2() {
		PhotoLibrary pl = new PhotoLibrary("Justin", 1);
		Photograph parade = new Photograph("Parade", "parade.jpg", "2019-01-23", 5);
		Photograph beach = new Photograph("Beach", "beach.jpg", "2019-02-03", 4);
		Photograph sun = new Photograph("Sun", "sun.jpg", "2019-02-01", 3);
		pl.takePhoto(beach);
		pl.takePhoto(sun);
		pl.takePhoto(parade);
		ArrayList<Photograph> ans = new ArrayList<Photograph>();
		ans.add(beach);
		assertFalse(pl.getPhotos(4).equals(ans));
	}
	/**
	 * Tests if getPhotosInMonth works. First instantiates a PhotoLibrary and takes three photos, two of which are in January (01) and one
	 * of which in February (02). All three are in 2019. Then calls getPhotosInMonth(2, 2019), and asserts that it should not return an 
	 * ArrayList of Photographs containing a Photograph taken in January.
	 */
	@Test(timeout=100)
	public void testGetPhotosInMonth2() {
		PhotoLibrary pl = new PhotoLibrary("Justin", 1);
		Photograph parade = new Photograph("Parade", "parade.jpg", "2019-01-23", 5);
		Photograph beach = new Photograph("Beach", "beach.jpg", "2019-02-03", 4);
		Photograph sun = new Photograph("Sun", "sun.jpg", "2019-01-01", 3);
		pl.takePhoto(beach);
		pl.takePhoto(sun);
		pl.takePhoto(parade);
		ArrayList<Photograph> ans = new ArrayList<Photograph>();
		ans.add(beach);
		ans.add(parade);
		assertFalse(pl.getPhotosInMonth(2, 2019).equals(ans));
	}
	/**
	 * Tests if getPhotosBetween works. First instantiates a PhotoLibrary and takes four photos, two of which are in between Jan. 2, 2019
	 * and Feb. 23, 2019. Then calls getPhotosBetween("2019-01-02", "2019-02-23") and asserts that it should not return an ArrayList of
	 * Photographs containing a Photograph taken outside of the date range.
	 */
	@Test(timeout=100)
	public void testGetPhotosBetween2() {
		PhotoLibrary pl = new PhotoLibrary("Justin", 1);
		Photograph parade = new Photograph("Parade", "parade.jpg", "2019-02-24", 5);
		Photograph beach = new Photograph("Beach", "beach.jpg", "2019-02-03", 4);
		Photograph sun = new Photograph("Sun", "sun.jpg", "2019-01-01", 3);
		Photograph myself = new Photograph("Me", "myself.jpg", "2019-01-29", 3);
		pl.takePhoto(beach);
		pl.takePhoto(sun);
		pl.takePhoto(myself);
		pl.takePhoto(parade);
		ArrayList<Photograph> ans = new ArrayList<Photograph>();
		ans.add(beach);
		ans.add(parade);
		ans.add(myself);
		assertFalse(pl.getPhotosBetween("2019-01-02", "2019-02-23").equals(ans));
	}
	/**
	 * Tests if erasePhoto works. First instantiates a PhotoLibrary and takes one Photograph beach. Then calls erasePhoto(parade)
	 * (parade is a separate Photograph that was instantiated but not taken by the PhotoLibrary) and asserts that it should return 
	 * false, because the Photo hasn't been taken and shouldn't be erased.
	 */
	@Test(timeout=100)
	public void testErasePhoto2() {
		PhotoLibrary pl = new PhotoLibrary("Justin", 1);
		Photograph beach = new Photograph("Beach", "beach.jpg", "2019-02-03", 4);
		Photograph parade = new Photograph("Parade", "parade.jpg", "2019-02-24", 5);
		pl.takePhoto(beach);
		assertFalse(pl.erasePhoto(parade));
	}
	/**
	 * Tests if similarity works. First, instantiates two PhotoLibraries and instantiates four Photographs. The first PhotoLibrary takes
	 * three of the Photos and the second also takes three of the Photos, with two Photos being taken by both. Then calls similarity on 
	 * the two PhotoLibraries and asserts that it should not return .5, as the similarity factor should be .67 (2/3 = .67. 2 Photos similar,
	 * the two PhotoLibraries both having 3 Photos, thus 2/3).
	 */
	@Test(timeout=100)
	public void testSimilarity2() {
		PhotoLibrary pl = new PhotoLibrary("Justin", 1);
		PhotoLibrary pl2 = new PhotoLibrary("Evan", 2);
		Photograph beach = new Photograph("Beach", "beach.jpg", "2019-02-03", 4);
		Photograph sun = new Photograph("Sun", "sun.jpg", "2019-01-01", 3);
		Photograph myself = new Photograph("Me", "myself.jpg", "2019-01-29", 3);
		Photograph parade = new Photograph("Parade", "parade.jpg", "2019-01-23", 5);
		pl.takePhoto(beach);
		pl.takePhoto(sun);
		pl.takePhoto(myself);
		pl2.takePhoto(sun);
		pl2.takePhoto(parade);
		pl2.takePhoto(myself);
		double ans = .5;
		assertFalse(PhotoLibrary.similarity(pl, pl2) == ans);
	}

}
