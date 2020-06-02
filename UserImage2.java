import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JPanel;

class UserImage2 extends JPanel{
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		Dimension d=new Dimension(220,70);
		Image img=Toolkit.getDefaultToolkit().getImage("playerTiger2.png");
		g.drawImage(img,0,0,d.width,d.height,this);
	}
}