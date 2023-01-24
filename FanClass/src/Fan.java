public class Fan {
	public final int SLOW = 1;
	public final int MEDIUM = 2;
	public final int FAST = 3;
	//data fields
	private int speed;
	private boolean on;
	private double radius;
	private String color;
	//Id will start at 1 and increment with each new Fan
	//must remain static so it applies to all fans
	private static int IDcounter = 0; 
	private int ID;
	
	//default constructor
	public Fan() {
		ID = ++IDcounter;
		speed = SLOW;
		on =  false;
		radius = 5;
		color = "Blue";
	}
			
			
	//Accessor methods
	public int getSpeed() {
		return speed;
	}
	
	public boolean isOn() {
		return on;
	}
	
	public double getRadius() {
		return radius;
	}
	
	public String getColor() {
		return color;
	}
	
	//Mutator methods
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	
	public void setOn(boolean isOn) {
		this.on = isOn;
	}
	
	public void setRadius(double radius) {
		this.radius = radius;
	}
	
	public void setColor(String color) {
		this.color = color;
	}

	public String toString() {
		if (on) {
			return "Fan Id: " + ID +  ", speed is " + speed + ", radius is " + radius + ", color is " + color + "";
		}
		else {
			return "Fan Id: " + ID + ", radius is " + radius + ", color is " + color + " the fan is off";
		}
	}
		
	
	
}
