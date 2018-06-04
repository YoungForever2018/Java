package array;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Arrays_Demo {

	public static void main(String[] args) {
		int[] array1 = new int[]{1,6,3,9,1,0,2};
		int[] array2 = new int[]{1,6,3,9,1,0,2};

		testEquals(array1, array2);
//		testSort(array1);
//		testCopyOf(array1);
//		reverse(array1);
//		stringToArray();
//		testBinarySearch(array1);
		
List<int[]> list = new ArrayList<int[]>(Arrays.asList(array1));
list.add(new int[]{1,2});
for (int[] is : list) {
	for(int i : is){
		System.out.print(i);
	}
	System.out.println();
}
	}
	
	/**
	 * String <--> Array
	 */
	public static void stringToArray(){
		String string = "hello";
		char[] c = string.toCharArray();
		
		for (int i = 0; i < c.length; i++) {
			c[i] -=32; //upper case
			System.out.println(c[i]);
		}
		System.out.println(new String(c));
	}

	/**
	 * reverse
	 */
public static void reverse(int[] array){
	int[] result = new int[array.length];
	for (int i = 0 , j = array.length -1 ; i < array.length; i++,j--) {
		result[i] = array[j];
	}
}
	
	/**
	 * test Arrays.sort()
	 */
	public static void testSort(int[] array){
		Arrays.sort(array, 2, 5);
		
		for (int i : array) {
			System.out.print(i);
		}
	}
	
	/**
	 * test Arrays.equals()
	 */
	public static void testEquals(int[] array1,int[] array2){
		boolean flag = Arrays.equals(array1, array2);
		System.out.println(flag);
	}
	
	/**
	 * test Arrays.copyOf()  == array.clone() ? 
	 * 
	 * copyOf() , truncating or padding with zeros (if necessary) so he copy has the specified length
	 */
	public static void testCopyOf(int[] array){
		int[] arrayCopy = Arrays.copyOf(array, 20);
		
		for (int i : array) {
			System.out.print(i);
		}
		
		System.out.println();
		
		for (int i : arrayCopy) {
			System.out.print(i);
		}
	}
	
	/**
	 * test Arrays.binarySearch , the array must be sorted or the results are undefined
	 */
	public static void testBinarySearch(int[] array){
		Arrays.sort(array);
		int index = Arrays.binarySearch(array, 3);
		System.out.println("index = "+index);
	}
}
