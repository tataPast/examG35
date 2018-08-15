package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends ParentPage {

    @FindBy(xpath = "//input[@id='username']")
    private WebElement userNameInput;
    @FindBy(xpath = "//*[@id = 'password']")
    private WebElement userPasswordInput;
    @FindBy(xpath = "//*[@id='intro_login']/fieldset/div/div[3]/div[1]/button")
    private WebElement submitLoginButton;


    public LoginPage(WebDriver webDriver) {
        super(webDriver, "/ru/v5/signin");
    }

    public void openPage() {
        try {
            webDriver.get(baseUrl + "/ru/v5/signin");
            checkCurrentUrl();
            logger.info("Login page was opened");
        } catch (Exception e) {
            logger.error("Can't open Login page");
            Assert.fail("Can't open Login page");
        }
    }

    public void enterLogin(String login) {
        elementsActions.enterTextToElement
                (userNameInput, login, "login input field");
    }

    public void enterPassword(String password) {
        elementsActions.enterTextToElement
                (userPasswordInput, password, "password input field");
    }

    public boolean isSubmitLoginButtonDisplayed() {
        return elementsActions.isElementDisplayed(submitLoginButton, "Submit button");
    }

    public void clickSubmitLoginButton() {
        elementsActions.clickOnElement(submitLoginButton, "submit Login Button");
    }

}