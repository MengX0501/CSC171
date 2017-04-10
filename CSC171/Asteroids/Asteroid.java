import java.awt.Color;
import java.awt.Polygon;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Asteroid extends AnimatedPolygon {
	private static final Random RNG = new Random();
	
	private RotateablePolygon polygon;
	private int angle;

	public Asteroid(int x, int y, int scale, Color color, Canvas canvas) {
		super(getPolygon(x, y, scale), color, canvas, getDelta(5, 15), getDelta(5, 15));
		polygon = (RotateablePolygon)getPolygon();
		angle = RNG.nextInt(20);
		//polygon.rotate(angle);
		
		
	}
	
	@Override
	public void update() {
		super.update();
		//polygon.rotate(angle);
	}
	
	public static RotateablePolygon getPolygon(int x, int y, int scale) {
		int[] xpoints = {
				x+(20*scale),
				x+(40*scale),
				x+(60*scale),
				x+(70*scale),
				x+(60*scale),
				x+(70*scale),
				x+(50*scale),
				x+(30*scale),
				x+(20*scale),
				x,
				x+(10*scale),
				x
		};
		
		int[] ypoints = {
				y,
				y+(10*scale),
				y,
				y+(10*scale),
				y+(20*scale),
				y+(30*scale),
				y+(70*scale),
				y+(40*scale),
				y+(50*scale),
				y+(30*scale),
				y+(20*scale),
				y+(20*scale)
		};
		return new RotateablePolygon(xpoints, ypoints);
	}
	
	private static int getDelta(int min, int max) {
		int delta = RNG.nextInt(max-min) + min + 1;
		int coin = RNG.nextInt(2);
		if(coin == 0) {
			delta = -delta;
		}
		return delta;
	}
}
