package Controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import Main.Constants;
import Model.EmployeeInformation;
import Model.EventInformation;
import Observer.Observer;

/** 
 * Andres, Sameksha, Shruti, Vivek
 * ExcelController.java
 * {Andres - Caterers 0.9}
 */
public class ExcelController implements Observer {

	public final static Logger LOGGER = LogManager.getLogger(ExcelController.class.getName());
	private HSSFWorkbook workbook;
	private HSSFSheet sheet;
	private FileOutputStream out;
	
	public ExcelController() {
		this.workbook = new HSSFWorkbook();
		this.sheet = createSheet();
		
		try {
			setOut(new FileOutputStream(new File(System.getProperty("user.home") 
					+ Constants.FILE)));
			System.out.println("Location:"+System.getProperty("user.home")+Constants.FILE);    //Just for Testing
		}catch (Exception e) {
			LOGGER.error(Constants.ERROR_MESSAGE, e);
		}
	}
	
	public HSSFSheet createSheet() {
		HSSFSheet sheet = this.workbook.createSheet();
		return sheet;
	}
	
	public HSSFWorkbook getWorkbook() {
		return this.workbook;
	}
	
	
	/**
	 * writePersonalInfoToSheet
	 * writes the 4 main fields requested from the GUI
	 * @param sheet
	 * @param emp
	 */
	public void writePersonalInfoToSheet(EmployeeInformation emp) {
		
		int rowNumber = 2;
		HSSFRow row = sheet.createRow(rowNumber);
		row.createCell(1).setCellValue("Name");
		row.createCell(2).setCellValue(emp.getName());
		rowNumber++;
		row = sheet.createRow(rowNumber);
		row.createCell(1).setCellValue("Address");
		row.createCell(2).setCellValue(emp.getAddress());
		rowNumber++;
		row = sheet.createRow(rowNumber);
		row.createCell(1).setCellValue("Email");
		row.createCell(2).setCellValue(emp.getEmail());
		rowNumber++;
		row = sheet.createRow(rowNumber);
		row.createCell(1).setCellValue("Billing Cycle");
		row.createCell(2).setCellValue(emp.getBillingStart());
		
	}
	
	
	/**
	 * writeEventToSheet
	 * writes event information from event list.
	 * @param sheet
	 * @param list
	 */
	public void writeEventToSheet(List<EventInformation> list) {
		int rowNumber = 8;
		HSSFRow nameRow = sheet.createRow(rowNumber);
		nameRow.createCell(1).setCellValue("Date");
		nameRow.createCell(2).setCellValue("Event ID");
		nameRow.createCell(3).setCellValue("Location");
		nameRow.createCell(4).setCellValue("Call in");
		nameRow.createCell(5).setCellValue("Call out");
		nameRow.createCell(6).setCellValue("Hours");
		nameRow.createCell(7).setCellValue("Pay");
		
		if(!list.isEmpty()) {
			rowNumber = 9;
			for(EventInformation item : list) {
				HSSFRow row = sheet.createRow(rowNumber);

				row.createCell(1).setCellValue(item.getDate());
				row.createCell(2).setCellValue(item.getEventID());
				row.createCell(3).setCellValue(item.getEventLocation());
				row.createCell(4).setCellValue(item.getCallIn());
				row.createCell(5).setCellValue(item.getCallOut());
				row.createCell(6).setCellValue(item.getHoursWorked());
				row.createCell(7).setCellValue(item.getExtraPay());

				rowNumber++;
				
			}
		}
		
	}
	
	/**
	 * Method trying to write the data received
	 */
	public void write() {
		try {
			this.workbook.write(this.out);
		} catch (Exception e) {
			LOGGER.error(Constants.ERROR_MESSAGE, e);
		}
	}
	
	
	public void closeFile() throws IOException {
		this.out.close();
	}
	
	
	public FileOutputStream getOut() {
		return out;
	}

	public void setOut(FileOutputStream out) {
		this.out = out;
	}

	public void update(Object... objects) {
		if(objects != null) {
			EmployeeInformation emp = (EmployeeInformation) objects[0];
			this.writePersonalInfoToSheet(emp);
		}		
	}
}
