package generaltest;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

public class GenericTest {
	
	static void fun(){
		Map<Integer, Map<Integer, Integer>> mmap = new HashMap<Integer, Map<Integer, Integer>>();
		
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		
		map.put(5,5);
		
		mmap.put(5,map);
		
		System.out.println(mmap.toString());
		
	}
	
	public static void main(String[] args) {
		fun();
	}

}
