import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.Timer;

//플레이 페이지
class PlayPage{
	
	
	public PlayPage(JFrame frame, String rabbitName,String tigerName) {

		Player rabbit = new Player('r');
		rabbit.set_NAME(rabbitName);
		Player tiger = new Player('t');
		tiger.set_NAME(tigerName);
		//점수판 class Constructor
		Scoreboard sc= new Scoreboard(rabbit,tiger); //Player p1,Player p2 보내줘야함
		
		Container contentPane=frame.getContentPane();
		
		//과녁 이미지, Shoot버튼이 눌리면 결과 값을 받아서 맞는 이미지를 출력, 그리고 다시 사라짐
	      
	    Label pointlbl=new Label("+");
	    pointlbl.setVisible(true);
	    pointlbl.setForeground(Color.black);
	    pointlbl.setBackground(Color.GRAY);
	    pointlbl.setAlignment(SwingConstants.CENTER);
	    pointlbl.setLocation(195, 113);
	    pointlbl.setSize(10,10);
	    
	    TargetImage targetimage=new TargetImage(rabbit.get_wind().get_direction());
	    targetimage.setVisible(true);
	    targetimage.setLayout(null);
	    targetimage.add(pointlbl);
	    targetimage.setBounds(0, 0, 400, 250);
	    contentPane.add(targetimage);
		
		//사용자 이미지, Shoot버튼을 누를때마다 변경되게 하기
		UserImage1 userimage1=new UserImage1();
		UserImage2 userimage2=new UserImage2();
		frame.add(userimage1);
		frame.add(userimage2);
		userimage1.setVisible(true);
		userimage2.setVisible(false);
		userimage1.setLayout(null);
		userimage2.setLayout(null);
		userimage1.setBounds(0, 250, 220, 70);
		userimage2.setBounds(0, 250, 220, 70);
		Label turnOfUser=new Label(rabbitName);
		
		//Conditions, 랜덤값을 객체 생성해서 받아온다음 Label생성해서 합쳐서 적용하면 됨
		Font font1=new Font("Helvica",Font.BOLD,11);
		JPanel conditions=new JPanel();
		conditions.setLayout(null);
		String windstr = rabbit.return_windstr();
		String audiencestr = rabbit.return_crowdstr();
		String conditionstr = rabbit.return_conditionstr();
		Label wind=new Label(windstr);
		Label audience=new Label(audiencestr);
		Label condition=new Label(conditionstr);

		wind.setFont(font1);
		audience.setFont(font1);
		condition.setFont(font1);
		wind.setBounds(240, 280, 200, 15);
		audience.setBounds(240, 300, 60, 15);
		condition.setBounds(300, 300, 100, 15);
		
		conditions.add(wind);
		conditions.add(audience);
		conditions.add(condition);
				
		//버튼 누를때마다 아이디 변경해주기
		Font font2=new Font("Helvica",Font.BOLD,16);
		Label userId=new Label(rabbitName);
		userId.setFont(font2);
		userId.setBounds(240, 250, 200, 30);
		conditions.add(userId);
		contentPane.add(conditions);
		
		//SHOOT 버튼
		FlowLayout layout=new FlowLayout();
		JPanel shootPanel= new JPanel(layout);
		
		JButton shootButton=new JButton("SHOOT");
		shootButton.setBackground(Color.gray);
		shootButton.setForeground(Color.WHITE);
		shootButton.setFont(new Font("Helvetica",Font.PLAIN,15));
		shootButton.setHorizontalAlignment(SwingConstants.CENTER);
		shootButton.setVerticalAlignment(SwingConstants.CENTER);
		shootButton.setSize(200, 40);
		
		KeyAdapter arrowListener = new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				int keyCode = e.getKeyCode();
	            switch (keyCode) {
	            case KeyEvent.VK_UP:
	            	if(pointlbl.getY()-10 >= 33) pointlbl.setLocation(pointlbl.getX(), pointlbl.getY() -10);
	                break;
	            case KeyEvent.VK_DOWN:
	            	if(pointlbl.getY()+10 <= 193) pointlbl.setLocation(pointlbl.getX(), pointlbl.getY() +10);
	                break;
	            case KeyEvent.VK_LEFT:
	            	if(pointlbl.getX()-10 >= 95) pointlbl.setLocation(pointlbl.getX() -10, pointlbl.getY());
	                break;
	            case KeyEvent.VK_RIGHT:
	            	if(pointlbl.getX()+10 <= 295) pointlbl.setLocation(pointlbl.getX() +10, pointlbl.getY());
	                break;
	            }
			}
		};
		ActionListener shootListener=new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//이미지 변경
				if((turnOfUser.getText()).equals(rabbitName)) {
					//frame.setVisible(false);
					double delta_x = (pointlbl.getX() - 195)/100.0;
					double delta_y = (pointlbl.getY() - 113)/100.0;
					rabbit.run(delta_x, delta_y);
					new Animation(rabbit.get_arrow(),rabbit);
					userimage1.setVisible(false);
					userimage2.setVisible(true);
					turnOfUser.setText(tigerName);
					targetimage.set_direction(tiger.get_wind().get_direction());
					targetimage.repaint();
					targetimage.requestFocus();
					wind.setText(tiger.return_windstr());
					audience.setText(tiger.return_crowdstr());
					condition.setText(tiger.return_conditionstr());
				    pointlbl.setLocation(195, 113);

				}else {
					double delta_x = (pointlbl.getX() - 195)/100.0;
					double delta_y = (pointlbl.getY() - 113)/100.0;
					tiger.run(delta_x, delta_y);
					new Animation(tiger.get_arrow(),tiger);
					userimage1.setVisible(true);
					userimage2.setVisible(false);
					turnOfUser.setText(rabbitName);
					targetimage.set_direction(rabbit.get_wind().get_direction());
					targetimage.repaint();
					targetimage.requestFocus();
					wind.setText(rabbit.return_windstr());
					audience.setText(rabbit.return_crowdstr());
					condition.setText(rabbit.return_conditionstr());
				    pointlbl.setLocation(195, 113);
				    if(rabbit.get_round()+tiger.get_round()==20) {
				    	frame.setVisible(false);
				    	Timer timer = new Timer(2000, new ActionListener() {
				    		  @Override
				    		  public void actionPerformed(ActionEvent arg0) {
				    			  sc.showWIN(rabbit, tiger);
							    	RankPage next = new RankPage();
							    	Dimension dim=new Dimension(400,400);
									JFrame new_frame=new JFrame("The Rabbit and Tiger");	
							    	next.showRanking_end(rabbit, tiger, sc, new_frame); //Player 정보 업데이트 + save 버튼
									new_frame.setLocation(150, 150);	//창 위치 설정
									new_frame.setPreferredSize(dim);	//창 크기 설정
									new_frame.setResizable(false);		//창 크기 조절 불가 설정
									//첫번째 페이지로 frame 객체 전달
									StartPage return_to_startpage=new StartPage(new_frame);
									new_frame.pack();
									//new_frame.setVisible(true);
				    		  }
				    		});
				    		timer.setRepeats(false); // Only execute once
				    		timer.start(); // Go go go!
				    }
				}
				//이름 변경
				if((userId.getText()).equals(rabbitName)) {
					userId.setText(tigerName);
				}
				else {
					userId.setText(rabbitName);
				}
				//shoot할때마다 플레이어점수 읽어와서 점수판 업데이트
				sc.scorechange(rabbit, tiger); //Player p1, Player p2
			}
		};
		shootButton.addActionListener(shootListener);
		targetimage.addKeyListener(arrowListener);
		targetimage.requestFocus();
		shootPanel.add(shootButton);
		shootButton.setVisible(true);
		shootPanel.setVisible(true);
		contentPane.add(shootPanel,BorderLayout.SOUTH);				//프레임에 패널추가
	}
}
