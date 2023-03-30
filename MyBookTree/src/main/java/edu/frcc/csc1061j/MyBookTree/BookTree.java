package edu.frcc.csc1061j.MyBookTree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.Iterator;
import java.util.Stack;

import com.sun.tools.javac.util.List;

public class BookTree implements Iterable<MyBookNode>{
	private MyBookNode root;
	
	public BookTree(String title) {
		//the 0,0,0 are chapter,section and sub
		root = new MyBookNode(title, 0,0,0);
	}
	
	public MyBookNode getBook() {
		//title is the root remember
		return root;
	}
	
	public boolean addBookNode(String title, int chapNum, int secNum,
			int subSecNum) {
		MyBookNode node = new MyBookNode(title, chapNum, secNum, subSecNum);
		if (secNum == 0) {
			//This means that this is a chapter
			root.getChildNodes().add(node);
			//If we want the chapters to be in order we have to sort after adding it
			Collections.sort(root.getChildNodes());
			return true;
		}
		
		if (subSecNum == 0) {
			//This means that it must be a section
			//This iterates through a list of the chapters
			for(MyBookNode aNode: root.getChildNodes()) {
				//once the given chap num is reached
				if(chapNum == aNode.getChapterNum()) {
					//We add the node
					aNode.getChildNodes().add(node);
					//Sort the sections
					Collections.sort(aNode.getChildNodes());
					return true;
					
				}
			}
			//once all chapters have been looped through 
			return false;
		}
		//implicitly this must be a subsection
		MyBookNode chapterNode = null;
		for (MyBookNode cNode: root.getChildNodes()) {
			if (chapNum == cNode.getChapterNum()) {
				//This locates the correct chapter
				chapterNode = cNode;
			}
		}
		if (chapterNode == null) {
			//if chapter is not found
			//TODO we could make a test case for this
			return false;
		}
		
		//Then we locate the correct subsection in the chapter
		for (MyBookNode sNode: chapterNode.getChildNodes()) {
			if (secNum == sNode.getSectionNum()) {
				//Then the subsection is added to the section
				sNode.getChildNodes().add(node);
				//Then we sort
				Collections.sort(sNode.getChildNodes());
				return true;
			}
		}
		return false;
	}

	
	@Override
	public Iterator<MyBookNode> iterator() {
		return new BookNodeIterator(root);
	}
	
	private class BookNodeIterator implements Iterator<MyBookNode> {
		Deque<MyBookNode> stack;
		
		public BookNodeIterator(MyBookNode node) {
			stack = new ArrayDeque<MyBookNode>();
			stack.push(node);
		}

		@Override
		public boolean hasNext() {
			//This will check if there are "next" things
			return !stack.isEmpty();
		}

		@Override
		public MyBookNode next() {
			MyBookNode node = stack.pop();
			
			ArrayList<MyBookNode> nodes = 
					new ArrayList<>(node.getChildNodes()); 
			Collections.reverse(nodes);
			for (MyBookNode child: nodes) {
				stack.push(child);
			}
			return node;
		}
	}
	
}
