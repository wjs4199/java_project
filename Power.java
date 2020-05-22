
public class Power extends Variable{ //변인4, 속도는 파워게이지바를 통해 결정 
	private double velocity;
	
	public Power() {
		velocity = 95;
	}
	public void set(double x) {
		velocity = x;
	}
	public double get() {
		return velocity;
	}
}
