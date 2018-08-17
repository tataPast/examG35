package loginTest;

import org.junit.Before;
import org.junit.Test;
import pages.LoginPage;
import pages.MainPage;
import parentTest.ParentTest;

public class LoginTest extends ParentTest {
    private LoginPage loginpage;
    private MainPage mainPage;

    @Before
    public void setUp() {
        loginpage = new LoginPage(webDriver);
        mainPage = new MainPage(webDriver);
    }

    @Test
    public void validLogin() {
        mainPage = loginpage.openPage()
                .enterLogin("tatyana.pasternak@gmail.com")
                .enterPassword("NfnmzyF58")
                .clickSubmitLoginButton();

        checkAC("user name is not displayed", mainPage.isUsernameDisplayed(), true);
        checkAC("user ID is not displayed", mainPage.isUserIdDisplayed(), true);
    }
}
