import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JFrame;
	
public class Explanation {
	
	private JFrame frame=new JFrame("Explanation");
	
	//Constructor - ÇÁ·¹ÀÓ ¸¸µé±â
	public Explanation() {
		Dimension dim =new Dimension (400,400);
		frame.setPreferredSize(dim);
		frame.setResizable(false);
		frame.setFont(new Font("Helvetica",Font.BOLD,12));
		frame.setBounds(160,170, 400, 400);
		
		ExplainImage explainimage=new ExplainImage();
		frame.add(explainimage);
		explainimage.setVisible(true);
		frame.setVisible(true);
	}
}
