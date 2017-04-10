import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

/**
 * A Sprite occupies a rectangular region on the screen into which it
 * draws itself. It also has an update method that is called from the
 * timer loop to animate the sprite.
 */
abstract public class Sprite {
	
	protected int centerX;
	protected int centerY;
	
	public Sprite(int x, int y) {
		setLocation(x, y);
	}

	public void setLocation(int x, int y) {
		centerX = x;
		centerY = y;
	}

	public int getX() {
		return centerX;
	}

	public int getY() {
		return centerY;
	}

	protected int width;
	protected int height;

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public Rectangle getRect() {
		return new Rectangle(centerX-width/2, centerY-height/2, width, height);
	}


	protected int G = 10; // "gravity" (which can be 0 for some sprites!)

	/**
	 * Called from canvas paintComponent method to draw this Sprite.
	 * This method must be provided by subclasses.
	 */
	abstract public void draw(Graphics g);

	/**
	 * Called from the animation loop to update any time-dependent
	 * properties of this Sprite.
	 * This is a no-op for the base Sprite class.
	 */
	public void update() {
	}

}
