package edu.frcc.csc1061j.ArrayAndLinkedList;

public class TestArrayAndLinkedList {
	
	public static void main(String[] args) {
		MyArrayList<Integer> me = new MyArrayList<>();
		
		Integer myInt = new Integer(8);
		me.add(new Integer(8));
		me.add(0, myInt);
		me.remove(1);
		me.remove(myInt);
		
		
		
		
		
	}

}
