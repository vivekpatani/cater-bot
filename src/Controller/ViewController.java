package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import ui.EditingWindow;
import ui.LoggingWindow;
import ui.MainWindow;

public class ViewController implements ActionListener {
	
	private MainWindow mainWindow;
	private LoggingWindow loginWindow;
	private EditingWindow editWindow;
	
	public ViewController(MainWindow mainWindow, LoggingWindow loginWindow, EditingWindow editWindow) {
		this.mainWindow = mainWindow;
		initButtonMain();
		this.loginWindow = loginWindow;
		initButtonLogin();
		this.editWindow = editWindow;
		initButtonEdit();
	}

	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == this.mainWindow.getStartButton()) {
			this.mainWindow.setVisible(false);
			this.editWindow.setVisible(true);
		} else if (e.getSource() == this.loginWindow.getLoginButton()) {
			this.loginWindow.setVisible(false);
			this.editWindow.setVisible(true);
			//TODO: webcontroller logs in to the website using this information
			//webcontroller.login()
		} else if (e.getSource() == this.loginWindow.getCancelButton()) {
			this.loginWindow.setVisible(false);
			this.editWindow.setVisible(true);
		} else if (e.getSource() == this.loginWindow.getCancelButton()) {
			this.loginWindow.setVisible(false);
			this.mainWindow.setVisible(true);
		} else if (e.getSource() == this.editWindow.getScrapeButton()) {
			this.editWindow.setVisible(false);
			this.loginWindow.setVisible(true);
		} else if (e.getSource() == this.editWindow.getAddInformationButton()) {
			
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
		this.editWindow.getAddInformationButton().addActionListener(this);
	}
}
