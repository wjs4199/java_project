package team_project;
import java.util.Scanner;

public class Player {
	private static int hp;
	private static String name;
	private static int[] score = new int[10];
	
	public Player() {
		hp=50;
		name="NULL";
		for (int i=0;i<10;i++) {
			score[i]=0;
		}
	}
	public static void set_player() {
		Scanner sc = new Scanner(System.in);
		name=sc.next();
		for (int i=0;i<10;i++) {
			score[i]=0;
		}
	}
	public static void set_hp(int num) {
		hp=num;
	}
	public static void set_name(String input) {
		name=input;
	}
	public int sum_score() {
		int sum=0;
		for (int i=0;i<10;i++) {
			sum+=score[i];
		}
		return sum;
	}
	public double average_score() {
		return this.sum_score()/10.0;
	}
}
