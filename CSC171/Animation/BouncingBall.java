import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

/**
 * Created by Bobby on 3/27/2017.
 */
public class BouncingBall extends JComponent {
    private Rectangle bBox;
    private int deltaX;
    private int deltaY;

    public BouncingBall() {
        // the bounding box of the ball
        bBox = new Rectangle(100, 100, 100, 100);
        // how many pixels in each direction the X and Y coordinates change
        deltaX = 10;
        deltaY = 10;

        // the timer that controls how often the component is updated and painted
        Timer timer = new Timer(80, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // update the state
                updateBall();
                // repaint
                repaint();
            }
        });
        // start the timer!
        timer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Dimension size = getSize();

        // fill the background with black
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, size.width, size.height);
        // paint the ball in red
        g.setColor(Color.RED);
        g.fillOval(bBox.x, bBox.y, bBox.width, bBox.height);
    }

    private void updateBall() {
        // move the ball
        bBox.x += deltaX;
        bBox.y += deltaY;

        // make sure that the ball hasn't gone off the edge of the screen
        Dimension size = getSize();
        if(bBox.x + bBox.width > size.width || bBox.x < 0) {
            // if it's gone off the edge, reverse direction
            deltaX = -deltaX;
        }

        if(bBox.y + bBox.height > size.height || bBox.y < 0) {
            // if it's gone off the edge, reverse direction
            deltaY = - deltaY;
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Bouncing Ball");
        frame.add(new BouncingBall());
        frame.setSize(640, 480);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
