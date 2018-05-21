package mainTests;

import org.junit.Test;
import parentTest.ParentTest;

public class MainTests extends ParentTest {
    final String nameOfProject = "Work Project";


    /* Test Case 1
    Summary:  На главной станице проверить функцию добавления нового проекта в список проектов
    на боковой панели меню.
    */
    @Test
    public void addNewProject() {
        loginPage.userLogin("lunopark123@ukr.net", "Lunopark123");
        mainPage.clickoOnAddProgectButton();
        mainPage.enterProjectName("Work Project");
        mainPage.clickoOnDescriptionButton();
        mainPage.waitSeconds(3);
        mainPage.enterProjectDescription("Work at automation tests");
        mainPage.clickoOnBoardRadioButton();
        mainPage.scroll();
        mainPage.clickoOnCreateButton();
        checkAC("Work Project is not added", mainPage.isNewProjectAdded(nameOfProject), true);
    }


    /* Test Case2
    Summary:  Проверить функцию добавления колонки в новый проект «Work Project».
    */
    @Test
    public void addNewColumn() {
        loginPage.userLogin("lunopark123@ukr.net", "Lunopark123");
        mainPage.clickOnProjectButton();
        mainPage.clickOnAddColumnsButton();
        mainPage.enterColumnText("First Goal" + "\n");
        mainPage.clickOnAddButtonPlus();
        mainPage.enterTextIntoTextarea("Organizatioonal");
        checkAC("Link Show Project Description is not present", mainPage.isLinkPresent(), true);
    }

    /* Test Case3
      Summary:  Проверить функцию появления секции DESCRIPTION с текстом «Work at automation tests».
      */
    @Test
    public void checkProjectDescription() {
        loginPage.userLogin("lunopark123@ukr.net", "Lunopark123");
        mainPage.clickOnProjectButton();
        mainPage.clickOnShowDescriptionLink();
        checkAC(" DESCRIPTION BOARD is not present", mainPage.isDescriptionBoardPresent(), true);
    }

    /*Test Case4
    Summary:  Проверить функцию добавления задания к проекту.
    */
    @Test
    public void checkAddTask() {
        loginPage.userLogin("lunopark123@ukr.net", "Lunopark123");
        mainPage.clickOnMyTaskButton();
        mainPage.clickOnAddTaskButton();
        mainPage.enterTaskName("Task new 1");
        mainPage.clicOnAddToProjectButton();
        mainPage.selectAddTaskToWorkProject();
        checkAC("Task 1 is not assigned to Project", mainPage.isWorkProjectLabelPresent(), true);
    }


    /*Test Case5
    Summary:  Проверить функцию удаления проекта.
    */
    @Test
    public void deleteProject() {
        loginPage.userLogin("lunopark123@ukr.net", "Lunopark123");
        mainPage.clickOnProjectButton();
        mainPage.clickoOnProjectDDButton();
        mainPage.clickOnDeleteOption();
        mainPage.clicOnConfirmButton();
    }
}
