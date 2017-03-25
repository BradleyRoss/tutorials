/**
 * 
 */
package bradleyross.opensource.pdfbox;
import java.awt.image.BufferedImage;
// import java.awt.image.WritableRaster;
import java.awt.Graphics;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

// import bradleyross.swing.SwingDemo.MainPage;

import javax.swing.JFrame;
/**
 * First test for pdfbox (under development).
 * 
 * @author Bradley Ross
 * 
 * <p>Questions on StackOverflow</p>
 * <ul>
 * <li><a href="http://stackoverflow.com/questions/37478424/bufferedimage-color-saturation" target="_blank">
 *     http://stackoverflow.com/questions/37478424/bufferedimage-color-saturation</a></li>
 * </ul>
 *
 */
public class PdfTest1 {
	JFrame mainFrame;
	JPanel mainPanel;
	BufferedImage image1;
	Graphics graph1;
	@SuppressWarnings("serial")
	protected class MainPanel extends JPanel {
		
	}
	protected void buildImage1() {
		image1 = new BufferedImage(300, 300, BufferedImage.TYPE_3BYTE_BGR);
		graph1 = image1.createGraphics();

	}
	protected void createFrame() {
		mainFrame = new JFrame();
		mainPanel = new MainPanel();

	}
	protected class MainPage implements Runnable {
		public void run() {
			createFrame(); 
				
			
		}
	}

	public void run2() {
		System.out.println("starting run2");
		try {
			SwingUtilities.invokeLater(new MainPage());
		}catch (Exception e) {
			System.out.println("Exception in main page");
			e.printStackTrace();
		}
		System.out.println("run2 complete");
	}
}
