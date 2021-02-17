import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.Timer;

public class TargetFrame {
	private JFrame frame=new JFrame("TARGET");
	
	public TargetFrame(int score) {
		Dimension dim =new Dimension (400,250);
		frame.setPreferredSize(dim);
		frame.setResizable(false);
		frame.setFont(new Font("Helvetica",Font.BOLD,12));
		frame.setBounds(160, 170, 400, 250);
		
		ScoredTarget image=new ScoredTarget(score);
		frame.add(image);
		image.setVisible(true);
		frame.setVisible(true);
		
		Timer timer = new Timer(1000, new ActionListener() {
			@Override
	  		public void actionPerformed(ActionEvent arg0) {
				frame.setVisible(false);
	  		}
  		});
  		timer.setRepeats(false); // Only execute once
  		timer.start(); // Go go go!
	}
}
