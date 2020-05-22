import java.util.Random;

public class Crowd extends Variable{ //변인3, 관중소리는 매횟수마다 랜덤한 값으로 변화 
	double noise_level;
	
	public Crowd() {
		Random rand = new Random();
		noise_level = (rand.nextDouble()*100%11);		
	}
	public void set(double x) {
		noise_level = x;
	}
	public double get() {
		return noise_level;
	}
}
