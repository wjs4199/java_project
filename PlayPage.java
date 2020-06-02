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

//�÷��� ������
class PlayPage{
	
	
	public PlayPage(JFrame frame, String rabbitName,String tigerName) {

		Player rabbit = new Player('r');
		rabbit.set_NAME(rabbitName);
		Player tiger = new Player('t');
		tiger.set_NAME(tigerName);
		//������ class Constructor
		Scoreboard sc= new Scoreboard(rabbit,tiger); //Player p1,Player p2 ���������
		
		Container contentPane=frame.getContentPane();
		
		//���� �̹���, Shoot��ư�� ������ ��� ���� �޾Ƽ� �´� �̹����� ���, �׸��� �ٽ� �����
	      
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
		
		
		//����� �̹���, Shoot��ư�� ���������� ����ǰ� �ϱ�
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
		
		//Conditions, �������� ��ü �����ؼ� �޾ƿ´��� Label�����ؼ� ���ļ� �����ϸ� ��
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
		
		
		//��ư ���������� ���̵� �������ֱ�
		Font font2=new Font("Helvica",Font.BOLD,16);
		Label userId=new Label(rabbitName);
		userId.setFont(font2);
		userId.setBounds(240, 250, 200, 30);
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

				//�̹��� ����
				if((turnOfUser.getText()).equals(rabbitName)) {
					double delta_x = (pointlbl.getX() - 195)/100.0;
					double delta_y = (pointlbl.getY() - 113)/100.0;
					rabbit.run(delta_x, delta_y);
					userimage1.setVisible(false);
					userimage2.setVisible(true);
					turnOfUser.setText(tigerName);
					targetimage.requestFocus();
					wind.setText(tiger.return_windstr());
					audience.setText(tiger.return_crowdstr());
				    pointlbl.setLocation(195, 113);

				}else {
					double delta_x = (pointlbl.getX() - 195)/100.0;
					double delta_y = (pointlbl.getY() - 113)/100.0;
					tiger.run(delta_x, delta_y);
					userimage1.setVisible(true);
					userimage2.setVisible(false);
					turnOfUser.setText(rabbitName);
					targetimage.requestFocus();
					wind.setText(rabbit.return_windstr());
					audience.setText(rabbit.return_crowdstr());
				    pointlbl.setLocation(195, 113);
				    if(rabbit.get_round()+tiger.get_round()==20) {
				    	sc.showWIN(rabbit, tiger);
				    	RankPage next = new RankPage();
				    	frame.setVisible(false);
						Dimension dim=new Dimension(400,400);
						JFrame new_frame=new JFrame("The Rabbit and Tiger");	
				    	next.showRanking_end(rabbit, tiger, sc, new_frame); //Player ���� ������Ʈ + save ��ư
						new_frame.setLocation(150, 150);	//â ��ġ ����
						new_frame.setPreferredSize(dim);	//â ũ�� ����
						new_frame.setResizable(false);		//â ũ�� ���� �Ұ� ����
						//ù��° �������� frame ��ü ����
						StartPage return_to_startpage=new StartPage(new_frame);
						new_frame.pack();
						//new_frame.setVisible(true);
				    }
				}
				//�̸� ����
				if((userId.getText()).equals(rabbitName)) {
					userId.setText(tigerName);
				}
				else {
					userId.setText(rabbitName);
				}
				//shoot�Ҷ����� �÷��̾����� �о�ͼ� ������ ������Ʈ
				sc.scorechange(rabbit, tiger); //Player p1, Player p2
			}
		};
		shootButton.addActionListener(shootListener);
		targetimage.addKeyListener(arrowListener);
		targetimage.requestFocus();
		shootPanel.add(shootButton);
		shootButton.setVisible(true);
		shootPanel.setVisible(true);
		contentPane.add(shootPanel,BorderLayout.SOUTH);				//�����ӿ� �г��߰�
	}
}