import java.util.Scanner;

public class Rabbit extends Player{
	private char type ='r';
	
	public Rabbit() {
		condition = 5;
		round =0;
		name = "NULL";
	}
	public void set_playerNAME() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Please input your Name: ");
		name=sc.next();
	}
	public String get_NAME() {
		return name;
	}
	public int get_SCORE(int i) {
		return score_arr[i];
	}
	
	public int sum_score() {
		int sum =0;
		for(int score : score_arr) {
			sum += score;
		}
		return sum;
	}
	
	public void run() {
		Gravity gravity = new Gravity();
		Wind wind = new Wind();
		Power power = new Power();
		Angle angle = new Angle();
		Scanner sc = new Scanner(System.in);
		//System.out.print("Wind speed: "+wind.get_speed()+" Wind direction: "+wind.get_direction());
		wind.print_wind();
		//angle.set(sc.nextDouble(),sc.nextDouble());
		angle.set(3,0);
		
		Target target = new Target();
		Arrow arrow = new Arrow(gravity, wind, power, angle);
				
		int x;
		double real_x, real_y, real_z;
		do {
			real_x = arrow.fx();
			real_y = arrow.fy();
			real_z = arrow.fz();
			x = (int)Math.floor(real_x);
		}while(x!=100);
		System.out.printf("(x,y,z): (%.2f, %.2f, %.2f)\n",real_x,real_y,real_z);
		
		score_arr[round++] =target.decide_score(real_y, real_z, type, condition);
		condition = score_arr[round -1];
	}
}
