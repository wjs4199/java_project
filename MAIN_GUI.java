
import javax.swing.*;
import java.awt.*;
import java.awt.Label;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.ActionEvent;
import java.awt.Container;

import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;


public class MAIN_GUI {
	
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
				if(rabbitName.equals(tigerName)) {
					Warning name_issue = new Warning();
					SecondPage secondpage=new SecondPage(frame);
				}
				else{
					PlayPage playpage=new PlayPage(frame,rabbitName,tigerName);
				}
			}
		};
		startButton.addActionListener(startListener);
		contentPane.add(startButton, BorderLayout.SOUTH);
	}
}

class Warning{
	private JFrame frame=new JFrame("**System Message**");
	
	public Warning() {
		frame.setSize(200,100);
		frame.setLocation(500,500);
		frame.setResizable(false);
		frame.setVisible(true);
		Label wrong=new Label("Same Name! Please Rename!");
		wrong.setVisible(true);
		wrong.setFont(new Font("Helvetica",Font.BOLD,12));
		frame.add(wrong);
	}
}


//점수판 class
class Scoreboard{
	private String score[][]=new String[11][3];
	private String scorelevel[]= {"STAGE","Rabbit","Tiger"};
	JFrame frame2;
	private JTable table;
	private JPanel winpanel;

	//점수판 띄우기
	public Scoreboard(Player p1, Player p2) {
		Dimension dim=new Dimension(150,400);

		frame2=new JFrame("**Score Board**");
		frame2.setLocation(790,400);
		frame2.setPreferredSize(dim);
		frame2.setResizable(false);
		frame2.setFont(new Font("Helvetica",Font.BOLD,12));

		for(int i=0;i<10;i++){
			score[i][0]="Stage "+(i+1);
			score[i][1]=p1.get_SCORE_str(i);
			score[i][2]=p2.get_SCORE_str(i);
		}
		score[10][0]="SUM";
		score[10][1]=String.valueOf(p1.sum_score());
		score[10][2]=String.valueOf(p2.sum_score());

		DefaultTableModel model=new DefaultTableModel(score,scorelevel);
		table=new JTable(model);

		DefaultTableCellRenderer model_center = new DefaultTableCellRenderer();
		model_center.setHorizontalAlignment(SwingConstants.CENTER);
		TableColumnModel tcm = table.getColumnModel() ;
		for (int i = 0; i < tcm.getColumnCount(); i++) {
			tcm.getColumn(i).setCellRenderer(model_center);
		}

		table.setRowHeight(27);
		table.setBackground(Color.gray);
		table.setForeground(Color.white);
		table.setVisible(true);
		JScrollPane scrollpane =new JScrollPane(table);

		frame2.add(scrollpane,BorderLayout.CENTER);
		frame2.pack();
		frame2.setVisible(true);
	}

	public void scorechange(Player p1, Player p2) {
		for(int i=0;i<10;i++) {
			table.setValueAt(p1.get_SCORE_str(i),i, 1);
			table.setValueAt(p2.get_SCORE_str(i),i, 2);
		}
		table.setValueAt(p1.sum_score(),10,1);
		table.setValueAt(p2.sum_score(),10,2);
	}
	
