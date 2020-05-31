import java.util.Random;

public class Crowd extends Variable{ 
	double noise_level;
	
	public Crowd() {
		Random rand = new Random();
		noise_level = (rand.nextDouble()*100%10);		
	}
	public void set(double x) {
		noise_level = x;
	}
	public void reset() {
		Random rand = new Random();
		noise_level = (rand.nextDouble()*100%10);	
	}
	public double get_noiselevel() {
		return noise_level;
	}
	public Crowd get() {
		return this;
	}
}
