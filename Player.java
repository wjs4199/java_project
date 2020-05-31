import java.util.Scanner;

public class Player {
	private Gravity gravity = new Gravity();
	private Wind wind = new Wind();
	private Power power = new Power();
	private Angle angle = new Angle();
	private Crowd crowd = new Crowd();
	private int condition;
	private String name;
	private int round;
	private int[] score_arr = new int[10];
	private int outcome;
	private char type;
	
	public Player(char type) {
		round = 0;
		condition = 5;
		name = "NULL";
		this.type = type;
	}
	public void set_NAME(String n) {name = n;}
	public String get_NAME() {return name;}
	public int get_round() {return round;}
	public int get_SCORE(int i) {return score_arr[i];}
	public Wind get_wind() {return wind;}
	public Crowd get_crowd() {return crowd;}
	
	
	public int sum_score() {
		int sum =0;
		for(int score : score_arr) sum += score;
		return sum;
	}
	
	public int is_win(Player p2) {
		if(this.sum_score() > p2.sum_score()) return 1;
		else if(this.sum_score() < p2.sum_score()) return -1;
		else return 0;
	}
	
	public void run() {
		wind.print_wind();
		//angle.set(sc.nextDouble(),sc.nextDouble());
		angle.set(3,0);
		
		Target target = new Target(crowd);
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
		crowd.reset();
		wind.reset();
	}
}
