package Lab1;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
public class Lab1Scanner {
	public static void main(String[] args) {
		
		Scanner theInput = new Scanner(System.in);
		int[] nums = new int[5];
		for(int x = 0; x < 5; x++) {
			nums[x] = theInput.nextInt();
		}
		theInput.close();
		int sum = 0;
		
		System.out.print("The average of ");
		for(int x: nums) {
			sum+=x; 
			System.out.print(x + ", ");
		}
		System.out.print("is " + sum/5);
		
		File theFile = new File("data1.txt");
		try {
			Scanner fileScnr = new Scanner(theFile);
			System.out.println(theFile.length());
			System.out.println(theFile.getAbsolutePath());
			while(fileScnr.hasNextLine()) {
				System.out.println(fileScnr.nextLine());
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
