// LAB 9: Recursion, Pt. 1

public class Recursion {
	
	public static void main(String[] args) 
	{
		int[] values = {19, 12, 13, 14, 17, 18, 16, 14, 11};
		int[] maxMinResults = maxMin(values, 0, values.length - 1);
		System.out.println(maxMinResults[0] + " and " + maxMinResults[1]);
	}

	/*  maxMin() - Return an array containing the minimum and maximum values of the input array.
	 * 	@param list: an array of ints as input
	 * 	@param first: the first index of the list (for recursion)
	 * 	@param last: the last index of the list (for recursion)
	 * 	
	 * 	Identify a base case, and work it out so that the array returns the min and max values.
	 * 	Then, identify what the method does to recursively arrive at the base case.
	 * 	
	 * 	@return: an int array, one index is minimum and the other is the maximum value.
	 */
	public static int[] maxMin(int[] list, int first, int last)
	{
		if(first == last - 2) {
			int max = 0;
			int min = 0;
			if(list[first] > list[last]) {
				if(list[first] > list[first+1]) {
					max = list[first];
					if(list[last] < list[first + 1]) min = list[last];
					else min = list[first + 1];
					
				}
				else {
					max = list[first+1];
					min = list[last];
				}
				int[] fnl = {min, max};
				return fnl;
			}
			else if(list[last] > list[first]) {
				if(list[last] > list[first+1]) {
					max = list[last];
					if(list[first] < list[first + 1]) min = list[first];
					else min = list[first + 1];
				}
				else {
					max = list[first + 1];
					min = list[first];
				}
				int[] fnl = {min, max};
				return fnl;
			}
		}
		if(first == last - 1) {
			if(list[first] > list[last]) {
				int[] ar = {list[last], list[first]};
				return ar;
			}
			else {
				int[] ar = {list[first], list[last]};
				return ar;
			}
		}
		int mid = (first+last)/2;
		int[] fh = maxMin(list, first, mid);
		int[] sh = maxMin(list, mid+1, last);
		int[] fnl = new int[2];
		if(fh[0] < sh[0]) {
			fnl[0] = fh[0];
		}
		else fnl[0] = sh[0];
		if(fh[1] > sh[1]) fnl[1] = fh[1];
		else fnl[1] = sh[1];
		return fnl;
		
	}
}