package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.concurrent.TimeUnit;

public class MainPage extends ParentPage {
    @FindBy(xpath = ".//*[@class='CircularButton CircularButton--enabled CircularButton--xxsmall CircularButton--circular SidebarTeamDetailsProjectsList-addProjectButton']")
    private WebElement addProjectButon;
    @FindBy(xpath = ".//input[@id='new_project_dialog_content_name_input']")
    private WebElement projectName;
    @FindBy(xpath = ".//*[text()='Description']")
    private WebElement descriptionButton;
    @FindBy(xpath = ".//*[@class='quill-container']//div[1]")
    private WebElement projectDescription;
    @FindBy(xpath = ".//input[@class='NewProjectForm-boardRadio']")
    private WebElement boardRadioButton;

    @FindBy(xpath = ".//input[@class='NewProjectForm-privateToMembersRadio']")
    private WebElement scrollbar;

    @FindBy(xpath = ".//*[@class='Button Button--medium Button--primary CreateBlankProjectRow-button NewProjectForm-createButton']")
    private WebElement createButton;

    @FindBy(xpath = ".//*[@title='Work Project']")
    private WebElement projectButton;

    @FindBy(xpath = ".//*[@class='PageHeaderStructure-titleRightElement']")
    private WebElement projectDDButton;

    @FindBy(xpath = ".//span[.='Delete Project']")
    private WebElement deleteOption;

    @FindBy(xpath = ".//*[@class='menuItem-button is-highlighted menuItem--small ProjectDropdownMenuButton-deleteProjectButton']")
    private WebElement deleteOption_S;

    @FindBy(xpath = ".//*[@class='Button Button--medium Button--primary BoardWelcomeBanner-button']")
    private WebElement addColumnsButton;
    @FindBy(xpath = ".//*[@class='textInput textInput--medium BoardColumnNameInput-input BoardNewColumnForm-input']")
    private WebElement columnText;
    @FindBy(xpath = ".//*[@class='BoardBody-descriptionLink']")
    private WebElement showDescriptionLink;

    @FindBy(xpath = ".//*[@class='CardButton BoardAddCardButton BoardColumnCardsContainer-addCardButton']")
    private WebElement addButtonPlus;

    @FindBy(xpath = ".//*[@class='simpleTextarea autogrowTextarea-input']")
    private WebElement textarea;

    @FindBy(xpath = ".//*[@class='ProjectOverviewSection-header']")
    private WebElement descriptionBoard;

    @FindBy(xpath = ".//*[@id='confirm']")
    private WebElement confirmButton;


    public MainPage(WebDriver webDriver) {
        super(webDriver, "/0/dashboard/661707260041680");
    }

    public void clickoOnAddProgectButton() {
        actionsWithOurElements.clickOnElement(addProjectButon);
    }

    public void enterProjectName(String text) {
        actionsWithOurElements.enterTextIntoElement(projectName, text);
    }

    public void clickoOnDescriptionButton() {
        actionsWithOurElements.clickOnElement(descriptionButton);
    }

    public void enterProjectDescription(String text) {
        actionsWithOurElements.enterTextIntoElement(projectDescription, text);
    }

    public void waitSeconds(int seconds) {
        webDriver.manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);
    }

    public void clickoOnBoardRadioButton() {
        actionsWithOurElements.clickOnElement(boardRadioButton);
    }

    public void clickoOnCreateButton() {
        actionsWithOurElements.clickOnElement(createButton);
    }

    public void scroll() {
        actionsWithOurElements.scrollbarDown(scrollbar);
    }

    public boolean isNewProjectAdded(String nameOfProject) {
        return actionsWithOurElements.isElementPresent(".//*[text()='" + nameOfProject + "']");
    }

    public void assertProjectNotExists(String nameOfProject) {
        Assert.assertFalse(actionsWithOurElements.isElementPresent(".//*[text()='" + nameOfProject + "']"));
    }

    public void clickOnProjectButton() {
        actionsWithOurElements.clickOnElement(projectButton);
    }

    public void clickoOnProjectDDButton() {
        actionsWithOurElements.clickOnElement(projectDDButton);
    }

    public void clickOnDeleteOption() {
        actionsWithOurElements.clickOnElement(deleteOption);
    }

    public void selectDeleteOption(String text) {
        actionsWithOurElements.selectValueInDD(deleteOption_S, text);
    }

    public void mouseOnDeleteOption() {
        actionsWithOurElements.mouseOver(deleteOption);
    }

    public void clickOnAddColumnsButton() {
        actionsWithOurElements.clickOnElement(addColumnsButton);
    }

    public void enterColumnText(String text) {
        actionsWithOurElements.enterTextIntoElement(columnText, text);
    }

    public void clickOnShowDescriptionLink() {
        actionsWithOurElements.clickOnElement(showDescriptionLink);
    }

    public void clickOnAddButtonPlus() {
        actionsWithOurElements.clickOnElement(addButtonPlus);
    }

    public void enterTextIntoTextarea(String text) {
        actionsWithOurElements.enterTextIntoElement(textarea, text);
    }

    public boolean isLinkPresent() {
        return actionsWithOurElements.isElementPresent(showDescriptionLink);
    }

    public boolean isDescriptionBoardPresent() {
        return actionsWithOurElements.isElementPresent(descriptionBoard);
    }

    public void clicOnConfirmButton() {
        actionsWithOurElements.clickOnElement(confirmButton);
    }
}
