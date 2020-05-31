/*import java.util.Scanner;

public class TestConsole {

	public static void main(String[] args) {
		RankingFile rf = new RankingFile();
		System.out.println("Rabbit And Tiger loading...");
		Player p1 = new Player('r');
		Player p2 = new Player('t');
		//System.out.println("Player 1");
		//p1.set_playerNAME();
		//System.out.println("Player 2");
		//p2.set_playerNAME();
		for(int i=0; i<10; i++) {
			p1.run();
			System.out.println(p1.get_NAME()+"'s "+(i+1)+"th Trial Score: "+ p1.get_SCORE(i)+"\n");
			p2.run();
			System.out.println(p2.get_NAME()+"'s "+(i+1)+"th Trial Score: "+ p2.get_SCORE(i)+"\n");
		}
		System.out.println(p1.get_NAME()+"'s Average: "+p1.sum_score()/10.0);
		System.out.println(p2.get_NAME()+"'s Average: "+p2.sum_score()/10.0);
		
		if(p1.is_win(p2)==0) System.out.println("Draw!");
		else if(p1.is_win(p2)==1) System.out.println("Rabbit Win!");
		else System.out.println("Tiger Win!");
		rf.print_ranking(p1, p2);
	}
	
	public static int run_withoutV() {
		Gravity gravity = new Gravity();
		Wind wind = new Wind();
		wind.set(10,90);
		Power power = new Power();
		Angle angle = new Angle();
		angle.set(3,-6.478);
		
		Target target = new Target();
		System.out.println("-Main-\nWind speed: "+wind.get_speed()+" Wind direction: "+wind.get_direction());
		Arrow arrow = new Arrow(gravity, wind, power, angle);
				
		int x;
		double real_x, real_y, real_z;
		do {
			real_x = arrow.fx();
			real_y = arrow.fy();
			real_z = arrow.fz();
			x = (int)Math.floor(real_x);
		}while(x!=100);
		System.out.println("(x,y,z): "+"("+real_x+","+real_y+","+real_z+")");
		return target.decide_score(real_y, real_z);
	}
	

}*/
