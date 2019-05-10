package OneDArrayActivity;
//Justin Cai, jc5pz
import java.util.Scanner;

public class OneDArrayActivity {

	public static void main(String[] args) {
		
		Scanner keyboard = new Scanner(System.in);
		System.out.println("How many values do you want in the array?");
		int x = keyboard.nextInt();
		int[] values = new int[x];
		for(int i = 0; i < x; i++){
			System.out.println("Enter the " + i + " value in the array");
			values[i] = keyboard.nextInt();
		}
		
		
		
		for(int j = 0; j < values.length; j++){
			System.out.print(values[j] + " ");
		}
		
		for(int j = 0; j < values.length -1; j++) {
			if(values[j] > values[j+1]) {
				System.out.print("Not increasing");
				break;
			}
			if(j==values.length-2) {
				System.out.print("Increasing");
			}
		}
		
		keyboard.close();
	}

}
