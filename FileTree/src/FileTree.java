import java.io.File;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;
import java.util.Queue;


public class FileTree implements Iterable <FileNode> {

	private FileNode root;
	
	public FileTree(String path) {
		root = new FileNode(path);
		buildTree(root);
	}

	/**
	 * Return a depth first post-order traversal iterator 
	 */
	@Override
	public Iterator<FileNode> iterator() {

		return new DepthFirstIterator();
	}
	
	/**
	 * 	 for Exam 2
	 *  Use recursion to build the tree from the directory structure.
	 *  For each of node starting from the root node use listFiles() from File to get 
	 *  the list of files in that directory/folder.
	 *  Create a node for each of the files and add it to a list of child nodes for the node
	 *  Do this recursively for all the nodes.  
	 * 
	 * @param fileNode
	 */
	private void buildTree(FileNode fileNode) {
		if (fileNode.getFile().listFiles() == null) {
			return;
		}
		ArrayList<FileNode> tmpList = new ArrayList<>();
		File[] fileList = fileNode.getFile().listFiles();
		for (File file: fileList) {
			FileNode tmpFile = new FileNode(file);
			System.out.println(tmpFile);
			//This is the recursive call it will call this on each next child until the end of that branch is reached
			buildTree(tmpFile);
			tmpList.add(tmpFile);
			System.out.println(tmpList.size());
			System.out.println("here");
		}
		fileNode.setChildNodes(tmpList);
	}
	
	/**
	 *  for Exam 2
	 * Iterator that does a post order traversal of the tree.
	 * For post-order traversal use the 2 stack approach outlined here: 
	 * https://www.geeksforgeeks.org/iterative-postorder-traversal/
	 * 
	 * @return 
	 */
	private class DepthFirstIterator implements Iterator<FileNode> {
		//We use 2 stacks as outlined in the psuedocode
		Deque<FileNode> stack1 = new ArrayDeque<FileNode>();
		Deque<FileNode> stack2 = new ArrayDeque<FileNode>();
		
		public DepthFirstIterator() {
			//push root to first stack
			stack1.push(root);
			while(!stack1.isEmpty()) {
				FileNode tmp = stack1.pop();
				stack2.push(tmp);
				//if the file is not a directory, we don't add anything to stack1
				if (!tmp.getFile().isDirectory()) {
					continue;
				}
				//Adds all children to stack 1
				for (FileNode child : tmp.getChildNodes()) {
					stack1.push(child);
				}
				
			}
				
		}

		@Override
		public boolean hasNext() {
			return !(stack2.isEmpty());
		}
		
		@Override
		public FileNode next() {
			return stack2.pop();
		}
	}
	
	/**
	 *  Returns an iterator that does a breadth first traversal of the tree using a queue.
	 * 
	 * @return
	 */
	public Iterator<FileNode> breadthFirstIterator() {
		
		return new BreadthFirstIterator();

	}	
	
	/** 
	 * for Exam 2
	 * Iterator that does a breadth first traversal of the tree using a queue.
	 * Push root to front
	 * Then add the children in order to back, 
	 * as the nodes are taken from the front, add their children etc.
	 * 
	 */
	private class BreadthFirstIterator implements Iterator<FileNode> {
		Deque<FileNode> queue = new ArrayDeque<FileNode>();
		
		public BreadthFirstIterator() {
			queue.add(root);
		}
		
		@Override
		public boolean hasNext() {
			return !(queue.isEmpty());
		}

		@Override
		public FileNode next() {
			FileNode tmp = queue.removeFirst();
			for (FileNode child : tmp.getChildNodes()) {
				queue.addLast(child);
			}
			return tmp;
		}
		
	}
}
