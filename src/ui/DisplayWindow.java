/**
 * Andres, Sameksha, Shruti, Vivek
 * DisplayWindow.java
 * {Andres - Caterers 0.9}
 */
package ui;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import Main.Constants;
import net.sourceforge.jdatepicker.impl.JDatePanelImpl;
import net.sourceforge.jdatepicker.impl.JDatePickerImpl;
import net.sourceforge.jdatepicker.impl.UtilDateModel;

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
	private JLabel startDateLabel;
	private JLabel endDateLabel;
	
	
	//Personal Information Panel
	private JLabel nameLabelData;
	private JLabel addressLabelData;
	private JLabel billingPeriodLabelData;
	private JLabel emailLabelData;
	
	//Utility Button Panel
	private JPanel buttonPanel;
	
	//Utility Buttons
	private JButton visualisationButton;
	private JButton exportExcelButton;
	private JButton logoutButton;
	private JButton filterButton;
	private JButton exitButton;
	
	
	
	//Split Pane
	private JSplitPane personalButtonPanel;
	
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
		this.setSize(Constants.WINDOW_WIDTH , Constants.WINDOW_HEIGHT);
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
	
	/**
	 * Method to build all the individual panel
	 */
	public void setUpPanel() {
		
		//This is the setup for the Top Most Personal Panel
		this.personalPanel = new JPanel();
		this.personalPanel.setBorder(BorderFactory
				.createTitledBorder(Constants.PERSONAL_INFORMATION));
		this.personalPanel.setLayout(new GridBagLayout());
		
		//This is the setup for the Middle Panel consisting of Data Manipulation and Misc
		this.buttonPanel = new JPanel();
		this.buttonPanel.setBorder(BorderFactory
				.createTitledBorder(Constants.DATA_MANIPULATION));
		this.buttonPanel.setLayout(new GridBagLayout());
		
		//This is the setup for the Bottom Most Display Data Panel
		this.displayPanel = new JPanel();
		this.displayPanel.setBorder(BorderFactory
				.createTitledBorder(Constants.DISPLAY_DATA));
		//this.displayPanel.setLayout(new GridBagLayout()); //Setting Layout causes to shrink
		
		//Combining the personal and the button
		super.getPanel().setLayout(new GridLayout(2, 1));
		personalButtonPanel = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,personalPanel,buttonPanel);
		
		//Adding and Setting Layout
		super.getPanel().add(this.personalButtonPanel);
		super.getPanel().add(this.displayPanel);
	}
	
	/**
	 * To setup the Data Table required in the window
	 */
	public void setUpTable()
    {
        //create table with data
        dataTable = new JTable(data, columns);
        //add the table to the frame
        displayPanel.add(new JScrollPane(dataTable), super.setGridLocation(3, 1));
    }
    
	/**
	 * Method to Setup various labels required in the Display Window
	 */
    public void setUpLabel() {
    	
    	//The name Label
    	this.nameLabel = new JLabel(Constants.NAME);
		this.personalPanel.add(this.nameLabel, super.setGridLocation(0, 0));
		
		//The name Label Data - Needs to taken from Editing Window
		this.nameLabelData = new JLabel(Constants.NAME);
		this.personalPanel.add(this.nameLabelData, super.setGridLocation(0, 1));
		
		//The Address Label
		this.addressLabel = new JLabel(Constants.ADDRESS);
		this.personalPanel.add(this.addressLabel, super.setGridLocation(1, 0));
		
		//The address Label Data - Needs to taken from Editing Window
		this.addressLabelData = new JLabel(Constants.ADDRESS);
		this.personalPanel.add(this.addressLabelData, super.setGridLocation(1, 1));
				
		//The billing Label
		this.billingPeriodLabel = new JLabel(Constants.BILLING_PERIOD);
		this.personalPanel.add(this.billingPeriodLabel, super.setGridLocation(2, 0));
		
		//The billing Label Data - Needs to taken from Editing Window
		this.billingPeriodLabelData = new JLabel(Constants.BILLING_PERIOD);
		this.personalPanel.add(this.billingPeriodLabelData, super.setGridLocation(2, 1));
		
		//The Email Label
		this.emailLabel = new JLabel(Constants.EMAIL);
		this.personalPanel.add(this.emailLabel, super.setGridLocation(3, 0));
		
		//The Email Label
		this.emailLabelData = new JLabel(Constants.EMAIL);
		this.personalPanel.add(this.emailLabelData, super.setGridLocation(3, 1));
		
		this.startDateLabel = new JLabel(Constants.START_DATE);
		this.buttonPanel.add(this.startDateLabel,super.setGridLocation(0, 0));
		
		this.endDateLabel = new JLabel(Constants.END_DATE);
		this.buttonPanel.add(this.endDateLabel,super.setGridLocation(0, 1));
		
	}
	
    /**
     * To setup the buttons required in the window
     */
	public void setUpButton() {
		
		//Setting up the button which exports the data to an Excel Sheet
		this.exportExcelButton = new JButton();
		this.exportExcelButton.setText(Constants.EXPORT);
		this.exportExcelButton.setEnabled(false);
		this.buttonPanel.add(this.exportExcelButton, super.setGridLocation(2, 1));
		
		//Setting up the button which logs the user of the account
		this.logoutButton = new JButton();
		this.logoutButton.setText(Constants.LOGOUT);
		this.logoutButton.setEnabled(false);
		this.buttonPanel.add(this.logoutButton, super.setGridLocation(3, 1));
		
		//Setting up the button which displays the various visulations
		this.visualisationButton = new JButton();
		this.visualisationButton.setText(Constants.DATA_VISUALISATION);
		this.visualisationButton.setEnabled(false);
		this.buttonPanel.add(this.visualisationButton, super.setGridLocation(2, 2));
		
		//Setting up the button which helps the user Filter Data
		this.filterButton = new JButton();
		this.filterButton.setText(Constants.FILTER_DATA);
		this.filterButton.setEnabled(false);
		this.buttonPanel.add(this.filterButton,super.setGridLocation(3, 2));
		
		//Setting up the button which helps the user Filter Data
		this.exitButton = new JButton();
		this.exitButton.setText(Constants.EXIT);
		this.exitButton.setEnabled(false);
		this.buttonPanel.add(this.exitButton,super.setGridLocation(4, 1));
		
		
		UtilDateModel model = new UtilDateModel();
		JDatePanelImpl datePickerPanel = new JDatePanelImpl(model);
		JDatePickerImpl startDatePicker = new JDatePickerImpl(datePickerPanel);
		this.buttonPanel.add(startDatePicker);
		
		UtilDateModel model2 = new UtilDateModel();
		JDatePanelImpl datePickerPanel2 = new JDatePanelImpl(model2);
		JDatePickerImpl endDatePicker = new JDatePickerImpl(datePickerPanel);
		this.buttonPanel.add(endDatePicker);
		
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

	/**
	 * @return the filterButton
	 */
	public JButton getFilterButton() {
		return filterButton;
	}

	/**
	 * @param filterButton the filterButton to set
	 */
	public void setFilterButton(JButton filterButton) {
		this.filterButton = filterButton;
	}

	/**
	 * @return the exitButton
	 */
	public JButton getExitButton() {
		return exitButton;
	}

	/**
	 * @param exitButton the exitButton to set
	 */
	public void setExitButton(JButton exitButton) {
		this.exitButton = exitButton;
	}
	
	
}