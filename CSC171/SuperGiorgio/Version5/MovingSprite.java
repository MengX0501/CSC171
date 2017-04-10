/**
 * A Moving Sprite is a Sprite that has horizontal and vertical
 * speed and acceleration (which can of course be 0), and updates
 * its position based on these at each call to update().
 */
abstract public class MovingSprite extends Sprite {

	public MovingSprite(int x, int y) {
		super(x, y);
	}

	protected int vX = 0;
	protected int vY = 0;
	protected int aX = 0;
	protected int aY = 0;
	
	protected void setHorizSpeed(int v) {
		vX = v;
	}

	protected void setVertSpeed(int v) {
		vY = v;
	}

	protected void setHorizAccel(int a) {
		aX = a;
	}

	protected void setVertAccel(int a) {
		aY = a;
	}

	/**
	 * Called from the animation loop to update the position of this
	 * MovingSprite.
	 */
	public void update() {
		super.update();
		// Update velocity from acceleration
		vX += aX;
		vY += aY;
		// Update position from velocity
		centerX += vX;
		centerY += vY;
		// Limit checks for sprite motion
		centerX = Math.min(centerX, GameFrame.CANVAS_WIDTH-width/2);
		centerX = Math.max(width/2, centerX);
		if (centerY >= GameFrame.CANVAS_BASELINE-height/2) {
			centerY = GameFrame.CANVAS_BASELINE-height/2;
			vY = 0;
		}
	}

}
