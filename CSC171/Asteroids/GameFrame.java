import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.WindowConstants;

public class GameFrame extends JFrame {
	private static final Random RNG = new Random();
	
	private GameCanvas canvas;
	
	public GameFrame() {
		setLayout(new BorderLayout());
		canvas = new GameCanvas(Color.RED);
		add(canvas, BorderLayout.CENTER);
		
		JPanel bottom = new JPanel();
		bottom.setLayout(new FlowLayout(FlowLayout.CENTER));
		JButton colorChanger = new JButton("Change Color!");
		bottom.add(colorChanger);
		colorChanger.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Color should change!");
				int r = RNG.nextInt(255);
				int g = RNG.nextInt(255);
				int b = RNG.nextInt(255);
				Color c = new Color(r, g, b);
				canvas.setBackgroundColor(c);	
				repaint();
			}
		});
		add(bottom, BorderLayout.SOUTH);
		
		Timer timer = new Timer(100, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				update();
			}
		});
		timer.start();
	}
	
	private void update() {
		System.out.println("update called!");
		System.out.println("Color should change!");
		int r = RNG.nextInt(255);
		int g = RNG.nextInt(255);
		int b = RNG.nextInt(255);
		Color c = new Color(r, g, b);
		canvas.setBackgroundColor(c);	
		repaint();
	}
	
	public static void main(String[] args) {
		GameFrame frame = new GameFrame();
		frame.pack();
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
