package ui;

/*
 * InputURLWindow.java
 * 
 * This is used to take the input from the user.
 * The URL refers to the one which needs to be scraped.
 */

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import Controller.DataController;
import Main.Constants;

public class InputURLWindow {

	private static JFrame mainFrame = ApplicationWindow.getFrame();
	private static JPanel windowPanel;
	DataController controller = new DataController();
	
	public InputURLWindow() {
		initComponents();
	}

	private void initComponents() {

		// Defining a Panel on which everything will be set
		windowPanel = new JPanel();
		windowPanel.setLayout(new GridBagLayout());

		// To put the GridBagLayout Constraints
		GridBagConstraints c = new GridBagConstraints();

		// Set Panel Size
		windowPanel.setSize(Constants.windowWidth, Constants.windowHeight);

		// Setting the Input Box
		final JTextArea inputURL = new JTextArea();
		inputURL.setLineWrap(true);
		inputURL.setWrapStyleWord(true);
		c.fill = GridBagConstraints.CENTER;
		c.ipady = 50;
		c.weightx = 0.0;
		c.gridwidth = 3;
		c.gridx = 0;
		c.gridy = 1;
		windowPanel.add(inputURL, c);

		// Adding the start button
		JButton submitURL = new JButton(Constants.SUBMIT_URL_BUTTON);

		// The placement of the button
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipady = 60;
		c.weightx = 0.0;
		c.gridwidth = 3;
		c.gridx = 0;
		c.gridy = 2;
		windowPanel.add(submitURL, c);

		submitURL.addActionListener(new ActionListener() {

			/* The action performed by the start button*/
			public void actionPerformed(ActionEvent e) {
				String userURL = inputURL.getText();
				controller.setURL(userURL);
				windowPanel.setVisible(false);
				windowPanel.validate();
				// DisplayOutput output = new DisplayOutput(userURL);
			}
		});

		/* Adding the components on Panel to Frame*/
		mainFrame.add(windowPanel);

	}
}