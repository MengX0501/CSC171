/*
 * File: Powerup.java
 * Creator: George Ferguson
 * Created: Mon Nov 23 15:51:57 2015
 * Time-stamp: <Mon Nov 23 16:27:16 EST 2015 ferguson>
 */
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

public class Powerup extends Sprite {

	public Powerup(int x, int y) {
		super(x, y);
		width = 32;
		height = 32;

	}

	protected int seqnum = 0;
	protected int seqdir = +1;

	Image[] images = {
			ImageUtils.loadImage("graphics/star-coin-1.png"),
			ImageUtils.loadImage("graphics/star-coin-2.png"),
			ImageUtils.loadImage("graphics/star-coin-3.png"),
			ImageUtils.loadImage("graphics/star-coin-4.png"),
			ImageUtils.loadImage("graphics/star-coin-5.png"),
	};

	public void draw(Graphics g) {
		int x = centerX - 16;
		int y = centerY - 16;
		g.drawImage(images[seqnum], x, y, null);
	}

	public void update() {
		super.update();
		seqnum += seqdir;
		if (seqnum == images.length-1 || seqnum == 0) {
			seqdir *= -1;
		}
	}

}
