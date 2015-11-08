package com.cateringxpert.logic;

/*
 * InputURL.java
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
import javax.swing.JTextField;

import com.cateringxpert.constants.Constants;
import com.cateringxpert.main.Launcher;

public class InputURL {
	
	public InputURL() {
		input();
	}
	
	private static JFrame mainFrame = Launcher.getFrame();
    private static JPanel mainPanel;
	
	private void input(){
		
    
    //Defining a Panel on which everything will be set
    mainPanel = new JPanel();
    mainPanel.setLayout(new GridBagLayout());
    
    //To put the GridBagLayout Constraints
    GridBagConstraints c = new GridBagConstraints();
    
    //Set Panel Size
    mainPanel.setSize(Constants.windowWidth,Constants.windowHeight);
    
    //Setting the Input Box
    JTextArea inputURL = new JTextArea();
    inputURL.setLineWrap(true);
    inputURL.setWrapStyleWord(true);
    c.fill = GridBagConstraints.CENTER;
    c.ipady = 50;
    c.weightx = 0.0;
    c.gridwidth = 3;
    c.gridx = 0;
    c.gridy = 1;
    mainPanel.add(inputURL, c);
    
    //Adding the start button
    JButton submitURL = new JButton(Constants.SUBMIT_URL_BUTTON);
    submitURL.addActionListener(new ActionListener() {
    	 
    	//The action performed by the start button
        public void actionPerformed(ActionEvent e)
        {
        	String userURL = inputURL.getText();
        	mainPanel.setVisible(false);
        	mainPanel.validate();
        	DisplayOutput output = new DisplayOutput(userURL);
            }
    });      
    
    //The placement of the button
    c.fill = GridBagConstraints.HORIZONTAL;
    c.ipady = 60;
    c.weightx = 0.0;
    c.gridwidth = 3;
    c.gridx = 0;
    c.gridy = 2;
    mainPanel.add(submitURL, c);

    
    //Adding the components on Panel to Frame
    mainFrame.add(mainPanel);
    
  	}
}