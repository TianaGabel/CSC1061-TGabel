
public class RecursionExamples {

	public static void main(String[] args) {
		fibonacci(6,"start");
	}
	
	public static int fibonacci(int term,String word) {
		System.out.print(word + " ");
		if (term == 0 || term == 1) {
			System.out.println("return 1");
			return 1;
		}
		System.out.println("f(" + term + "- 1) + f(" + term + "-2)");
		return (fibonacci(term - 1, "left") + fibonacci(term - 2,"right"));
	}

}
