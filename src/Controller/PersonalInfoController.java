package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import ui.EditingWindow;

public class PersonalInfoController implements ActionListener{
	
	
	public final static Logger LOGGER = LogManager.getLogger(PersonalInfoController.class.getName());
	private EditingWindow editWindow;
	
	public PersonalInfoController() {
		this.editWindow = new EditingWindow();
		initEditButton();
	}
	
	public void actionPerformed(ActionEvent e) {
		//add personal information pressed
		if(e.getSource() == this.editWindow.getAddInformationButton()) {
			String name = this.editWindow.getNameText().getText();
			String address = this.editWindow.getAddressText().getText();
			String email = this.editWindow.getEmailText().getText();
			String billing = this.editWindow.getBillingPeriodText().getText();
			
			//write to excel
		}
	}
	
	public void initEditButton() {
		this.editWindow.getAddInformationButton().addActionListener(this);
	}

}
