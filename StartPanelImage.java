import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JPanel;

//�� ó�� ���� ������ �̹���
class StartPanelImage extends JPanel{
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		Dimension d=new Dimension(400,330);
		g.drawLine(0, 330, 400, 330);
		Image img=Toolkit.getDefaultToolkit().getImage("startPageImage.png");
		g.drawImage(img,0,0,d.width,d.height,this);
	}
}