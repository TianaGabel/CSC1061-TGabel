package edu.frcc.csc1061j.TreeMap;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

//has key, value as any map. We make it iterable on values
//This is a binary tree
public class TreeMap<K,V> implements Map<K,V>, Iterable<V> 
{
	private Node root = null;//root
	private int size = 0;//map's size
	
	public V getRoot() {
		return root.value;
	}
	
	public int getSize() {
		return size;
	}
	
	//from outside you can see either key or value
	private class Node
	{
		private K key;//can be any object
		private V value;//can be any object
		private Node left = null;//children left and right
		private Node right = null;
		
		public Node(K key, V value)//constractor
		{
			this.key = key;
			this.value = value;
		}
		
	}

	@Override
	public Iterator<V> iterator() {
		// TODO Auto-
		return new InOrderIterator();
	}
	
	private class InOrderIterator implements Iterator<V> {
		//We will use recursion to pull all of these values into a list
		private ArrayList<V> list = new ArrayList<>();
		private int currentIndex = 0;
		
		public InOrderIterator() {
			//
			inorder(root);
		}
		
		private void inorder(Node node) {
			//Summary basically left-myself-right
			//continue while it has left
			//if no left then return self
			//Then it continues to the right
			if (node == null) {
				return; //This is our base case so if it is called on a non node it does this.
			}
			inorder(node.left);
			list.add(node.value);
			inorder(node.right);
			
		}
		
		@Override
		public boolean hasNext() {
			//We check if the index is at the end of the list or not
			return currentIndex < list.size();
		}

		@Override
		public V next() {
			//NOTE this is a list of values
			V value = list.get(currentIndex);
			currentIndex++;
			return value;
		}
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public boolean containsKey(Object key) {
		return false;
	}

	@Override
	public boolean containsValue(Object value) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public V get(Object key) {
		//This coverts the key into something comparable
		Comparable<K> k = (Comparable<K>) key;
		Node current = root;
		
		while (current != null)
		{
			if (k.compareTo(current.key)<0)
			{//k - incoming k, 
				current = current.left;
			}
			else if (k.compareTo(current.key)>0)
			{
				current = current.right;
			}
			//if keys are the same, we return the current value 
			else {
				//TODO shouldn't this return V it returned null
				return current.value;//we do nothing if keys are the same
			}
		}
		
		return null;//if nothing match or will be bigger, smaller
	}

	@Override
	public V put(K key, V value) //set up the value for the nodes
	{
		if (root == null) //check if root is null, then add something
		{
			Node newNode = new Node(key, value);
			root = newNode;//create root
			size++;//increase lenght
			return value;
		}
		
		Node current = root;
		Node parent = null;//helps to track nodes when we delete some a node 
		//key to compare nodes
		Comparable<K> k = (Comparable<K>) key;//to be sure that the keys are comparable
		
		while (current != null)
		{
			if (k.compareTo(current.key)<0)
			{//k - incoming k, 
				parent = current;
				current = current.left;
			}
			else if (k.compareTo(current.key)>0)
			{
				parent = current;
				current = current.right;
			}
			//if keys are the same
			else {
				return null;//we do nothing if keys are the same
			}
		}
		
		Node newNode = new Node(key, value);
		if (k.compareTo(parent.key)>0) {
			parent.right = newNode;
			//current = current.right; //TODO what does this mean
		}
		else {
			parent.left = newNode;
		}
		size++;
		return value;
	}
	
	//HW
	@Override
	public V remove(Object key) {
		//First we find the value
		V value = get(key);
		//Then we delete the value
		if (value == null) {
			return null;
		} else {
		root = remove(root, key); //This covers that case that we have to change the root
		size--;
		return value;
		}
		
	}
	
	private Node remove(Node currRoot, Object key) {
		if (currRoot == null) {
			return null;
		}
		Comparable<K> k = (Comparable<K>) key;
		if (k.compareTo(currRoot.key) < 0) {
			currRoot.left = remove(currRoot.left, key);
			return currRoot;
		} else if (k.compareTo(currRoot.key) > 0) {
			currRoot.right = remove(currRoot.right, key);
			return currRoot;
		} else {
			//This means that the currRoot is the thing to be deleted
			//Case 1 no children
			if (currRoot.left ==  null & currRoot.right == null) {
				return null; //This will return null back to the parents call
			}else if (currRoot.left == null ^ currRoot.right == null) {
				//Xor operation so one or the other but not both
				if (currRoot.left == null) {
					return currRoot.right; //Basically instead of the node we wanted to remove, we replace it with it's child
				} else {
					return currRoot.left;
				}
			} else {
				//This is the case that there are 2 children
				//We can replace the node(or information) with the leftmost descendant of it's right child
				Node current = currRoot.right;
				while (current.left != null)
				{
					current = current.left;
				}
				currRoot.key = current.key;
				currRoot.value = current.value;
				//Then repeat the deletion process with the other node so there is not a repeat
				currRoot.right = remove(currRoot.right, current.key);
				return currRoot;
			}
		}
		//return null; //Not necessay, but won't compile without it
	}

	@Override
	public void putAll(Map<? extends K, ? extends V> m) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Set<K> keySet() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<V> values() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<Entry<K, V>> entrySet() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
