package Main;
/**
 * Andres, Sameksha, Shruti, Vivek
 * Launcher.java
 * {Andres - Caterers 0.9}
 */
import javax.swing.UIManager;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import ui.DisplayWindow;
import ui.EditingWindow;
import ui.HelpWindow;
import ui.LoggingWindow;
import ui.MainWindow;
import Controller.ViewController;


/**
 * This is the main Launcher which initiates the application
 */
public class Launcher {

	//Basic Logger Declaration
	public final static Logger LOGGER = LogManager.getLogger(Launcher.class
			.getName());

	/**
	 * Method main to drive the programme
	 * @param args
	 */
	public static void main(String[] args) {
		MainWindow mainWindow = new MainWindow();
		LoggingWindow loginWindow = new LoggingWindow();
		EditingWindow editWindow = new EditingWindow();
		DisplayWindow displayWindow = new DisplayWindow();
		HelpWindow helpWindow = new HelpWindow();
		ViewController viewController = new ViewController(mainWindow,
				loginWindow, editWindow,displayWindow,helpWindow);

		try {
			//To set the look and feel of the software according to the Operating System
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			LOGGER.error(Constants.ERROR_MESSAGE, e);
		}

		//Basic Setup
		mainWindow.setVisible(false);
		editWindow.setVisible(true);
		loginWindow.setVisible(false);
		displayWindow.setVisible(false);
		helpWindow.setVisible(false);
	}
}