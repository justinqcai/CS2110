//Justin Cai, jc5pz
//Ayush Mayur, am3nz
import java.io.File;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class ReadInData {
	
	public static double readData(String fileName) {
		File file = new File(fileName);
		Scanner scan;
		double sum = 0;
		try {
			scan = new Scanner(file);
			int numOfValues = Integer.parseInt(scan.nextLine()); // Read in Val for # values
			for(int i = 0; i < numOfValues; i++) { // for-loop to get that many values
				sum += scan.nextDouble(); // add the values together (doubles)
			}
			scan.close();
			return sum; // return the sum of all the values in the file 
		}
		catch(FileNotFoundException e) {
			System.out.println("File Not Found");
			return 0.0;
		}
		catch(InputMismatchException e) {
			System.out.println("Input not matching");
			return 0.0;
		}
		catch(NoSuchElementException e) {
			System.out.println("No such element");
			return 0.0;
		}
		catch(RuntimeException e) {
			System.out.println("Runtime error");
			return 0.0;
		}
		
	}
	
	public static void main(String[] args) {
		System.out.println(readData("Test3.txt"));
		System.out.println(readData("Test2.txt"));
		System.out.println(readData("Text4.txt")); // notice spelling of the file name! 
		System.out.println(readData("Test4.txt"));
	}

}