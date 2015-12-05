package ui;
/**
 * Andres, Sameksha, Shruti, Vivek
 * AbstractPanel.java
 * {Andres - Caterers 0.9}
 */
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Class is abstract and is used to define the generic structure of a JFrame
 * It also defines the components potentially needed to setup each window
 */
public abstract class AbstractPanel extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	//General Variable Declaration
	private JPanel panel;
	private GridBagLayout layout;
	private GridBagConstraints constraints;

	/**
	 * Basic Constructor
	 */
	public AbstractPanel() {
		this.panel = new JPanel();
		this.layout = new GridBagLayout();
		this.constraints = new GridBagConstraints();
		this.panel.setLayout(this.layout);
		this.add(this.panel);
	}

	/**
	 * Method to setup basic Constraints to the GridBadConstraints layout
	 */
	public void setConstraints() {
		this.constraints.weightx = 0.5;
		this.constraints.weighty = 0.5;
		this.constraints.insets = new Insets(5, 5, 0, 5);
		this.constraints.fill = GridBagConstraints.BOTH;
	}

	/**
	 * Method to setup basic Constraints to the GridBadConstraints location
	 * @param x
	 * @param y
	 * @return
	 */
	public GridBagConstraints setGridLocation(int x, int y) {
		this.constraints.gridx = x;
		this.constraints.gridy = y;
		return this.constraints;
	}
	
	/**
	 * Method to get the current JPanel
	 * @return
	 */
	public JPanel getPanel() {
		return this.panel;
	}
	
	/**
	 * Method to get the GridBag Layout
	 */
	public GridBagLayout getLayout() {
		return this.layout;
	}
	
	/**
	 * Method used to get the GridBagConstraints
	 * @return
	 */
	public GridBagConstraints getConstraints()  {
		return this.constraints;
	}
	
	/**
	 * Method used to set the name of the screen
	 */
	public void setName(String name) {
		this.setTitle(name);
	}
	
	/**
	 * Method used to place the software window towards the center
	 * @param frame
	 */
	public void center(JFrame frame) {
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setLocation(dim.width / 2 - frame.getSize().width / 2,
				dim.height / 2 - frame.getSize().height / 2);
	}
}