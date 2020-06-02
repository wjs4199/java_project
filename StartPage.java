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
				RankPage secondpage=new RankPage();
				secondpage.showRanking_home();
				
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