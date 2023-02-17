import java.awt.BorderLayout;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class Canvas extends JFrame{
	
//	JPanel canvas=null;
	Canvas(String function){
		setTitle("Functions Drawer");
		setSize(500,500);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
		setLayout(new BorderLayout());
	//	canvas = new JPanel();
		CanvasOnPanel canPan = new CanvasOnPanel();
		
		add(canPan);
		canPan.drawFunc();
	//	canPan.repaint();
		
	//	add(canvas, BorderLayout.CENTER);
		
		
		
		setVisible(true);
	}
	

}
