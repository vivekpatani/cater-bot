package ui;

/*
 * InputURLWindow.java
 * 
 * This is used to take the input from the user.
 * The URL refers to the one which needs to be scraped.
 */

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Controller.DataController;
import Main.Constants;

public class InputURLWindow {

	private static JFrame mainFrame = ApplicationWindow.getFrame();
	private static JPanel windowPanel;
	private static JTextField inputURL = new JTextField("20");
	private static JButton submitURL = new JButton(Constants.SUBMIT_URL_BUTTON);
	private static JLabel header = new JLabel(Constants.SOFTWARE_NAME);
	
	DataController controller = new DataController();
	
	public InputURLWindow() {
		initComponents();
	}

	/*
	 * This is used to generate the components use to obtain
	 * information from the user.
	 */
	private void initComponents() {

		// Defining a Panel on which everything will be set
		windowPanel = new JPanel();
		windowPanel.setLayout(new GridBagLayout());

		// Set Panel Size
		windowPanel.setSize(Constants.windowWidth, Constants.windowHeight);
		
		// To put the GridBagLayout Constraints
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.insets = new Insets(Constants.SUBMITBUTTON_BORDER,Constants.SUBMITBUTTON_BORDER,Constants.SUBMITBUTTON_BORDER,Constants.SUBMITBUTTON_BORDER);
		windowPanel.add(header, gbc);

		// Setting the Input Box
		gbc.gridy++;
		gbc.insets = new Insets (0,00,0,0);
		windowPanel.add(inputURL,gbc);
		
		// The placement of the button
		submitURL.setMargin(new Insets(Constants.SUBMITBUTTON_BORDER,Constants.SUBMITBUTTON_BORDER,Constants.SUBMITBUTTON_BORDER,Constants.SUBMITBUTTON_BORDER));
		gbc.insets = new Insets(0,0,0,0);
		gbc.weighty = 1.0;
		windowPanel.add(submitURL, gbc);

		submitURL.addActionListener(new ActionListener() {

			/* 
			 * The action performed by the start button
			 */
			public void actionPerformed(ActionEvent e) {
				String userURL = inputURL.getText();
				controller.setURL(userURL);
				windowPanel.setVisible(false);
				windowPanel.validate();
				// DisplayOutput output = new DisplayOutput(userURL);
			}
		});

		/* Adding the components on Panel to Frame*/
		windowPanel.setVisible(true);
		mainFrame.add(windowPanel);

	}
}