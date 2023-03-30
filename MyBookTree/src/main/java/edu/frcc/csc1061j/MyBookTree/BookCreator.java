package edu.frcc.csc1061j.MyBookTree;

public class BookCreator {

	public static void main(String[] args) {
		BookTree book = new BookTree("Trees for Dummies");
		
		//four chapters
		//four sections
		//four additionall 3 sections
		for(int i=1; i<5;i++) {
			book.addBookNode("Chapter " + i, i, 0, 0);
		}

		for(int i=1; i<5;i++) {
			book.addBookNode("Section " + i +"." + i, i, i, 0);
		}
		
		for(int i=1; i<5;i++) {
			book.addBookNode("Section 3", 3, i, 0);
		}
		
		for(int i=1; i<5;i++) {
			book.addBookNode("SubSection " + i + ".1." + i, i, 1, i);
		}
		
		
		for(MyBookNode node: book) {
			System.out.println(node);
		}
	}

}
