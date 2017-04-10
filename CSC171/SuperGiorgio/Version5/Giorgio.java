/*
 * File: Giorgio.java
 * Creator: George Ferguson
 * Created: Mon Nov 23 09:21:40 2015
 * Time-stamp: <Mon Nov 23 16:21:17 EST 2015 ferguson>
 */
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

/**
 * Sprite representing our character in the SuperGiorgio game.
 */
public class Giorgio extends GravitySprite {

	public Giorgio(int x, int y) {
		super(x, y);
		// Size of images used for animation (below)
		width = 64;
		height = 118;
	}

	/**
	 * Direction a GameCharacter is facing or moving.
	 * UP, DOWN, LEFT, and RIGHT are relative to screen.
	 * OUT means facing out at the player.
	 * IN means facing into the screen away from the player.
	 */
	public enum Direction {
		NONE, UP, DOWN, LEFT, RIGHT, OUT, IN;
	}

	protected Direction facing = Direction.OUT;
	protected Direction moving = Direction.NONE;
	
	public void setFacing(Direction d) {
		facing = d;
	}

	public void setMoving(Direction d) {
		moving = d;
	}

	/**
	 * The possible states that a character can be in.
	 */
	public enum State {
		STANDING, WALKING, JUMPING, FALLING;
	}

	protected State state = State.STANDING;

	public void setState(State s) {
		state = s;
	}

	protected int walkingSeqnum = 0;

	//
	// Graphics resources
	//
	Image standingFrontImage =
			ImageUtils.loadImage("graphics/character-standing-front.png");
	Image[] walkingRightImages = {
			ImageUtils.loadImage("graphics/character-walking-right-1.png"),
			ImageUtils.loadImage("graphics/character-walking-right-2.png"),
	};
	Image[] walkingLeftImages = {
			ImageUtils.loadImage("graphics/character-walking-left-1.png"),
			ImageUtils.loadImage("graphics/character-walking-left-2.png"),
	};

	/**
	 * Called from canvas paintComponent method to draw this GameCharacter.
	 */
	// Might want canvas rather than graphics context
	public void draw(Graphics g) {
		int x = centerX - width/2;
		int y = centerY - height/2;
		switch(state) {
		case STANDING:
			g.drawImage(standingFrontImage, x, y, null);
			break;
		case WALKING:
			switch (facing) {
			case RIGHT:
				g.drawImage(walkingRightImages[walkingSeqnum], x, y, null);
				break;
			case LEFT:
				g.drawImage(walkingLeftImages[walkingSeqnum], x, y, null);
				break;
			}
			walkingSeqnum = (walkingSeqnum + 1) % walkingRightImages.length;
			break;
		}
	}

}
