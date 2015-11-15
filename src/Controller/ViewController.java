package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import ui.LoggingWindow;
import ui.MainWindow;

public class ViewController implements ActionListener {
	
	private MainWindow mainWindow;
	private LoggingWindow loginWindow;
	
	public ViewController(MainWindow mainWindow, LoggingWindow loginWindow) {
		this.mainWindow = mainWindow;
		initButtonMain();
		this.loginWindow = loginWindow;
		initButtonLogin();
	}

	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == this.mainWindow.getStartButton()) {
			this.mainWindow.setVisible(false);
			this.loginWindow.setVisible(true);

		} else if (e.getSource() == this.loginWindow.getLoginButton()) {
			this.loginWindow.setVisible(false);
			this.mainWindow.setVisible(true);
		}
	}
	
	public void initButtonMain() {
		this.mainWindow.getStartButton().addActionListener(this);
	}
	
	public void initButtonLogin() {
		this.loginWindow.getLoginButton().addActionListener(this);
	}
}
