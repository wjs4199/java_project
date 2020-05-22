
public class TestConsole {

	public static void main(String[] args) {
		int score;
		int sum =0;
		for(int i=0; i<10; i++) {
			score = run();
			sum += score;
			System.out.println((i+1)+"th Trial"+" Score: "+ score+"\n");
		}
		System.out.println("Average: "+sum/10.0);
	}
	
	public static int run() {
		Target target = new Target();
		Arrow arrow = new Arrow();
				
		int x;
		double real_x, real_y;
		do {
			real_x = arrow.fx();
			real_y = arrow.fy();
			x = (int)Math.floor(real_x);
		}while(x!=100);
		
		return target.decide_score(real_y);
	}

}
