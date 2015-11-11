package Main;

/*
 * Launcher.java
 * 
 * Contains main() and is the driver of the program
 * Defines basic frame properties
 */

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import ui.ApplicationWindow;


public class Launcher{

	public final static Logger log = Logger.getLogger(Launcher.class);
       
	
    public static void main(String[] args) {
				
			BasicConfigurator.configure();
			ApplicationWindow appWindow = new ApplicationWindow();
			appWindow.setVisible(true);
    }}