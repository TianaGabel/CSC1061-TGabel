package edu.frcc.csc1061j.ArrayAndLinkedList;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class MyLinkedList<E> implements List<E> {

	private class Node {
		public E data;
		public Node next;

		public Node(E data) {
			this.data = data;
			this.next = null;
		}
	}

	private Node head;
	private int size;

	public MyLinkedList() {
		head = null;
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
		if (indexOf(o) == -1) {
			return false;
		}
		return true;
	}

	@Override
	public Iterator<E> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object[] toArray() {
		Object[] array = new Object[size];
		Node currNode = head;
		for (int i = 0;i<size;i++) {  //we could write this in terms of the next nodes as well
			//for(Node node = head; node != null; node = node.next)
			array[i] = currNode.data;
			currNode = currNode.next;
		}
		return array;
	}

	@Override
	public <T> T[] toArray(T[] a) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean add(E e) {
		Node newNode = new Node(e);
		if (head == null) {
			head = newNode;
			size++;
			return true;
		} else {
			Node currNode = null;
//			while (currNode.next != null) {
//				currNode = currNode.next;
//			}
			 for(currNode = head; currNode.next != null; currNode = currNode.next) {}
			currNode.next = newNode;
			size++;
			return true;
		}
	}

	@Override
	public boolean remove(Object o) {
		int index = indexOf(o);
		if (index == -1) { // object is not found so it cannot be removed
			return false;
		}
		remove(index);
		return true;
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addAll(Collection<? extends E> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addAll(int index, Collection<? extends E> c) {
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
		head = null;
		size = 0;
	}

	@Override
	public E get(int index) {
		Node node = getNode(index);
		return node.data;
	}

	@Override
	public E set(int index, E element) {
		Node node = getNode(index);
		E tmpData = node.data;
		node.data = element;
		return tmpData; // returns the previous data
	}

	@Override
	public void add(int index, E element) {
		Node node = new Node(element);
		if (index == 0) {
			node.next = head;
			head = node;
		} else {
			Node before = getNode(index - 1); // This throws a size check exception
			node.next = before.next; // new node is equal to the next node
			before.next = node; // previous node is now equal to new node
		}
		size++;
	}

	@Override
	public E remove(int index) {
		E tmpData = get(index);
		if (index == 0) {
			head = head.next;
		} else {
			Node node = getNode(index - 1);
			node.next = node.next.next; // skips over this one
		}
		size--;
		return tmpData;
	}

	private Node getNode(int index) {
		checkSize(index, size);
		Node node = head;
		for (int i = 0; i < index; i++) {
			node = node.next; // we literally just iterate through list lol
		}
		return node;

	}

	private void checkSize(int index, int ubound) {
		if (index < 0 || index >= ubound) {
			throw new IndexOutOfBoundsException();
		}
	}

	@Override
	public int indexOf(Object o) {
		Node currNode = head;
		for (int i = 0; i < size; i++) {
			if (o.equals(currNode.data)) {
				return i;
			}
			currNode = currNode.next;
		}
		return -1;
	}

	@Override
	public int lastIndexOf(Object o) {
		Node currNode = head;
		int currO = -1;
		for (int i = size - 1; i >= 0; i++) {
			if (o.equals(currNode.data)) {
				currO = i;
			}
			currNode = currNode.next;
		}
		return currO;
	}

	@Override
	public ListIterator<E> listIterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ListIterator<E> listIterator(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<E> subList(int fromIndex, int toIndex) {
		// TODO Auto-generated method stub
		return null;
	}

}
