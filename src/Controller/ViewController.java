package Controller;
/**
 * Andres, Sameksha, Shruti, Vivek
 * ViewController.java
 * {Andres - Caterers 0.9}
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import Main.Constants;
import ui.DisplayWindow;
import ui.EditingWindow;
import ui.HelpWindow;
import ui.LoggingWindow;
import ui.MainWindow;

public class ViewController implements ActionListener {
	
	public final static Logger LOGGER = LogManager
			.getLogger(ViewController.class.getName());
	
	private MainWindow mainWindow;
	private LoggingWindow loginWindow;
	private EditingWindow editWindow;
	private ExcelController excelController;
	private PersonalInfoController personalController;
	private HelpWindow helpWindow;
	private WebController webController;
	private DisplayWindow displayWindow;
	private String startDate;
	private String endDate;
	
	public ViewController(MainWindow mainWindow, LoggingWindow loginWindow, EditingWindow editWindow, DisplayWindow displayWindow, HelpWindow helpWindow) {
		this.mainWindow = mainWindow;
		initButtonMain();
		this.loginWindow = loginWindow;
		initButtonLogin();
		this.editWindow = editWindow;
		initButtonEdit();
		this.excelController = new ExcelController();
		this.personalController = new PersonalInfoController(this.editWindow, this.excelController);
		this.webController = new WebController(this.excelController);
		this.displayWindow = displayWindow;
		initDisplay();
		this.helpWindow = helpWindow;
		initHelpWindow();
	}

	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == this.mainWindow.getStartButton()) {
			this.mainWindow.setVisible(false);
			this.editWindow.setVisible(true);
		} else if (e.getSource() == this.loginWindow.getLoginButton()) {
			try {
				String pass_wrd = new String(this.loginWindow.getPassText().getPassword());
				this.webController.login(
						this.loginWindow.getUserText().getText(), 
						pass_wrd);
//				this.editWindow.getLogoutButton().setEnabled(true);
//				this.editWindow.getExportExcelButton().setEnabled(true);
			} catch (Exception e1) {
				LOGGER.error(Constants.ERROR_MESSAGE, e1);
			}
			this.displayWindow.getExportExcelButton().setEnabled(true);
			this.displayWindow.getVisualisationButton().setEnabled(true);
			this.displayWindow.getLogoutButton().setEnabled(true);
			this.displayWindow.getExitButton().setEnabled(true);
			this.displayWindow.getFilterButton().setEnabled(true);
			this.loginWindow.setVisible(false);
			this.displayWindow.setVisible(true);
		} else if (e.getSource() == this.loginWindow.getCancelButton()) {
			this.loginWindow.setVisible(false);
			this.editWindow.setVisible(true);
		} else if (e.getSource() == this.editWindow.getScrapeButton()) {
			this.webController.setTargetPage(this.editWindow.getUrlText().getText());
			this.webController.goToPage();
			this.editWindow.setVisible(false);
			this.loginWindow.setVisible(true);
		} else if (e.getSource() == displayWindow.getExportExcelButton()) {
			this.webController.getFrame("right");
			this.webController.exportToExcel();
		} else if (e.getSource() == displayWindow.getLogoutButton()) {
			this.webController.getFrame("header");
			this.webController.logout();
			this.webController.quit();
		} else if (e.getSource() == displayWindow.getExitButton()) {
			this.webController.getFrame("header");
			this.webController.logout();
			this.webController.quit();
			this.displayWindow.setVisible(false);
			this.displayWindow.validate();
			this.displayWindow.dispose();
		} else if(e.getSource() == displayWindow.getFilterButton()){
				//Sameeksha Code Call
			this.webController.getFrame("header");
			SimpleDateFormat formatter
		     = new SimpleDateFormat ("MM/dd/yyyy");
		 
		 startDate = formatter.format(this.displayWindow.startDatePicker.getModel().getValue()).toString();
		 endDate = formatter.format(this.displayWindow.endDatePicker.getModel().getValue()).toString();
			this.webController.filterData(startDate, endDate);
			} else if(e.getSource() == displayWindow.getHelpButton()){
				this.helpWindow.setVisible(true);
			} else if(e.getSource() == helpWindow.getBackButton()){
				this.helpWindow.setVisible(false);
				this.helpWindow.validate();
			} else if(e.getSource() == displayWindow.getExitButton()){
				this.helpWindow.setVisible(true);
			}
		}
	
	public void initButtonMain() {
		this.mainWindow.getStartButton().addActionListener(this);
	}
	
	public void initButtonLogin() {
		this.loginWindow.getLoginButton().addActionListener(this);
		this.loginWindow.getCancelButton().addActionListener(this);
	}
	
	public void initButtonEdit() {
		this.editWindow.getScrapeButton().addActionListener(this);
	}
	
	public void initDisplay() {
		this.displayWindow.getExportExcelButton().addActionListener(this);
		this.displayWindow.getLogoutButton().addActionListener(this);
		this.displayWindow.getVisualisationButton().addActionListener(this);
		this.displayWindow.getExitButton().addActionListener(this);
		this.displayWindow.getFilterButton().addActionListener(this);
		this.displayWindow.getHelpButton().addActionListener(this);
	}
	
	public void initHelpWindow() {
		this.helpWindow.getBackButton().addActionListener(this);
		this.helpWindow.getExitButton().addActionListener(this);
	}
}