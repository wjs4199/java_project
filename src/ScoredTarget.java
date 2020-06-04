import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JPanel;

public class ScoredTarget extends JPanel{
	private int num;
	private Image img;	
	public ScoredTarget(int score) {
		num = score;
		String picturename = Integer.toString(num) + ".png";
		img=Toolkit.getDefaultToolkit().getImage(picturename);

	}
		@Override
	public void paint(Graphics g) {
		super.paint(g);
		Dimension d=new Dimension(400,250);
		g.drawImage(img,0,0,d.width,d.height,this);
	}
		
}

