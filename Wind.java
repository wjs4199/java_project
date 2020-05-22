import java.util.Random;

public class Wind extends Variable{ //변인2, 풍속은 매횟수마다 랜덤한 값으로 변화 
	
	private double wind_speed;
	
	public Wind() {
		Random rand = new Random();		
		wind_speed = ((rand.nextDouble()*100)%31 -15);
	}
	public void set(double x) {
		wind_speed = x;
	}
	public double get() {
		return wind_speed;
	}
}