	public void showWIN(Player p1, Player p2) {
		Container contentPane=frame2.getContentPane();
		FlowLayout layout=new FlowLayout();
		winpanel= new JPanel(layout);
		winpanel.setLayout(new GridLayout(1,1));
		JLabel win;
		if(p1.is_win(p2)==1){
			win=new JLabel("Rabbit WIN!");
		}
		else if(p1.is_win(p2)==-1) {
			win=new JLabel("Tiger WIN!");
		}
		else {
			win=new JLabel("Draw!");
		}
		Font font1=new Font("Helvica",Font.BOLD,25);

		win.setForeground(Color.black);
		win.setBackground(Color.GRAY);
		win.setHorizontalAlignment(SwingConstants.CENTER);
		win.setVerticalAlignment(SwingConstants.CENTER);
		win.setBounds(800, 750, 150,100);
		win.setSize(150,50);
		win.setFont(font1);

		win.setVisible(true);
		winpanel.add(win);
		winpanel.setVisible(true);
		frame2.add(winpanel);
		contentPane.add(winpanel,BorderLayout.SOUTH);
		frame2.setVisible(true);
	}
	public void quit_scoreboard() {
		frame2.setVisible(false);
	}
	
}

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
	      
	    TargetImage targetimage=new TargetImage();
	    targetimage.setVisible(true);
	    targetimage.setLayout(null);
	    targetimage.add(pointlbl);
	    targetimage.setBounds(0, 0, 400, 250);
	    contentPane.add(targetimage);
		
		
		//사용자 이미지, Shoot버튼을 누를때마다 변경되게 하기
		UserImage1 userimage1=new UserImage1();
		frame.add(userimage1);
		userimage1.setVisible(true);
		userimage1.setLayout(null);
		userimage1.setBounds(0, 250, 220, 70);
		Label turnOfUser=new Label(rabbitName);
		
		//Conditions, 랜덤값을 객체 생성해서 받아온다음 Label생성해서 합쳐서 적용하면 됨
		Font font1=new Font("Helvica",Font.BOLD,13);
		JPanel conditions=new JPanel();
		conditions.setLayout(null);
		String windstr = rabbit.return_windstr();
		String audiencestr = rabbit.return_crowdstr();
		Label wind=new Label(windstr);
		Label audience=new Label(audiencestr);
		wind.setFont(font1);
		audience.setFont(font1);
		wind.setBounds(240,280,200,20);
		audience.setBounds(240,300, 200, 20);
		conditions.add(wind);
		conditions.add(audience);
		
		
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
	            	if(pointlbl.getY()-10 >= 0) pointlbl.setLocation(pointlbl.getX(), pointlbl.getY() -10);
	                break;
	            case KeyEvent.VK_DOWN:
	            	if(pointlbl.getY()+10 <= 260) pointlbl.setLocation(pointlbl.getX(), pointlbl.getY() +10);
	                break;
	            case KeyEvent.VK_LEFT:
	            	if(pointlbl.getX()-10 >= 0) pointlbl.setLocation(pointlbl.getX() -10, pointlbl.getY());
	                break;
	            case KeyEvent.VK_RIGHT:
	            	if(pointlbl.getX()+10 <= 290) pointlbl.setLocation(pointlbl.getX() +10, pointlbl.getY());
	                break;
	            }
			}
		};
		
		ActionListener shootListener=new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				//이미지 변경
				if((turnOfUser.getText()).equals(rabbitName)) {
					double delta_x = (pointlbl.getX() - 195)/100.0;
					double delta_y = (pointlbl.getY() - 113)/100.0;
					rabbit.run(delta_x, delta_y);
					UserImage2 userimage2=new UserImage2();
					frame.add(userimage2);
					userimage2.setVisible(true);
					//userimage1.setVisible(false);
					userimage2.setLayout(null);
					userimage2.setBounds(0, 250, 220, 70);
					turnOfUser.setText(tigerName);
					targetimage.requestFocus();
					wind.setText(tiger.return_windstr());
					audience.setText(tiger.return_crowdstr());
				    pointlbl.setLocation(195, 113);

				}else {
					double delta_x = (pointlbl.getX() - 195)/100.0;
					double delta_y = (pointlbl.getY() - 90)/100.0;
					tiger.run(delta_x, delta_y);
					UserImage1 userimage1=new UserImage1();
					frame.add(userimage1);
					userimage1.setVisible(true);
					//userimage2.setVisible(false);
					userimage1.setLayout(null);
					userimage1.setBounds(0, 250, 220, 70);
					turnOfUser.setText(rabbitName);
					targetimage.requestFocus();
					wind.setText(rabbit.return_windstr());
					audience.setText(rabbit.return_crowdstr());
				    pointlbl.setLocation(195, 113);
				    if(rabbit.get_round()+tiger.get_round()==20) {
				    	sc.showWIN(rabbit, tiger);
				    	RankPage next = new RankPage();
				    	next.showRanking_end(rabbit, tiger, sc, frame); //Player 정보 업데이트 + save 버튼
				    	frame.setVisible(false);
				    	
						Dimension dim=new Dimension(400,400);
						JFrame new_frame=new JFrame("The Rabbit and Tiger");	
						new_frame.setLocation(400, 400);	//창 위치 설정
						new_frame.setPreferredSize(dim);	//창 크기 설정
						new_frame.setResizable(false);		//창 크기 조절 불가 설정
						//첫번째 페이지로 frame 객체 전달
						StartPage return_to_startpage=new StartPage(new_frame);
						new_frame.pack();
						new_frame.setVisible(true);
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
//Rank 페이지
class RankPage{
	private String conditions[]= {"Rank","Name","Number of Win"};
	private String values[][];
	private JFrame frame=new JFrame("**Game Ranking**");
	private RankingFile rf = new RankingFile();

	//Constructor -랭킹 프레임 만들기
	public RankPage() {
		Dimension dim =new Dimension (400,300);
		frame.setLocation(200,400);
		frame.setPreferredSize(dim);
		frame.setResizable(false);
		frame.setFont(new Font("Helvetica",Font.BOLD,12));
		rf.load();
	}
	
	public void showRanking_home() {
		values= rf.getvalues();
		DefaultTableModel model=new DefaultTableModel(values,conditions);
		JTable table=new JTable(model);
		JScrollPane scrollpane =new JScrollPane(table);
		DefaultTableCellRenderer model_center = new DefaultTableCellRenderer();
		model_center.setHorizontalAlignment(SwingConstants.CENTER);
		TableColumnModel tcm = table.getColumnModel() ;
		for (int i = 0; i < tcm.getColumnCount(); i++) {
			tcm.getColumn(i).setCellRenderer(model_center);
		}

		table.setRowHeight(30);
		table.setBackground(Color.gray);
		table.setForeground(Color.white);
		frame.add(scrollpane,BorderLayout.CENTER);
		frame.pack();
		frame.setVisible(true);
	}

	//게임 후에 보여주는 랭킹(save 버튼존재)
	public void showRanking_end(Player p1, Player p2, Scoreboard sc, JFrame frame2) {
		rf.update_players(p1, p2);
		values= rf.getvalues();
		DefaultTableModel model=new DefaultTableModel(values,conditions);
		JTable table=new JTable(model);
		JScrollPane scrollpane =new JScrollPane(table);
		DefaultTableCellRenderer model_center = new DefaultTableCellRenderer();
		model_center.setHorizontalAlignment(SwingConstants.CENTER);
		TableColumnModel tcm = table.getColumnModel() ;
		for (int i = 0; i < tcm.getColumnCount(); i++) {
			tcm.getColumn(i).setCellRenderer(model_center);
		}

		table.setRowHeight(30);
		table.setBackground(Color.gray);
		table.setForeground(Color.white);
		JPanel panel =new JPanel();
		JButton save = new JButton("Return to Home");
		save.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				sc.quit_scoreboard();
				frame.setVisible(false);
			}
		});
		panel.add(save);
		frame.add(panel,BorderLayout.SOUTH);
		frame.add(scrollpane,BorderLayout.CENTER);
		frame.pack();
		frame.setVisible(true);
	}
}

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

//사용자 이미지, 토끼랑 사자
class UserImage1 extends JPanel{
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		Dimension d=new Dimension(220,70);
		Image img=Toolkit.getDefaultToolkit().getImage("playerRabbit2.png");
		g.drawImage(img,0,0,d.width,d.height,this);
	}
}
class UserImage2 extends JPanel{
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		Dimension d=new Dimension(220,70);
		Image img=Toolkit.getDefaultToolkit().getImage("playerTiger2.png");
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
		Image img=Toolkit.getDefaultToolkit().getImage("startPageImage.png");
		g.drawImage(img,0,0,d.width,d.height,this);
	}
}
