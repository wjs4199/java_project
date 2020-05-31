import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class Aim extends JPanel{
	Label la = new Label("+");
	final int FLYING_UNIT =10;
	
	Aim(){
		this.setLayout(null);
		this.addKeyListener(new MyKeyListener());
		la.setLocation(195, 90);
		la.setSize(20,20);
		this.requestFocus();
	    la.setForeground(Color.black);
	    la.setBackground(null);
	    la.setAlignment(SwingConstants.CENTER);
	    la.setBounds(195, 90, 10, 10);
	}
	
	class MyKeyListener extends KeyAdapter{
		public void keyPressed(KeyEvent e) {
            int keyCode = e.getKeyCode();
            switch (keyCode) {
            case KeyEvent.VK_UP:
            	if(la.getY()-FLYING_UNIT >= 0) la.setLocation(la.getX(), la.getY() - FLYING_UNIT);
                break;
            case KeyEvent.VK_DOWN:
            	if(la.getY()+FLYING_UNIT <= 260) la.setLocation(la.getX(), la.getY() + FLYING_UNIT);
                break;
            case KeyEvent.VK_LEFT:
            	if(la.getX()-FLYING_UNIT >= 0) la.setLocation(la.getX() - FLYING_UNIT, la.getY());
                break;
            case KeyEvent.VK_RIGHT:
            	if(la.getX()+FLYING_UNIT <= 290) la.setLocation(la.getX() + FLYING_UNIT, la.getY());
                break;
            }
        }
	}
}
