package Controller;

import Model.WebPageData;
import ui.InputURLWindow;

public class DataController {

	//InputURLWindow inputURLView = new InputURLWindow();
	WebPageData webPageDataModel = new WebPageData();

	public void setURL(String URL) {
		String extractedData = webPageDataModel.getData(URL);
		
	}
}
