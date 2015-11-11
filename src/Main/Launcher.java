package Main;

/*
 * Launcher.java
 * 
 * Contains main() and is the driver of the program
 * Defines basic frame properties
 */

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import ui.ApplicationWindow;


public class Launcher{
	
	public final static Logger log = LogManager.getLogger(Launcher.class.getName());
       
	
    public static void main(String[] args) {
				
			ApplicationWindow appWindow = new ApplicationWindow();
    }
}