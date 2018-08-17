package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends Page {

    @FindBy(xpath = "//input[@id='username']")
    private WebElement userNameInput;
    @FindBy(xpath = "//*[@id = 'password']")
    private WebElement userPasswordInput;
    @FindBy(xpath = "//*[@id='intro_login']/fieldset/div/div[3]/div[1]/button")
    private WebElement submitLoginButton;


    public LoginPage(WebDriver webDriver) {
        super(webDriver, "/ru/v5/signin");
    }

    public LoginPage openPage() {
        try {
            webDriver.get(baseUrl + "/ru/v5/signin");
            checkCurrentUrl();
            logger.info("Login page was opened");
        } catch (Exception e) {
            logger.error("Can't open Login page");
            Assert.fail("Can't open Login page");
        }
        return new LoginPage(webDriver);
    }

    public LoginPage enterLogin(String login) {
        elementsActions.enterTextToElement
                (userNameInput, login, "login input field");
        return this;
    }

    public LoginPage enterPassword(String password) {
        elementsActions.enterTextToElement
                (userPasswordInput, password, "password input field");
        return this;
    }

    public boolean isSubmitLoginButtonDisplayed() {
        return elementsActions.isElementDisplayed(submitLoginButton, "Submit button");
    }

    public MainPage clickSubmitLoginButton() {
        elementsActions.clickOnElement(submitLoginButton, "submit Login Button");
        return new MainPage(webDriver);
    }
}