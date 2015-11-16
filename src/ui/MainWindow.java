package ui;

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

public class MainWindow extends AbstractPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public final static Logger LOGGER = LogManager
			.getLogger(MainWindow.class.getName());

	private BufferedImage logo;
	private JLabel picLabel;
	private JButton startButton;

	public MainWindow() {
		super();
		init();
	}

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
	
	
	public void setUpStart() {
		this.startButton = new JButton(Constants.START_BUTTON);
		super.getPanel().add(this.startButton, super.setGridLocation(0, 1));
	}
	
	public JButton getStartButton() {
		return this.startButton;
	}
}
