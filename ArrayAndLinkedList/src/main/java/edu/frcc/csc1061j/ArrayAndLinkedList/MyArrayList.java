package edu.frcc.csc1061j.ArrayAndLinkedList;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

//The <Type> stands for a generic type

public class MyArrayList<Type> implements List<Type> {

	private Type[] array;
	private int size;

	@SuppressWarnings("unchecked")
	public MyArrayList() {
		array = (Type[]) new Object[4];
		size = 0;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return (size == 0);
	}

	@Override
	public boolean contains(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterator<Type> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object[] toArray() {
		Object[] a = Arrays.copyOf(array, size);
		return a;
	}

	@Override
	public <T> T[] toArray(T[] a) {
		
		return null;
	}

	@Override
	public boolean add(Type e) {
		sizeCheck();
		array[size] = e;
		size++;
		return true;
	}

	@Override
	public boolean remove(Object o) {
		int index = indexOf(o); 
		if(index == -1) {return false;} //if the object is not found returns false
		//shifts all elements after the "removed" one
		for (int i = index; i < size-1; i++) {
			array[i] = array[i+1];
		}
		array[size-1]= null;  //this is actually not necessary, becuase we use size not length
		size--;
		return true;
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addAll(Collection<? extends Type> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addAll(int index, Collection<? extends Type> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void clear() {
		size = 0;

	}

	@Override
	public Type get(int index) {
		if(index<0||index>=size) {
			throw new IndexOutOfBoundsException();
		}
		return array[index];
	}

	@Override
	public Type set(int index, Type element) {
		if(index<0||index>=size) {
			throw new IndexOutOfBoundsException();
		}
		Type old = array[index];
		array[index] = element;
		return old;
	}

	@Override
	public void add(int index, Type element) {
		if(index<0||index>size) {
			throw new IndexOutOfBoundsException();
		}
		sizeCheck();  //makes sure that array is not too small
		for(int i = size; i > index; i--) {
			array[i] = array[i-1];
		}
		array[index] = element;
		size++;
	}

	@Override
	public Type remove(int index) {
		Type element = get(index);
		for(int i = index; i < size -1;i++) {
			array[i] = array[i+1];
		}
		size--;
		return element;
	}

	@Override
	public int indexOf(Object o) {
		int index = -1;
		for(int i =0; i < size; i++) { //This looks through the array for o
			if (o.equals(array[i])) {
				index = i;
				break;
			}
		}
		return index;
	}

	@Override
	public int lastIndexOf(Object o) {
		int index = -1;
		for(int i = size - 1 ; i >= 0; i--) { //Starts at the back and loops backwards
			if (o.equals(array[i])) {
				index = i;
				break;
			}
		}
		return index;
	}

	@Override
	public ListIterator<Type> listIterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ListIterator<Type> listIterator(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Type> subList(int fromIndex, int toIndex) {
		// TODO Auto-generated method stub
		return null;
	}
	
	private void sizeCheck() {
		if (size >= array.length) {
			@SuppressWarnings("unchecked")
			Type[] bigger = (Type[]) new Object[array.length * 2];

			System.arraycopy(array, 0, bigger, 0, array.length);
			array = bigger;
		}
	}

}
