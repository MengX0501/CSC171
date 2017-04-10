/*
 * File: GameCharacter.java
 * Creator: George Ferguson
 * Created: Mon Nov 23 09:21:40 2015
 * Time-stamp: <Mon Nov 23 15:42:04 EST 2015 ferguson>
 */
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 * Base class for characters that get drawn on the canvas.
 * This could be a true base class with abstract drawing method, but
 * I'm just going to use it for my main character so I won't bother with
 * that.
 */
public class GameCharacter {

	protected int centerX;
	protected int centerY;

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

	protected int width = 64;
	protected int height = 118;

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	protected int vX = 0;
	protected int vY = 0;

	protected void setHorizSpeed(int v) {
		vX = v;
	}

	protected void setVertSpeed(int v) {
		vY = v;
	}

	protected int G = 10; // "gravity"

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
	protected Image loadImage(String filename) {
		try {
			return ImageIO.read(new File(filename));
		} catch (IOException e) {
			System.err.println(e);
			return null;
		}
	}

	Image standingFrontImage = loadImage("graphics/character-standing-front.png");
	Image[] walkingRightImages = {
			loadImage("graphics/character-walking-right-1.png"),
			loadImage("graphics/character-walking-right-2.png"),
	};
	Image[] walkingLeftImages = {
			loadImage("graphics/character-walking-left-1.png"),
			loadImage("graphics/character-walking-left-2.png"),
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

	/**
	 * Called from the animation loop to update any time-dependent
	 * properties of this GameCharacter.
	 */
	// Might want time and/or other params
	public void update() {
		centerX += vX;
		centerX = Math.min(centerX, GameFrame.CANVAS_WIDTH-width/2);
		centerX = Math.max(width/2, centerX);
		vY += G;
		centerY += vY;
		if (centerY >= GameFrame.CANVAS_BASELINE-height/2) {
			centerY = GameFrame.CANVAS_BASELINE-height/2;
			vY = 0;
		}
	}

}
