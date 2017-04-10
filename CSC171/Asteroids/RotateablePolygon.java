import java.awt.Point;
import java.awt.Polygon;
import java.awt.Rectangle;
import java.awt.geom.AffineTransform;

public class RotateablePolygon extends Polygon {
	public RotateablePolygon(int[] xpoints, int[] ypoints) {
		super(xpoints, ypoints, xpoints.length);
	}
	
	public void rotate(double angle) {
		Rectangle bBox = getBounds();
		
		Point[] start = new Point[npoints];
		for(int i=0; i<npoints; i++) {
			start[i] = new Point(xpoints[i], ypoints[i]);
		}
		
		Point[] end = new Point[npoints];
		for(int i=0; i<end.length; i++) {
			end[i] = new Point(start[i].x, start[i].y);
		}
		
		AffineTransform rotation = 
				AffineTransform.getRotateInstance(Math.toRadians(angle), 
						bBox.getCenterX(), bBox.getCenterY());
		rotation.transform(start, 0, end, 0, npoints);
		
		reset();
		for(Point point : end) {
			addPoint(point.x, point.y);
		}
		
		invalidate();
	}
}
