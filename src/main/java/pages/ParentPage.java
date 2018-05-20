package pages;

import libs.ActionsWithOurElements;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;


public class ParentPage {
    WebDriver webDriver;
    String expectedURL;
    final String baseUrl = "https://app.asana.com";
    static Logger logger =  Logger.getLogger(ParentPage.class);
    ActionsWithOurElements actionsWithOurElements;

    public ParentPage(WebDriver webDriver, String expectedURL) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
        this.expectedURL = baseUrl + expectedURL;
        actionsWithOurElements = new ActionsWithOurElements(webDriver);
    }

    public String getCurrentURL() {
        return webDriver.getCurrentUrl();
    }
}
