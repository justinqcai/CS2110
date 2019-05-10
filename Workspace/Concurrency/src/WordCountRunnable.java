//Justin Cai, jc5pz
//Ayush Mayur, am3nz
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
/**
 *  Counts how many words in a file.
 */
public class WordCountRunnable implements Runnable {
	public String filename;
	public int count; 
	/**
	 * Constructs a WordCountRunnable object with a file name.
	 * @param aFilename the file name that needs to count words
	 */
	public WordCountRunnable(String aFilename) {
		filename = aFilename;
	}

	public void run() {
		count = 0;
		try {
			Scanner sc = new Scanner(new FileInputStream(filename));

			while(sc.hasNext()) {
				if(sc.next() != null){
					count++; 
				}
			}
			sc.close();
		}
		catch (FileNotFoundException e) {
			System.out.println("File not found");

		}
		System.out.println("Words: " + count); 
	}
}