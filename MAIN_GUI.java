import javax.swing.*;
import java.awt.*;

public class MAIN_GUI {
	public static final int SLEEP_TIME = 10;
	public static final int ARROW_SPEED = 10;
	public static void main(String[] args) {
		
		//������ ���� 400*400�������
		Dimension dim=new Dimension(400,400);
		JFrame frame=new JFrame("The Rabbit and Tiger");	
		frame.setLocation(150, 150);	//â ��ġ ����
		frame.setPreferredSize(dim);	//â ũ�� ����
		frame.setResizable(false);		//â ũ�� ���� �Ұ� ����

		//ù��° �������� frame ��ü ����
		StartPage startpage=new StartPage(frame);
	
		frame.pack();
		frame.setVisible(true);
	}
}