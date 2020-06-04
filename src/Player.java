import java.text.DecimalFormat;
import java.util.Scanner;

public class Player {
	private Gravity gravity = new Gravity();
	private Wind wind = new Wind();
	private Power power = new Power();
	private Angle angle = new Angle();
	private Crowd crowd = new Crowd();
	private Arrow arrow;
	private int condition;
	private String name;
	private int round;
	private int[] score_arr = new int[10];
	private char type;
	
	public Player(char type) {
		arrow = new Arrow(gravity, wind, power, angle);
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
	public String get_SCORE_str(int i) {return String.valueOf(score_arr[i]);}
	public int get_condition() {return condition;}
	
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
	
	public String return_windstr() {
		DecimalFormat form1 = new DecimalFormat("#.#");
		String windstr = "Wind Speed: " + form1.format(this.get_wind().get_speed()*10);
		return windstr;
	}
	public String return_crowdstr() {
		DecimalFormat form = new DecimalFormat("#");
		String audiencestr = "Noise: " + form.format(this.get_crowd().get_noiselevel());
		audiencestr += ",";
		return audiencestr;
	}
	public String return_conditionstr() {
		if(condition >= 8) return "Feels Good";
		else if(condition >= 4) return "Feels Soso";
		else return "Feels Bad";
	}
	public Arrow get_arrow() {
		return arrow;
	}
	
	public void run(double a, double b) {
		angle.set(3+a,b);
		Target target = new Target(crowd);
		arrow = new Arrow(gravity, wind, power, angle);
		int x;
		double real_x, real_y, real_z;
		do {
			real_x = arrow.fx();
			real_y = arrow.fy();
			real_z = arrow.fz();
			x = (int)Math.floor(real_x);
		}while(x!=100);
		
		score_arr[round++] =target.decide_score(real_y, real_z, type, condition);
		condition = score_arr[round -1];
		crowd.reset();
		wind.reset();
	}
}
