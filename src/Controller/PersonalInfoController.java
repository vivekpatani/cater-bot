package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import ui.EditingWindow;
import Model.EmployeeInformation;

public class PersonalInfoController implements ActionListener{
	
	
	public final static Logger LOGGER = LogManager.getLogger(PersonalInfoController.class.getName());
	private EditingWindow editWindow;
	private ExcelController excelController;
	
	public PersonalInfoController(EditingWindow editWindow, ExcelController excelController) {
		this.editWindow = editWindow;
		initEditButton();
		this.excelController = excelController;
	}
	
	public void actionPerformed(ActionEvent e) {
		//add personal information pressed
		if(e.getSource() == this.editWindow.getAddInformationButton()) {
			String name = this.editWindow.getNameText().getText();
			String address = this.editWindow.getAddressText().getText();
			String email = this.editWindow.getEmailText().getText();
			String billing = this.editWindow.getBillingPeriodText().getText();
			
			EmployeeInformation emp = new EmployeeInformation(name, address, email, billing);
			//write to excel
			this.excelController.writePersonalInfoToSheet(emp);
		}
	}
	
	public void initEditButton() {
		this.editWindow.getAddInformationButton().addActionListener(this);
	}

}
