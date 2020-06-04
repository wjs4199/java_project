import javax.swing.*;
import java.awt.*;

public class MAIN_GUI {
	public static final int SLEEP_TIME = 10;
	public static final int ARROW_SPEED = 10;
	public static void main(String[] args) {
		
		//프레임 설정 400*400사이즈로
		Dimension dim=new Dimension(400,400);
		JFrame frame=new JFrame("The Rabbit and Tiger");	
		frame.setLocation(150, 150);	//창 위치 설정
		frame.setPreferredSize(dim);	//창 크기 설정
		frame.setResizable(false);		//창 크기 조절 불가 설정

		//첫번째 페이지로 frame 객체 전달
		StartPage startpage=new StartPage(frame);
	
		frame.pack();
		frame.setVisible(true);
	}
}