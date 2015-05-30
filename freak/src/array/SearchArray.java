package array;

import java.util.Arrays;

public class SearchArray {
	
	public static void main(String[] args) {
		
		int[] temp = {1,3,2,8,6};
		int x = 4;
		
		System.out.println(Arrays.asList(temp));
		
		System.out.println(findElememt(temp, x));
	}
	
	public static boolean findElememt(int[] temp , int x){
		
		System.out.println(temp +"   "+ x);
		return Arrays.asList(temp).contains(x);
	}

}
