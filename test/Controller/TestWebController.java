package Controller;

import junit.framework.TestCase;

public class TestWebController extends TestCase {

	WebController wc;
	String target;

	public void setUp() {
		target = "http://www.google.com";
		wc = new WebController(target);
	}

	public void testDriver() throws Exception {

		String title = "Google";
		assertEquals(wc.getFirefoxDriver().getTitle(), title);

		Thread.sleep(2000);
		wc.quit();
	}

	public void testPage() throws Exception {
		String xmlPage = wc.getFirefoxDriver().getPageSource();
		String str = "Search the world's information, including webpages, images, videos and more. "
				+ "Google has many special features to help you find exactly what you're looking for.";

		assertTrue(xmlPage.contains(str));

		Thread.sleep(3000);
		wc.quit();
	}
}
