package ui;
/**
 * Andres, Sameksha, Shruti, Vivek
 * LoggingWindow.java
 * {Andres - Caterers 0.9}
 */
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import Main.Constants;

public class LoggingWindow extends AbstractPanel {
	
	public final static Logger LOGGER = LogManager
			.getLogger(LoggingWindow.class.getName());
	
	private static final long serialVersionUID = 1L;
	
	private JLabel userLabel;
	private JLabel passLabel;
	private JTextField userText;
	private JPasswordField passText;
	private JButton loginButton;
	private JButton cancelButton;
	
	public LoggingWindow() {
		super();
		init();
	}
	
	
	public void init() {
		super.setName(Constants.LOGIN);
		this.setSize(Constants.WINDOW_WIDTH/3, Constants.WINDOW_HEIGHT/3);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		/* Place frame in the middle of the screen */
		try {
			super.center(this);
		} catch (Exception e) {
			LOGGER.error(Constants.ERROR_MESSAGE, e);
		}
		
		setUpLabel();
		setUpTextField();
		setUpButton();
	}
	
	public void setUpLabel() {
		this.userLabel = new JLabel(Constants.USERNAME);
		this.passLabel = new JLabel(Constants.PASSWORD);
		super.getPanel().add(this.userLabel, super.setGridLocation(0,0));
		super.getPanel().add(this.passLabel, super.setGridLocation(0,1));
	}
	
	public void setUpTextField() {
		this.userText = new JTextField();
		this.userText.setPreferredSize(new Dimension(Constants.FIELD_WIDHT, Constants.FIELD_HEIGHT));
		this.passText = new JPasswordField();
		this.passText.setPreferredSize(new Dimension(Constants.FIELD_WIDHT, Constants.FIELD_HEIGHT));
		super.getPanel().add(this.userText, super.setGridLocation(1,0));
		super.getPanel().add(this.passText, super.setGridLocation(1,1));
	}
	
	public void setUpButton() {
		this.loginButton = new JButton();
		this.loginButton.setText(Constants.LOGIN);
		this.cancelButton = new JButton();
		this.cancelButton.setText(Constants.CANCEL);
		super.getPanel().add(this.loginButton, super.setGridLocation(0, 2));
		super.getPanel().add(this.cancelButton, super.setGridLocation(1, 2));
	}
	
	public JButton getLoginButton() {
		return this.loginButton;
	}
	
	public JButton getCancelButton() {
		return this.cancelButton;
	}


	public JTextField getUserText() {
		return userText;
	}


	public void setUserText(JTextField userText) {
		this.userText = userText;
	}


	public JPasswordField getPassText() {
		return passText;
	}


	public void setPassText(JPasswordField passText) {
		this.passText = passText;
	}
}
