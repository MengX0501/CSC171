import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.WindowConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class BouncingBallFrame extends JFrame {
	
	private ImprovedBouncingBall ibb;
	private BouncingBallSlider slider;
	
	public BouncingBallFrame(int min, int max, int start) {
		super("Bouncing Balls!");
		
		// set the layout on the frame itself
		setLayout(new BorderLayout());
		
		// add the "bouncing ball" component to the center
		ibb = new ImprovedBouncingBall(start);
		add(ibb, BorderLayout.CENTER);
		
		// add the bouncing ball slider
		slider = new BouncingBallSlider(5, 50, start);
		add(slider, BorderLayout.SOUTH);
		
		// the frame will listen for the slider value to change and, if it does,
		// change the number of balls in the ibb...
		slider.getSlider().addChangeListener(new ChangeListener() {
			
			@Override
			public void stateChanged(ChangeEvent e) {
				ibb.setNumberOfBalls(slider.getSlider().getValue());
			}
		});
	}
	
	public static void main(String[] args) {
		BouncingBallFrame frame = new BouncingBallFrame(5, 30, 10);
		frame.pack();
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

}
