
public class Angle extends Variable{
	private double theta;
	private double deflection;
	
	public Angle() {
		theta = Math.toRadians(4);
		deflection = Math.toRadians(0);
	}
	public void set(double x, double y) {
		theta = Math.toRadians(x);
		deflection= Math.toRadians(y);
	}
	public Angle get() {
		return this;
	}
	public double get_theta() {
		return theta;
	}
	public double get_deflection() {
		return deflection;
	}
}
