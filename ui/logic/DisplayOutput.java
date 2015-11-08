package com.cateringxpert.logic;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.cateringxpert.constants.Constants;
import com.cateringxpert.main.Launcher;

public class DisplayOutput {
	
	private static String userURL;
	private static JFrame displayFrame = Launcher.getFrame();
	private static JPanel displayPanel;
	
	public DisplayOutput(String userURL) {
		this.userURL = userURL;
		displayOutput();
	}
	
	private static void displayOutput() {
	displayPanel = new JPanel();
    displayPanel.setLayout(new GridBagLayout());
    
    //To put the GridBagLayout Constraints
    GridBagConstraints c = new GridBagConstraints();
    
    //Set Panel Size
    displayPanel.setSize(Constants.windowWidth,Constants.windowHeight);
    
    //Setting the Input Box
    JLabel outputURL = new JLabel(userURL);
    c.fill = GridBagConstraints.CENTER;
    c.ipady = 50;
    c.weightx = 0.0;
    c.gridwidth = 3;
    c.gridx = 0;
    c.gridy = 1;
    displayPanel.add(outputURL, c);
    
//    //Adding the start button
//    JButton submitURL = new JButton(Constants.SUBMIT_URL_BUTTON);
//    submitURL.addActionListener(new ActionListener() {
//    	 
//    	//The action performed by the start button
//        public void actionPerformed(ActionEvent e)
//        {
//        	String userURL = inputURL.getText();
//        	mainPanel.setVisible(true);
//        	mainPanel.validate();
//        	DisplayOutput output = new DisplayOutput(userURL);
//            }
//    });      
    
//    //The placement of the button
//    c.fill = GridBagConstraints.HORIZONTAL;
//    c.ipady = 60;
//    c.weightx = 0.0;
//    c.gridwidth = 3;
//    c.gridx = 0;
//    c.gridy = 2;
//    mainPanel.add(submitURL, c);

    
    //Adding the components on Panel to Frame
    displayFrame.add(displayPanel);
    
  	}
}
