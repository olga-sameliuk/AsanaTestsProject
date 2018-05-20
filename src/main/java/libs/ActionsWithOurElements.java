package libs;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class ActionsWithOurElements {
    WebDriver webDriver;
    Logger logger;
    WebDriverWait webDriverWait10;
    JavascriptExecutor je = (JavascriptExecutor) webDriver;

    public ActionsWithOurElements(WebDriver webDriver) {
        this.webDriver = webDriver;
        logger = Logger.getLogger(getClass());
        webDriverWait10 = new WebDriverWait(webDriver, 10);
    }

    public void enterTextIntoElement(WebElement webElement, String text) {
        try {
            webDriverWait10.until(ExpectedConditions.visibilityOf(webElement));
            webElement.clear();
            webElement.sendKeys(text);
            logger.info(text + " was inputted into element");
        } catch (Exception e) {
            printErrorAndStopTest(e);
            e.printStackTrace();
        }
    }

    private void printErrorAndStopTest(Exception e) {
        e.printStackTrace();
        logger.error("Can not work with element");
        Assert.fail("Can not work with element");
    }

    public void clickOnElement(WebElement webElement) {
        try {
            webDriverWait10.until(ExpectedConditions.elementToBeClickable(webElement));
            webElement.click();
            logger.info("Element was clicked");
        } catch (Exception e) {
            printErrorAndStopTest(e);
        }
    }

    public void scrollbarDown(WebElement webElement) {
        ((JavascriptExecutor) webDriver).executeScript("arguments[0].scrollIntoView(true);", webElement);
    }

    public boolean isElementPresent(String locator) {
        try {
            WebElement webElement = webDriver.findElement(By.xpath(locator));
            return isElementPresent(webElement);

        } catch (Exception e) {
            return false;
        }
    }

    public boolean isElementPresent(WebElement webElement) {
        try {
            return webElement.isDisplayed() && webElement.isEnabled();
        } catch (Exception e) {
            return false;
        }
    }

    public void selectValueInDD(WebElement webElement, String text) {
        try {
            Select select = new Select(webElement);
            select.selectByVisibleText(text);
            logger.info(text + "was select in DD");
        } catch (Exception e) {
            printErrorAndStopTest(e);
        }
    }

    public void mouseOver(WebElement element) {
        Actions actions = new Actions(webDriver);
        actions.moveToElement(element).build().perform();
    }
}
