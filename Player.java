public class Player {
	
	private String name;      //player name
	private int[] score;      //player's score 
	private boolean outcome;  //whether the player wins or loses.
	
	public Player() {
		name= null;
		score= new int[10];
	}
	
	public Player(String name) {
		this.name= name;
		score= new int[10];
	}
	
	public String getName() {
		return name;
	}
	
	public void setScore(int playerscore, int i) {
		score[i]=playerscore;
	}
	
	public void setOutcome(boolean outcome) {
		this.outcome=outcome;
	}
	
	public boolean getOutcome() {
		return outcome;
	}
	
	//player's total sum of score
	public int sum_score() {
		int sum=0;
		for(int i=0;i<10;i++) {
			sum+= score[i];
		}
		return sum;
	}
	
	//player's average of total sum of score
	public double average_score() {
		return Math.round(sum_score()/10*100)/100.0;
	}

	
}
