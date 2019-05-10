import java.util.Comparator;

public class CompareByRating implements Comparator<Photograph> {

	/**
	 * Compares two Photographs by their rating in descending order (i.e.
	 * the Photograph with a higher rating will come first), if their ratings are the same then compares them by their caption
	 */
	public int compare(Photograph a, Photograph b) {
		if (a.getRating() > b.getRating()) {
			return -1;
		} else if (a.getRating() < b.getRating()) {
			return 1;
		} else if (a.getCaption().compareTo(b.getCaption()) < 0) {
			return -1;
		} else if (a.getCaption().compareTo(b.getCaption()) > 0) {
			return 1;
		}
		return 0;
	}

}
