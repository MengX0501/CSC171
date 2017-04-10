/*
 * File: ImageUtils.java
 * Creator: George Ferguson
 * Created: Mon Nov 23 15:58:32 2015
 * Time-stamp: <Mon Nov 23 16:07:29 EST 2015 ferguson>
 */

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class ImageUtils {

	public static Image loadImage(String filename) {
		try {
			return ImageIO.read(new File(filename));
		} catch (IOException e) {
			System.err.println(e);
			return null;
		}
	}

}
