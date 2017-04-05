import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;

public class BouncingBallSlider extends JPanel {
	private JSlider slider;
	
	public BouncingBallSlider(int min, int max, int start) {
		setLayout(new BorderLayout());
		
		JLabel label = new JLabel("Slide to Adjust the Number of Balls", JLabel.CENTER);
		add(label, BorderLayout.NORTH);
		
		slider = new JSlider(min, max);
		slider.setValue(start);
		add(slider, BorderLayout.CENTER);
	}
	
	public JSlider getSlider() {
		return slider;
	}
}
