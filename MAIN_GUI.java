
import javax.swing.*;
import java.awt.*;
import java.awt.Label;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Container;
import javax.swing.table.DefaultTableModel;


public class MAIN_GUI {
	
	public static void main(String[] args) {
		
		//프레임 설정 400*400사이즈로
		Dimension dim=new Dimension(400,400);
		JFrame frame=new JFrame("The Rabbit and Tiger");	
		frame.setLocation(400, 400);	//창 위치 설정
		frame.setPreferredSize(dim);	//창 크기 설정
		frame.setResizable(false);		//창 크기 조절 불가 설정

		//첫번째 페이지로 frame 객체 전달
		StartPage startpage=new StartPage(frame);
		
		frame.pack();
		frame.setVisible(true);
	}
}

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
				startImage.setVisible(false);
				startButtonPanel4.setVisible(false);
				RankPage secondpage=new RankPage(frame);
				
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

//두번째 페이지, ID입력하는 페이지
class SecondPage{
	
	//이름 가져와야할때 여기서 가져오기
	public String rabbitName;
	public String tigerName;
	
	public SecondPage(JFrame frame) {
		
		Container contentPane=frame.getContentPane();
		
		
		//패널 2개를 만들어서 mainPanel에 넣은 뒤 Container에 적용
		FlowLayout layout=new FlowLayout();
		JPanel mainPanel=new JPanel();
		mainPanel.setSize(400, 300);
		mainPanel.setVisible(true);
		
		JPanel rabbitID=new JPanel();
		rabbitID.setLayout(layout);
		rabbitID.setVisible(true);
		JPanel tigerID=new JPanel();
		tigerID.setLayout(layout);
		tigerID.setVisible(true);
		JPanel buttonPanel=new JPanel();	//Panel 생성
		
		//라벨 설정
		Font font=new Font("Helvica",Font.BOLD,13);
		Label rabbitlbl=new Label("Rabbit");
		rabbitlbl.setFont(font);
		Label tigerlbl=new Label("Tiger");
		tigerlbl.setFont(font);
		
		//이 텍스트필드가 사용자가 입력할 수 있게 해줌
		TextField rabbitIdText=new TextField("Name",20);
		TextField tigerIdText=new TextField("Name",20);
		
		//각 패널들에 적용해주기
		rabbitID.add(rabbitlbl);
		rabbitID.add(rabbitIdText);
		mainPanel.add(rabbitID);
		
		tigerID.add(tigerlbl);
		tigerID.add(tigerIdText);
		mainPanel.add(tigerID);
		
		//마지막으로 프레임에 적용
		contentPane.add(mainPanel);
		
		//시작 버튼 생성
		JButton startButton=new JButton("START!");
		startButton.setBackground(Color.gray);
		startButton.setForeground(Color.WHITE);
		startButton.setFont(new Font("Helvetica",Font.PLAIN,20));
		startButton.setHorizontalAlignment(SwingConstants.CENTER);
		startButton.setVerticalAlignment(SwingConstants.CENTER);
		startButton.setSize(180, 200);
		startButton.setVisible(true);
		//시작버튼 누를경우 넘어가기
		ActionListener startListener=new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String rabbitName;
				String tigerName;
				
				mainPanel.setVisible(false);
				startButton.setVisible(false);
				rabbitName=rabbitIdText.getText();
				tigerName=tigerIdText.getText();
				
				PlayPage playpage=new PlayPage(frame,rabbitName,tigerName);
				
			}
		};
		startButton.addActionListener(startListener);
		contentPane.add(startButton, BorderLayout.SOUTH);
	}
}
//플레이 페이지
class PlayPage{
	
	
	public PlayPage(JFrame frame, String rabbitName,String tigerName) {
		
		
		Container contentPane=frame.getContentPane();
		System.out.printf("%s, %s",rabbitName, tigerName);
		
		//과녁 이미지, Shoot버튼이 눌리면 결과 값을 받아서 맞는 이미지를 출력, 그리고 다시 사라짐
		TargetImage targetimage=new TargetImage();
		targetimage.setVisible(true);
		targetimage.setLayout(null);
		targetimage.setBounds(0, 0, 400, 180);
		frame.add(targetimage);
		
		/*
		 * TO DO: 점 이미지 삽입, 키보드 입력에 따라 이동하고 위치값 넘겨주는 작업
		 * */
		
		//사용자 이미지, Shoot버튼을 누를때마다 변경되게 하기
		UserImage1 userimage1=new UserImage1();
		frame.add(userimage1);
		userimage1.setVisible(true);
		userimage1.setLayout(null);
		userimage1.setBounds(0, 180, 220, 70);
		Label turnOfUser=new Label(rabbitName);
		
		//Conditions, 랜덤값을 객체 생성해서 받아온다음 Label생성해서 합쳐서 적용하면 됨
		Font font1=new Font("Helvica",Font.BOLD,12);
		JPanel conditions=new JPanel();
		conditions.setLayout(null);
		Label wind=new Label("Wind: S +10");
		Label audience=new Label("Audience +3");
		wind.setFont(font1);
		audience.setFont(font1);
		wind.setBounds(240,210,200,20);
		audience.setBounds(240,230, 200, 20);
		conditions.add(wind);
		conditions.add(audience);
		
		
		//버튼 누를때마다 아이디 변경해주기
		Font font2=new Font("Helvica",Font.BOLD,15);
		Label userId=new Label(rabbitName);
		userId.setFont(font2);
		userId.setBounds(240,185, 200, 20);
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
		
		
		ActionListener shootListener=new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//이미지 변경
				if((turnOfUser.getText()).equals(rabbitName)) {
				UserImage2 userimage2=new UserImage2();
				frame.add(userimage2);
				userimage2.setVisible(true);
				userimage2.setLayout(null);
				userimage2.setBounds(0, 180, 200, 70);
				turnOfUser.setText(tigerName);
				}else {
					UserImage1 userimage1=new UserImage1();
					frame.add(userimage1);
					userimage1.setVisible(true);
					userimage1.setLayout(null);
					userimage1.setBounds(0, 180, 200, 70);
					turnOfUser.setText(rabbitName);
				}
				//이름 변경
				if((userId.getText()).equals(rabbitName)) {
					userId.setText(tigerName);
				}else {
					userId.setText(rabbitName);
				}
				
			}
		};
		
		shootButton.addActionListener(shootListener);
		
		shootPanel.add(shootButton);
		shootButton.setVisible(true);
		shootPanel.setVisible(true);
		
		
		contentPane.add(shootPanel,BorderLayout.SOUTH);				//프레임에 패널추가
	}
}
//Rank 페이지
class RankPage{
		
