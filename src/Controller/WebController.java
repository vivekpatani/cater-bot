package Controller;

import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

/**
 * WebController
 * 
 * Simulates a firefox browser and connects to the given website
 * @author drusc0
 *
 */
public class WebController {
	
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
		this.firefoxDriver.getCapabilities().isJavascriptEnabled();
	}
	
	
	public void setCapabilities() {
		this.capabilities = DesiredCapabilities.firefox();
		this.capabilities.setBrowserName("firefox");
		this.capabilities.setPlatform(Platform.ANY);
		this.capabilities.setJavascriptEnabled(true);
	}
	
	public void goToPage() {
		this.firefoxDriver.get(this.targetPage);
	}
	
	public String getSourcePage() {
		return this.firefoxDriver.getPageSource();
	}
	
	
	public String getFrame() {
		WebElement item = this.firefoxDriver.findElement(By.name("right"));
		this.firefoxDriver.switchTo().frame(item);
		return this.firefoxDriver.getPageSource();
	}
	
	/**
	 * login()
	 * finds user and password elements. We set this elements with
	 * user defined information to log in.
	 * @param username
	 * @param password
	 * @throws Exception
	 */
	public void login(String username, String password) throws Exception {
		//domain specific (CaterXpert)
		WebElement user = this.firefoxDriver.findElement(By.name("userBean.userName"));
		WebElement pass = this.firefoxDriver.findElement(By.name("userBean.password"));
		WebElement loginButton = this.firefoxDriver.findElement(By.id("save"));
		//pass the user and pass
		user.sendKeys(username);
		pass.sendKeys(password);
		//perform web click on the button
		loginButton.click();
		this.followingPage = this.firefoxDriver.getCurrentUrl();
	}
	
	
	/**
	 * close()
	 * closes current window
	 */
	public void close() {
		this.firefoxDriver.close();
	}
	
	/**
	 * quit()
	 * quits driver closing all associated windows
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
	
	
	//MAIN (testing purposes)
	public static void main(String[] args) throws Exception {
		WebController wc = new WebController("http://designcuisine.com/staff");
		
		wc.login("jrivero", "3513usa");
		
		System.out.println(wc.getFrame());		
		
		
		Thread.sleep(5000);
		wc.quit();
	}
}
