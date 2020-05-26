
public class Gravity extends Variable{ //변인1, 중력가속도는 항상 일정 
	
	private static double GRAVITY_ACCEL=9.80665;
	
	public Gravity() {
	}
	public void set() {
	}
	public Gravity get() {
		return this;
	}
	public double get_gravity() {
		return GRAVITY_ACCEL;
	}
}
