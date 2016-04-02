package bradleyross.library.tools;

import javax.swing.JApplet;
import javax.swing.event.*;
import javax.swing.border.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.event.MenuListener;
import javax.swing.event.MenuEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JMenuBar;
import javax.swing.SwingUtilities;
import bradleyross.library.helpers.ExceptionHelper;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public class MasterIndex {
	protected ExceptionHelper logger = new ExceptionHelper(LogManager.getLogger());
	protected JFrame frame = null;
	protected JMenuBar menuBar = null;
	protected ActionListener menuListener = null;
	public void buildMenuBar(JMenuBar menuBar) {
		menuListener = new MenuActions();
		JMenu file = new JMenu("File");
		menuBar.add(file);
		JMenuItem open = new JMenuItem("Open");
		open.setActionCommand("OPEN");
		file.add(open);
		open.addActionListener(menuListener);
		JMenuItem save = new JMenuItem("Save");
		save.setActionCommand("SAVE");
		save.addActionListener(menuListener);
		file.add(save);
		JMenuItem exit = new JMenuItem("Exit");
		exit.setActionCommand("EXIT");
		exit.addActionListener(menuListener);
		file.add(exit);
	}
	protected class MenuActions implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			System.out.println(e.getActionCommand());
			
		}
		
	}
	public class MainPage implements Runnable {
		public void run() {
			frame = new JFrame();
			frame.setSize(300, 200);
			menuBar = new JMenuBar();
			frame.setJMenuBar(menuBar);
			buildMenuBar(menuBar);
			frame.setVisible(true);
			
			
			
			
		}
	}
	@SuppressWarnings("serial")
	public class Body extends JPanel  {
	GridBagConstraints c = new GridBagConstraints();
	GridBagConstraints cEnd = new GridBagConstraints();
	GridBagLayout layout = new GridBagLayout();

	}
	public void launch() {
		System.out.println("Starting launch");
		try {
		SwingUtilities.invokeLater(new MainPage());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		System.out.println("Starting program");
		MasterIndex instance = new MasterIndex();
		instance.launch();
	}
}
