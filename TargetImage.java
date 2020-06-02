import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JPanel;

//과녁 기본 이미지 
class TargetImage extends JPanel{
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		Dimension d=new Dimension(400,250);
		Image img=Toolkit.getDefaultToolkit().getImage("bigTarget.png");
		g.drawImage(img,0,0,d.width,d.height,this);
	}
}