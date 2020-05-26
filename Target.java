
public class Target {
	private Crowd crowd;
	private static int TARGET_X;
	private static int TARGET_HEIGHT;
	private static int TARGET_MID;
	private static int TARGET_WIDTH;
	
	public Target() {
		crowd = new Crowd();
		TARGET_X = 100;
		TARGET_HEIGHT = 2;
		TARGET_MID = TARGET_HEIGHT/2;
		TARGET_WIDTH = 2;
	}
	
	public int decide_score(double y, double z){
		//double delta = Math.abs(z - TARGET_MID);
		System.out.printf("Noise level: %.2f\n",crowd.get_noiselevel());
		double delta = Math.sqrt((y-0)*(y-0)+(z-1)*(z-1))+crowd.get_noiselevel()/100;
		
		if(delta <= 0.1) return 10;
		else if(delta <= 0.2) return 9;
		else if(delta <= 0.3) return 8;
		else if(delta <= 0.4) return 7;
		else if(delta <= 0.5) return 6;
		else if(delta <= 0.6) return 5;
		else if(delta <= 0.7) return 4;
		else if(delta <= 0.8) return 3;
		else if(delta <= 0.9) return 2;
		else if(delta <= 1.0) return 1;
		else return 0;
	}
	
	/*public boolean is_hit(int x, int y) {
		
	}*/
	
}
