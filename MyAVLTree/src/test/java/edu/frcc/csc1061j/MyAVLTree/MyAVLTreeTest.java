package edu.frcc.csc1061j.MyAVLTree;

import edu.frcc.csc1061j.MyAVLTree.MyAVLTree;
import edu.frcc.csc1061j.MyAVLTree.MyAVLTree.Node;

public class MyAVLTreeTest {

	public static void main(String[] args) {
		MyAVLTree<Integer, Integer> map = new MyAVLTree<>();
		
		map.put(1, 1);
		printInOrder(map);
		
		map.put(2, 2);
		printInOrder(map);
		
		map.put(5, 5);		// Needs LL rotation at node 25
		printInOrder(map);
		
		map.put(34, 34);
		printInOrder(map);
		
		map.put(50, 50);     // Needs RR rotation at node 25 
		printInOrder(map);
		
		
		map.put(55, 55);	// Needs RL rotation at node 20
		printInOrder(map);
	
		
		map.put(90, 90);     // Needs LR rotation at node 20.
		printInOrder(map);
		printBalanceFactor(map);
		
		//I accidentally added this code instead of the "remove bst" assignment
//		map.remove(25);
//		System.out.println("Removed 25");
//		printBalanceFactor(map);
//		map.remove(30);
//		System.out.println("Removed 30");
//		printBalanceFactor(map);
//		map.remove(34);
//		System.out.println("Removed 34");
//		map.remove(50);
//		System.out.println("Removed 50");
//		printBalanceFactor(map);
//		map.remove(10);
//		map.remove(5);
	}

	private static void printInOrder(MyAVLTree<Integer, Integer> map) {
		for(Node node: map) {
			System.out.print(node.getKey().toString() + " ");
		}
		System.out.println();
	}
	
	private static void printBalanceFactor(MyAVLTree<Integer, Integer> map) {
		int minHeight = 1;
		for(Node node: map) {
			if (node.getHeight() == 0) {
				minHeight = 0;
				break;
			}
		}
		
		System.out.println("\nNode\tHeight\tBalance Factor\tLeftChild\tRightChild");
		for(Node node: map) {
			if (minHeight == 1) {
				System.out.println(node.getKey().toString() + "\t" + node.getHeight() + "\t"
					+ ((node.getRight() != null ? node.getRight().getHeight() : 0) 
							- (node.getLeft() != null ? node.getLeft().getHeight() : 0)) 
								+ "\t\t" + (node.getLeft() != null ? node.getLeft().getKey().toString() : "null") 
										+ "\t\t" + (node.getRight() != null ? node.getRight().getKey().toString() : "null"));
			}
			else {
				System.out.println(node.getKey().toString() + "\t" + node.getHeight() + "\t"
						+ ((node.getRight() != null ? node.getRight().getHeight() + 1 : 0) 
								- (node.getLeft() != null ? node.getLeft().getHeight() + 1 : 0))
								+ "\t\t" + (node.getLeft() != null ? node.getLeft().getKey().toString() : "null") 
								+ "\t\t" + (node.getRight() != null ? node.getRight().getKey().toString() : "null"));
			}
		}
		System.out.println();
	}
}
