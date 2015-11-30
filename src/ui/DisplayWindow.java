/**
 * Vivek Patani {FlipSwitch}
 * DisplayData.java
 * {Algorithms 0.: Living in Beta}
 */
package ui;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import Main.Constants;

/**
 * Class used to Display Data and Export it to various formats.
 */ 
public class DisplayWindow extends AbstractPanel{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public final static Logger LOGGER = LogManager
			.getLogger(EditingWindow.class.getName());
	
		private JFrame displayFrame = new JFrame();
		
		//Display Panel JComponents
		private JPanel displayPanel;
		private JLabel statLabel;
		private JButton exportExcelButton;
		private JButton logoutButton;

		//Button Panel JComponents
		private JPanel buttonPanel;
		
		//Labels
		private JLabel nameLabel;
		private JLabel addressLabel;
		private JLabel billingPeriodLabel;
		private JLabel emailLabel;
		
		// TextFields
		private JTextField nameText;
		private JTextField addressText;
		private JTextField billingPeriodText;
		private JTextField emailText;

		private JButton addInformationButton;

	/**
	 * Basic Constructor
	 */
	public DisplayWindow(){
		super();
		init();
	}
	
	private void init(){
		super.setName(Constants.SOFTWARE_NAME);
		this.setSize(Constants.WINDOW_WIDTH / 2, Constants.WINDOW_HEIGHT / 2);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		/* Place frame in the middle of the screen */
		try {
			super.center(this);
		} catch (Exception e) {
			LOGGER.error(Constants.ERROR_MESSAGE, e);
		}
		displayData();
		setUpPanel();
		setUpLabel();
		setUpButton();
	}
	
	public void setUpPanel() {
		
		//This is used to display the table
		this.displayPanel = new JPanel();
		this.displayPanel.setBorder(BorderFactory
				.createTitledBorder(Constants.URL_SCRAPE));
		//this.scrapePanel.setBackground(Color.darkGray);
		this.displayPanel.setLayout(new GridBagLayout());
		
		//This is used to display various buttons on the top
		this.buttonPanel = new JPanel();
		this.buttonPanel.setBorder(BorderFactory
				.createTitledBorder(Constants.DISPLAY_DATA));
		//this.personalPanel.setBackground(Color.darkGray);
		this.buttonPanel.setLayout(new GridBagLayout());
		
		super.getPanel().setLayout(new GridLayout(2, 1));
		super.getPanel().add(this.displayPanel);
		super.getPanel().add(this.buttonPanel);
	}
	
	/**
	 * To setup the buttons required in the window.
	 */
	public void displayData()
    {
        //headers for the table
        String[] columns = new String[] {
            "Id", "Name", "Hourly Rate", "Part Time"
        };
         
        //actual data for the table in a 2d array
        Object[][] data = new Object[][] {
            {1, "John", 40.0, "yes" },
            {2, "Rambo", 70.0, "yes" },
            {3, "Zorro", 60.0, "yes" },
        };
 
        //create table with data
        JTable table = new JTable(data, columns);
         
        //add the table to the frame
        this.add(new JScrollPane(table));
         
        this.setTitle("Table Example");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);       
        this.pack();
        this.setVisible(true);
    }
    
    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new DisplayWindow();
            }
        });
    }
    public void setUpLabel() {
		this.statLabel = new JLabel(Constants.URL_SCRAPE);
		this.displayPanel.add(this.statLabel, super.setGridLocation(0, 0));
		
		this.nameLabel = new JLabel(Constants.NAME);
		this.buttonPanel.add(this.nameLabel, super.setGridLocation(0, 0));
		this.addressLabel = new JLabel(Constants.ADDRESS);
		this.buttonPanel.add(this.addressLabel, super.setGridLocation(0, 1));
		this.billingPeriodLabel = new JLabel(Constants.BILLING_PERIOD);
		this.buttonPanel.add(this.billingPeriodLabel, super.setGridLocation(0, 2));
		this.emailLabel = new JLabel(Constants.EMAIL);
		this.buttonPanel.add(this.emailLabel, super.setGridLocation(0, 3));
	}
	
	public void setUpButton() {
		
		this.exportExcelButton = new JButton();
		this.exportExcelButton.setText(Constants.EXPORT);
		this.exportExcelButton.setEnabled(false);
		this.buttonPanel.add(this.exportExcelButton, super.setGridLocation(2, 1));
		
		this.logoutButton = new JButton();
		this.logoutButton.setText(Constants.LOGOUT);
		this.logoutButton.setEnabled(false);
		this.buttonPanel.add(this.logoutButton, super.setGridLocation(2, 2));
		
		this.addInformationButton = new JButton();
		this.addInformationButton.setText(Constants.PERSONAL_INFORMATION);
		this.buttonPanel.add(this.addInformationButton, super.setGridLocation(1, 4));
	}
}