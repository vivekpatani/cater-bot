package ui;
/**
 * Andres, Sameksha, Shruti, Vivek
 * MainWindow.java
 * {Andres - Caterers 0.9}
 */
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import Main.Constants;


/**
 * This is similar to a Splash Screen but is no more required and will be removed in the future updates
 */
public class MainWindow extends AbstractPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//Basic Logger Declaration
	public final static Logger LOGGER = LogManager
			.getLogger(MainWindow.class.getName());

	//Other Variable Declaration
	private BufferedImage logo;
	private JLabel picLabel;
	private JButton startButton;

	/**
	 * Basic Constructor
	 */
	public MainWindow() {
		super();
		init();
	}

	/**
	 * Method to initiate the MainWindow
	 */
	public void init() {
		super.setName(Constants.SOFTWARE_NAME);
		this.setSize(Constants.WINDOW_WIDTH, Constants.WINDOW_HEIGHT);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		/* Place frame in the middle of the screen */
		try {
			super.center(this);
		} catch (Exception e) {
			LOGGER.error(Constants.ERROR_MESSAGE, e);
		}
		
		setUpLogo();
		setUpStart();
	}

	/**
	 * Method simply used to setup the logo of the software
	 */
	public void setUpLogo() {

		// Importing the logo for the software
		try {
			logo = ImageIO.read(new File(Constants.LOGO_DIR));
		} catch (IOException e) {
			LOGGER.error(Constants.ERROR_MESSAGE, e);
		}

		// Add the logo to the panel
		this.picLabel = new JLabel(new ImageIcon(logo));
		super.getPanel().add(this.picLabel, super.setGridLocation(0, 0));
	}
	
	/**
	 * Method used to setup the other components of the complete panel
	 */
	public void setUpStart() {
		this.startButton = new JButton(Constants.START_BUTTON);
		super.getPanel().add(this.startButton, super.setGridLocation(0, 1));
	}
	
	/**
	 * Getter to get the start button to run the application
	 * @return
	 */
	public JButton getStartButton() {
		return this.startButton;
	}
}
