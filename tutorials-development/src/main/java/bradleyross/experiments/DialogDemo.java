package bradleyross.experiments;
// import javax.swing.JDialog;
// import javax.swing.JTextPane;
import javax.swing.JOptionPane;
import javax.swing.JFrame;
// import java.awt.GridLayout;
import java.awt.Dimension;
/**
 * Demonstration of dialogs.
 * <p>See <a href="https://docs.oracle.com/javase/tutorial/uiswing/components/dialog.html" target="_blank">
 *    https://docs.oracle.com/javase/tutorial/uiswing/components/dialog.html</a></p>
 * @author Bradley Ross
 * 
 * 
 *
 */

public class DialogDemo implements Runnable {
	// protected JDialog dialog;
	protected JFrame frame;
	public void run() {
		frame = new JFrame();
		frame.setSize(new Dimension(400, 200));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		JOptionPane.showMessageDialog(frame, "this is a warning message dialog", "Warning Message Dialog",
				JOptionPane.WARNING_MESSAGE);
		System.out.println("Warning message dialog closed");
		JOptionPane.showMessageDialog(frame,  "This is a plain message dialog.", "Plain message dialog",
				JOptionPane.PLAIN_MESSAGE);
		System.out.println("Plain message dialog closed");
		// Object[] choices = {"Launch", "Abort", "Cancel"};
		int n = JOptionPane.showOptionDialog(frame, "Do you wish to launch", "Option Dialog",
				     JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
		System.out.println("Selected option is " + Integer.toString(n) + " " + convertOption(n));
		
		
	}
	/**
	 * Converts return codes to a meaningful string.
	 * @param value return code from JOptionPane showXxxDialog
	 * @return
	 */
	protected static String convertOption(int value) {
		if (value == JOptionPane.CANCEL_OPTION) { return "Cancel"; }
		else if (value == JOptionPane.NO_OPTION) { return "No"; }
		else if (value == JOptionPane.OK_OPTION) { return "OK"; }
		else if (value == JOptionPane.YES_OPTION) { return "Yes"; }
		else if (value == JOptionPane.CLOSED_OPTION) {return "Closed";}
		else {return "Unknown"; }
	}
	
	

	
	/**
	 * Test driver.
	 * @param args not used
	 */
	public static void main(String[] args) {
		
		Runnable instance = new DialogDemo();
		instance.run();
	}

}
