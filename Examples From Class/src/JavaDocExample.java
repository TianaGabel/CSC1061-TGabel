/*
 * Copyright(c) 2023 Tatiana Gabel
 */
/**
 * 
 * @author Tatiana Gabel
 * @version 1.0
 */
//under project, click generate javaDocs
public class JavaDocExample {
	public static final double NUM = 1.5;
	//For Java docs, an array would be a single arguemtn rather than multiple
	/**cubes num
	 * @param num just for kicks
	 * @return num cubed
	 */
	public static double tripleNum(int num) {
		num += 1;
		return NUM*NUM*NUM;
	}
	/**
	 * This method says hi to Jacob lol
	 */
	public static void HiJacob() {
		int num = 5+ 3;
	}
	
}
