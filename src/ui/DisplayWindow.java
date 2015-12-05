/**
 * Andres, Sameksha, Shruti, Vivek
 * DisplayWindow.java
 * {Andres - Caterers 0.9}
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

	//Logger
	public final static Logger LOGGER = LogManager.getLogger(EditingWindow.class.getName());
	
	//Personal Information Panel
	private JPanel personalPanel;
	
	//Personal Information Labels
	private JLabel nameLabel;
	private JLabel addressLabel;
	private JLabel billingPeriodLabel;
	private JLabel emailLabel;
	
	//Utility Button Panel
	private JPanel buttonPanel;
	
	//Utility Buttons
	private JButton visualisationButton;
	private JButton exportExcelButton;
	private JButton logoutButton;
	
	//Display Data Panel
	private JPanel displayPanel;
	
	//Display Table
	private JTable dataTable;
	
	//Headers for Table;
	private String columns[] = new String[] {
            "Id", "Name", "Hourly Rate", "Part Time"
        }; //Should be shifted to Constants soon.
	
	private Object[][] data = new Object[][] {
        {1, "John", 40.0, "yes" },
        {2, "Rambo", 70.0, "yes" },
        {3, "Zorro", 60.0, "yes" },
    };
	
    /**
     * Basic Constructor
     */
	public DisplayWindow(){
		super();
		init();
	}
	
	/**
	 * Method used to initiate the Display Window with data
	 */
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

		setUpPanel();
		setUpLabel();
		setUpTable();
		setUpButton();
	}
	
	public void setUpPanel() {
		this.personalPanel = new JPanel();
		this.personalPanel.setBorder(BorderFactory
				.createTitledBorder(Constants.PERSONAL_INFORMATION));
		this.personalPanel.setLayout(new GridBagLayout());
		
		this.buttonPanel = new JPanel();
		this.buttonPanel.setBorder(BorderFactory
				.createTitledBorder(Constants.DATA_MANIPULATION));
		this.buttonPanel.setLayout(new GridBagLayout());
		
		this.displayPanel = new JPanel();
		this.displayPanel.setBorder(BorderFactory
				.createTitledBorder(Constants.DISPLAY_DATA));
		this.displayPanel.setLayout(new GridBagLayout());

		super.getPanel().setLayout(new GridLayout(3, 1));
		super.getPanel().add(this.personalPanel);
		super.getPanel().add(this.buttonPanel);
		super.getPanel().add(this.displayPanel);
	}
	
	/**
	 * To setup the buttons required in the window.
	 */
	public void setUpTable()
    {
        //create table with data
        dataTable = new JTable(data, columns);
        //add the table to the frame
        displayPanel.add(new JScrollPane(dataTable), super.setGridLocation(3, 1));
    }
    
    public void setUpLabel() {
    	this.nameLabel = new JLabel(Constants.NAME);
		this.personalPanel.add(this.nameLabel, super.setGridLocation(0, 0));
		this.addressLabel = new JLabel(Constants.ADDRESS);
		this.personalPanel.add(this.addressLabel, super.setGridLocation(0, 1));
		this.billingPeriodLabel = new JLabel(Constants.BILLING_PERIOD);
		this.personalPanel.add(this.billingPeriodLabel, super.setGridLocation(0, 2));
		this.emailLabel = new JLabel(Constants.EMAIL);
		this.personalPanel.add(this.emailLabel, super.setGridLocation(0, 3));
	}
	
	public void setUpButton() {
		this.exportExcelButton = new JButton();
		this.exportExcelButton.setText(Constants.EXPORT);
		this.exportExcelButton.setEnabled(false);
		this.buttonPanel.add(this.exportExcelButton, super.setGridLocation(1, 1));
		
		this.logoutButton = new JButton();
		this.logoutButton.setText(Constants.LOGOUT);
		this.logoutButton.setEnabled(false);
		this.buttonPanel.add(this.logoutButton, super.setGridLocation(1, 2));
		
		this.visualisationButton = new JButton();
		this.visualisationButton.setText(Constants.DATA_VISUALISATION);
		this.visualisationButton.setEnabled(false);
		this.buttonPanel.add(this.visualisationButton, super.setGridLocation(1, 3));
		}

	/**
	 * @return the visualisationButton
	 */
	public JButton getVisualisationButton() {
		return visualisationButton;
	}

	/**
	 * @param visualisationButton the visualisationButton to set
	 */
	public void setVisualisationButton(JButton visualisationButton) {
		this.visualisationButton = visualisationButton;
	}

	/**
	 * @return the exportExcelButton
	 */
	public JButton getExportExcelButton() {
		return exportExcelButton;
	}

	/**
	 * @param exportExcelButton the exportExcelButton to set
	 */
	public void setExportExcelButton(JButton exportExcelButton) {
		this.exportExcelButton = exportExcelButton;
	}

	/**
	 * @return the logoutButton
	 */
	public JButton getLogoutButton() {
		return logoutButton;
	}

	/**
	 * @param logoutButton the logoutButton to set
	 */
	public void setLogoutButton(JButton logoutButton) {
		this.logoutButton = logoutButton;
	}
	
	
}