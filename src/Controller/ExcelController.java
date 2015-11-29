package Controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import Model.EmployeeInformation;
import Model.EventInformation;

/**
 * ExcelController
 * 
 * allows creating an excel workbook to be written information from web and personal
 * @author drusc0
 *
 */
public class ExcelController {

	public final static Logger LOGGER = LogManager.getLogger(ExcelController.class.getName());
	private HSSFWorkbook workbook;
	
	public ExcelController() {
		this.workbook = new HSSFWorkbook();
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
	public void writePersonalInfoToSheet(HSSFSheet sheet, EmployeeInformation emp) {
		
		int rowNumber = 2;
		List<HSSFRow> rows = new ArrayList<HSSFRow>();
		for(int i = 0; i < 4; i++) {
			rows.add(sheet.createRow(rowNumber+i));
		}
		rows.get(0).createCell(1).setCellValue("Name");
		rows.get(0).createCell(2).setCellValue(emp.getName());
		rows.get(1).createCell(1).setCellValue("Address");
		rows.get(1).createCell(2).setCellValue(emp.getAddress());
		rows.get(2).createCell(1).setCellValue("Email");
		rows.get(2).createCell(2).setCellValue(emp.getEmail());
		rows.get(3).createCell(1).setCellValue("Billing Cycle");
		rows.get(3).createCell(2).setCellValue(emp.getBillingStart());
	}
	
	
	/**
	 * writeEventToSheet
	 * writes event information from event list.
	 * @param sheet
	 * @param list
	 */
	public void writeEventToSheet(HSSFSheet sheet, List<EventInformation> list) {
		
		if(!list.isEmpty()) {
			int rowNumber = 6;
			
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
}
