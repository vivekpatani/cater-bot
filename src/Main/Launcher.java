package Main;

/*
 * Launcher.java
 * 
 * Contains main() and is the driver of the program
 * Defines basic frame properties
 */

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.UIManager;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import ui.LoggingWindow;
import ui.MainWindow;
import Controller.ViewController;

public class Launcher {

	public final static Logger LOGGER = LogManager.getLogger(Launcher.class
			.getName());

	public static void main(String[] args) {
		MainWindow mainWindow = new MainWindow();
		LoggingWindow loginWindow = new LoggingWindow();
		ViewController viewController = new ViewController(mainWindow,
				loginWindow);

		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			LOGGER.error(Constants.ERROR_MESSAGE, e);
		}

		mainWindow.setVisible(true);
		loginWindow.setVisible(false);
	}
}
