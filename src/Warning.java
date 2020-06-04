import java.awt.Font;
import java.awt.Label;

import javax.swing.JFrame;

class Warning{
	private JFrame frame=new JFrame("**System Message**");
	
	public Warning() {
		frame.setSize(200,100);
		frame.setLocation(250,300);
		frame.setResizable(false);
		frame.setVisible(true);
		Label wrong=new Label("Same Name! Please Rename!");
		wrong.setVisible(true);
		wrong.setFont(new Font("Helvetica",Font.BOLD,12));
		frame.add(wrong);
	}
}
