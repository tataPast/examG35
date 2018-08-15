package loginTest;

import org.junit.Test;
import parentTest.ParentTest;

public class LoginTest extends ParentTest {

    @Test
    public void validLogin() {
        loginpage.openPage();
        loginpage.enterLogin("tatyana.pasternak@gmail.com");
        loginpage.enterPassword("NfnmzyF58");
        loginpage.isSubmitLoginButtonDisplayed();
        loginpage.clickSubmitLoginButton();
        mainPage.isUsernameDisplayed();
        checkAC("user name is not displayed", mainPage.isUsernameDisplayed(), true);
        mainPage.isUserIdDisplayed();
        checkAC("user ID is not displayed", mainPage.isUserIdDisplayed(), true);
    }


}
