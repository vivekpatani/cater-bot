/**
 * Andres, Sameksha, Shruti, Vivek
 * HelpWindow.java
 * {Andres - Caterers 0.9}
 */
package ui;

import java.awt.GridBagLayout;
import java.awt.GridLayout;

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
	private JPanel FAQPanel;
	
	//This is used to display Labels
	private JLabel titleLabel;
	private JLabel dataLabel;
	private JLabel FAQLabel;
	private JLabel FAQ1;
	private JLabel FAQ2;
	private JLabel data1;
	private JLabel data2;
	private JLabel FAQA1;
	private JLabel FAQA2;
	
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
		
		this.FAQPanel = new JPanel();
		this.FAQPanel.setBorder(BorderFactory
				.createTitledBorder(Constants.FAQ));
		this.FAQPanel.setLayout(new GridBagLayout());
		
		super.getPanel().setLayout(new GridLayout(2, 1));
		super.getPanel().add(this.helpPanel);
		super.getPanel().add(this.FAQPanel);
	}
	
	private void setUpLabel(){
    	//The Title Label
    	this.titleLabel = new JLabel(Constants.SOFTWARE_NAME + ": " + Constants.HELP);
		this.helpPanel.add(this.titleLabel, super.setGridLocation(0, 0));
		
		//The actual Help
		this.dataLabel = new JLabel(Constants.HELP);
		this.helpPanel.add(this.dataLabel, super.setGridLocation(0, 2));
		
		this.data1 = new JLabel(Constants.HELP1);
		this.helpPanel.add(this.data1, super.setGridLocation(0, 4));
		
		this.data2 = new JLabel(Constants.HELP2);
		this.helpPanel.add(this.data2, super.setGridLocation(0, 6));
		
		this.FAQ1 = new JLabel(Constants.FAQ1);
		this.FAQPanel.add(this.FAQ1, super.setGridLocation(0, 2));
		
		this.FAQA1 = new JLabel(Constants.FAQA1);
		this.FAQPanel.add(this.FAQA1, super.setGridLocation(0, 4));
		
		this.FAQ2 = new JLabel(Constants.FAQ2);
		this.FAQPanel.add(this.FAQ2, super.setGridLocation(0, 6));
		
		this.FAQA2 = new JLabel(Constants.FAQA2);
		this.FAQPanel.add(this.FAQA2, super.setGridLocation(0, 8));
		
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
		this.FAQPanel.add(this.backButton, super.setGridLocation(0, 10));
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
