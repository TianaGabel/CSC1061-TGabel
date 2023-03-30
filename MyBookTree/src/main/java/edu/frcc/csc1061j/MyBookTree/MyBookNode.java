package edu.frcc.csc1061j.MyBookTree;

import java.util.ArrayList;
import java.util.List;

public class MyBookNode implements Comparable<MyBookNode> {
	
	private String title; //this is out root
	private int chapterNum;
	private int sectionNum;
	private int subSectionNum;
	private List<MyBookNode> childNodes;
	
	public MyBookNode(String title, int chapNum, int secNum, 
			int subSecNum) {
		this.title = title;
		chapterNum = chapNum;
		sectionNum = secNum;
		subSectionNum = subSecNum;
		childNodes = new ArrayList<MyBookNode>();
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getChapterNum() {
		return chapterNum;
	}

	public void setChapterNum(int chapterNum) {
		this.chapterNum = chapterNum;
	}

	public int getSectionNum() {
		return sectionNum;
	}

	public void setSectionNum(int sectionNum) {
		this.sectionNum = sectionNum;
	}

	public int getSubSectionNum() {
		return subSectionNum;
	}

	public void setSubSectionNum(int subSectionNum) {
		this.subSectionNum = subSectionNum;
	}

	public List<MyBookNode> getChildNodes() {
		return childNodes;
	}

	public void setChildNodes(List<MyBookNode> childNodes) {
		this.childNodes = childNodes;
	}
	
	@Override
	public String toString() {
		if (chapterNum == 0) {
			//This would be just the root node
			return title;
		}
		if (sectionNum == 0) {
			//chapters are indented once
			return ("\t" + chapterNum + " " + title);
		}
		if (subSectionNum == 0) {
			//sections are indented twice
			return ("\t\t" + chapterNum + " " + sectionNum + 
					" " + title);
		} //subsections are indented 3 times
		return ("\t\t\t" + chapterNum + " " + sectionNum +
				" " + subSectionNum + " " + title);
	}

//	@Override
//	public int compareTo(MyBookNode o) {
//		//My code
//		if(o.getChapterNum() == chapterNum) {
//			if(o.getSectionNum() == sectionNum) {
//				if(o.getSubSectionNum() == subSectionNum) {
//					return 0;
//				}
//				return subSectionNum - o.getSubSectionNum();
//			}
//			return sectionNum - o.getSectionNum();
//		}
//		return chapterNum - o.getChapterNum();
//	}
	
	public int compareTo(MyBookNode o) {
		if (chapterNum > o.chapterNum) {
			return 1;
		} else if (chapterNum < o.getChapterNum()) {
			return -1;
		}
		if (sectionNum > o.sectionNum) {
			return 1;
		} else if (sectionNum < o.getSectionNum()) {
			return -1;
		}
		if (subSectionNum > o.subSectionNum) {
			return 1;
		} else if (subSectionNum < o.getSubSectionNum()) {
			return -1;
		}
		return 0;
	}
	
	
	
}
