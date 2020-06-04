
public class Power extends Variable{ 
	private double velocity;
	
	public Power() {
		velocity = 87.1;
	}
	public void set(double x) {
		velocity = x;
	}
	public Power get() {
		return this;
	}
	public double get_velocity() {
		return velocity;
	}
}
