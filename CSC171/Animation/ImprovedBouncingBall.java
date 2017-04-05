import javax.swing.*;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Bobby on 3/27/2017.
 */
public class ImprovedBouncingBall extends JComponent {
	// used for random ball location
	private static final Random RNG = new Random();
	
	private List<Ball> balls;

    public ImprovedBouncingBall(int numberOfBalls) { 
    	balls = new ArrayList<>(numberOfBalls);
    	setNumberOfBalls(numberOfBalls);

        // the timer that controls how often the component is updated and painted
        Timer timer = new Timer(100, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // update the state
                updateBall();
                // repaint
                repaint();
            }
        });
        // start the timer!
        timer.start();
    }
    
    public void setNumberOfBalls(int numberOfBalls) {
    	int current = balls.size();
    	while(current > numberOfBalls) {
    		current = current - 1;
    		balls.remove(current);
    	}
    	while(current < numberOfBalls) {
    		balls.add(generateRandomBall());
    		current = current + 1;
    	}
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Dimension size = getSize();

        // fill the background with black
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, size.width, size.height);
        // paint the ball in red
        for(Ball ball : balls) {
        	ball.draw(g);
        }
    }

    private void updateBall() {
    	Dimension size = getSize();
        for(Ball ball : balls) {
        	ball.checkBounds(size);
        	
        	ball.move();
        }
    }

    @Override
    public Dimension getPreferredSize() {
    	return new Dimension(800, 600);
    }
    
    private Ball generateRandomBall() {
    	Dimension size = getSize();
    	size = size.width > 0 ? size : getPreferredSize();
    	int diameter = RNG.nextInt(50) + 50;
    	
    	return new Ball(RNG.nextInt(size.width - diameter), RNG.nextInt(size.height - diameter), diameter);
    }
    
}

