package edu.frcc.csc1061j.MyHashmap;

import java.util.Map;

public class HashmapTest {

	public static void main(String[] args) {
		//we declare as a generic type to allow for future changes
		Map map = new MyHashmap<String,Integer>();
		map.put("One", 1);
		map.put("Two", 2);
		map.put("Three", 3);
		map.put("Four", 4);
		
		if(map.containsKey("Two")) {
			System.out.println("Has Two");
		}
		
		System.out.println("The value of Three:" + map.get("Three"));
	}

}
