import java.util.Random;

public class Wind extends Variable{ //변인2, 풍속은 매횟수마다 랜덤한 값으로 변화 
	private double wind_direction;
	private double wind_speed;
	
	public Wind() {
		Random rand = new Random();		
		wind_speed = ((rand.nextDouble()*100)%1);
		wind_direction = ((rand.nextDouble()*1000)%360);
	}
	public void set(double x, double y) {
		wind_speed = x;
		wind_direction = y;
	}
	public Wind get() {
		return this;
	}
	public double get_speed() {
		return wind_speed;
	}
	public double get_direction() {
		return wind_direction;
	}
	public void print_wind() {
		System.out.print("Wind speed: ");
		System.out.printf("%.2f", wind_speed);
		System.out.print(", Wind direction: ");
		System.out.printf("%.2f\n", wind_direction);
	}
	public double get_dx() {
		double dx = wind_speed * Math.cos(Math.toRadians(wind_direction));
		return dx;
	}
	public double get_dy() {
		double dy = wind_speed * Math.sin(Math.toRadians(wind_direction));
		return dy;
	}
}