	public RankPage(JFrame frame){
		
		String conditions[]= {"Name","Rank","Number of Win"};
		String values[][]= {
			{"Moon","1","3"},
			{"Kim","2","2"},
			{"Lee","3","1"}
		};
		DefaultTableModel model=new DefaultTableModel(values,conditions);
		JTable conditionTable=new JTable(model);
		frame.add(conditionTable,BorderLayout.CENTER);
		
		/*
		 * 추가 방법
		 * String inputStr[]=new String[3];
		 * model.addRow(inputStr);
		 */
		
		//conditionTable.setValueAt(1,1); 이런식ㅇ로 값 변경
	}
	
}
//과녁 기본 이미지 
class TargetImage extends JPanel{
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		Dimension d=new Dimension(400,200);
		Image img=Toolkit.getDefaultToolkit().getImage("C:\\Users\\moonkey\\Desktop\\JavaFinal\\bigTarget.png");
		g.drawImage(img,0,0,d.width,d.height,this);
	}
}

//사용자 이미지, 토끼랑 사자
class UserImage1 extends JPanel{
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		Dimension d=new Dimension(220,70);
		Image img=Toolkit.getDefaultToolkit().getImage("C:\\Users\\moonkey\\Desktop\\JavaFinal\\playerRabbit2.png");
		g.drawImage(img,0,0,d.width,d.height,this);
	}
}
class UserImage2 extends JPanel{
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		Dimension d=new Dimension(200,70);
		Image img=Toolkit.getDefaultToolkit().getImage("C:\\Users\\moonkey\\Desktop\\JavaFinal\\playerTiger2.png");
		g.drawImage(img,0,0,d.width,d.height,this);
	}
}

//맨 처음 시작 페이지 이미지
class StartPanelImage extends JPanel{
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		Dimension d=new Dimension(400,330);
		g.drawLine(0, 330, 400, 330);
		Image img=Toolkit.getDefaultToolkit().getImage("C:\\Users\\moonkey\\Desktop\\JavaFinal\\startPageImage.png");
		g.drawImage(img,0,0,d.width,d.height,this);
	}
}