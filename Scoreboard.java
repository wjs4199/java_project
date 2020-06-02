import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

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
		frame2.setLocation(535,150);
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