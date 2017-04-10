import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.Timer;
import javax.swing.WindowConstants;

public class Asteroids extends JComponent implements Canvas {
	private static final Random RNG = new Random();
	
	private Color background;
	private Color foreground;
	
	private AnimatedPolygon[] asteroids;
	
	public Asteroids(Color background, Color foreground) {
		this.background = background;
		this.foreground = foreground;
		asteroids = new AnimatedPolygon[10];
		for(int i=0; i<asteroids.length; i++) {
			asteroids[i] = new Asteroid(RNG.nextInt(600), RNG.nextInt(400), RNG.nextInt(2) + 1, foreground, this);
		}
		
		Timer timer = new Timer(80, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				update();
				repaint();				
			}
			
		});
		
		timer.start();
	}
	
	public void update() {
		for(AnimatedPolygon asteroid : asteroids) {
			asteroid.update();
		}
	}
	
	@Override
	public void paintComponent(Graphics g) {		
		Dimension size = getSize();
		g.setColor(background);
		g.fillRect(0, 0, size.width, size.height);
		
		for(AnimatedPolygon asteroid : asteroids) {
			asteroid.draw(g);
		}
	}
	
	public static void main(String[] args) {
		JFrame frame = new JFrame("Asteroids!");
		frame.add(new Asteroids(Color.BLACK, Color.WHITE));
		frame.setSize(640,  480);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}

