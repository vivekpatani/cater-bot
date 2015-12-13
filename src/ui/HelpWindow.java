/**
 * Andres, Sameksha, Shruti, Vivek
 * HelpWindow.java
 * {Andres - Caterers 0.9}
 */
package ui;

import java.awt.GridBagLayout;

import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import Main.Constants;

/**
 * Class used to Display Help.
 */
public class HelpWindow extends AbstractPanel{
	
	//Logger
	public final static Logger LOGGER = LogManager.getLogger(EditingWindow.class.getName());
	
	//This is used to display the help tips
	private JPanel helpPanel;
	
	//This is used to display Labels
	private JLabel titleLabel;
	private JLabel dataLabel;
	private JLabel data;
	
	//This is used to exit and back button
	private JButton backButton;
	private JButton exitButton;
	
	public HelpWindow(){
		super.setName(Constants.SOFTWARE_NAME);
		this.setSize(Constants.WINDOW_WIDTH , Constants.WINDOW_HEIGHT);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		/* Place frame in the middle of the screen */
		try {
			super.center(this);
		} catch (Exception e) {
			LOGGER.error(Constants.ERROR_MESSAGE, e);
		}
		
		setUpPanel();
		setUpLabel();
		setUpButton();
	}
	
	private void setUpPanel(){
		this.helpPanel = new JPanel();
		this.helpPanel.setBorder(BorderFactory
				.createTitledBorder(Constants.HELP));
		this.helpPanel.setLayout(new GridBagLayout());
		super.getPanel().add(this.helpPanel);
	}
	
	private void setUpLabel(){
    	//The Title Label
    	this.titleLabel = new JLabel(Constants.SOFTWARE_NAME + ": " + Constants.HELP);
		this.helpPanel.add(this.titleLabel, super.setGridLocation(0, 0));
		
		//The actual Help
		this.dataLabel = new JLabel(Constants.HELP);
		this.helpPanel.add(this.dataLabel, super.setGridLocation(0, 1));
		
		this.data = new JLabel("This is help\n"
				+ "This is help\n"
				+ "This is help\n"
				+ "This is help\n"
				+ "This is help\n"
				+ "This is help\n"
				+ "This is help\n"
				+ "This is help\n");
		this.helpPanel.add(this.data, super.setGridLocation(0, 2));
	}
	
	private void setUpButton(){
		
		//Setting up the button which exits the programme
		this.exitButton = new JButton();
		this.exitButton.setText(Constants.EXIT);
		this.exitButton.setEnabled(true);
		//this.helpPanel.add(this.exitButton, super.setGridLocation(2, 2));
		
		//Setting up the button which exits the programme
		this.backButton = new JButton();
		this.backButton.setText(Constants.BACK);
		this.backButton.setEnabled(true);
		this.helpPanel.add(this.backButton, super.setGridLocation(0, 4));
	}

	/**
	 * @return the backButton
	 */
	public JButton getBackButton() {
		return backButton;
	}

	/**
	 * @param backButton the backButton to set
	 */
	public void setBackButton(JButton backButton) {
		this.backButton = backButton;
	}

	/**
	 * @return the exitButton
	 */
	public JButton getExitButton() {
		return exitButton;
	}

	/**
	 * @param exitButton the exitButton to set
	 */
	public void setExitButton(JButton exitButton) {
		this.exitButton = exitButton;
	}

}
