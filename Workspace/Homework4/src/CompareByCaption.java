import java.util.Comparator;

public class CompareByCaption implements Comparator<Photograph> {
	/**
	 * Compares two Photographs by their Caption first, if their captions are the same then compares their rating in descending order (i.e.
	 * the Photograph with a higher rating will come first)
	 */
	public int compare(Photograph a, Photograph b) {
		if (a.getCaption().compareTo(b.getCaption()) < 0) {
			return -1;
		} else if (a.getCaption().compareTo(b.getCaption()) > 0) {
			return 1;
		} else if (a.getRating() > b.getRating()) {
			return -1;
		} else if (a.getRating() < b.getRating()) {
			return 1;
		}
		return 0;
	}

}
