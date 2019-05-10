package Duplicates;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Duplicates {

	public static void main(String[] args) {
		ArrayList<String> inputList = new ArrayList<String>();
		//comment out above and uncomment below if you want to try the array bonus
		String[] stringList;
		
		Scanner key = new Scanner(System.in);
		System.out.println("How many Strings would you like to enter?");
		int num = key.nextInt();
		key.nextLine();

		//uncomment below if you want to try the array bonus
		stringList = new String[num];
		
		String str;
		for(int i = 0; i < num; i++) {
			System.out.println("What String would you like to add?");
			str = key.nextLine();
			inputList.add(str);
			//comment out above and uncomment below if you want to try the array bonus
			stringList[i] = str;
			
		}
		
		
		System.out.println(inputList);
		System.out.println(removeDups(inputList));
		key.close();
		//comment out above and uncomment below if you want to try the array bonus
		System.out.println(Arrays.toString(stringList));
		System.out.println(Arrays.toString(removeDups(stringList)));
		
	}
	public static ArrayList<String> removeDups(ArrayList<String> al) {
		ArrayList<String> ans = new ArrayList<String>();
		for(String s: al) {
			if(!ans.contains(s)) {
				ans.add(s);
			}
		}
		return ans;
	}
	public static String[] removeDups(String[] sl) {
		int count = 0;
		String[] temp = new String[sl.length];
		for(int x = 0; x<temp.length;x++) {
			boolean c = Arrays.stream(temp).anyMatch(sl[x]::equals);
			if(!c) {
				temp[x-count] = sl[x];
			}
			else {
				count++;
			}
		}
		String[] temp2 = new String[sl.length - count];
		for(int x = 0; x < sl.length - count; x++) {
			temp2[x] = temp[x];
		}
		return temp2;
		
	}

}