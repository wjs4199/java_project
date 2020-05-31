import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.*;

public class Aim extends JPanel{
	
	/*
	 * ImageIcon imgicon = new ImageIcon("aim.png"); JLabel la = new
	 * JLabel(imgicon); final int FLYING_UNIT = 10;
	 * 
	 * Aim(){ setLayout(null); addKeyListener(new MyKeyListener());
	 * la.setLocation(350,350); la.setSize(200,200); add(la); la.setVisible(true);
	 * requestFocus(); }
	 */
	public void paint(Graphics g) {
		super.paint(g);
		Dimension d= new Dimension(30,30);
		Image img = Toolkit.getDefaultToolkit().createImage("aim.png");
		g.drawImage(img, 0, 0, d.width, d.height, null);
	}
	
	/*class MyKeyListener extends KeyAdapter{
		public void keyPressed(KeyEvent e) {
			int keyCode = e.getKeyCode();
			switch(keyCode) {
			case KeyEvent.VK_UP:
				if(la.getY()-FLYING_UNIT >= 0) la.setLocation(la.getX(), la.getY()-FLYING_UNIT);
				break;
			case KeyEvent.VK_DOWN:
				if(la.getY()+FLYING_UNIT <= 0) la.setLocation(la.getX(), la.getY()+FLYING_UNIT);
				break;
			case KeyEvent.VK_LEFT:
				if(la.getX()-FLYING_UNIT >= 0) la.setLocation(la.getX()-FLYING_UNIT, la.getY());
				break;
			case KeyEvent.VK_RIGHT:
				if(la.getX()+FLYING_UNIT <= 0) la.setLocation(la.getX()+FLYING_UNIT, la.getY());
				break;
			}
		}	
	}*/
}
