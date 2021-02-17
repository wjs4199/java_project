import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

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
		File description = new File("description.txt");
		Scanner read_file;
		String descript_str = "";
		try {
			read_file = new Scanner(description);
			while(read_file.hasNextLine()) {
				descript_str = descript_str + read_file.nextLine() +"\n";
			}
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		//설명과 설명 버튼 추가할 패널
		JPanel explainpanel=new JPanel();
		explainpanel.setLayout(layout);
		explainpanel.setBounds(50, 200, 300, 120);

				//설명 텍스트
		JTextArea txt = new JTextArea(descript_str);
		txt.setFont(font);
		txt.setLineWrap(true);
		txt.setWrapStyleWord(true);
		txt.setOpaque(false);
		txt.setEditable(false);
		txt.setVisible(true);
		txt.setBounds(50, 200, 300, 90);
		//추가설명 버튼
		JButton explain=new JButton("Explanation");
		explain.setBackground(Color.black);
		explain.setForeground(Color.yellow);
		explain.setFont(new Font("Helvetica",Font.PLAIN,17));
		explain.setVisible(true);
		explain.setHorizontalAlignment(SwingConstants.CENTER);
		explain.setVerticalAlignment(SwingConstants.CENTER);
		//explain.setBounds(100, 300, 80, 60);
		ActionListener explainListener=new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			Explanation ex=new Explanation();
			}
		};
		explain.addActionListener(explainListener);
		explainpanel.add(explain,BorderLayout.EAST);
		
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
		
		mainPanel.add(txt);
		mainPanel.add(explainpanel);
		mainPanel.add(explainpanel, BorderLayout.CENTER);

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
