/*
 * File: GameFrame.java
 * Creator: George Ferguson
 * Created: Sat Nov 21 15:55:22 2015
 * Time-stamp: <Mon Nov 23 15:51:00 EST 2015 ferguson>
 */
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 * Main class for the videogame.
 */
public class GameFrame extends JFrame {

	protected static final String FRAME_TITLE = "SuperGiorgio";
	protected static final int TIMER_DELAY = 100; // ms
	protected static final int CANVAS_WIDTH = 640;
	protected static final int CANVAS_HEIGHT = 480;
	protected static final int CANVAS_BASELINE = 450;

	public GameFrame() {
		initGraphics();
		initHandlers();
		initCharacter();
		initTimer();
	}

	protected GraphicsCanvas canvas;

	protected void initGraphics() {
		setTitle(FRAME_TITLE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
		setLayout(new BorderLayout());
		canvas = new GraphicsCanvas();
		canvas.setPreferredSize(new Dimension(CANVAS_WIDTH, CANVAS_HEIGHT));
		add(canvas, BorderLayout.CENTER);
		pack();
	}

	protected Timer timer;

	protected void initTimer() {
		timer = new Timer(TIMER_DELAY, new TimerHandler());
	}

	protected void initHandlers() {
		canvas.addKeyListener(new KeyHandler());
	}

	/**
	 * Start the game by making the frame visible and starting the
	 * animation timer.
	 */
	public void start() {
		setVisible(true);
		timer.start();
	}


	//
	// Character
	//

	GameCharacter character = new GameCharacter();

	protected void initCharacter() {
		character = new GameCharacter();
		int x = CANVAS_WIDTH/2-character.getWidth()/2;
		int y = CANVAS_BASELINE-character.getHeight()/2;
		character.setLocation(x, y);
		character.setFacing(GameCharacter.Direction.OUT);
		character.setMoving(GameCharacter.Direction.NONE);
		character.setState(GameCharacter.State.STANDING);
	}

	/**
	 * Graphic canvas panel.
	 */
	protected class GraphicsCanvas extends JPanel {
		public GraphicsCanvas() {
		    setFocusable(true);
		}
		@Override
		public void paintComponent(Graphics g) {
			//System.out.println("GraphicsCanvas.paintComponent");
			character.draw(g);
		}
	}

	/**
	 * Timer callback handler. Updates everything and schedules
	 * a repaint.
	 */
	protected class TimerHandler implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			//System.out.println("TimerHandler.actionPerformed");
			character.update();
			repaint();
		}
	}

	/**
	 * KeyListener handles keypresses in game.
	 */
	protected class KeyHandler implements KeyListener {
		boolean leftPressed = false;
		boolean rightPressed = false;
		public void keyPressed(KeyEvent e) {
			//System.out.println("GameFrame.keyPressed: " + e);
			switch (e.getKeyCode()) {
			case KeyEvent.VK_RIGHT:
				rightPressed = true;
				startMovingRight();
				break;
			case KeyEvent.VK_LEFT:
				leftPressed = true;
				startMovingLeft();
				break;
			case KeyEvent.VK_UP:
				startJumping();
				break;
			}
		}
		public void keyReleased(KeyEvent e) {
			//System.out.println("GameFrame.keyReleased: " + e);
			switch (e.getKeyCode()) {
			case KeyEvent.VK_RIGHT:
				rightPressed = false;
				if (leftPressed) {
					startMovingLeft();
				} else {
					stopMoving();
				}
				break;
			case KeyEvent.VK_LEFT:
				leftPressed = false;
				if (rightPressed) {
					startMovingRight();
				} else {
					stopMoving();
				}
				break;
			case KeyEvent.VK_UP:
				stopJumping();
				break;
			}
		}
		public void keyTyped(KeyEvent e) {
		}
	}

	protected void startMovingRight() {
		//System.out.println("GameFrame.startMovingRight");
		character.setHorizSpeed(+5);
		character.facing = GameCharacter.Direction.RIGHT;
		character.state = GameCharacter.State.WALKING;
	}

	protected void startMovingLeft() {
		//System.out.println("GameFrame.startMovingRight");
		character.setHorizSpeed(-5);
		character.facing = GameCharacter.Direction.LEFT;
		character.state = GameCharacter.State.WALKING;
	}

	protected void stopMoving() {
		//System.out.println("GameFrame.stopMoving");
		character.setHorizSpeed(0);
		character.facing = GameCharacter.Direction.OUT;
		character.state = GameCharacter.State.STANDING;
	}

	protected void startJumping() {
		character.setVertSpeed(-50);
	}

	protected void stopJumping() {
	}

	public static void main(String[] argv) {
		new GameFrame().start();
	}

}
