package bradleyross.swing;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.lang.reflect.InvocationTargetException;
import java.awt.event.KeyEvent;
import java.awt.Graphics;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import java.util.Random;
/**
 * This Swing demo creates a JPanel component and randomly 
 * moves a red dot within the panel when triggered by a
 * timer.
 * 
 * <p>Try changing the size of the window to see how it affects the relationship between
 *    the button and the panel where the graphics are generated.</p>
 * 
 * <p>The {@link java.util.Timer} object was replaced with a {@link javax.swing.Timer} object.</p>
 * 
 * @author Bradley Ross
 *
 */
public class SwingTimer implements Runnable {
	protected JFrame mainFrame;
	protected FlowLayout layout;
	protected MyPanel panel;
	/**
	 * x-coordinate of red dot in pixels.
	 */
	protected int xPos = 0;
	/**
	 * y-coordinate of red dot in pixels.
	 */
	protected int yPos = 0;
	protected Random random = new Random();
	/**
	 * Timer object for this application.
	 */
	protected Timer timer;
	/**
	 * This method is triggered by the Swing utilities.
	 */
	public void run() {
		buildFrame();
	}
	/**
	 * Action listener for this application for the
	 * buttons in this application.
	 * 
	 * @author Bradley Ross
	 *
	 */
	protected class Listener1 implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			System.out.println("Action " + e.getActionCommand());
		}
	}
	/**
	 * Key listener for this application.
	 * 
	 * @author Bradley Ross
	 *
	 */
	protected class Listener2 implements KeyListener {
		/** 
		 * Action when key event is detected.
		 *  @param e key event
		 */
		public void keyTyped(KeyEvent e) {
			System.out.println("Keystroke received " + e.getKeyChar());
		}
		public void keyPressed(KeyEvent e) { ; }
		public void keyReleased(KeyEvent e) { ; }
		
	}
	/**
	 * This subclass of JPanel represents the
	 * panel where the graphics are displayed.
	 * 
	 * <p>It repaints the
	 *    the dot using {@link SwingTimer#xPos} and 
	 *    {@link SwingTimer#yPos}.</p>
	 * 
	 * @author Bradley Ross
	 *
	 */
	@SuppressWarnings("serial")
	protected class MyPanel extends JPanel {
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.fillOval(xPos,  yPos, 5, 5);
		}
	}
	/**
	 * Executed each time the timer triggers an event.
	 * 
	 * <p>It randomly repositions the dot within the
	 *    panel by changing {@link SwingTimer#xPos} and 
	 *    {@link SwingTimer#yPos}.  After this the
	 *    repaint method of the panel causes the
	 *    contents to be repainted using the
	 *    {@link MyPanel#paintComponent(Graphics)}
	 *    method.
	 *    </p>
	 * @author Bradley Ross
	 *
	 */
	protected class Motion implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			xPos = random.nextInt(300);
			yPos = random.nextInt(300);
			panel.repaint();
		}
	}
	/**
	 * Creates and sets up components in frame.
	 */
	protected void buildFrame() {
		xPos = random.nextInt(300);
		yPos = random.nextInt(300);
		KeyListener listener2 = new Listener2();
		ActionListener listener1 = new Listener1();
		mainFrame = new JFrame();
		layout = new FlowLayout(FlowLayout.LEADING);
		mainFrame.setLayout(layout);
		mainFrame.addKeyListener(listener2);
		JButton first = new JButton("First");
		first.setActionCommand("first");
		first.addActionListener(listener1);
		first.addKeyListener(listener2);
		first.setFocusable(false);
		mainFrame.add(first);
		mainFrame.setFocusable(true);
		panel = new MyPanel();
		panel.setBorder(BorderFactory.createLineBorder(Color.black));
		panel.setPreferredSize(new Dimension(300,300));
		panel.setForeground(Color.red);
		panel.addKeyListener(listener2);
		panel.repaint();
		timer = new Timer(2000, new Motion());
		timer.start();
		mainFrame.add(panel);
		mainFrame.setSize(500, 500);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setVisible(true);
	}
	/**
	 * Main driver.
	 * @param args not used in this example
	 */
	public static void main(String[] args) {
		try {
			SwingUtilities.invokeAndWait(new SwingTimer());
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
