package edu.frcc.csc1061j.TreeMap;

public class TreeMapTest {

	public static void main(String[] args) {
		TreeMap<Integer,Integer> map = new TreeMap<>();
		
		Integer[] array = {8,2,10,13,5,7,8,9,1,0,14,2};
		for(Integer i: array) {
			map.put(i, i);
		}
		
		printInOrder(map);
		
	}
	
	private static void printInOrder(TreeMap<Integer,Integer> map) {
		for (Integer value:map) {
			System.out.print(value + " ");
		}
		System.out.println();
	}

}
