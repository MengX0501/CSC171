import javax.swing.*;

/**
 * Created by Bobby on 3/2/2017.
 */
public class MyCanvasApp {
    public static void main(String[] args) {

        JFrame frame = new JFrame("BIG RED");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        frame.add(new MyCanvas());

        frame.pack();
        frame.setVisible(true);

    }
}
