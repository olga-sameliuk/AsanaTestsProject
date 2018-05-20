package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.ParentPage;

public class LoginPage extends ParentPage {
    @FindBy(xpath = ".//input[@id='email_input']")
    private WebElement inputLogin;
    @FindBy(xpath = ".//input[@id='password_input']")
    private WebElement inputPass;
    @FindBy(xpath = ".//button[@id='submit_button']")
    private WebElement buttonSubmit;

    public LoginPage(WebDriver webDriver) {
        super(webDriver, "/-/login");
    }

    public void openPage() {
        try {
            webDriver.get("https://app.asana.com");
            logger.info("Login page was open");
        } catch (Exception e) {
            logger.error("Can not open pages.LoginPage");
            Assert.fail("Can not open pages.LoginPage");
        }
    }

    public void enterLogin(String login) {
        actionsWithOurElements.enterTextIntoElement(inputLogin, login);
    }

    public void enterPass(String pass) {
        actionsWithOurElements.enterTextIntoElement(inputPass, pass);
    }

    public void clickSubmitButton() {
        actionsWithOurElements.clickOnElement(buttonSubmit);
    }
    public void userLogin (String login, String password) {
        openPage();
        enterLogin(login);
        enterPass(password);
        clickSubmitButton();
    }


}