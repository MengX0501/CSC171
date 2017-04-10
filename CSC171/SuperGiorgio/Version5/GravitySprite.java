
/**
 * A GravitySprite is a MovingSprite whose vertical acceleration
 * is always the force of gravity. You wouldn't want this if
 * you modeled true vertical acceleration, but it's ok for a
 * jumping SuperGiorgio which gets instantaneous vertical velocity
 * when it jumps.
 */
abstract public class GravitySprite extends MovingSprite {

	public static int GRAVITY = 10;
	
	public GravitySprite(int x, int y) {
		super(x, y);
		aY = GRAVITY;
	}
	
}
