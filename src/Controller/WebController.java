package Controller;
/**
 * Andres, Sameksha, Shruti, Vivek
 * WebController.java
 * {Andres - Caterers 0.9}
 */
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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
	
	private ExcelController excelController;

	private FirefoxDriver firefoxDriver;

	private DesiredCapabilities capabilities;

	private String targetPage;

	private String followingPage;

	public WebController(String url, ExcelController excelController) {
		this.excelController = excelController;
		this.setCapabilities();
		this.firefoxDriver = new FirefoxDriver(this.capabilities);
		this.targetPage = url;
		this.goToPage();
	}

	public WebController(ExcelController excelController) {
		this.excelController = excelController;
		this.setCapabilities();
		this.firefoxDriver = new FirefoxDriver(this.capabilities);
	}

	public WebController(String url) {
		this.setCapabilities();
		this.firefoxDriver = new FirefoxDriver(this.capabilities);
		this.targetPage = url;
		this.goToPage();
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
	public String getFrame(String frame) {
		System.out.println(frame);
		WebElement item = this.firefoxDriver.findElement(By.name(frame));
		System.out.println("item"+item);
		this.firefoxDriver.switchTo().frame(item);
		return this.firefoxDriver.getPageSource();
	}
	
	/**
	 * getNextPage
	 * 
	 * clicks on next page to load the new html code
	 */
	public void getNextPage() {
		try {
			WebElement next = this.firefoxDriver.findElementByXPath("//*[@title='Next']");
			next.click();
		} catch (Exception e) {
			LOGGER.warn(e);
		}
	}
	
	
	public boolean nextPage() {
		try{
			this.firefoxDriver.findElementByXPath("//*[@title='Next']");
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * getEventList() go over table and extract all the items in columns
	 * 
	 * @param name
	 * @return event information name
	 */
	public void getEventListBy(String name, List<EventInformation> lst) {
		try {
			// get table table based on name
			WebElement table = this.firefoxDriver.findElement(By.id(name));
			// get next paging item
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
					WebElement confirm = null;
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
							this.getCallInfo(tdElement, ei);
							
							if(ei.getCallIn().isEmpty()) {
								ei.setCallIn(tdElement.getText());
							}
							break;
						case 6:
							if(ei.getCallOut().isEmpty()) {
								ei.setCallOut(tdElement.getText());
							}
							break;
						case 7:
							if(ei.getHoursWorked() == 0) {
								ei.setHoursWorked(Double.parseDouble(tdElement
										.getText()));
							}
							break;
						case 8:
							ei.setEventLocation(tdElement.getText());
							break;
						case 10:
							confirm = tdElement.findElement(By.xpath("//*[@class='dijitReset dijitInputInner']"));
							break;
						default:
							break;
						}
						i++;
					}
					if(confirm.getAttribute("value").equals("Confirmed"))
						lst.add(ei);
				}
			}
		} catch (Exception e) {
			LOGGER.warn(e);
		}
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
	 * logout()
	 * finds the logout web element and proceeds to click
	 */
	public void logout() {
		this.excelController.write();
		
		try {
			this.excelController.closeFile();
		} catch (IOException e) {
			LOGGER.error(Constants.ERROR_MESSAGE, e);
		}
		
		WebElement logout = this.firefoxDriver.findElementByXPath("//*[@title='Logout']");
		logout.click();
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			LOGGER.error(Constants.ERROR_MESSAGE, e);
		}
	}
	
	
	/**
	 * getCallInfo
	 * finds the call info item in the DOM, this item is important
	 * because it contains the processed event information.
	 * It clicks and displays the information
	 */
	public void getCallInfo(WebElement tdElement, EventInformation ei) {
		try {
			String actualInfo = "";
			WebElement temp = tdElement.findElement(By.tagName("a"));
			double rate = 0;
			actualInfo = temp.getAttribute("href");
			String[] array = actualInfo.split(",");
			for(int k = 0; k < array.length; k++) {
				switch(k) {
				case 0:
					ei.setCallIn(array[k].split("\'")[1].replace("%20", " "));
					break;
				case 1:
					ei.setCallOut(array[k].split("\'")[1].replace("%20", " "));
					break;
				case 2:
					rate = Double.parseDouble(array[k].split("\'")[1]);
					break;
				case 3:
					ei.setHoursWorked(Double.parseDouble(array[k].split("\'")[1]));
					ei.setExtraPay(ei.getHoursWorked() * rate);
					break;
				case 4:
					break;
				case 5:
					ei.setExtraPay(ei.getExtraPay() +  Double.parseDouble(array[k].split("\'")[1]));
					break;
				case 6:
					ei.setExtraPay(ei.getExtraPay() +  Double.parseDouble(array[k].split("\'")[1]));
					break;
				}
			}
		} catch (Exception e) {}
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
	public void exportToExcel() {
		List<EventInformation>  eventList = new ArrayList<EventInformation>();
		
		while(this.nextPage()) {
			this.getEventListBy("eventsList", eventList);
			this.getNextPage();
		}
		
		this.getEventListBy("eventsList", eventList);
		
		this.excelController.writeEventToSheet(eventList);
		
		this.firefoxDriver.switchTo().parentFrame();
	}
	

	/**
	 * filterData()
	 * filter data based on the date provided by the user.
	 * @param startDate,endDate
	 */
	public void filterData(String startDate, String endDate) {
		try {
			Thread.sleep(5000);

			System.out.println("Title of the page BEFORE - switchingTo: " + firefoxDriver.getTitle());
			WebElement filterTag = this.firefoxDriver.findElementByXPath("//*[@id='screenlinks']/div[1]/a");

			filterTag.click();
			for (String winHandle : firefoxDriver.getWindowHandles()) {
				this.firefoxDriver.switchTo().window(winHandle);
			}
			Thread.sleep(5000);
			// getFrame("filterPreferences");
			WebElement webStartDate = this.firefoxDriver.findElement(By.id("startDate"));
			WebElement webEndDate = this.firefoxDriver.findElement(By.id("endDate"));
			WebElement applyButton = this.firefoxDriver.findElement(By.id("apply"));

			webStartDate.clear();
			webEndDate.clear();

			webStartDate.sendKeys(startDate);
			webEndDate.sendKeys(endDate);
			applyButton.click();

			//System.out.println("Title of the page after - switchingTo: " + firefoxDriver.getTitle());

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	

	// MAIN (testing purposes)
	public static void main(String[] args) throws Exception {
		ExcelController ec = new ExcelController();
		WebController wc = new WebController("http://designcuisine.com/staff", ec);
		try {
			wc.login("", "");
	
			wc.getFrame("right");
			Thread.sleep(2000);
			//List<EventInformation> eventList = wc.getEventListBy("eventsList");
			wc.exportToExcel();
			wc.getFrame("right");
			//wc.getFrame("header");
			//wc.logout();
			Thread.sleep(5000);
		} catch (Exception e) {
			LOGGER.error(Constants.ERROR_MESSAGE, e);
		} finally {
			wc.quit();
		}
	}

	public void changeWindow() {
		// TODO Auto-generated method stub
		for (String winHandle : firefoxDriver.getWindowHandles()) {
			this.firefoxDriver.switchTo().window(winHandle);
			//System.out.println(winhandle);
		}
		
	}

}
