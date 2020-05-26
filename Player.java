package team_project;
import java.util.Scanner;

public class Player {
	private static int hp;
	private static String name;
	private static int[] score = new int[10];
	
	public Player() {
		Scanner sc = new Scanner(System.in);
		name=sc.next();
		for (int i=0;i<10;i++) {
			score[i]=0;
		}
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
