package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends Pages {

    @FindBy(xpath = "//input[@id='username']")
    private WebElement userNameInput;
    @FindBy(xpath = "//*[@id = 'password']")
    private WebElement userPasswordInput;
    @FindBy(xpath = "//*[@id='intro_login']/fieldset/div/div[3]/div[1]/button")
    private WebElement submitLoginButton;
    @FindBy(xpath = "//*[@class='login__boxInputErrorMsg']")
    private WebElement loginInputErrorMsg;

    public LoginPage(WebDriver webDriver) {
        super(webDriver, "/ru/v5/signin");
    }

    public LoginPage openPage() {
        try {
            webDriver.get(baseUrl + "/ru/v5/signin");
            checkCurrentUrl();
            logger.info("Login page was opened");
            return this;
        } catch (Exception e) {

            logger.error("Can't open Login page");
            Assert.fail("Can't open Login page");
        }
        return this;
    }

    public void login() {
        openPage();
        enterLogin(login);
        enterPassword(pass);
        clickSubmitLoginButton();
    }

    public LoginPage enterLogin(String login) {
        elementsActions.enterTextToElement
                (userNameInput, login, "userNameInput");
    return this;
    }

    public LoginPage enterPassword(String password) {
        elementsActions.enterTextToElement
                (userPasswordInput, password, "userPasswordInput");
    return this;
    }

    public boolean isSubmitLoginButtonDisplayed() {
        return elementsActions.isElementDisplayed(submitLoginButton, "submitLoginButton");
    }

    public MainPage clickSubmitLoginButton() {
        elementsActions.clickOnElement(submitLoginButton, "submitLoginButton");
    return new MainPage(webDriver);
    }

    public boolean isErrorMsgVisible() {
        return elementsActions.isElementDisplayed(loginInputErrorMsg, "loginInputErrorMsg");
    }
}