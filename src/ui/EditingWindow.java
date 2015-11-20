package ui;

import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import Main.Constants;

public class EditingWindow extends AbstractPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public final static Logger LOGGER = LogManager
			.getLogger(EditingWindow.class.getName());

	// scraping panel JComponents
	private JPanel scrapePanel;
	private JLabel urlLabel;
	private JTextField urlText;
	private JButton scrapeButton;
	private JButton exportExcelButton;
	private JButton logoutButton;

	// personal information panel JComponents
	private JPanel personalPanel;
	// Labels
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

	public EditingWindow() {
		super();
		init();
	}

	public void init() {
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
		setUpTextField();
		setUpButton();
	}

	public void setUpPanel() {
		this.scrapePanel = new JPanel();
		this.scrapePanel.setBorder(BorderFactory
				.createTitledBorder(Constants.URL_SCRAPE));
		//this.scrapePanel.setBackground(Color.darkGray);
		this.scrapePanel.setLayout(new GridBagLayout());

		this.personalPanel = new JPanel();
		this.personalPanel.setBorder(BorderFactory
				.createTitledBorder(Constants.PERSONAL_INFORMATION));
		//this.personalPanel.setBackground(Color.darkGray);
		this.personalPanel.setLayout(new GridBagLayout());
		
		super.getPanel().setLayout(new GridLayout(2, 1));
		super.getPanel().add(this.scrapePanel);
		super.getPanel().add(this.personalPanel);
	}
	
	public void setUpLabel() {
		this.urlLabel = new JLabel(Constants.URL_SCRAPE);
		this.scrapePanel.add(this.urlLabel, super.setGridLocation(0, 0));
		
		this.nameLabel = new JLabel(Constants.NAME);
		this.personalPanel.add(this.nameLabel, super.setGridLocation(0, 0));
		this.addressLabel = new JLabel(Constants.ADDRESS);
		this.personalPanel.add(this.addressLabel, super.setGridLocation(0, 1));
		this.billingPeriodLabel = new JLabel(Constants.BILLING_PERIOD);
		this.personalPanel.add(this.billingPeriodLabel, super.setGridLocation(0, 2));
		this.emailLabel = new JLabel(Constants.EMAIL);
		this.personalPanel.add(this.emailLabel, super.setGridLocation(0, 3));
	}
	
	public void setUpTextField() {
		this.urlText = new JTextField();
		this.urlText.setPreferredSize(new Dimension(Constants.FIELD_WIDHT, Constants.FIELD_HEIGHT));
		this.scrapePanel.add(this.urlText, super.setGridLocation(1, 0));
		
		this.nameText = new JTextField();
		this.nameText.setPreferredSize(new Dimension(Constants.FIELD_WIDHT, Constants.FIELD_HEIGHT));
		this.personalPanel.add(this.nameText, super.setGridLocation(1, 0));
		this.addressText = new JTextField();
		this.addressText.setPreferredSize(new Dimension(Constants.FIELD_WIDHT, Constants.FIELD_HEIGHT));
		this.personalPanel.add(this.addressText, super.setGridLocation(1, 1));
		this.billingPeriodText = new JTextField();
		this.billingPeriodText.setPreferredSize(new Dimension(Constants.FIELD_WIDHT, Constants.FIELD_HEIGHT));
		this.personalPanel.add(this.billingPeriodText, super.setGridLocation(1, 2));
		this.emailText = new JTextField();
		this.emailText.setPreferredSize(new Dimension(Constants.FIELD_WIDHT, Constants.FIELD_HEIGHT));
		this.personalPanel.add(this.emailText, super.setGridLocation(1, 3));
	}
	
	public void setUpButton() {
		this.scrapeButton = new JButton();
		this.scrapeButton.setText(Constants.SUBMIT_URL_BUTTON);
		this.scrapePanel.add(this.scrapeButton, super.setGridLocation(2, 0));
		
		this.exportExcelButton = new JButton();
		this.exportExcelButton.setText(Constants.EXPORT);
		this.exportExcelButton.setEnabled(false);
		this.scrapePanel.add(this.exportExcelButton, super.setGridLocation(1, 1));
		
		this.logoutButton = new JButton();
		this.logoutButton.setText(Constants.LOGOUT);
		this.logoutButton.setEnabled(false);
		this.scrapePanel.add(this.logoutButton, super.setGridLocation(1, 2));
		
		this.addInformationButton = new JButton();
		this.addInformationButton.setText(Constants.PERSONAL_INFORMATION);
		this.personalPanel.add(this.addInformationButton, super.setGridLocation(1, 4));
	}

	public JTextField getUrlText() {
		return urlText;
	}

	public void setUrlText(JTextField urlText) {
		this.urlText = urlText;
	}

	public JButton getScrapeButton() {
		return scrapeButton;
	}

	public void setScrapeButton(JButton scrapeButton) {
		this.scrapeButton = scrapeButton;
	}

	public JTextField getNameText() {
		return nameText;
	}

	public void setNameText(JTextField nameText) {
		this.nameText = nameText;
	}

	public JTextField getAddressText() {
		return addressText;
	}

	public void setAddressText(JTextField addressText) {
		this.addressText = addressText;
	}

	public JTextField getBillingPeriodText() {
		return billingPeriodText;
	}

	public void setBillingPeriodText(JTextField billingPeriodText) {
		this.billingPeriodText = billingPeriodText;
	}

	public JTextField getEmailText() {
		return emailText;
	}

	public void setEmailText(JTextField emailText) {
		this.emailText = emailText;
	}

	public JButton getAddInformationButton() {
		return addInformationButton;
	}

	public void setAddInformationButton(JButton addInformationButton) {
		this.addInformationButton = addInformationButton;
	}
	
	public JButton getExportExcelButton() {
		return exportExcelButton;
	}

	public void setExportExcelButton(JButton exportExcelButton) {
		this.exportExcelButton = exportExcelButton;
	}

	public JButton getLogoutButton() {
		return logoutButton;
	}

	public void setLogoutButton(JButton logoutButton) {
		this.logoutButton = logoutButton;
	}

}
