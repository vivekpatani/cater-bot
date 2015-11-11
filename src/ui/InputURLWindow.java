package ui;

/*
 * InputURLWindow.java
 * 
 * This is used to take the input from the user.
 * The URL refers to the one which needs to be scraped.
 */

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Controller.DataController;
import Main.Constants;

public class InputURLWindow {

	private static JFrame mainFrame = ApplicationWindow.getFrame();
	private static JPanel windowPanel;
	private static JTextField inputURL = new JTextField("20");
	private static JButton submitURL = new JButton(Constants.SUBMIT_URL_BUTTON);
	private GridBagLayout gridBagLayout;
	private GridBagConstraints gridBagConstraints;
	
	DataController controller = new DataController();
	
	public InputURLWindow() {
		gridBagLayout = new GridBagLayout();
		initGridBagConstraints();
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

		//set the frame to a smaller size
		Dimension dim = mainFrame.getSize();
		mainFrame.setSize(dim.width/2, dim.height/2);

		windowPanel.add(inputURL,setGridBagConstraints(0, 0));
		windowPanel.add(submitURL, setGridBagConstraints(0, 1));

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
	
	private void initGridBagConstraints() {
		gridBagConstraints = new GridBagConstraints();
		gridBagConstraints.weightx = 0.5;
		gridBagConstraints.weighty = 0.0;
		gridBagConstraints.insets = new Insets(5, 5, 0, 5);
		gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
	}
	
	private GridBagConstraints setGridBagConstraints(int x, int y) {
		gridBagConstraints.gridx = x;
		gridBagConstraints.gridy = y;
		return gridBagConstraints;
	}
}