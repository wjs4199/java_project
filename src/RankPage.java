import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

//Rank 페이지
class RankPage{
	private String conditions[]= {"Rank","Name","Number of Win"};
	private String values[][];
	private JFrame frame=new JFrame("**Game Ranking**");
	private RankingFile rf = new RankingFile();

	//Constructor -랭킹 프레임 만들기
	public RankPage() {
		Dimension dim =new Dimension (400,300);
		frame.setLocation(690,150);
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
				frame2.setVisible(true);
			}
		});
		panel.add(save);
		frame.add(panel,BorderLayout.SOUTH);
		frame.add(scrollpane,BorderLayout.CENTER);
		frame.pack();
		frame.setVisible(true);
	}
}
