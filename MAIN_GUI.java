
import javax.swing.*;
import java.awt.*;
import java.awt.Label;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Container;
import javax.swing.table.DefaultTableModel;


public class MAIN_GUI {
	
	public static void main(String[] args) {
		
		//������ ���� 400*400�������
		Dimension dim=new Dimension(400,400);
		JFrame frame=new JFrame("The Rabbit and Tiger");	
		frame.setLocation(400, 400);	//â ��ġ ����
		frame.setPreferredSize(dim);	//â ũ�� ����
		frame.setResizable(false);		//â ũ�� ���� �Ұ� ����

		//ù��° �������� frame ��ü ����
		StartPage startpage=new StartPage(frame);
		
		frame.pack();
		frame.setVisible(true);
	}
}

//ù��° ������
class StartPage{
	
	public StartPage(JFrame frame){
		
		//ó���� �����ٰ� ���� COntainer�� ���� �� �ȿ� add �ϴ� ������ ���� ���������� �����
		Container contentPane=frame.getContentPane();
		
		
		//ù ������ �̹��� ���� ����
		StartPanelImage startImage=new StartPanelImage();
		frame.add(startImage);
		startImage.setVisible(true);
		
		
		//��ư�� ���� �г� ����
		FlowLayout layout=new FlowLayout();
		JPanel startButtonPanel1=new JPanel();
		startButtonPanel1.setLayout(layout);	//start��ư ���� �г� ����
		JPanel startButtonPanel2=new JPanel();
		startButtonPanel2.setLayout(layout);	//rank��ư ���� �г� ����
		JPanel startButtonPanel3=new JPanel();
		startButtonPanel3.setLayout(layout);	//quit��ư ���� �г� ����
		JPanel startButtonPanel4=new JPanel();
		startButtonPanel4.setLayout(layout);	//��ư�� ��ġ�� �г� ����

		//��ư�� �Ӽ����� ���� ����, ���߿� ���� ����
		//ù��° ������ START ��ư
		JButton startPageButton1=new JButton("Start");
		startPageButton1.setBackground(Color.gray);
		startPageButton1.setForeground(Color.WHITE);
		startPageButton1.setFont(new Font("Helvetica",Font.PLAIN,15));
		startPageButton1.setHorizontalAlignment(SwingConstants.CENTER);
		startPageButton1.setVerticalAlignment(SwingConstants.CENTER);
		startPageButton1.setSize(180, 60);
		
		//Start��ư Ŭ���� ����, ������������ frame ��ü�� �Ѱ���
				ActionListener startListener=new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						//������ �̹���,��ư�� �Ⱥ��̰� ����
						startImage.setVisible(false);
						startButtonPanel4.setVisible(false);
						SecondPage secondpage=new SecondPage(frame);
						
					}
				};
				//�� �Ʒ��� �ȽἭ 2�ð� ���� ���پ�
				startPageButton1.addActionListener(startListener);	
				
				
		//õ��° ������ RANK ��ư   
		JButton startPageButton2=new JButton("Rank");
		startPageButton2.setBackground(Color.gray);
		startPageButton2.setForeground(Color.WHITE);
		startPageButton2.setFont(new Font("Helvetica",Font.PLAIN,15));
		startPageButton2.setHorizontalAlignment(SwingConstants.CENTER);
		startPageButton2.setVerticalAlignment(SwingConstants.CENTER);
		startPageButton2.setSize(180, 60);
		//Rank�������� �̵�
		ActionListener rankListener=new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				startImage.setVisible(false);
				startButtonPanel4.setVisible(false);
				RankPage secondpage=new RankPage(frame);
				
			}
		};
		startPageButton2.addActionListener(rankListener);	
		
		
		//ù��° ������ Quit ��ư
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
		
		
		
		//�� ��ư�� ��ġ �����ؼ� �Ѱ��� �ǳڿ� ����
		startButtonPanel4.add(startPageButton1,BorderLayout.WEST);
		startButtonPanel4.add(startPageButton2,BorderLayout.CENTER);
		startButtonPanel4.add(startPageButton3,BorderLayout.EAST);
		
		//��ģ ��ư Frame�� ���� �̶� frame�� �ٷ� �������� �ʰ� �� ���� ���� Container�� ������
		contentPane.add(startButtonPanel4,BorderLayout.SOUTH);				//�����ӿ� �г��߰�
		startButtonPanel4.setVisible(true);	//��ư �߰��ϱ�
		
	}
}

