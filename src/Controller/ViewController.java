package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import Main.Constants;
import ui.EditingWindow;
import ui.LoggingWindow;
import ui.MainWindow;

public class ViewController implements ActionListener {
	
	public final static Logger LOGGER = LogManager
			.getLogger(ViewController.class.getName());
	
	private MainWindow mainWindow;
	private LoggingWindow loginWindow;
	private EditingWindow editWindow;
	private WebController webController;
	
	public ViewController(MainWindow mainWindow, LoggingWindow loginWindow, EditingWindow editWindow) {
		this.mainWindow = mainWindow;
		initButtonMain();
		this.loginWindow = loginWindow;
		initButtonLogin();
		this.editWindow = editWindow;
		initButtonEdit();
		this.webController = new WebController();
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
				this.editWindow.getLogoutButton().setEnabled(true);
				this.editWindow.getExportExcelButton().setEnabled(true);
			} catch (Exception e1) {
				LOGGER.error(Constants.ERROR_MESSAGE, e1);
			}
			
			this.loginWindow.setVisible(false);
			this.editWindow.setVisible(true);
		} else if (e.getSource() == this.loginWindow.getCancelButton()) {
			this.loginWindow.setVisible(false);
			this.editWindow.setVisible(true);
		} else if (e.getSource() == this.editWindow.getScrapeButton()) {
			this.webController.setTargetPage(this.editWindow.getUrlText().getText());
			this.webController.goToPage();
			this.editWindow.setVisible(false);
			this.loginWindow.setVisible(true);
		} else if (e.getSource() == editWindow.getExportExcelButton()) {
			this.webController.getFrame("right");
			this.webController.exportToExcel();
		} else if (e.getSource() == this.editWindow.getLogoutButton()) {
			this.webController.getFrame("header");
			this.webController.logout();
			this.webController.quit();
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
		//this.editWindow.getAddInformationButton().addActionListener(this);
		this.editWindow.getExportExcelButton().addActionListener(this);
		this.editWindow.getLogoutButton().addActionListener(this);
	}
}
