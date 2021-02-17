import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JPanel;

//°ú³á ±âº» ÀÌ¹ÌÁö 
class TargetImage extends JPanel{
	private double direction;
	public TargetImage(double d) {
		direction =Math.toRadians(d-90);
	}
	public void set_direction(double d) {
		direction =Math.toRadians(d-90);
	}
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		Dimension d=new Dimension(400,250);
		Image img=Toolkit.getDefaultToolkit().getImage("bigTarget.png");
		g.drawImage(img,0,0,d.width,d.height,this);
		g.drawString("TARGET", 180, 220);
		g.drawString("Wind Direction",290, 190);
		g.drawOval(330-20, 215-20, 40, 40);
		g.drawLine(330, 215, (int)(330+20*Math.cos(direction)),(int)(215+20*Math.sin(direction)));
	}
}
