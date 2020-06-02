import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

//첫번째 페이지
class StartPage{
	
	public StartPage(JFrame frame){
		
		//처음에 다음줄과 같이 COntainer를 만들어서 이 안에 add 하는 형식이 가장 안정적으로 적용됨
		Container contentPane=frame.getContentPane();
		
		
		//첫 페이지 이미지 사진 삽입
		StartPanelImage startImage=new StartPanelImage();
		frame.add(startImage);
		startImage.setVisible(true);
		
		
		//버튼을 넣을 패널 생성
		FlowLayout layout=new FlowLayout();
		JPanel startButtonPanel1=new JPanel();
		startButtonPanel1.setLayout(layout);	//start버튼 넣을 패널 생성
		JPanel startButtonPanel2=new JPanel();
		startButtonPanel2.setLayout(layout);	//rank버튼 넣을 패널 생성
		JPanel startButtonPanel3=new JPanel();
		startButtonPanel3.setLayout(layout);	//quit버튼 넣을 패널 생성
		JPanel startButtonPanel4=new JPanel();
		startButtonPanel4.setLayout(layout);	//버튼들 합치는 패널 생성

		//버튼의 속성들을 각각 설정, 나중에 수정 예정
		//첫번째 페이지 START 버튼
		JButton startPageButton1=new JButton("Start");
		startPageButton1.setBackground(Color.gray);
		startPageButton1.setForeground(Color.WHITE);
		startPageButton1.setFont(new Font("Helvetica",Font.PLAIN,15));
		startPageButton1.setHorizontalAlignment(SwingConstants.CENTER);
		startPageButton1.setVerticalAlignment(SwingConstants.CENTER);
		startPageButton1.setSize(180, 60);
		
		//Start버튼 클릭시 적용, 다음페이지로 frame 객체를 넘겨줌
				ActionListener startListener=new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						//기존으 이미지,버튼은 안보이게 설정
						startImage.setVisible(false);
						startButtonPanel4.setVisible(false);
						SecondPage secondpage=new SecondPage(frame);
						
					}
				};
				//이 아래꺼 안써서 2시간 날림 에바야
				startPageButton1.addActionListener(startListener);	
				
				
		//천번째 페이지 RANK 버튼   
		JButton startPageButton2=new JButton("Rank");
		startPageButton2.setBackground(Color.gray);
		startPageButton2.setForeground(Color.WHITE);
		startPageButton2.setFont(new Font("Helvetica",Font.PLAIN,15));
		startPageButton2.setHorizontalAlignment(SwingConstants.CENTER);
		startPageButton2.setVerticalAlignment(SwingConstants.CENTER);
		startPageButton2.setSize(180, 60);
		//Rank페이지로 이동
		ActionListener rankListener=new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				RankPage secondpage=new RankPage();
				secondpage.showRanking_home();
				
			}
		};
		startPageButton2.addActionListener(rankListener);	
		
		
		//첫번째 페이지 Quit 버튼
		JButton startPageButton3=new JButton("Quit");
		startPageButton3.setBackground(Color.gray);
		startPageButton3.setForeground(Color.WHITE);
		startPageButton3.setFont(new Font("Helvetica",Font.PLAIN,15));
		startPageButton3.setHorizontalAlignment(SwingConstants.CENTER);
		startPageButton3.setVerticalAlignment(SwingConstants.CENTER);
		startPageButton3.setSize(180, 60);
		ActionListener quitListener=new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				startImage.setVisible(false);
				startButtonPanel4.setVisible(false);
				frame.setVisible(false);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				
			}
		};
		startPageButton3.addActionListener(quitListener);	
		
		
		
		//각 버튼의 위치 지정해서 한개의 판넬에 지정
		startButtonPanel4.add(startPageButton1,BorderLayout.WEST);
		startButtonPanel4.add(startPageButton2,BorderLayout.CENTER);
		startButtonPanel4.add(startPageButton3,BorderLayout.EAST);
		
		//합친 버튼 Frame에 적용 이때 frame에 바로 적용하지 않고 맨 위에 만든 Container에 적용함
		contentPane.add(startButtonPanel4,BorderLayout.SOUTH);				//프레임에 패널추가
		startButtonPanel4.setVisible(true);	//버튼 추가하기
		
	}
}