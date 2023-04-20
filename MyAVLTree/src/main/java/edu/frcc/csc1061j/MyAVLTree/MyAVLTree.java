package edu.frcc.csc1061j.MyAVLTree;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MyAVLTree<K, V> implements Map<K, V>, Iterable<edu.frcc.csc1061j.MyAVLTree.MyAVLTree.Node> {

	private Node root = null;
	private int size = 0;
	// This is just like a master list, we will reuse for dif things
	private List<Node> path;

	public class Node {
		private K key;
		private V value;
		private int height;
		private Node left = null;
		private Node right = null;

		public Node(K key, V value) {
			this.key = key;
			this.value = value;
		}

		// Node that we only include setters and not getters
		public K getKey() {
			return key;
		}

		public V getValue() {
			return value;
		}

		public int getHeight() {
			return height;
		}

		public Node getLeft() {
			return left;
		}

		public Node getRight() {
			return right;
		}

	}

	@Override
	public Iterator iterator() {
		return new InOrderNodeIterator();
	}

	private class InOrderIterator implements Iterator<V> {
		private ArrayList<V> list = new ArrayList<>();
		private int currentIndex = 0;

		public InOrderIterator() {
			inorder(root);
		}

		private void inorder(Node node) {
			if (node == null) {
				return;
			}
			inorder(node.left);
			list.add(node.value);
			inorder(node.right);
		}

		@Override
		public boolean hasNext() {
			return currentIndex < list.size();
		}

		@Override
		public V next() {
			V value = list.get(currentIndex);
			currentIndex++;
			return value;
		}

	}

	private class InOrderNodeIterator implements Iterator<Node> {
		private ArrayList<Node> list = new ArrayList<>();
		private int currentIndex = 0;

		public InOrderNodeIterator() {
			inorder(root);
		}

		private void inorder(Node node) {
			if (node == null) {
				return;
			}
			inorder(node.left);
			list.add(node);
			inorder(node.right);
		}

		@Override
		public boolean hasNext() {
			return currentIndex < list.size();
		}

		@Override
		public Node next() {
			Node node = list.get(currentIndex);
			currentIndex++;
			return node;
		}

	}

	private void updateHeight(Node node) {
		if (node.left == null && node.right == null) {
			node.height = 0;
		} else if (node.left == null) {
			node.height = node.right.height + 1;
		} else if (node.right == null) {
			node.height = node.left.height + 1;
		} else {
			node.height = Math.max(node.left.height, node.right.height) + 1;
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
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean containsValue(Object value) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public V get(Object key) {
		Comparable<K> k = (Comparable<K>) key;
		Node current = root;

		while (current != null) {
			if (k.compareTo(current.key) < 0) {
				current = current.left;
			} else if (k.compareTo(current.key) > 0) {
				current = current.right;
			} else {
				return current.value;
			}
		}

		return null;
	}

	// @Override
	public V put(K key, V value) {
		if (root == null) {
			Node newNode = new Node(key, value);
			root = newNode;
			size++;
			path = new ArrayList<Node>(); // this list is created when the first element is added to the list
			updateHeight(root);
			return value;
		}

		Node current = root;
		Node parent = null;
		Comparable<K> k = (Comparable<K>) key;

		path.clear();
		while (current != null) {
			path.add(current);
			if (k.compareTo(current.key) < 0) {
				parent = current;
				current = current.left;
			} else if (k.compareTo(current.key) > 0) {
				parent = current;
				current = current.right;
			} else {
				return null;
			}
		}

		Node newNode = new Node(key, value);
		if (k.compareTo(parent.key) > 0) {
			parent.right = newNode;
		} else {
			parent.left = newNode;
		}
		size++;

		updateHeight(newNode);
		balancePath();
		return value;
	}

	private void balancePath() {
		// Remeber that path is a path so a single path from the root to the newnode
		// looped through from the lowest to the root
		for (int i = path.size() - 1; i >= 0; i--) {
			Node current = path.get(i);
			updateHeight(current);
			Node parent = null;
			if (i > 0) {
				parent = path.get(i - 1);
			}
			int bFactor = balanceFactor(current);
			// This is how we decide how to rebalance
			switch (bFactor) {
			// Left
			case -2:
				if (balanceFactor(current.left) <= 0) {
					balanceLL(current, parent);
				} else {
					balanceLR(current, parent);
				}
				break;
			case 2:
				if (balanceFactor(current.right) >= 0) {
					balanceRR(current, parent);
				} else {
					balanceRL(current, parent);
				}
				break;
			default:
				break;
			}
		}

	}

	private void balanceRL(Node node, Node parent) {
		// Altered code, prolly should double check.
		Node rightNode = node.right;
		Node child = rightNode.left;

		if (node == root) {
			root = child;
		} else {
			if (parent.left == node) {
				parent.left = child;
			} else {
				parent.right = child;
			}
		}

		// Handle child's children
		node.right = child.left;
		rightNode.left = child.right;

		child.right = rightNode;
		child.left = node;

		updateHeight(node);
		updateHeight(rightNode);
		updateHeight(child);

	}

	private void balanceRR(Node prevChild, Node parent) {
		Node newChild = prevChild.right;
		if (prevChild == root) {// This is the case that there is no parent
			root = newChild;
		} else {
			// We determine wether or not this is the left or right child
			// Then this would be making P child 20
			if (parent.left == prevChild) {
				parent.left = newChild;
			} else {
				parent.right = newChild;
			}
		}
		prevChild.right = newChild.left;
		newChild.left = prevChild;
		updateHeight(prevChild);
		updateHeight(newChild);

	}

	private void balanceLR(Node node, Node parent) {
		Node leftNode = node.left;
		Node child = leftNode.right;

		if (node == root) {
			root = child;
		} else {
			if (parent.left == node) {
				parent.left = child;
			} else {
				parent.right = child;
			}
		}

		// Handle child's children
		node.left = child.right;
		leftNode.right = child.left;

		child.left = leftNode;
		child.right = node;

		updateHeight(node);
		updateHeight(leftNode);
		updateHeight(child);

	}

	private void balanceLL(Node prevChild, Node parent) {
		// Example L5-L20-L25-P
		// PrevChild is 25
		// newChild will be 20
		// then L5-R25-20L-P
		Node newChild = prevChild.left;
		if (prevChild == root) {// This is the case that there is no parent
			root = newChild;
		} else {
			// We determine wether or not this is the left or right child
			// Then this would be making P child 20
			if (parent.left == prevChild) {
				parent.left = newChild;
			} else {
				parent.right = newChild;
			}
		}
		prevChild.left = newChild.right;
		newChild.right = prevChild;
		updateHeight(prevChild);
		updateHeight(newChild);

	}

	private int balanceFactor(Node current) {
		int balanceFactor = 0;
		int rightHeight = -1;
		int leftHeight = -1;
		// if it were null it would be -1
		if (current.left != null) {
			leftHeight = current.left.height;
		}
		if (current.right != null) {
			rightHeight = current.right.height;
		}
		balanceFactor = rightHeight - leftHeight;
		return balanceFactor;
	}

	@Override
	public V remove(Object key) {
		V value;
		if (root == null) { // Case the tree is empty
			return null;
		}
		if (root.getKey().equals(key)) { // Case we are removing root
			value = root.getValue(); // record the value
			Node current;
			if (root.right != null) {
				current = root.right;
				while (current.left != null) {
					current = current.left;
				}
				root.value = current.value;
				root.key = current.key;
				remove(root, current.key); //TODO this is the code i changed 
			} else {
				root = root.left;
			}
			return value;
		}
		return remove(root, key);
	}

	private V remove(Node currRoot, Object key) { //Parent
		// First we find the node
		Node nodeToRemove = null;
		Node parent = currRoot;
		Comparable<K> k = (Comparable<K>) key;
		Node current = currRoot;

		if (currRoot.key.equals(key)) { //This is the case when we are doing the 2 child swap
			current = current.right;
		}
		while (current != null) {
			if (k.compareTo(current.key) < 0) {
				parent = current; // The previously searched node is the current node's parent
				current = current.left;
			} else if (k.compareTo(current.key) > 0) {
				parent = current; // The previously searched node is the current node's parent
				current = current.right;
			} else {
					nodeToRemove = current;
					break;
			}
		}
		//} else {
			if ((nodeToRemove.left == null) && (nodeToRemove.right == null)) {
				if (parent == null) {
					nodeToRemove = null;
				}
				// Case that this is a leaf node, we just cut if off from the rest of the tree
				if (parent.left.key == key) {
					parent.left = null;
				} else {
					parent.right = null;
				}

			} else if ((parent.left == null) ^ (parent.right == null)) {
				// Case parent has only one child (check uses xor)
				if (parent.left == nodeToRemove) {
					parent.left = nodeToRemove;
				} else {
					parent.right = nodeToRemove; // TODO height must be updated
				}
			} else {
				// case there are 2 children
				// Case nodetoremove has only one child
				if (nodeToRemove.left == null ^ nodeToRemove.right == null) {
					if (parent.left == nodeToRemove) {
						if (nodeToRemove.left == null) {
							parent.left = nodeToRemove.right;
						} else {
							parent.left = nodeToRemove.left;
						}
					} else {
						if (nodeToRemove.left == null) {
							parent.right = nodeToRemove.right;
						} else {
							parent.right = nodeToRemove.left;
						}
					}
				} else {
					// Otherwise
					V value = nodeToRemove.value;
					current = nodeToRemove.right;
					while (current.left != null) {
						current = current.left;
					}
					nodeToRemove.value = current.value;
					nodeToRemove.key = current.key;
					remove(nodeToRemove, current.key);
					return value;
				}
			}
		//}
		return nodeToRemove.value;
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
