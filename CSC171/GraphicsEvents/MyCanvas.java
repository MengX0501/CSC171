import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Created by Bobby on 3/2/2017.
 */
public class MyCanvas extends JComponent implements MouseListener {
    private int lastClickX = -1;
    private int lastClickY = -1;

    public MyCanvas() {
        addMouseListener(this);
    }

    @Override
    protected void paintComponent(Graphics g) {
        g.setColor(Color.RED);

        Dimension size = getSize();

        g.fillRect(0, 0, size.width, size.height);

        if(lastClickX > 0 && lastClickY > 0) {
            drawCircle(g, Color.YELLOW, true, lastClickX, lastClickY, 50);
            drawCircle(g, Color.BLACK, false, lastClickX, lastClickY, 50);
        }

    }

    public void drawCircle(Graphics g, Color color, boolean filled,
                           int centerX, int centerY, int radius) {
        int x = centerX - radius;
        int y = centerY - radius;

        g.setColor(color);

        if(filled) {
            g.fillOval(x, y, radius * 2, radius * 2);
        }
        else {
            g.drawOval(x, y, radius*2, radius*2);
        }
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(640, 480);
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        System.out.println("mouse clicked");
        lastClickX = e.getX();
        lastClickY = e.getY();
        repaint();
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
