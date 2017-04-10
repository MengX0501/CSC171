import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JComponent;

public class GameCanvas extends JComponent {
	private Color background;
	
	public GameCanvas(Color bg) {
		background = bg;
	}
	
	public void setBackgroundColor(Color bg) {
		background = bg;
	}
	
	@Override
	public void paintComponent(Graphics g) {
		Dimension size = getSize();
		g.setColor(background);
		g.fillRect(0, 0, size.width, size.height);
	}
	
	@Override
	public Dimension getPreferredSize() {
		return new Dimension(640, 480);
	}
}
