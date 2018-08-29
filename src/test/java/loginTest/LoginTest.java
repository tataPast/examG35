package loginTest;

import org.junit.Test;
import parentTest.Tests;

public class LoginTest extends Tests {

    @Test
    public void validLogin() {
        loginpage.openPage()
                .enterLogin(configProperties.login())
                .enterPassword(configProperties.password())
                .isSubmitLoginButtonDisplayed();
        loginpage.clickSubmitLoginButton();
        checkAC("user ID is not displayed", mainPage.isUserIdDisplayed(), true);
    }

    @Test
    public void loginWithEmptyInputs() {
        loginpage.openPage()
                .isSubmitLoginButtonDisplayed();
        loginpage.clickSubmitLoginButton();
        checkAC("Error massage is not displayed", loginpage.isErrorMsgVisible(), true);
    }
}