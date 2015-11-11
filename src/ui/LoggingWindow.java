package ui;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoggingWindow {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static JFrame mainFrame = ApplicationWindow.getFrame();
	private static JPanel windowPanel;
	private Dimension dim = mainFrame.getSize();
	private GridBagConstraints gridBagConstraints;
	private JButton loginButton;
	private JLabel userLabel;
	private JLabel passLabel;
	private JTextField userText;
	private JPasswordField passText;
	
	public LoggingWindow() {
		windowPanel = new JPanel();
		this.userLabel = new JLabel("Username");
		this.passLabel = new JLabel("Password");
		this.userText = new JTextField();
		this.passText = new JPasswordField();
		this.loginButton = new JButton();
		initGridBagConstraints();
		initWindow();
	}
	
	public void initWindow() {
		windowPanel.setLayout(new GridBagLayout());
		this.userLabel.setText("Username");
		this.passLabel.setText("Password");
		this.userText.setToolTipText("type in username");
		this.passText.setToolTipText("type in password");
		this.loginButton.setText("Log In");
		this.loginButton.setEnabled(false);
		
		Dimension dim = mainFrame.getSize();
		
		mainFrame.setSize(dim.width/2, dim.height/2);
		
		windowPanel.add(this.userLabel, setGridBagConstraints(0,0));
		windowPanel.add(this.userText, setGridBagConstraints(1,0));
		windowPanel.add(this.passLabel, setGridBagConstraints(0,1));
		windowPanel.add(this.passText, setGridBagConstraints(1,1));
		windowPanel.add(this.loginButton, setGridBagConstraints(1,2));
		mainFrame.add(windowPanel);
	}
	
	private void initGridBagConstraints() {
		gridBagConstraints = new GridBagConstraints();
		gridBagConstraints.weightx = 0.5;
		gridBagConstraints.weighty = 0.0;
		gridBagConstraints.insets = new Insets(5, 5, 0, 5);
		gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
	}
	
	private GridBagConstraints setGridBagConstraints(int x, int y) {
		gridBagConstraints.gridx = x;
		gridBagConstraints.gridy = y;
		return gridBagConstraints;
	}
	
}
