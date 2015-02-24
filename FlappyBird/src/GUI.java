import java.applet.AudioClip;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.*;

/**
 * @author P. Brack taken from example by John B. Matthews; distribution per GNU
 *         Public License
 */
public class GUI extends JApplet {
	 AudioClip clip;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {

			public void run() {
				JFrame frame = new JFrame();
				frame.setTitle("Flappy Bird Game");
				initContainer(frame);
				frame.pack();
				frame.setVisible(true);
			}
		});
	}

	// Common initialization for either JApplet or JFrame
	private static void initContainer(Container container) {
		// will need to hook up the clicking.
		GraphicsPanel subway = new GraphicsPanel();
		// container.add(Box.createVerticalStrut(8), BorderLayout.NORTH);
		container.add(subway, BorderLayout.CENTER);
		subway.beginOperation();
	}
   public void playSound() { 
	        clip.play();

	    }

	@Override
	public void init() {
		
		clip  = getAudioClip(getDocumentBase(), "gun.wav");
		System.out.println("Initializing...");
		EventQueue.invokeLater(new Runnable() {

			public void run() {
				initContainer(GUI.this);
			}
		});

	}

	@Override
	public void destroy() {
		System.out.println("That's all, folks...");
	}
}

class GraphicsPanel extends JPanel implements ActionListener, KeyListener {

	Game gameBoard;
	private int lastPressedKey;

	private int xx = 0;
	private int yy = 0;

	private Timer timer = new Timer(100, this);

	private boolean loading;

	public GraphicsPanel() {
		super(true);
		lastPressedKey = KeyEvent.VK_COMMA;
		setPreferredSize(new Dimension(800, 400));
		addKeyListener(this);
		setFocusable(true);
		try {
			gameBoard = new Game(timer);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}


	public void beginOperation() {
		timer.setInitialDelay(200);
		timer.start();
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		gameBoard.updateGraphics(g, getWidth(), getHeight(), lastPressedKey);
		lastPressedKey = KeyEvent.VK_ESCAPE;
	}

	// Handle Timer events
	public void actionPerformed(ActionEvent e) {

		// do some work.
		this.repaint();
	}

	@Override
	public void keyPressed(KeyEvent e) {
		lastPressedKey = e.getKeyCode();

	}

	@Override
	public void keyReleased(KeyEvent e) {

	}

	@Override
	public void keyTyped(KeyEvent e) {

	}
}