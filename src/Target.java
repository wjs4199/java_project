
public class Target {
	private Crowd crowd;
	private static int TARGET_MID;
	
	public Target(Crowd crowd) {
		this.crowd = crowd;
		TARGET_MID = 1;
	}
	
	public int decide_score(double y, double z, char type, int condition){
		double delta;
		if(type == 't') {
			delta = Math.sqrt((y-0)*(y-0)+(z-TARGET_MID)*(z-TARGET_MID))+crowd.get_noiselevel()/100-(condition)/100;
		}
		else if(type == 'r') {
			delta = Math.sqrt((y-0)*(y-0)+(z-TARGET_MID)*(z-TARGET_MID))+crowd.get_noiselevel()/80-(condition)/80;
		}
		else {
			delta = 0;
			System.exit(0);
		}		
		if(delta <= 0.1) return 10;
		else if(delta <= 0.2) return 9;
		else if(delta <= 0.3) return 8;
		else if(delta <= 0.4) return 7;
		else if(delta <= 0.5) return 6;
		else if(delta <= 0.6) return 5;
		else if(delta <= 0.7) return 4;
		else if(delta <= 0.8) return 3;
		else return 2;
	}
}
