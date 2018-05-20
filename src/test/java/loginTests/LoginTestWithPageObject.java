package loginTests;

import org.junit.Test;
import parentTest.ParentTest;

public class LoginTestWithPageObject  extends ParentTest{

    @Test
    public void validLogin(){
        loginPage.openPage();
        loginPage.enterLogin("lunopark123@ukr.net");
        loginPage.enterPass("Lunopark123");
        loginPage.clickSubmitButton();
    }
}
