import java.util.*; 

public class Phonebook {
	public static TreeMap<Integer, String> reverseBook(TreeMap<String, Integer> phoneBook) {
		TreeMap<Integer, String> fnl = new TreeMap<Integer, String>();
		for(String name: phoneBook.keySet()) {
			fnl.put(phoneBook.get(name), name);
		}
		return fnl;
	}
	public static void main(String[] args) {
		TreeMap<String, Integer> phoneBook = new TreeMap<String, Integer>();
		phoneBook.put("John", 123);
		phoneBook.put("Justin", 234);
		TreeMap<Integer, String> fnl = reverseBook(phoneBook);
		System.out.print(fnl);
	}
	
}