//�ι�° ������, ID�Է��ϴ� ������
class SecondPage{
	
	//�̸� �����;��Ҷ� ���⼭ ��������
	public String rabbitName;
	public String tigerName;
	
	public SecondPage(JFrame frame) {
		
		Container contentPane=frame.getContentPane();
		
		
		//�г� 2���� ���� mainPanel�� ���� �� Container�� ����
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
		JPanel buttonPanel=new JPanel();	//Panel ����
		
		//�� ����
		Font font=new Font("Helvica",Font.BOLD,13);
		Label rabbitlbl=new Label("Rabbit");
		rabbitlbl.setFont(font);
		Label tigerlbl=new Label("Tiger");
		tigerlbl.setFont(font);
		
		//�� �ؽ�Ʈ�ʵ尡 ����ڰ� �Է��� �� �ְ� ����
		TextField rabbitIdText=new TextField("Name",20);
		TextField tigerIdText=new TextField("Name",20);
		
		//�� �гε鿡 �������ֱ�
		rabbitID.add(rabbitlbl);
		rabbitID.add(rabbitIdText);
		mainPanel.add(rabbitID);
		
		tigerID.add(tigerlbl);
		tigerID.add(tigerIdText);
		mainPanel.add(tigerID);
		
		//���������� �����ӿ� ����
		contentPane.add(mainPanel);
		
		//���� ��ư ����
		JButton startButton=new JButton("START!");
		startButton.setBackground(Color.gray);
		startButton.setForeground(Color.WHITE);
		startButton.setFont(new Font("Helvetica",Font.PLAIN,20));
		startButton.setHorizontalAlignment(SwingConstants.CENTER);
		startButton.setVerticalAlignment(SwingConstants.CENTER);
		startButton.setSize(180, 200);
		startButton.setVisible(true);
		//���۹�ư ������� �Ѿ��
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
//�÷��� ������
class PlayPage{
	
	
	public PlayPage(JFrame frame, String rabbitName,String tigerName) {
		
		
		Container contentPane=frame.getContentPane();
		System.out.printf("%s, %s",rabbitName, tigerName);
		
		//���� �̹���, Shoot��ư�� ������ ��� ���� �޾Ƽ� �´� �̹����� ���, �׸��� �ٽ� �����
		TargetImage targetimage=new TargetImage();
		targetimage.setVisible(true);
		targetimage.setLayout(null);
		targetimage.setBounds(0, 0, 400, 180);
		frame.add(targetimage);
		
		/*
		 * TO DO: �� �̹��� ����, Ű���� �Է¿� ���� �̵��ϰ� ��ġ�� �Ѱ��ִ� �۾�
		 * */
		
		//����� �̹���, Shoot��ư�� ���������� ����ǰ� �ϱ�
		UserImage1 userimage1=new UserImage1();
		frame.add(userimage1);
		userimage1.setVisible(true);
		userimage1.setLayout(null);
		userimage1.setBounds(0, 180, 220, 70);
		Label turnOfUser=new Label(rabbitName);
		
		//Conditions, �������� ��ü �����ؼ� �޾ƿ´��� Label�����ؼ� ���ļ� �����ϸ� ��
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
		
		
		//��ư ���������� ���̵� �������ֱ�
		Font font2=new Font("Helvica",Font.BOLD,15);
		Label userId=new Label(rabbitName);
		userId.setFont(font2);
		userId.setBounds(240,185, 200, 20);
		conditions.add(userId);
		contentPane.add(conditions);
		
		//SHOOT ��ư
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
				//�̹��� ����
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
				//�̸� ����
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
		
		
		contentPane.add(shootPanel,BorderLayout.SOUTH);				//�����ӿ� �г��߰�
	}
}
//Rank ������
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
		 * �߰� ���
		 * String inputStr[]=new String[3];
		 * model.addRow(inputStr);
		 */
		
		//conditionTable.setValueAt(1,1); �̷��Ĥ��� �� ����
	}
	
}
//���� �⺻ �̹��� 
class TargetImage extends JPanel{
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		Dimension d=new Dimension(400,200);
		Image img=Toolkit.getDefaultToolkit().getImage("C:\\Users\\moonkey\\Desktop\\JavaFinal\\bigTarget.png");
		g.drawImage(img,0,0,d.width,d.height,this);
	}
}

//����� �̹���, �䳢�� ����
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

//�� ó�� ���� ������ �̹���
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