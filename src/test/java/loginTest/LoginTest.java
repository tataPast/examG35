package loginTest;

import org.junit.Test;
import parentTest.ParentTest;

public class LoginTest extends ParentTest {

    @Test
    public void validLogin() {
        loginpage.openPage();
        loginpage.enterLogin(configProperties.login());
        loginpage.enterPassword(configProperties.password());
        loginpage.isSubmitLoginButtonDisplayed();
        loginpage.clickSubmitLoginButton();
        checkAC("user ID is not displayed", mainPage.isUserIdDisplayed(), true);
    }

    @Test
    public void loginWithEmptyInputs(){
        loginpage.openPage();
        loginpage.isSubmitLoginButtonDisplayed();
        loginpage.clickSubmitLoginButton();
        checkAC("Error massage is not displayed", loginpage.isErrorMsgVisible(), true);
    }
}