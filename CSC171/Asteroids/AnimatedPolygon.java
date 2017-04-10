import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Polygon;
import java.awt.Rectangle;

public class AnimatedPolygon implements Animated {
	private Canvas canvas;
	private Color color;
	private Polygon shape;
	private int deltaX;
	private int deltaY;
	
	public AnimatedPolygon(Polygon shape, Color color, Canvas canvas, int deltaX, int deltaY) {
		this.shape = shape;
		this.color = color;
		this.canvas = canvas;
		this.deltaX = deltaX;
		this.deltaY = deltaY;
	}
	
	public int getDeltaX() {
		return deltaX;
	}

	public void setDeltaX(int deltaX) {
		this.deltaX = deltaX;
	}

	public int getDeltaY() {
		return deltaY;
	}

	public void setDeltaY(int deltaY) {
		this.deltaY = deltaY;
	}
	
	public Polygon getPolygon() {
		return shape;
	}

	@Override
	public void update() {
		// move the shape
		shape.translate(deltaX,  deltaY);
		
		// check to see if it is off the screen
		Dimension size = canvas.getSize();
		Rectangle bBox = shape.getBounds();
		// is it off the screen horizontally?
		if(bBox.x > size.width) {
			shape.translate(-(bBox.width + size.width), 0);
		}
		else if(bBox.x + bBox.width < 0) {
			shape.translate(size.width + bBox.width, 0);
		}
		// is it off the screen vertically?
		if(bBox.y > size.height) {
			shape.translate(0, -(bBox.height + size.height));
		}
		else if(bBox.y + bBox.height < 0) {
			shape.translate(0, size.height + bBox.height);
		}
	}
	
	@Override
	public void draw(Graphics g) {
		g.setColor(color);
		g.drawPolygon(shape);
	}
}
