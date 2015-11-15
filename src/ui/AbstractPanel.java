package ui;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public abstract class AbstractPanel extends JFrame {

	/**
	 * 
	 */
	public final static Logger LOGGER = LogManager
			.getLogger(AbstractPanel.class.getName());
	private static final long serialVersionUID = 1L;
	private JPanel panel;
	private GridBagLayout layout;
	private GridBagConstraints constraints;

	public AbstractPanel() {
		this.panel = new JPanel();
		this.layout = new GridBagLayout();
		this.constraints = new GridBagConstraints();
		this.panel.setLayout(this.layout);
		this.add(this.panel);
	}

	public void setConstraints() {
		this.constraints.weightx = 0.5;
		this.constraints.weighty = 0.5;
		this.constraints.insets = new Insets(5, 5, 0, 5);
		this.constraints.fill = GridBagConstraints.BOTH;
	}

	public GridBagConstraints setGridLocation(int x, int y) {
		this.constraints.gridx = x;
		this.constraints.gridy = y;
		return this.constraints;
	}
	
	public JPanel getPanel() {
		return this.panel;
	}
	
	public GridBagLayout getLayout() {
		return this.layout;
	}
	
	public GridBagConstraints getConstraints()  {
		return this.constraints;
	}
	
	public void setName(String name) {
		this.setTitle(name);
	}
	
	public void center(JFrame frame) {
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setLocation(dim.width / 2 - frame.getSize().width / 2,
				dim.height / 2 - frame.getSize().height / 2);
	}

}
