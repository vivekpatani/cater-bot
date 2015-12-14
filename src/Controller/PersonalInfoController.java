package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import ui.EditingWindow;
import Model.EmployeeInformation;
import Observer.Observable;
import Observer.Observer;

public class PersonalInfoController implements ActionListener, Observable{
	
	
	public final static Logger LOGGER = LogManager.getLogger(PersonalInfoController.class.getName());
	private EditingWindow editWindow;
	private ExcelController excelController;
	private List<Observer> observers;
	EmployeeInformation emp;
	
	public PersonalInfoController(EditingWindow editWindow, ExcelController excelController) {
		this.editWindow = editWindow;
		initEditButton();
		this.excelController = excelController;
		this.observers = new ArrayList<Observer>();
	}
	
	public void actionPerformed(ActionEvent e) {
		//add personal information pressed
		if(e.getSource() == this.editWindow.getAddInformationButton()) {
			String name = this.editWindow.getNameText().getText();
			String address = this.editWindow.getAddressText().getText();
			String email = this.editWindow.getEmailText().getText();
			String billing = this.editWindow.getBillingPeriodText().getText();
			
			this.emp = new EmployeeInformation(name, address, email, billing);
			this.notifyObservers();
			//write to excel
			this.excelController.writePersonalInfoToSheet(emp);
		}
	}
	
	public void initEditButton() {
		this.editWindow.getAddInformationButton().addActionListener(this);
	}

	public void addObserver(Observer observer) {
		this.observers.add(observer);
	}

	public void removeObserver(Observer observer) {
		this.observers.remove(observer);
	}

	public void removeAllObservers() {
		this.observers.clear();
	}

	public void notifyObservers(Object... obj) {
		// TODO Auto-generated method stub
		
	}

	public void notifyObservers() {
		for(Observer o: observers) {
			o.update(this.emp);
		}
	}

}
