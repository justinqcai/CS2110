//Justin Cai, jc5pz
import java.util.*;

public class DogNames {
	public HashSet<String> names(HashSet<String> cards, HashSet<String> topNames) {
		HashSet<String> fnl = new HashSet<String>();
		for(String s: topNames) {
			if(!cards.contains(s)) {
				fnl.add(s);
			}
		}
		return fnl;
	}
}
