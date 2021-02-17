import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Animation{
		private Arrow arrow;
		private Player p;
		private Image img = Toolkit.getDefaultToolkit().getImage("arrow.png");
		private ImageIcon icon = new ImageIcon("background.png");
		public Animation(Arrow a, Player p){
			arrow = a;
			this.p=p;
			EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                    ex.printStackTrace();
                }

                JFrame frame = new JFrame("Flying Arrow");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
                frame.setBounds(150,150,800,300);
                TestPane arrowPane = new TestPane(frame);
                arrowPane.requestFocus();
                frame.add(arrowPane);
                frame.pack();
                frame.setLocationRelativeTo(null);
            }
			});
		}
        public class TestPane extends JPanel {
        	private double x = 0;
        	private double z = 0;

        public TestPane(JFrame frame) {
            Timer timer = new Timer(10, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                	if(x<570) {
                		//System.out.println(x);
                        moveArrow();
                        repaint();
                	}
                	else {
                		((Timer)e.getSource()).stop();
                		quit(frame);
                		TargetFrame scoredtarget = new TargetFrame(p.get_condition());
                		return;
                	}
                }
            });
            timer.start();

        }

        protected void moveArrow() {for(int i=0; i<500; i++){x= arrow.fx(); z=arrow.fz();}}
        @Override
        public Dimension getPreferredSize() {
            return new Dimension(800, 300);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
			g.drawImage(icon.getImage(),0,0,null);
	        g.drawImage(img, (int)x, (int)z+265, null);
        }
        private void quit(JFrame frame) {
        	frame.setVisible(false);
        }
    }
}
