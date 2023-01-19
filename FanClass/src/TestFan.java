
public class TestFan {

	public static void main(String[] args) {
		Fan testfan1 = new Fan();
		Fan testfan2 = new Fan();
		
		//fan 1
		testfan1.setSpeed(testfan1.FAST);
		testfan1.setRadius(10);
		testfan1.setColor("yellow");
		testfan1.setOn(true);
		
		//fan 2
		testfan2.setSpeed(testfan2.MEDIUM);
		testfan2.setRadius(5);
		testfan2.setColor("blue");
		testfan2.setOn(false);
		
		System.out.println(testfan1.toString());
		System.out.println(testfan2.toString());
		

	}

}
