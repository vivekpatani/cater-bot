package com.cateringxpert.main;

/*
 * Launcher.java
 * 
 * Contains main() and is the driver of the program
 * Defines basic frame properties
 */

import com.cateringxpert.constants.*;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;

import com.cateringxpert.logic.*;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

public class Launcher{

	public final static Logger log = Logger.getLogger(Launcher.class);
    private static JFrame mainFrame;
    private static Dimension dim;
    private static BufferedImage logo;
    private static JPanel mainPanel;
    
    public static JFrame getFrame(){
    	return mainFrame;
    }
	
    public static void main(String[] args) {
			
			//To set basic Configuration of log4j
			BasicConfigurator.configure();
			
			
	        // Set look and feel to that of OS
	        try {
	            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
	        } 
	        catch (Exception e) {
	        	 log.error(Constants.ERROR_MESSAGE, e);
	        }
	        
	        //Defining the Frame and its properties
	        mainFrame = new JFrame(Constants.SOFTWARE_NAME);
	        mainFrame.setSize(Constants.windowWidth, Constants.windowHeight);
	        mainFrame.setResizable(false);
	        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        
	        //Defining a Panel on which everything will be set
	        mainPanel = new JPanel();
	        mainPanel.setLayout(new GridBagLayout());
	        
	        //To put the GridBagLayout Constraints
	        GridBagConstraints c = new GridBagConstraints();
	        
	        //Set Panel Size
	        mainPanel.setSize(Constants.windowWidth,Constants.windowHeight);
	        
	        //Importing the logo for the software
			try {
				logo = ImageIO.read(new File(Constants.LOGO_DIR));
				} catch (IOException e) {
				// Auto-generated catch block
				log.error(Constants.ERROR_MESSAGE, e);
			}
			
			
			//Add the logo to the panel
	        JLabel picLabel = new JLabel(new ImageIcon(logo));
	        c.fill = GridBagConstraints.CENTER;
	        c.ipady = 50;
	        c.weightx = 0.0;
	        c.gridwidth = 3;
	        c.gridx = 0;
	        c.gridy = 1;
	        mainPanel.add(picLabel, c);
	        
	        //Adding the start button
	        JButton start = new JButton(Constants.START_BUTTON);
	        start.addActionListener(new ActionListener() {
	        	 
	        	//The action performed by the start button
	            public void actionPerformed(ActionEvent e)
	            {
	                //Execute when button is pressed
	                mainPanel.setVisible(false);
	                mainPanel.validate();
	                InputURL inputURL = new InputURL();
	            }
	        });      
	        
	        //The placement of the button
	        c.fill = GridBagConstraints.HORIZONTAL;
	        c.ipady = 60;
	        c.weightx = 0.0;
	        c.gridwidth = 6;
	        c.gridx = 0;
	        c.gridy = 2;
	        mainPanel.add(start, c);

	        
	        //Adding the components on Panel to Frame
	        mainFrame.add(mainPanel);

	        
	        /*Place mainFrame in the middle of the screen*/
	        try {
	    		dim = Toolkit.getDefaultToolkit().getScreenSize();
	    		mainFrame.setLocation(dim.width/2-mainFrame.getSize().width/2, dim.height/2-mainFrame.getSize().height/2);
	        } 
	        catch (Exception e) {
	            log.error(Constants.ERROR_MESSAGE, e);
	        }
	        
	        //Setting the visibility once the properties are defined
	        mainFrame.setVisible(true);
    	}
	}