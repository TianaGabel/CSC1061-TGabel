package edu.frcc.csc1061j.ArrayAndLinkedList;

import java.util.Arrays;
import java.util.List;

public class TestArrayAndLinkedList {
	
	public static void main(String[] args) {
		//We can write list so that if we change the implementation we do not need to update code
		List<Integer> me = new MyArrayList<Integer>();
		
		Integer myInt = new Integer(8);
		me.add(new Integer(8));
		me.add(0, myInt);
		//me.remove(1);
		//me.remove(myInt);
		
		MyLinkedList<Integer> y = new MyLinkedList<Integer>();
		y.add(1);
		y.add(2);
		y.add(3);
		y.add(8);
		System.out.println(Arrays.toString(y.toArray())+ "" + y.toArray().length);
		//System.out.println(array[0]);
		
		y.remove(0);
		System.out.println(Arrays.toString(y.toArray())+ "" + y.toArray().length);

		y.remove(myInt);
		System.out.println(Arrays.toString(y.toArray())+ "" + y.toArray().length);

		
		
		
		
	}

}
