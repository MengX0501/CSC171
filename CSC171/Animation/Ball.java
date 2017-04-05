import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class Ball {
	// random number generator
	private static final Random RNG = new Random();
	// the size of the ball
	private Rectangle size;
	// the movement of the ball
	private int deltaX;
	private int deltaY;
	
	public Ball(int x, int y, int diameter) {		
		size = new Rectangle(x, y, diameter, diameter);
		this.deltaX = getRandomSpeed();
		this.deltaY = getRandomSpeed();	
	}
	
	public void move() {
		// move the ball
		size.setLocation(size.x + deltaX, size.y + deltaY);
	}
	
	// draw the ball at its current location
	public void draw(Graphics g) {
		g.setColor(Color.RED);
		g.fillOval(size.x,  size.y,  size.width,  size.height);
	}
	
	public void checkBounds(Dimension space) {
		if(size.x + size.width > space.width || size.x < 0) {
            // if it's gone off the edge, reverse direction
            deltaX = -deltaX;
        }

        if(size.y + size.height > space.height || size.y < 0) {
            // if it's gone off the edge, reverse direction
            deltaY = -deltaY;
        }
	}
	
	private static int getRandomSpeed() {
		int base = RNG.nextInt(30) + 2;
		return RNG.nextInt(2) == 0 ? -base : base;
	}
}
