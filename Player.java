import java.util.Scanner;

public class Player {
	protected int condition;
	protected String name;
	protected int round;
	protected int[] score_arr = new int[10];
	protected int outcome;
	
	public Player() {
		round = 0;
		condition = 5;
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
	
	public int is_win(Player p2) {
		if(this.sum_score() > p2.sum_score()) return 1;
		else if(this.sum_score() < p2.sum_score()) return -1;
		else return 0;
	}

}
