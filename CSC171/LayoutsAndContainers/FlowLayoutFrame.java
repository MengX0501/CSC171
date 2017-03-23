import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.WindowConstants;

public class FlowLayoutFrame extends JFrame {
	
	public FlowLayoutFrame() {
		super("Flow Layout Frame");
		
		
		setLayout(new BorderLayout());
		
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		panel.add(new JButton("LEFT"));
		panel.add(new JButton("Middle"));
		panel.add(new JButton("Right"));
	
		add(panel, BorderLayout.SOUTH);
		
		
		JTextArea area = new JTextArea(40, 80);
		add(area, BorderLayout.CENTER);
		
		
		JPanel north = new JPanel();
		north.setLayout(new GridLayout(5, 1));
		for(int i=0; i<5; i++) {
			north.add(new JLabel("Label " + i));
		}
		add(north, BorderLayout.NORTH);
		
		
	}
	
	public static void main(String args[] ) {
		FlowLayoutFrame frame = new FlowLayoutFrame();
		
		
		
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}

}
