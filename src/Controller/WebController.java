package Controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import Main.Constants;
import Model.EventInformation;

/**
 * WebController
 * 
 * Simulates a firefox browser and connects to the given website
 * 
 * @author drusc0
 *
 */
public class WebController {

	public final static Logger LOGGER = LogManager
			.getLogger(WebController.class.getName());

	private FirefoxDriver firefoxDriver;

	private DesiredCapabilities capabilities;

	private String targetPage;

	private String followingPage;

	public WebController(String url) {
		this.setCapabilities();
		this.firefoxDriver = new FirefoxDriver(this.capabilities);
		this.targetPage = url;
		this.goToPage();
	}

	public WebController() {
		this.setCapabilities();
		this.firefoxDriver = new FirefoxDriver(this.capabilities);
	}

	/**
	 * setCapabilities() set desired capabilities of our driver to be platform
	 * independent and enable javascript
	 */
	public void setCapabilities() {
		this.capabilities = DesiredCapabilities.firefox();
		this.capabilities.setBrowserName("firefox");
		this.capabilities.setPlatform(Platform.ANY);
		this.capabilities.setJavascriptEnabled(true);
	}

	/**
	 * goToPage() takes the driver to the current target page
	 */
	public void goToPage() {
		this.firefoxDriver.get(this.targetPage);
	}

	public String getSourcePage() {
		return this.firefoxDriver.getPageSource();
	}

	/**
	 * getFrame() finds the element by its name and points the driver to it.
	 * 
	 * @return frame's source
	 */
	public String getFrame() {
		WebElement item = this.firefoxDriver.findElement(By.name("right"));
		this.firefoxDriver.switchTo().frame(item);
		return this.firefoxDriver.getPageSource();
	}

	/**
	 * getEventList() go over table and extract all the items in columns
	 * 
	 * @param name
	 * @return event information name
	 */
	public List<EventInformation> getEventListBy(String name) {
		List<EventInformation> lst = new ArrayList<EventInformation>();

		// get table table based on name
		WebElement table = this.firefoxDriver.findElement(By.id(name));
		int j = 0;
		// get its rows
		for (WebElement trElement : table.findElements(By.tagName("tr"))) {
			if (j == 0 || j == 1 || j == 2) {
				j++;
				continue;
			}
			List<WebElement> rowElements = trElement.findElements(By
					.tagName("td"));

			if (rowElements.size() > 1) {

				int i = 0;
				EventInformation ei = new EventInformation();
				// some data columns are useless or irrelevant
				for (WebElement tdElement : rowElements) {
					switch (i) {
					case 0:
						break;
					case 1:
						ei.setEventID(tdElement.getText());
						break;
					case 2:
						ei.setPosition(tdElement.getText());
						break;
					case 3:
						ei.setCustomerName(tdElement.getText());
						break;
					case 4:
						ei.setDate(tdElement.getText());
						break;
					case 5:
						ei.setCallIn(tdElement.getText());
						break;
					case 6:
						ei.setCallOut(tdElement.getText());
						break;
					case 7:
						ei.setHoursWorked(Double.parseDouble(tdElement
								.getText()));
						break;
					case 8:
						ei.setEventLocation(tdElement.getText());
					default:
						break;
					}
					i++;
				}
				lst.add(ei);
			}
		}
		return lst;
	}

	/**
	 * login() finds user and password elements. We set this elements with user
	 * defined information to log in.
	 * 
	 * @param username
	 * @param password
	 * @throws Exception
	 */
	public void login(String username, String password) throws Exception {
		// domain specific (CaterXpert)
		WebElement user = this.firefoxDriver.findElement(By
				.name("userBean.userName"));
		WebElement pass = this.firefoxDriver.findElement(By
				.name("userBean.password"));
		WebElement loginButton = this.firefoxDriver.findElement(By.id("save"));
		// pass the user and pass
		user.sendKeys(username);
		pass.sendKeys(password);
		// perform web click on the button
		loginButton.click();
		this.followingPage = this.firefoxDriver.getCurrentUrl();
	}

	/**
	 * close() closes current window
	 */
	public void close() {
		this.firefoxDriver.close();
	}

	/**
	 * quit() quits driver closing all associated windows
	 */
	public void quit() {
		this.firefoxDriver.quit();
	}

	public FirefoxDriver getFirefoxDriver() {
		return firefoxDriver;
	}

	public void setFirefoxDriver(FirefoxDriver firefoxDriver) {
		this.firefoxDriver = firefoxDriver;
	}

	public Capabilities getCapabilities() {
		return capabilities;
	}

	public void setCapabilities(DesiredCapabilities capabilities) {
		this.capabilities = capabilities;
	}

	public String getTargetPage() {
		return targetPage;
	}

	public void setTargetPage(String targetPage) {
		this.targetPage = targetPage;
	}

	public String getFollowingPage() {
		return followingPage;
	}

	public void setFollowingPage(String following) {
		this.followingPage = following;
	}
	
	/**
	 * exportToExcel()
	 * writes the items saved in models to excel
	 * @param eventList
	 */
	@SuppressWarnings("resource")
	private void exportToExcel(List<EventInformation> eventList) {
		HSSFWorkbook workbook = new HSSFWorkbook();
		HSSFSheet sheet = workbook.createSheet("Caterer's Info");
		FileOutputStream out;
		
		if (!eventList.isEmpty()) {
			int rowNumber = 2;
			for (EventInformation s : eventList) {
				s.print();
				HSSFRow nextrow = sheet.createRow(rowNumber);
				nextrow.createCell(0).setCellValue(s.getEventID());
				nextrow.createCell(1).setCellValue(s.getPosition());
				nextrow.createCell(2).setCellValue(s.getCustomerName());
				nextrow.createCell(3).setCellValue(s.getCallIn());
				nextrow.createCell(4).setCellValue(s.getCallOut());
				nextrow.createCell(5).setCellValue(s.getHoursWorked());
				nextrow.createCell(6).setCellValue(s.getEventLocation());
				nextrow.createCell(7).setCellValue(s.getDate());

				rowNumber++;
			}
		}
		try {
			out = new FileOutputStream(new File(System.getProperty("user.home")+"/newDocument.xls"));
			workbook.write(out);
			out.close();
		} catch (FileNotFoundException e) {
			LOGGER.error(Constants.ERROR_MESSAGE, e);		
		} catch (IOException e) {
			LOGGER.error(Constants.ERROR_MESSAGE, e);
		}
	}

	// MAIN (testing purposes)
	public static void main(String[] args) throws Exception {
		WebController wc = new WebController("http://designcuisine.com/staff");

		wc.login("", "");

		wc.getFrame();
		List<EventInformation> eventList = wc.getEventListBy("eventsList");
		wc.exportToExcel(eventList);
		Thread.sleep(5000);
		wc.quit();
	}

}
